setInterval(showTime, 1000);

function showTime() {
    let time = new Date();
    let hour = time.getHours();
    let min = time.getMinutes();
    let sec = time.getSeconds();
    am_pm = "AM";

    if (hour > 12) {
        hour -= 12; //subtrai do valor menos 12
        am_pm = "PM"
    }
    if (hour == 00) {
        hr = 12;
        am_pm = "AM";
    }
    hour = hour < 10 ? "0" + hour : hour;
    min = min < 10 ? "0" + min : min;
    sec = sec < 10 ? "0" + sec : sec;

    let currentTime = hour + " : " + min + " : " + sec + " " + am_pm;

    document.getElementById("relogio").innerHTML = currentTime;

}

window.onload = function() {
    var hrs = 00;
    var mn = 00;
    var sg = 00;
    var ml = 00;
    var appendTens = document.getElementById("hrs")
    var appendSeconds = document.getElementById("mn")
    var appendSeconds = document.getElementById("sg")
    var appendSeconds = document.getElementById("ml")
    var buttonStart = document.getElementById('button-start');
    var buttonStop = document.getElementById('button-stop');
    var buttonReset = document.getElementById('button-reset');
    var Interval;
    buttonStart.onclick = function() {
        clearInterval(Interval);
        Interval = setInterval(startTimer, 10);
    }
    buttonStop.onclick = function() {
        clearInterval(Interval);
    }
    buttonReset.onclick = function() {
        clearInterval(Interval);
        hrs = "00";
        mn = "00";
        sg = "00";
        ml = "00";
        appendHrs.innerHTML = hrs;
        appendMn.innerHTML = mn;
        appendSg.innerHTML = sg;
        appendMl.innerHTML = ml;
    }

    function startTimer() {
        if ((ml += 10) == 1000) {
            ml = 0;
            sg++;

        }
        if (sg == 60) {
            sg = 0;
            mn++;

        }
        if (mn == 60) {
            mn = 0;
            hrs++;
        }
    }
}

function start() {
    stop();
    cron = setInterval(() => { timer(); }, 10);

}

function stop() {
    clearInterval(cron);
}

function reset() {
    hrs = 0;
    mn = 0;
    sg = 0;
    ml = 0;
    document.getElementById("hrs").innerHTML = "00";
    document.getElementById("mn").innerHTML = "00";
    document.getElementById("sg").innerHTML = "00";
    document.getElementById("ml").innerHTML = "000";
}

function timer() {
    if ((ml += 10) == 1000) {
        ml = 0;
        sg++;

    }
    if (sg == 60) {
        sg = 0;
        mn++;

    }
    if (mn == 60) {
        mn = 0;
        hrs++;
    }

    document.getElementById("hrs").innerText = returnData(hrs);
    document.getElementById("mn").innerText = returnData(mn);
    document.getElementById("sg").innerText = returnData(sg);
    document.getElementById("ml").innerText = returnData(ml);
}

function returnData(input) {
    return input >= 10 ? input : 0, { input };
}