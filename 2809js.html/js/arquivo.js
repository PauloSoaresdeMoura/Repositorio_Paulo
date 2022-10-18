//Declaração for([expressão Inicial]; [condição]; [incremento])
//var passo;
//for( passo = 0; passo < 5; passo++){
   // console.log('Ande um Passo');
//}

function howMany(selectObject){
    var nroSelecoes = 0;
    for(var i = 0; i < selectObject.options.length; i++) {
        if(selectObject.options[i].selected){
            nroSelecoes++;
        }
    }
    return nroSelecoes;
}
var btn = document.getElementById('btn');
btn.addEventListener("click", function(){
    alert('Total selecionados: '+ howMany(document.selectForm.tipoMusica));
});

//do...while
/*do
    Stat
while(condição)*/

var resultado ='';
var i = 0;

do{
    i+=1;
    resultado += i+' ';
}while(i<15);
document.getElementById('exemplo').innerHTML = resultado;

//Elementos de repetição com funcionalidade semelhantes e suas diferenças

//=> while - Executa o loop enquanto a consição for verdadeira
//Contar de 1 até 10
contagem = 0;
var i = 0;
while(contar <= 10){
    i++;
}

//Do while - Executa o loop primeiro e depois verefica a condição
do{
    contagem ++;
}while(contagem <= 10);

//For - Executa o loop enquanto a condição for verdadeira, 
//porém a instância das variáveis de contagem são instanciadas na estrutura do loop!
contagem = 0;
var i = 0;
for(i = 0; i <= 10; i++){
    contagem++;
}

//forEach - Executa o loop sobre elementos de um array
contagem = [0,1,2,3,4,5,6,7,8,9];
i = 0;
contagem.forEach(contagem => {
    i++;
});

//Break - Encerra o loop atual
//sintaxe break[label]; - break;
//ex: A função encerra o loop quando a variável i for 3 e então retorna e * x
function testaBreak(x){
    var i = 0;
    while(i < 6){
        if(i==3){
            break;
        }
        i+= 1;
    }
    return i * x;
}

//A condição Switch avalia uma expressão, combinando o valor da expressão com uma "clausula case" 
//e executa os comandos associados ao case
switch(expr){
    case "Laranjas":
        console.log("Laranjas R$ 1,99 KG");
        break;
    case "Banana":
        console.log("Banana R$ 2,99 KG");
        break;
    case "Abacate":
        console.log("Abacate R$ 5,99 KG");
        break;         
    case "Melancia":
        console.log("Melancia R$ 6,99 KG");
        break;
    case "Manga":
        console.log("Manga R$ 4,99 KG");
        break;
    case "Morango":
            console.log("Morango R$ 4,99 KG");
            break;    
    default:
        console.log("Desculpe, estamos sem nenhuma "+ expr +" . " )   
}
console.log("Gostaria de adicionar mais algo?")