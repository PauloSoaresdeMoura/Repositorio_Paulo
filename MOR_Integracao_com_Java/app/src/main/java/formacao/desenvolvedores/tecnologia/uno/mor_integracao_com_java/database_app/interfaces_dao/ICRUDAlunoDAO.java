package formacao.desenvolvedores.tecnologia.uno.mor_integracao_com_java.database_app.interfaces_dao;

import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import formacao.desenvolvedores.tecnologia.uno.mor_integracao_com_java.database_app.tabelas.Aluno;

public interface ICRUDAlunoDAO {
    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertAluno(Aluno alunoTable);

    @Query("SELECT * FROM tbl_aluno where id = :id")
    public Aluno getEspecificaAlunoByID(int id);

}
