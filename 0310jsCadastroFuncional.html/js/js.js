$(function() {
    var operacao = "A"; //"A" = Adição
    var indice_selecionado = -1;
    var form = localStorage.getItem("form"); //recuperar os dados armazenados
    form = JSON.parse(form); //converte a String para objeto

    if (form == null) //caso não exista conteúdo iniciamos um vetor vazio
        form = [];

    //Adiciona registro no cadastro
    function adicionar() {
        var pro = localStorage.GetProdutos("codigo", $("txtCodigo").val());
        if (pro != null) { //verifica se o código já está cadastrado
            alert("Código já cadastrado!");
            return;
        }
        var pro = JSON.stringify({
            codigo: $("#txtCodigo").val(),
            descricao: $("#txtDescricao").val(),
            quantidade: $("#txtQuantidade").val(),
        });

        form.push(produto);
        localStorage.setItem("form", JSON.stringify(form));

        alert("Registro Cadastrado com Sucesso!");
        return true;

    }

    //Edita registro cadastrado
    function Editar() {
        form[indice_selecionado] = JSON.stringify({
            codigo: $("#txtCodigo").val(),
            descricao: $("#txtDescricao").val(),
            quantidade: $("#txtQuantidade").val(),
        });
        localStorage.setItem("form", JSON.stringify(form));
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
            "<th>Descrição</th>" +
            "<th>Quantidade</th>" +
            "</tr>" +
            "</thead>" +
            "<tbody>" +
            "</tbody>"
        );

        //percorre a tabela adicionando um a um
        for (var i in form) {
            var pro = JSON.parse(form[i]);
            $("#tblListar tbody").append("<tr>" +
                "   <td><img src='img/editar.png' alt='" + i + "' class='btnAdicionar'/><img src='img/sem_estoque.png' alt='" + i + "' class='btnExcluir' /></td>" +
                "   <td>" + pro.codigo + "</td>" +
                "   <td>" + pro.descricao + "</td>" +
                "   <td>" + pro.quantidade + "</td>" +
                "</tr>"
            );
        }
    }

    //função excluir o registro
    function Excluir() {
        indice_selecionado = parseInt($(this).attr("alt"));
        form.splice(indice_selecionado, 1);
        localStorage.setItem("form", JSON.stringify(form));
        alert("Registro excluido com sucesso!");
    }

    function GetProdutos(propriedade, valor) {
        var pro = null;
        for (var item in form) {
            var i = JSON.parse(form[item]);
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

    $(".btnAdicionar").bind("click", function() {
        operacao = "E";
        indice_selecionado = parseInt($(this).attr("alt"));
        var pro = JSON.parse(form[indice_selecionado]);
        $("#txtCodigo").val(pro.codigo);
        $("#txtDescricao").val(pro.descricao);
        $("#txtQuantidade").val(pro.quantidade);
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