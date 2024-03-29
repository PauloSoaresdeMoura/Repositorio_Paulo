package formacao.desenvolvedores.tecnologia.uno.mor_integracao_com_java.database_app.tabelas;

import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "tbl_pergunta"
        , indices = {@Index(value = "id", unique = true)})

public class Pergunta {
    @PrimaryKey (autoGenerate = true)
    private int id;
    private int prova_id;
    private String pergunta;
    public Pergunta() {}

    //Construtor de cópia
    public Pergunta(Pergunta tblAluno) {
        this.id       = tblAluno.getId();
        this.prova_id = tblAluno.getProva_id();
        this.pergunta = tblAluno.getPergunta();
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProva_id() {
        return prova_id;
    }

    public void setProva_id(int prova_id) {
        this.prova_id = prova_id;
    }
}
