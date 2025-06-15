// book class
class Book {
    constructor(title, author,isbn){
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }
}
// UI class
class UI {
    static loadBooks(books){
        books.forEach(book => this.addBookItem(book));
    }
    static addBookItem(book){
        const bookList = document.querySelector('#book-list');
        const item = document.createElement('tr');
        const title = document.createElement('td');
        title.appendChild(document.createTextNode(book.title));
        item.appendChild(title);
        const author = document.createElement('td');
        author.appendChild(document.createTextNode(book.author));
        item.appendChild(author);
        const isbn = document.createElement('td');
        isbn.appendChild(document.createTextNode(book.isbn));
        item.appendChild(isbn);
        const removeBtn = document.createElement('button');
        removeBtn.appendChild(document.createTextNode('X'));
        removeBtn.classList.add('btn');
        removeBtn.classList.add('btn-danger');
        removeBtn.classList.add('remove');
        item.appendChild(removeBtn);
        const editBtn = document.createElement('button');
        editBtn.appendChild(document.createTextNode('edit'));
        editBtn.classList.add('btn');
        editBtn.classList.add('btn-warning');
        editBtn.classList.add('edit');
        item.appendChild(editBtn);
        bookList.appendChild(item);
    }

    static removeBookItem(event){
        if (event.target.classList.contains('remove')){
            event.target.parentNode.remove();
            let isbn = Number.parseInt(event.target.previousSibling.innerText);
            Storage.removeBook(isbn);
        }
    }

    static clearFields(){
        document.querySelector('#book-title').value = '';
        document.querySelector('#book-author').value = '';
        document.querySelector('#book-isbn').value = '';
    }

    static showMessage(msg,msgType,location){
        const warning = document.createElement('div');
        warning.className = `alert alert-${msgType} text-capitalize msg`;
        warning.appendChild(document.createTextNode(msg));
        document.querySelector('#add-book').insertBefore(warning,location.nextSibling);
    }

    static search(keyword) {
        let books = document.querySelectorAll('#book-list>tr');
        books.forEach(book => book.style.display = 'none');
        books.forEach(book => {
            if(book.children[0].innerText.indexOf(keyword)>-1){
                book.style.display = 'table-row';
            }
            if(book.children[1].innerText.indexOf(keyword)>-1){
                book.style.display = 'table-row';
            }
            if(book.children[2].innerText.indexOf(keyword)>-1){
                book.style.display = 'table-row';
            }
        });
    }

    static editBook(event){
        if (event.target.classList.contains('edit')){
            document.querySelector('#book-title').value = event.target.parentNode.children[0].innerText;
            document.querySelector('#book-author').value = event.target.parentNode.children[1].innerText;
            document.querySelector('#book-isbn').value = event.target.parentNode.children[2].innerText;
            document.querySelector('#book-isbn').setAttribute('disabled','disabled');
            document.querySelector('#add').value = 'update';
        }
    }

    static clearList(){
        Array.from(document.querySelector('#book-list').children).forEach(item=>item.remove());
    }
}

// storage class
class Storage {
    static getBooks(){
        let books = [];
        if(localStorage.getItem('books')){
            books = JSON.parse(localStorage.getItem('books'));
        }
        return books;
    }

    static addBook(book){
        let books = this.getBooks();
        books.push(book);
        localStorage.setItem('books',JSON.stringify(books));
    }

    static editBook(newbook,isbn){
        let books = this.getBooks();
        books = books.map(book => {
            if(book.isbn === isbn){
                book.title = newbook.title;
                book.author = newbook.author;
            }
            return book;
        });
        localStorage.setItem('books',JSON.stringify(books));
    }

    static removeBook(isbn){
        let books = this.getBooks();
        books.forEach((book,index)=>{
            if (book.isbn === isbn){
                books.splice(index,1);
            }
        });
        localStorage.setItem('books', JSON.stringify(books));
    }

    static isRegistered(isbn){
        let found = false;
        Storage.getBooks().forEach(book=> {
            if (book.isbn === isbn){
               found = true;
            }
        });
        return found;
    }
}
// events
document.addEventListener('DOMContentLoaded', UI.loadBooks(Storage.getBooks()));

document.querySelector('#book-list').addEventListener('click', UI.removeBookItem);
document.querySelector('#book-list').addEventListener('click', UI.editBook);

document.querySelector('#add-book').addEventListener('click', (event)=> {
    event.preventDefault();
    if(event.target.id !== 'add'){
        return;
    }
    const title = document.querySelector('#book-title');
    const author = document.querySelector('#book-author');
    const isbn = document.querySelector('#book-isbn');
    document.querySelectorAll('.msg').forEach(msg => msg.remove());

    if(!title.value.trim()) {
        UI.showMessage('please enter the book title','danger',title.parentNode);
        return;
    }
    if(!author.value.trim()) {
        UI.showMessage('please enter the book author','danger',author.parentNode);
        return;
    }
    if(!isbn.value.trim() || Number.parseInt(isbn.value.trim()) === NaN) {
        UI.showMessage('please enter the book ISBN','danger',isbn.parentNode);
        return;
    } else if(event.target.value === 'update'){
        const book = new Book(title.value.trim(),author.value.trim(),Number.parseInt(isbn.value.trim()));
        Storage.editBook(book, book.isbn);
        UI.clearList();
        UI.loadBooks(Storage.getBooks());
        UI.showMessage('book updated successfully','success',isbn.parentNode);
        setTimeout(()=>document.querySelectorAll('.msg').forEach(msg => msg.remove()),3000);
        UI.clearFields();
        return;
    } else if(Storage.isRegistered(Number.parseInt(isbn.value.trim()))) {
        UI.showMessage('ISBN is already registered','danger',isbn.parentNode);
        return;
    }
    const book = new Book(title.value.trim(),author.value.trim(),Number.parseInt(isbn.value.trim()));
    Storage.addBook(book);
    UI.addBookItem(book);
    UI.showMessage('book added successfully','success',isbn.parentNode);
    setTimeout(()=>document.querySelectorAll('.msg').forEach(msg => msg.remove()),3000);
    UI.clearFields();
});

document.querySelector('#search').addEventListener('input',(event)=>UI.search(event.target.value.trim()))