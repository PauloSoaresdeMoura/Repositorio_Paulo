package formacao.desenvolvedores.tecnologia.uno.mor_integracao_com_java.database_app;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import formacao.desenvolvedores.tecnologia.uno.mor_integracao_com_java.database_app.converter.Converters;

@TypeConverters({Converters.class})
public abstract class DatabaseApp extends RoomDatabase {
    private static final String DB_NAME = "db_app.db";//nome do banco de dados que será criado
    private static volatile DatabaseApp sInstance;
    public static final String TAG = "DatabaseApp";



    public DatabaseApp() {//construtor público vazio
    }

    public static synchronized DatabaseApp getInstance(Context context){

        return null;
    }

    private static DatabaseApp getConnection(Context contextActivity){

        return null;
    }

    static RoomDatabase.Callback initDB = new RoomDatabase.Callback(){
        @Override
        public void onCreate (@NonNull SupportSQLiteDatabase db){
            super.onOpen(db);
            Executors.newSingleThreadScheduledExecutor().execute(() -> {
                Log.d(TAG , "Banco criado com sucesso! Executar rotinas posteriores.");
            });
        }

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
        }

    };



}
