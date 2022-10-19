window.onload = function() {
    var seconds = 00;
    var tens = 00;
    var appendTens = document.getElementById("tens")
    var appendSeconds = document.getElementById("seconds")
    var appendMl = document.getElementById("ml")
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
        tens = "00";
        seconds = "00";
        ml = "000";
        appendTens.innerHTML = tens;
        appendSeconds.innerHTML = seconds;
        appendMl.innerHTML = ml;
    }

    function startTimer() {
        tens++;
        if (tens <= 9) {
            appendTens.innerHTML = "0" + tens;
        }
        if (tens > 9) {
            appendTens.innerHTML = tens;
        }
        if (tens > 99) {
            console.log("seconds");
            seconds++;
            appendSeconds.innerHTML = "0" + seconds;
            tens = 0;
            appendTens.innerHTML = "0" + 0;
        }
        if (seconds > 9) {
            appendSeconds.innerHTML = seconds;
        }

    }
    //Relogio
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

}