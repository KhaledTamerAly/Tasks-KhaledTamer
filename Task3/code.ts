const specialWaldo = document.getElementById("special") as HTMLDivElement;
const leftCanvas = document.getElementById("leftCanvas") as HTMLDivElement;
const rightCanvas = document.getElementById("rightCanvas") as HTMLDivElement;
const leftWaldoArray: HTMLCollectionOf<HTMLImageElement> = leftCanvas.getElementsByClassName("waldo") as HTMLCollectionOf<HTMLImageElement>;
const rightWaldoArray: HTMLCollectionOf<HTMLImageElement> = rightCanvas.getElementsByClassName("waldo") as HTMLCollectionOf<HTMLImageElement>;

specialWaldo.addEventListener("click", (): void => {
    let top: number = Math.floor(Math.random() * 65);
    let left: number = Math.floor(Math.random() * 75);
    specialWaldo.style.top = top + "%";
    specialWaldo.style.left = left + "%";

    const posArray: { top: number; left: number }[] = [{ top: top, left: left }];

    for (let i = 0; i < rightWaldoArray.length; i++) {
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
    const newWaldo: HTMLImageElement = document.createElement("img");
    newWaldo.src =
        "https://static.wikia.nocookie.net/waldo/images/9/9d/Character.Waldo.jpg/revision/latest?cb=20071001045624";
    newWaldo.classList.add("waldo");
    newWaldo.style.top = top + "%";
    newWaldo.style.left = left + "%";

    const newWaldo2: HTMLImageElement = document.createElement("img");
    newWaldo2.src =
        "https://static.wikia.nocookie.net/waldo/images/9/9d/Character.Waldo.jpg/revision/latest?cb=20071001045624";
    newWaldo2.classList.add("waldo");
    newWaldo2.style.top = top + "%";
    newWaldo2.style.left = left + "%";

    leftCanvas.appendChild(newWaldo);
    rightCanvas.appendChild(newWaldo2);
});

function isPairIn(array: { top: number; left: number }[], pair: { top: number; left: number }): boolean {
    for (const p of array) {
        if (p.top === pair.top && p.left === pair.left) {
            return true;
        }
    }
    return false;
}
