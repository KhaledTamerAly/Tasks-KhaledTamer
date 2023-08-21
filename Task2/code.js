
const specialWaldo = document.getElementById("special");
const leftCanvas = document.getElementById("leftCanvas");
const rightCanvas = document.getElementById("rightCanvas");
var leftWaldos = leftCanvas.getElementsByClassName("waldo");
var rightWaldos = rightCanvas.getElementsByClassName("waldo");

specialWaldo.addEventListener("click", ()=> {
    var top = Math.floor(Math.random() * 65);
    var left = Math.floor(Math.random() * 75);
    specialWaldo.style.top = top+"%";
    specialWaldo.style.left = left+"%";

    var posArray = [{top: top, left: left}];

    var leftWaldoArray = Array.from(leftWaldos);
    var rightWaldoArray = Array.from(rightWaldos);

    for(var i =0;i<rightWaldoArray.length;i++)
    {
        
        var top = Math.floor(Math.random() * 65);
        var left = Math.floor(Math.random() * 65);
        while(isPairIn(posArray, {top: top, left: left}))
        {
            top = Math.floor(Math.random() * 65);
            left = Math.floor(Math.random() * 75);
        }
        posArray.push({top: top, left: left});

        leftWaldoArray[i].style.top = top+"%";
        leftWaldoArray[i].style.left = left+"%";

        rightWaldoArray[i].style.top = top+"%";
        rightWaldoArray[i].style.left = left+"%";
    }

    top = Math.floor(Math.random() * 65);
    left = Math.floor(Math.random() * 75);
    while(isPairIn(posArray, {top: top, left: left}))
    {
        top = Math.floor(Math.random() * 65);
        left = Math.floor(Math.random() * 75);
    }
    posArray.push({top: top, left: left});
    const newWaldo = document.createElement("img");
    newWaldo.src = "https://static.wikia.nocookie.net/waldo/images/9/9d/Character.Waldo.jpg/revision/latest?cb=20071001045624";
    newWaldo.classList.add("waldo");
    newWaldo.style.top = top+"%";
    newWaldo.style.left = left+"%";

    const newWaldo2 = document.createElement("img");
    newWaldo2.src = "https://static.wikia.nocookie.net/waldo/images/9/9d/Character.Waldo.jpg/revision/latest?cb=20071001045624";
    newWaldo2.classList.add("waldo");
    newWaldo2.style.top = top+"%";
    newWaldo2.style.left = left+"%";
    
    leftCanvas.appendChild(newWaldo);
    rightCanvas.appendChild(newWaldo2);

    leftWaldos.push(newWaldo);
    rightWaldos.push(newWaldo2);
});

function isPairIn(array, pair)
{
    for(var p of array)
    {
        if(p.top === pair.top && p.left === pair.left)
            return true;
    }
    return false;
}