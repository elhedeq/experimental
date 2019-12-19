package app;

class node {
    private int data;
    private node left,right;

    public node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getData() {
        return this.data;
    }

    public void setLeft(node left) {
        this.left = left;
    }

    public void setRight(node right) {
        this.right = right;
    }

    public node getLeft() {
        return this.left;
    }

    public node getRight() {
        return this.right;
    }
}

public class BST {
    private node root;
    private int nNode, nLeaf, nRight;
    // public functions to deal with user, private ones do the work
    // methods that do the work are private so that user doesn't have to specify the start node for each, instead it's specified by the public onse
    public BST() {
        this.root = null;
    }

    public void add(int data) {// to keep tree unbroken the added node must be related to its parent and to the root
        this.root = insert(this.root, data);
    }

    public void remove(int data) {// to keep tree unbroken the child of the removed node must be related to its parent and to the root
        this.root = delete(this.root, data);
    }

    public boolean find(int data) {
        return search(this.root, data) != null;
    }

    public int countNodes() {
        nNode = 0;
        countNode(root);
        return nNode;
    }

    public int countLeaves() {
        nLeaf = 0;
        countLeaf(root);
        return nLeaf;
    }

    public int countRightChildren() {
        nRight = 0;
        countRight(root);
        return nRight;
    }

    public int getHeight() {
        return height(root);
    }

    public node getRoot() {
        return root;
    }

    public void deleteLeaves() {
        deleteLeaf(root);
    }

    public boolean findSubTree(node subTree) {
        boolean result = true;
        return searchSubTree(subTree, result);
    }

    public void preorderBuild(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            add(arr[i]);
        }
    }

    public void display(String order) {
        switch (order) {
        case "in":
            displayInOrder(this.root);
            System.out.println();
            break;
        case "pre":
            displayPreOrder(this.root);
            System.out.println();
            break;
        case "post":
            displayPostOrder(this.root);
            System.out.println();
            break;
        }
    }

    // start node must be specified externally in order not to be changed every recursive call
    private node getMax(node current) { // max value is the most right
        while (current.getRight() != null)
            current = current.getRight();
        return current;
    }

    private node insert(node current, int data) {
        node newNode = new node(data);
        if (current == null) {
            current = newNode;
            return current;
        }
        if (current.getData() < data)
            current.setRight(insert(current.getRight(), data));
        else if (current.getData() > data)
            current.setLeft(insert(current.getLeft(), data));
        return current;
    }

    private node delete(node current, int data) {
        if (current == null) // if node not found return null
            return null;
        if (current.getData() < data) // if given data is greater than node data go to right
            current.setRight(delete(current.getRight(), data));
        else if (current.getData() > data) // if given data is less than node data go to left
            current.setLeft(delete(current.getLeft(), data));

        else { // else then inteded node found
            if (current.getLeft() == null && current.getRight() == null) // if node is leaf node delete it
                current = null;
            else if (current.getLeft() == null) { // if node has one child make its parent skip it to that child
                                                  // (garbage collector will delete it once it's unrelated)
                return current.getRight();
            } else if (current.getRight() == null) { // if node has one child make its parent skip it to that child
                                                     // (garbage collector will delete it once it's unrelated)
                return current.getLeft();
            } else { // if node has 2 childs
                node temp = getMax(current.getLeft()); // get its inorder successor
                current.setData(temp.getData());// replace it
                current.setLeft(delete(current.getLeft(), temp.getData())); // delete the inorder successor... the current.setLeft() is to keep the chain unbroken
            }
        }
        return current;
    }

    private node search(node current, int data) {
        if (current == null || current.getData() == data)
            return current;
        else if (current.getData() < data)
            return search(current.getRight(), data);
        else if (current.getData() > data)
            return search(current.getLeft(), data);
        return current;
    }

    private void displayInOrder(node current) {
        if (current == null)
            return;
        displayInOrder(current.getLeft());
        System.out.print(current.getData() + " ");
        displayInOrder(current.getRight());
    }

    private void displayPreOrder(node current) {
        if (current == null)
            return;
        System.out.print(current.getData() + " ");
        displayPreOrder(current.getLeft());
        displayPreOrder(current.getRight());
    }

    private void displayPostOrder(node current) {
        if (current == null)
            return;
        displayPostOrder(current.getLeft());
        displayPostOrder(current.getRight());
        System.out.print(current.getData() + " ");
    }

    private void countNode(node current) {
        if(current == null)
            return;
        nNode++;
        countNode(current.getLeft());
        countNode(current.getRight());
    }

    private void countLeaf(node current) {
        if(current == null)
            return;
        if(isLeaf(current))
            nLeaf++;
        countLeaf(current.getLeft());
        countLeaf(current.getRight());
    }

    private void countRight(node current) {
        if(current == null)
            return;
        if(current.getRight() != null)
            nRight++;
        countRight(current.getLeft());
        countRight(current.getRight());
    }

    private int height(node current) {
        if (current == null)
            return 0;
        return 1 + Math.max(height(current.getLeft()), height(current.getRight()));
    }

    private void deleteLeaf(node current) {
        if(current.getLeft()!=null && !isLeaf(current.getLeft()))
            deleteLeaf(current.getLeft());
        if(current.getRight() != null && !isLeaf(current.getRight()))
            deleteLeaf(current.getRight());
        if(current.getLeft()!=null && isLeaf(current.getLeft())){   //if left child is leaf
                current.setLeft(null);  //delete it
                if(current.getRight() != null && !isLeaf(current.getRight()))  //go right (the condition is to avoid null pointer exception)
                    deleteLeaf(current.getRight());
            }
        if(current.getRight() != null && isLeaf(current.getRight())){  //if right child is leaf
            current.setRight(null); //delete it
            if(current.getLeft() != null && !isLeaf(current.getLeft()))   //go left  (the condition is to avoid null pointer exception)
                deleteLeaf(current.getLeft());
        }
    }

    private boolean isLeaf(node current){
        return current.getLeft() == null && current.getRight() == null;
    }

    private boolean searchSubTree(node subTree, boolean result){
        if (find(subTree.getData())) {
            if(subTree.getLeft() != null)
                result = result && searchSubTree(subTree.getLeft(), true);
            if(subTree.getRight() != null)
                result = result && searchSubTree(subTree.getRight(), true);
        }
        else
            result = false;
        return result;
    }

}