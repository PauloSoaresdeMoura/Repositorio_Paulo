$(function() {
    var operacao = "A"; //"A" = Adição 
    var indice_selecionado = -1;
    var tbProdutos = localStorage.getItem("tbProdutos"); //recuperar os dados armazenados
    tbProdutos = JSON.parse(tbProdutos); //converte a String para objeto

    if (tbProdutos == null) // Caso não exista conteudo, iniciamos um vetor vazio!
        tbProdutos = [];

    //Adiciona novo registro
    function adicionar() {
        var pro = localStorage.GetProdutos("Codigo", $("txtCodigo").val());
        if (pro != null) { //Verifica se o codigo já está cadastrado
            alert("Código já cadastrado!");
            return;
        }
        var produto = JSON.stringify({
            Codigo: $("#txtCodigo").val(),
            Descricao: $("#txtDescricao").val(),
            Quantidade: $("#txtQuantidade").val()
        });

        tbProdutos.push(produto);
        localStorage.setItem("tbProdutos", JSON.stringify(tbProdutos));

        alert("Registro cadastrado com sucesso!");
        return true;

    }

    //Edita registro cadastrado
    function Editar() {
        tbProdutos[indice_selecionado] = JSON.stringify({
            Codigo: $("#txtCodigo").val(),
            Descricao: $("#txtDescricao").val(),
            Quantidade: $("#txtQuantidade").val(),
        });
        localStorage.setItem("tbProdutos", JSON.stringify(tbProdutos));
        alert("Informações editadas com sucesso!")
        operacao = "A";
        return true;
    }

    //Listar conteudo
    function Listar() {
        $("#tblListar").html("");
        $("#tblListar").html(
            "<thead>" + "<tr>" + "<th></th>" +
            "<th>Codigo</th>" +
            "<th>Descricao</th>" +
            "<th>Quantidade</th>" +
            "</tr>" +
            "</thead>" +
            "<tbody>" +
            "</tbody>"
        );

        //Percorre a tabela adicionando um a um
        for (var i in tbProdutos) {
            var pro = JSON.parse(tbProdutos[i]);
            $("#tblListar tbody").append("<tr>" + //The Element.append() method inserts a set of Node objects or string
                "	<td><img src='img/edit.png' alt='" + i + "' class='btnEditar'/><img src='img/delete.png' alt='" + i + "' class='btnExcluir'/></td>" +
                "	<td>" + pro.Codigo + "</td>" +
                "	<td>" + pro.Descricao + "</td>" +
                "	<td>" + pro.Quantidade + "</td>" +
                "</tr>");
        }
    }

    //Função que exclui o registro
    function Excluir() {
        indice_selecionado = parseInt($(this).attr("alt")); //attr = utilizada para guardar valor de um determinado atributo do elemento selecionado e usar na folha se sestilo
        tbProdutos.splice(indice_selecionado, 1);
        localStorage.setItem("tbProdutos", JSON.stringify(tbProdutos));
        alert("Registro excluído.");
    }

    function GetProdutos(propriedade, valor) {
        var pro = null;
        for (var item in tbProdutos) {
            var i = JSON.parse(tbProdutos[item]);
            if (i[propriedade] == valor)
                pro = i;
        }
        return pro;
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
        var pro = JSON.parse(tbProdutos[indice_selecionado]);
        $("#txtCodigo").val(pro.Codigo);
        $("#txtDescricao").val(pro.Descricao);
        $("#txtQuantidade").val(pro.Quantidade);
        $("#txtCodigo").attr("readonly", "readonly");
        $("#txtDescricao").focus();
    });

    $(".btnExcluir").bind("click", function() {
        indice_selecionado = parseInt($(this).attr("alt"));
        Excluir();
        Listar();
    });
});

function validar() {
    var Codigo = document.getElementById("Codigo").value;
    var Descricao = document.getElementById("Descricao").value;
    var Quantidade = document.getElementById("Quantidade").value;
    if (!Codigo) {
        document.getElementById("erro").style.display = "block";
        document.getElementById("erro").innerHTML = "Campo Código não Informado!";
        return false;
    }
    if (!Descricao) {
        document.getElementById("erro").style.display = "block";
        document.getElementById("erro").innerHTML = "Informe a Descrição!";
        document.getElementById("Descricao").focus;
        return false;
    }
    if (!Quantidade) {
        document.getElementById("erro").style.display = "block";
        document.getElementById("erro").innerHTML = "Informe a Quantidade!";
        return false;
    }
}