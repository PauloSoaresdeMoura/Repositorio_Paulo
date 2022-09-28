//Declaração for([expressão Inicial]; [condição]; [incremento])
var passo;
for( passo = 0; passo < 5; passo++){
    console.log('Ande um Passo');
}

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