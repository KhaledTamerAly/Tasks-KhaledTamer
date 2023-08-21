var specialWaldo = document.getElementById("special");
var leftCanvas = document.getElementById("leftCanvas");
var rightCanvas = document.getElementById("rightCanvas");
var leftWaldoArray = leftCanvas.getElementsByClassName("waldo");
var rightWaldoArray = rightCanvas.getElementsByClassName("waldo");
specialWaldo.addEventListener("click", function () {
    var top = Math.floor(Math.random() * 65);
    var left = Math.floor(Math.random() * 75);
    specialWaldo.style.top = top + "%";
    specialWaldo.style.left = left + "%";
    var posArray = [{ top: top, left: left }];
    for (var i = 0; i < rightWaldoArray.length; i++) {
        top = Math.floor(Math.random() * 65);
        left = Math.floor(Math.random() * 75);
        while (isPairIn(posArray, { top: top, left: left })) {
            top = Math.floor(Math.random() * 65);
            left = Math.floor(Math.random() * 75);
        }
        posArray.push({ top: top, left: left });
        leftWaldoArray[i].style.top = top + "%";
        leftWaldoArray[i].style.left = left + "%";
        rightWaldoArray[i].style.top = top + "%";
        rightWaldoArray[i].style.left = left + "%";
    }
    top = Math.floor(Math.random() * 65);
    left = Math.floor(Math.random() * 75);
    while (isPairIn(posArray, { top: top, left: left })) {
        top = Math.floor(Math.random() * 65);
        left = Math.floor(Math.random() * 75);
    }
    posArray.push({ top: top, left: left });
    var newWaldo = document.createElement("img");
    newWaldo.src =
        "https://static.wikia.nocookie.net/waldo/images/9/9d/Character.Waldo.jpg/revision/latest?cb=20071001045624";
    newWaldo.classList.add("waldo");
    newWaldo.style.top = top + "%";
    newWaldo.style.left = left + "%";
    var newWaldo2 = document.createElement("img");
    newWaldo2.src =
        "https://static.wikia.nocookie.net/waldo/images/9/9d/Character.Waldo.jpg/revision/latest?cb=20071001045624";
    newWaldo2.classList.add("waldo");
    newWaldo2.style.top = top + "%";
    newWaldo2.style.left = left + "%";
    leftCanvas.appendChild(newWaldo);
    rightCanvas.appendChild(newWaldo2);
});
function isPairIn(array, pair) {
    for (var _i = 0, array_1 = array; _i < array_1.length; _i++) {
        var p = array_1[_i];
        if (p.top === pair.top && p.left === pair.left) {
            return true;
        }
    }
    return false;
}
