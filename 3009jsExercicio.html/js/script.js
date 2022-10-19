const cardapioLanchonete = (codigoItem, quantidadeItem) => {
    let CachorroQuente = 1.70;
    let BauruSimples = 2.30;
    let BauruComOvo = 2.60;
    let Hamburguer = 2.40;
    let Cheeseburguer = 2.50;
    let Refrigerante = 1.00;
    switch (codigoItem) {
        case 100:
            return `Item(s) do pedido: Cachorro-quente, Total: ${(CachorroQuente * quantidadeItem).toFixed(2).replace('.', ',')}R$.`
        case 101:
            return `Item(s) do pedido: Hamburguer-Simples, Total: ${(BauruSimples * quantidadeItem).toFixed(2).replace('.', ',')}R$.`
        case 102:
            return `Item(s) do pedido: Cheeseburguer, Total: ${(BauruComOvo * quantidadeItem).toFixed(2).replace('.', ',')}R$.`
        case 103:
            return `Item(s) do pedido: Bauru, Total: ${(Hamburguer * quantidadeItem).toFixed(2).replace('.', ',')}R$.`
        case 104:
            return `Item(s) do pedido: Refrigerante, Total: ${(Cheeseburguer * quantidadeItem).toFixed(2).replace('.', ',')}R$.`
        case 105:
            return `Item(s) do pedido: Suco, Total: ${(Refrigerante * quantidadeItem).toFixed(2).replace('.', ',')}R$.`
        default:
            return 'produto não existente!'
    }
}
console.log(cardapioLanchonete(100, 3));
console.log(cardapioLanchonete(101, 1));
console.log(cardapioLanchonete(102, 5));
console.log(cardapioLanchonete(103, 2));
console.log(cardapioLanchonete(104, 1));
console.log(cardapioLanchonete(105, 4));
console.log(cardapioLanchonete(106, 1));

console.log('------------------')

function howMany(selectObject) {
    var total = 0;
    for (var i = 0; i < selectObject.options.length; i++) {
        if (selectObject.options[i].selected) {
            total++;
        }
    }
    return total;
}
var btn = document.getElementById('btn');
btn.addEventListener("click", function() {
    alert('Total selecionados: ' + howMany(document.selectForm.cardapioLanchonete));
});

//Break - Encerra o loop atual
//sintaxe break[label]; - break;
//ex: A função encerra o loop quando a variável i for 3 e então retorna e * x
function testaBreak(x) {
    var i = 0;
    while (i < 6) {
        if (i == 3) {
            break;
        }
        i += 1;
    }
    return i * x;
}

//A condição Switch avalia uma expressão, combinando o valor da expressão com uma "clausula case" 
//e executa os comandos associados ao case
switch (expr) {
    case "cachorroQuente":
        console.log("Cachorro Quente R$ 1,99 KG");
        break;
    case "bauruSimples":
        console.log("Bauru Simples R$ 2,99 KG");
        break;
    case "bauruComOvo":
        console.log("Bauru Com Ovo R$ 5,99 KG");
        break;
    case "Hamburguer":
        console.log("Hamburguer R$ 6,99 KG");
        break;
    case "Cheeseburguer":
        console.log("Cheeseburguer R$ 4,99 KG");
        break;
    case "Refrigerante":
        console.log("Refrigeraante R$ 4,99 KG");
        break;
    default:
        console.log("Desculpe, estamos sem nenhum " + expr + " . ")
}
console.log("Gostaria de adicionar mais algo?")

function contar15() {
    let out2 = document.getElementById('out2');
    out2.innerHTML += `<h2> Contando de 1 até 15</h2>`
    let cont2 = 1;
    while (cont2 <= 15) {
        if (cont2 % 2 == 0) {
            out2.innerHTML += `<mark><strong> ${cont2}</mark></strong>&#x1F448;`
        } else {
            out2.innerHTML += `${cont2} &#x1F449;`
        }
        cont2++;
    }
    out2.innerHTML += `&#x1F680`;
}

