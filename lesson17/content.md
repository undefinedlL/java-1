### Ссылка на презентацию
https://docs.google.com/presentation/d/1m1WOA1xO_luvBqM3L6rVAPM8_yVgrKXgz_Nfuju-fRE/edit?usp=sharing

#### HTML (файл - index.html)
```
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="style.css">
    <title>Game</title>
</head>
<body>
    
    <div id="bg">
        <button onclick="go()">Start</button>
        <img src="c0.png" width="130" height="40" id="car0">
        <img src="c1.png" width="130" height="40" id="car1">
        <img src="c2.png" width="130" height="40" id="car2">
        <img src="c3.png" width="130" height="40" id="car3">
        <img src="c4.png" width="130" height="40" id="car4">
    </div>

    <script src="script.js"></script>
</body>
</html>
```

#### CSS (файл - style.css)
```
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

body {
    height: 100dvh;
    width: 100%;
    overflow: hidden;
}

#bg {
    width: 100%;
    height: 100dvh;
    background-image: url('bg.png');
    background-position: top;
    background-repeat: no-repeat;
    background-size: cover;
    position: relative;
}

button {
    position: absolute;
    left: 20px;
    top: 20px;
    width: 150px;
    height: 50px;
    font-size: 30px;
    font-family: Arial;
    font-weight: 900;
    color: rgb(0, 0, 0);
}

img {
    position: absolute;
}

#car0, #car1, #car2, #car3, #car4 {
    right: 10px;
}

#car0 {
    top: 165px;
}
#car1 {
    top: 340px;
}
#car2 {
    top: 515px;
}
#car3 {
    top: 690px;
}
#car4 {
   top:  865px;
}

```


#### JavaScript код (файл - script.js)
```
let timer, cars, cx, gameStart;

function go() {
    if (gameStart == 1) return;
    gameStart = 1;
    cars = new Array();
    for (let i = 0; i < 5; i++) {
        cars[i] = document.getElementById("car" + i);
        cars[i].style.border = "none"
    }
    cx = new Array();
    for (let i = 0; i < 5; i++) {
        cx[i] = 0;
    }
    timer = window.setInterval(timerStart, 10);
}

function timerStart() {
    for (let i = 0; i < 5; i++) {
        cx[i] = cx[i] + Math.floor((Math.random()*7+2))
        if (cx[i] > window.innerWidth - 130) {
            window.clearInterval(timer);
            gameStart = 0;
            cars[i].style.border = "5px solid yellow"
            return;
        }
        cars[i].style.right = ""+cx[i]+"px";
    }
}
```