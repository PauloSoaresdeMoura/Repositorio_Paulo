function validar() {
    var codigo = document.getElementById("codigo").value;
    var descricao = document.getElementById("descricao").value;
    var quantidade = document.getElementById("quantidade").value;

    if (!codigo) {
        document.getElementById("erro").style.display = "block";
        document.getElementById("erro").innerHTML = "Código não informado!";
        return false;
    }
    if (!descricao) {
        document.getElementById("erro").style.display = "block";
        document.getElementById("erro").innerHTML = "Informe a descrição!";
        document.getElementById("descricao").focus;
        return false;
    }
    if (!quantidade) {
        document.getElementById("erro").style.display = "block";
        document.getElementById("erro").innerHTML = "Informe a quantidade!";
        return false;
    }
}

$(function() {
    var operacao = "A"; //"A" = Adição
    var indice_selecionado = -1;
    var frmCadastro = localStorage.getItem("frmCadastro"); //recuperar os dados armazenados
    frmCadastro = JSON.parse(frmCadastro); //converte a String para objeto

    if (frmCadastro == null) //caso não exista conteúdo iniciamos um vetor vazio
        frmCadastro = [];

    //Adiciona registro no cadastro
    function adicionar() {
        var pro = GetProdutos("codigo", $("frmCadastro").val());
        if (pro != null) { //verifica se o código já está cadastrado
            alert("Código já cadastrado!");
            return;
        }
        var pro = JSON.stringify({
            codigo: $("#txtCodigo").val(),
            descricao: $("#txtDescricao").val(),
            quantidade: $("#txtQuantidade").val(),
        });

        frmCadastro.push(id);
        localStorage.setItem("frmCadastro", JSON.stringify(frmCadastro));

        alert("Registro Cadastrado com Sucesso!");
        return true;

    }

    //Edita registro cadastrado
    function Editar() {
        frmCadastro[indice_selecionado] = JSON.stringify({
            codigo: $("#txtCodigo").val(),
            descricao: $("#txtDescricao").val(),
            quantidade: $("#txtQuantidade").val(),
        });
        localStorage.setItem("frmCadastro", JSON.stringify(frmCadastro));
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
        for (var i in frmCadastro) {
            var pro = JSON.parse(frmCadastro[i]);
            $("#tblListar tbody").append("<tr>" +
                "   <td><img src=<img src='img/comprado.png' alt='" + i + "' class='btnComprado' /><'img/editar.png' alt='" + i + "' class='btnAdicionar'/><img src='img/sem_estoque.png' alt='" + i + "' class='btnSemEstoque' /></td>" +
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
        frmCadastro.splice(indice_selecionado, 1);
        localStorage.setItem("frmCadastro", JSON.stringify(frmCadastro));
        alert("Registro excluido com sucesso!");
    }

    function GetProdutos(codigo, descricao) {
        var pro = null;
        for (var item in frmCadastro) {
            var i = JSON.parse(frmCadastro[item]);
            if (i[codigo] == descricao)
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