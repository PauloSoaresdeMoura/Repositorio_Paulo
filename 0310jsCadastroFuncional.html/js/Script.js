function validar() {
    var codigo = document.getElementById("codigo").value;
    var descricao = document.getElementById("descricao").value;
    var quantidade = document.getElementById("quantidade").value;
    if (!codigo) {
        document.getElementById("erro").style.display = "block";
        document.getElementById("erro").innerHTML = "Campo Código não Informado!";
        return false;
    }
    if (!descricao) {
        document.getElementById("erro").style.display = "block";
        document.getElementById("erro").innerHTML = "Informe a Descrição!";
        document.getElementById("Descricao").focus;
        return false;
    }
    if (!quantidade) {
        document.getElementById("erro").style.display = "block";
        document.getElementById("erro").innerHTML = "Informe a Quantidade!";
        return false;
    }
}


function checkCookie() {
    if (navigator.cookieEnabled == true) {
        alert("Cookies são permitidos!")
    } else {
        alert("Cookie não são permitidos!")
    }
}

function myChange() {
    var x = document.getElementById("fname");
    x.value = x.value.toUpperCase();
}

function mOver(obj) {
    obj.innerHTML = "Obrigado!";
}


function mOut(obj) {
    obj.innerHTML = "Passe o mouse aqui!";
}

function mDown(obj) {
    obj.style.backgroundColor = "#1ec5e5";
    obj.innerHTML = "Solte o click";
}

function mUp(obj) {
    obj.style.backgroundColor = "#D94A38";
    obj.innerHTML = "Obrigado!";
}

function dentro() {
    document.getElementById("meuInput").style.background = "red";
}

function fora() {
    document.getElementById("meuInput").style.background = "blue";
}