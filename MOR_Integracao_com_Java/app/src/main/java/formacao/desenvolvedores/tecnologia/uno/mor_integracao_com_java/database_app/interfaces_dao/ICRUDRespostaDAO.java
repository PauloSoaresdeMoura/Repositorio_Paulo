package formacao.desenvolvedores.tecnologia.uno.mor_integracao_com_java.database_app.interfaces_dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;

import formacao.desenvolvedores.tecnologia.uno.mor_integracao_com_java.database_app.tabelas.Resposta;

@Dao
public interface ICRUDRespostaDAO {
    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertResposta(Resposta respostaTable);//Insere respostas na tabela resposta

    @Query("SELECT * FROM tbl_resposta WHERE id = :id")
    public Resposta getEspecificaRespostaByID(int id);//Seleciona resposta pelo id

    @Query("SELECT * FROM tbl_resposta ORDER BY id DESC")
    public List<Resposta> getAllResposta();//Seleciona todas as respostas pelo id em ordem decrescente

    @Transaction
    @Update(entity = Resposta.class, onConflict = OnConflictStrategy.REPLACE)
    public void updateResposta(Resposta respostaTable);//Troca as respostas

    //O CASCADE deverá funcionar aqui p/ a tabela: Resposta
    @Transaction
    @Delete(entity = Resposta.class)
    public void deleteResposta(Resposta respostaTable);//Deleta resposta

    @Transaction
    @Query("DELETE FROM tbl_resposta WHERE id = :id")
    public void deleteRespostaByID(int id);//Deleta as respostas pelo id

    @Query("DELETE FROM tbl_resposta WHERE id > 0")
    public void deleteAllResposta();//Deleta todas as respostas
}
