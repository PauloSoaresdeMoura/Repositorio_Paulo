package formacao.desenvolvedores.tecnologia.uno.mor_integracao_com_java.database_app.interfaces_dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;

import formacao.desenvolvedores.tecnologia.uno.mor_integracao_com_java.database_app.tabelas.Pergunta;

@Dao
public interface ICRUDPerguntaDAO {
    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertPergunta(Pergunta perguntaTable);//Insere pergunta na tabela pergunta

    @Query("SELECT * FROM tbl_pergunta WHERE id = :id")
    public Pergunta getEspecificaPerguntaByID(int id);//Seleciona a pergunta pelo id

    @Query("SELECT * FROM tbl_pergunta ORDER BY id DESC")
    public List<Pergunta> getAllPergunta();//Seleciona todas as perguntas em ordem decrescente

    @Transaction
    @Update(entity = Pergunta.class, onConflict = OnConflictStrategy.REPLACE)
    public void updatePergunta(Pergunta perguntaTable);//Troca de pergunta

    //O CASCADE deverá funcionar aqui p/ a tabela: Pergunta
    @Transaction
    @Delete(entity = Pergunta.class)
    public void deletePergunta(Pergunta perguntaTable);//Deleta pergunta

    @Transaction
    @Query("DELETE FROM tbl_pergunta WHERE id = id")
    public void deletePerguntaByID(int id);//Deleta pergunta pelo id

    @Query("DELETE FROM tbl_pergunta WHERE id > 0")
    public void deleteAllPergunta();//Deleta todas as perguntas
}
