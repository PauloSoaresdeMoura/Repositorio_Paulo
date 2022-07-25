package formacao.desenvolvedores.tecnologia.uno.mor_integracao_com_java.database_app.tabelas;

public class Resposta {
    private int id, pergunta_id;

    public Resposta() {}

    //Construtor de cópia
    public Resposta(Resposta tblResposta) {
        this.id = tblResposta.getId();


    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
