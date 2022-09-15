package formacao.desenvolvedores.tecnologia.uno.mor_integracao_com_java.database_app.interfaces_dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;

import formacao.desenvolvedores.tecnologia.uno.mor_integracao_com_java.database_app.tabelas.Aluno;

@Dao
public interface ICRUDAlunoDAO {
    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAluno(Aluno alunoTable);//Insere o aluno na tabela aluno

    @Query("SELECT * FROM tbl_aluno WHERE id = :id")//ID é a chave primária da tabela
    Aluno getEspecificaAlunoByID(int id);

    @Query("SELECT * FROM tbl_aluno ORDER BY id DESC")//Seleciona todos os alunos da tabela
    List<Aluno> getAllAluno();

    @Transaction
    @Update(entity = Aluno.class, onConflict = OnConflictStrategy.REPLACE)
    void updateAluno(Aluno alunoTable);//Troca os nomes dos alunos

    //O CASCADE deverá funcionar aqui p/ a tabela: Aluno
    @Transaction
    @Delete(entity = Aluno.class)
    void deleteAluno(Aluno alunoTable);//Deleta aluno da tabela

    @Transaction
    @Query("DELETE FROM tbl_aluno WHERE id = :id")
    void deleteAlunoByID(int id);

    @Query("DELETE FROM tbl_aluno WHERE id > 0")
    void deleteAllAluno();//deleta todos os alunos
}
