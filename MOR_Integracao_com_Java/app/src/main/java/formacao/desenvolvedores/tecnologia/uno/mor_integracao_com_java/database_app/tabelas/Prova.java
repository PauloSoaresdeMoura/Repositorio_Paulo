package formacao.desenvolvedores.tecnologia.uno.mor_integracao_com_java.database_app.tabelas;

import androidx.room.Entity;
import androidx.room.Index;

@Entity(tableName = "tbl_prova"
        , indices = {@Index(value = "id", unique = true)})

public class Prova {
    private  int id;
    private String disciplina;

    public Prova() {}

    //Construtor de cópia
    public Prova(Prova tblProva) {
        this.id = tblProva.getId();
        this.disciplina = tblProva.getDisciplina();

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }
}
