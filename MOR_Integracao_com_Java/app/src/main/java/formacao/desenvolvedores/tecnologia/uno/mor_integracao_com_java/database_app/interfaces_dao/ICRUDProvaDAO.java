package formacao.desenvolvedores.tecnologia.uno.mor_integracao_com_java.database_app.interfaces_dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;

import formacao.desenvolvedores.tecnologia.uno.mor_integracao_com_java.database_app.tabelas.Prova;

@Dao
public interface ICRUDProvaDAO {
    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertProva(Prova provaTable);//Insere prova na tabela prova

    @Query("SELECT * FROM tbl_prova WHERE id = :id")
    public Prova getEspecificaProvaByID(int id);//Seleciona a prova pelo id

    @Query("SELECT * FROM tbl_prova ORDER BY id DESC")
    public List<Prova> getAllProva();//Seleciona todas as provas em ordem decrescente

    @Transaction
    @Update(entity = Prova.class, onConflict = OnConflictStrategy.REPLACE)
    public void updateProva(Prova provaTable);//Troca de prova

    //O CASCADE deverá funcionar aqui p/ a tabela: Prova
    @Transaction
    @Delete(entity = Prova.class)
    public void deleteProva(Prova provaTable);//Deleta prova

    @Transaction
    @Query("DELETE FROM tbl_prova WHERE id = id")
    public void deleteProvaByID(int id);//Deleta prova pelo id

    @Query("DELETE FROM tbl_prova WHERE id > 0")
    public void deleteAllProva();//Deleta todas as provas
}