function contarPares() {
    let out2 = document.getElementById('out2');
    out2.innerHTML += `<h2> Contando de 1 até 100 - Marcando Pares </h2>`
    let cont2 = 1;
    while (cont2 <= 100) {
        if (cont2 % 2 == 0) {
            out2.innerHTML += `<mark><strong> ${cont2}</mark></strong>&#x1F448;`
        } else {
            out2.innerHTML += `${cont2} &#x1F449;`
        }
        cont2++;
    }
    out2.innerHTML += `&#x1F680`;
}


$(function() {
    var operacao = "A"; //"A = Adição"
    var indice_selecionado = -1;
    var tbClientes = localStorage.getItem("tbClientes"); //recuperar os dados armazenados
    tbClientes = JSON.parse(tbClientes); //convertendo a String para objeto

    if (tbClientes == null) //caso não exista conteúdo iniciamos um vetor vazio
        tbClientes = [];

    //Adiciona registro no cadastro
    function adicionar() {
        var cli = GetCliente("Codigo", $("txtCodigo").val());
        if (cli != null) { //verifica se o código ja está cadastrado
            alert("Código já cadastrado!");
            return;
        }
        var cliente = JSON.stringify({
            Codigo: $("#txtCodigo").val(),
            Nome: $("#txtNome").val(),
            Telefone: $("#txtTelefone").val(),
            Email: $("#txtEmail").val(),
        });

        tbClientes.push(cliente);
        localStorage.setItem("tbClientes", JSON.stringify(tbClientes));

        alert("Registro Cadastrado com Sucesso!");
        return true;

    }

    //Edita registro cadastrado
    function Editar() {
        tbClientes[indice_selecionado] = JSON.stringify({
            Codigo: $("#txtCodigo").val(),
            Nome: $("#txtNome").val(),
            Telefone: $("#txtTelefone").val(),
            Email: $("#txtEmail").val()
        });
        localStorage.setItem("tbClientes", JSON.stringify(tbClientes));
        alert("Informações editadas com sucesso!")
        operacao = "A";
        return true;
    }

    //Listar conteúdo
    function Listar() {
        $("#tblListar").html("");
        $("#tblListar").html(
            "<thead>" + "<tr>" + "<th></th>" +
            "<th>Código</th>" +
            "<th>Nome</th>" +
            "<th>Telefone</th>" +
            "<th>Email</th>" +
            "</tr>" +
            "</thead>" +
            "<tbody>" +
            "</tbody>"
        );

        //percorre a tabela adicionando um a um
        for (var i in tbClientes) {
            var cli = JSON.parse(tbClientes[i]);
            $("#tblListar tbody").append("<tr>" +
                "   <td><img src='img/edit.png' alt='" + i + "' class='btnEditar'/><img src='img/delete.png' alt='" + i + "' class='btnExcluir' /></td>" +
                "   <td>" + cli.Codigo + "</td>" +
                "   <td>" + cli.Nome + "</td>" +
                "   <td>" + cli.Telefone + "</td>" +
                "   <td>" + cli.Email + "</td>" +
                "</tr>"
            );
        }
    }

    //função excluir o registro
    function Excluir() {
        indice_selecionado = parseInt($(this).attr("alt"));
        tbClientes.splice(indice_selecionado, 1);
        localStorage.setItem("tbClientes", JSON.stringify(tbClientes));
        alert("Registro excluido com sucesso!");
    }

    function GetCliente(propriedade, valor) {
        var cli = null;
        for (var item in tbClientes) {
            var i = JSON.parse(tbClientes[item]);
            if (i[propriedade] == valor)
                cli = i;
        }
        return cli;
    }
    Listar();

    $("#frmCadastro").bind("submit", function() {
        if (operacao == "A")
            return adicionar();
        else
            return Editar();
    });

    $(".btnEditar").bind("click", function() {
        operacao = "E";
        indice_selecionado = parseInt($(this).attr("alt"));
        var cli = JSON.parse(tbClientes[indice_selecionado]);
        $("#txtCodigo").val(cli.Codigo);
        $("#txtNome").val(cli.Nome);
        $("#txtTelefone").val(cli.Telefone);
        $("#txtEmail").val(cli.Email);
        $("#txtCodigo").attr("readonly", "readonly");
        $("#txtNome").focus();
    });

    $(".btnExcluir").bind("click", function() {
        indice_selecionado = parseInt($(this).attr("alt"));
        Excluir();
        Listar();
    });

});