package formacao.desenvolvedores.tecnologia.uno.mor_integracao_com_java.database_app.tabelas;

import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "tbl_resposta"
        , indices = {@Index(value = "id", unique = true)})

public class Resposta {
    @PrimaryKey (autoGenerate = true)
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
