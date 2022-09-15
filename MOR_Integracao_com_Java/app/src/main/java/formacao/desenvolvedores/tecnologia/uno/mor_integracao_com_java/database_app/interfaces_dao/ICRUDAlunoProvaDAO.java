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
import formacao.desenvolvedores.tecnologia.uno.mor_integracao_com_java.database_app.tabelas.AlunoProva;

@Dao
public interface ICRUDAlunoProvaDAO {
    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertAlunoProva(AlunoProva alunoProvaTable);//Insere aluno prova na tabela AlunoProva

    @Query("SELECT * FROM tbl_alunoProva WHERE id_aluno = :idAluno AND id_prova = :idProva")
    public AlunoProva getEspecificaAlunoProvaByID(int idAluno, int idProva);

    @Query("SELECT * FROM tbl_alunoProva ORDER BY id_aluno DESC")//Seleciona todos os alunos
    public List<AlunoProva> getAllAlunoProva();

    @Transaction
    @Update(entity = AlunoProva.class, onConflict = OnConflictStrategy.REPLACE)
    public void updateAlunoProva(AlunoProva alunoProvaTable);//Troca de alunos na tabela alunoProva

    //O CASCADE deverá funcionar aqui p/ a tabela: AlunoProva
    @Transaction
    @Delete(entity = AlunoProva.class)
    public void deleteAlunoProva(AlunoProva alunoProvaTable);//Deleta aluno

    @Transaction
    @Query("DELETE FROM tbl_alunoProva WHERE id_aluno = :id")
    public void deleteAlunoProvaByID(int id);//Deleta os alunos pelo id

    @Query("DELETE FROM tbl_alunoProva WHERE id_aluno > 0")
    public void deleteAllAlunoProva();//Deleta todos os alunos
}
