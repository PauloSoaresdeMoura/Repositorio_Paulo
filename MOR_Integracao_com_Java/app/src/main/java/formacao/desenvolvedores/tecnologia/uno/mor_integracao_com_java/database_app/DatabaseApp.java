package formacao.desenvolvedores.tecnologia.uno.mor_integracao_com_java.database_app;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import formacao.desenvolvedores.tecnologia.uno.mor_integracao_com_java.database_app.converter.Converters;
import formacao.desenvolvedores.tecnologia.uno.mor_integracao_com_java.database_app.interfaces_dao.ICRUDAlunoDAO;
import formacao.desenvolvedores.tecnologia.uno.mor_integracao_com_java.database_app.interfaces_dao.ICRUDAlunoProvaDAO;
import formacao.desenvolvedores.tecnologia.uno.mor_integracao_com_java.database_app.interfaces_dao.ICRUDPerguntaDAO;
import formacao.desenvolvedores.tecnologia.uno.mor_integracao_com_java.database_app.interfaces_dao.ICRUDProvaDAO;
import formacao.desenvolvedores.tecnologia.uno.mor_integracao_com_java.database_app.interfaces_dao.ICRUDRespostaDAO;
import formacao.desenvolvedores.tecnologia.uno.mor_integracao_com_java.database_app.tabelas.Aluno;
import formacao.desenvolvedores.tecnologia.uno.mor_integracao_com_java.database_app.tabelas.AlunoProva;
import formacao.desenvolvedores.tecnologia.uno.mor_integracao_com_java.database_app.tabelas.Pergunta;
import formacao.desenvolvedores.tecnologia.uno.mor_integracao_com_java.database_app.tabelas.Prova;
import formacao.desenvolvedores.tecnologia.uno.mor_integracao_com_java.database_app.tabelas.Resposta;

@Database(entities = {Aluno.class, Prova.class
        , AlunoProva.class, Pergunta.class
        , Resposta.class}
        , exportSchema = false
        , version = 1)

@TypeConverters({Converters.class})
public abstract class DatabaseApp extends RoomDatabase {
    private static final String     TAG = "DatabaseApp";
    private static final String DB_NAME = "db_app.db";
    private static volatile DatabaseApp sInstance;

    //Definição dos atributos de classe das interfaces DAO
    public abstract ICRUDAlunoDAO alunosDAO();
    public abstract ICRUDProvaDAO provasDAO();
    public abstract ICRUDAlunoProvaDAO alunoProvaDAO();
    public abstract ICRUDPerguntaDAO perguntasDAO();
    public abstract ICRUDRespostaDAO respostasDAO();

    public DatabaseApp() {}

    public static synchronized DatabaseApp getInstance(Context context) {
        if (sInstance == null) {
            sInstance = getConnection(context);
        }
        return sInstance;
    }

    private static DatabaseApp getConnection(Context activityContext) {
        DatabaseApp db = Room.databaseBuilder(activityContext, DatabaseApp.class, DB_NAME)
                .addCallback(initDB)
                .build();

        return db;

    }


    static RoomDatabase.Callback initDB = new RoomDatabase.Callback() {
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            Executors.newSingleThreadScheduledExecutor().execute(() -> {
                //Executar métodos e\ou rotinas logo appós a criação do banco
                Log.d(TAG, "Banco criado com sucesso! Executar rotinas posteriores.");

            });
        }

        public void onOpen(SupportSQLiteDatabase db){

        }

    };

}
