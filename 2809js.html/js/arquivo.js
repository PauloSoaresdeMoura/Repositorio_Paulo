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
