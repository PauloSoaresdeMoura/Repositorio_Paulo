package formacao.desenvolvedores.tecnologia.uno.mor_integracao_com_java.database_app.tabelas;

import static androidx.room.ForeignKey.CASCADE;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "tbl_alunoProva"
        , primaryKeys = {"id_aluno", "id_prova"}
        , indices = {@Index(value = {"id_aluno"}), @Index(value = {"id_prova"})}
        , foreignKeys = {@ForeignKey(entity = Aluno.class, parentColumns = "id",
        childColumns = "idAluno", onUpdate = CASCADE, onDelete = CASCADE)
        , @ForeignKey(entity = Prova.class, parentColumns = "id",
        childColumns = "id_prova", onUpdate = CASCADE, onDelete = CASCADE)})

public class AlunoProva {
    @PrimaryKey (autoGenerate = true)
    private int id_aluno, id_prova;

    public AlunoProva() {}

    //Construtor de cópia
    public AlunoProva(AlunoProva tblAlunoProva) {
        this.id_aluno = tblAlunoProva.getId_aluno();
        this.id_prova = tblAlunoProva.getId_prova();
    }

    public int getId_aluno() {
        return id_aluno;
    }

    public void setId_aluno(int id_aluno) {
        this.id_aluno = id_aluno;
    }

    public int getId_prova() {
        return id_prova;
    }

    public void setId_prova(int id_prova) {
        this.id_prova = id_prova;
    }
}
