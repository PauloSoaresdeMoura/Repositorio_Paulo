//Classe document
document.write("Bom dia");

//title - Retorna o Título da Página
//URL - Retorna a url da pagina

document.write("<h2"+document.title+"</h2>");
document.writeln(document.URL);

//Requisitando informações do HTML e alterando-as
function fAlterar(){
    var x = document.getElementById("paragrafo");
    x.innerHTML="Bom Dia";
}

function inter(){
    var btnNome = Element=document.getElementById("btnInter");
    var lampada = Element=document.getElementById("imglampada");
    if (Element.src.match("bulbon")){
        Element.src="img/pic_bulboff.gif";
        btnNome.innerHTML="Ligar"
    }else{
        Element.src="img/pic_bulbon.gif";
        btnNome.innerHTML="Desligar"
    }
}

function soma(){
    var n1 = parseInt(document.getElementById("v1").value);
    var n2 = parseInt(document.getElementById("v2").value);
    document.getElementById("res").innerHTML="Resposta: " + (n1+n2);
}

function sub(){
    var n1 = parseInt(document.getElementById("v1").value);
    var n2 = parseInt(document.getElementById("v2").value);
    document.getElementById("res").innerHTML = "Resposta: "+(n1-n2);
}

function mult(){
    var n1 = parseInt(document.getElementById("v1").value);
    var n2 = parseInt(document.getElementById("v2").value);
    document.getElementById("res").innerHTML = "Resposta: "+(n1*n2);
}

function div(){
    var n1 = parseInt(document.getElementById("v1").value);
    var n2 = parseInt(document.getElementById("v2").value);
    document.getElementById("res").innerHTML = "Resposta: "+(n1/n2);
}

function porcento(){
    var n1 = parseInt(document.getElementById("v1").value);
    var n2 = parseInt(document.getElementById("v2").value);
    document.getElementById("res").innerHTML = "Resposta: "+(n1-((n1*n2)/100));
}

function resDiv(){
    var n1 = parseInt(document.getElementById("v1").value);
    var n2 = parseInt(document.getElementById("v2").value);
    document.getElementById("res").innerHTML = "Resposta: "+(n1 % n2);
}

function limpa(){
    var n1 = document.getElementById("v1");
    var n2 = document.getElementById("v2");
    var r = document.getElementById("res");
    n1.value="";
    n2.value="";
    r.innerHTML="Resposta: ";
}
