window.alert("try to catch the text if you are on a pc just hover with the mouse pointer over it if on mobile tap it");
var sayings = ["ha ha ha", "don't even try", "no you won't", "you can't catch me", "not this time", "no", "whatever", "you're getting better", "try again", "keep trying", "you were about to do it", "you're not even getting better", "i'm here", "now here", "admit it you failed", "don't give up", "nope", "good luck next time", "i'm the master of escaping", "catch me if you can"];
var div = document.getElementsByTagName("div")[0];
var score = 0;
function escape() {
    'use strict';
    var y = Math.ceil(Math.random() * 90);
    var x = Math.ceil(Math.random() * 90);
    div.style.top = y + "%";
    div.style.right = x + "%";
    div.innerHTML = sayings[Math.floor(Math.random() * 20)];
    score++;
    if (score > 1) {
        document.getElementsByTagName("p")[0].style.display = "block";
        document.getElementsByTagName("p")[0].innerHTML = "Caught and Escaped " + score + " times";
    }
}
div.addEventListener("click", escape);
div.addEventListener("mouseover", escape);
