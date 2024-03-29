package formacao.desenvolvedores.tecnologia.uno.mor_integracao_com_java.database_app.async_crud;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.List;

import formacao.desenvolvedores.tecnologia.uno.mor_integracao_com_java.database_app.DatabaseApp;
import formacao.desenvolvedores.tecnologia.uno.mor_integracao_com_java.database_app.dbcallbacks.IAlunoDbCallback;
import formacao.desenvolvedores.tecnologia.uno.mor_integracao_com_java.database_app.dbcallbacks.IAlunoProvaDbCallback;
import formacao.desenvolvedores.tecnologia.uno.mor_integracao_com_java.database_app.tabelas.Aluno;
import formacao.desenvolvedores.tecnologia.uno.mor_integracao_com_java.database_app.tabelas.AlunoProva;
import formacao.desenvolvedores.tecnologia.uno.mor_integracao_com_java.utils_app.UtilsApp;

public class AsyncAlunoProvaCRUD extends AsyncTask<AlunoProva, Integer, List<AlunoProva>> {
    private static String TAG = "AsyncAlunoProvaCRUD";
    private UtilsApp.DataBaseCrudOperations dbOperations;
    private Context contextActivityOrFragment;
    private List<AlunoProva> lista = null;

    //Evitar leak de memória
    private WeakReference<IAlunoProvaDbCallback> dbCallBack;

    public AsyncAlunoProvaCRUD(UtilsApp.DataBaseCrudOperations dbOperations
            , Context context
            , IAlunoProvaDbCallback callBack){
        this.dbOperations              = dbOperations;
        this.contextActivityOrFragment = context;
        dbCallBack                     = new WeakReference(callBack);
    }


    @Override
    protected List<AlunoProva> doInBackground(AlunoProva... alunosProvas) {
        try{
            DatabaseApp databaseApp = DatabaseApp.getInstance(contextActivityOrFragment);
            lista                   = null;

            switch (dbOperations){
                case CREATE:{
                    for(AlunoProva alunoProva : alunosProvas) {
                        databaseApp.alunoProvaDAO().insertAlunoProva(alunoProva);
                    }
                    break;
                }
                case READ:{
                    lista = databaseApp.alunoProvaDAO().getAllAlunoProva();
                    break;
                }
                case UPDATE:{
                    databaseApp.alunoProvaDAO().updateAlunoProva(alunosProvas[0]);
                    break;
                }
                case DELETE:{
                    databaseApp.alunoProvaDAO().deleteAlunoProva(alunosProvas[0]);
                    break;
                }
            }
        } catch (Exception e){
            Log.d(TAG, "doInBackground: FALHA - " + e.getMessage());
            e.printStackTrace();
        }

        return lista;
    }

    @Override
    protected void onPostExecute(List<AlunoProva> alunosProvas) {
        super.onPostExecute(alunosProvas);

        if(dbOperations == UtilsApp.DataBaseCrudOperations.CREATE
                || dbOperations == UtilsApp.DataBaseCrudOperations.READ) {
            if (dbCallBack != null) {
                IAlunoProvaDbCallback callBack = dbCallBack.get();
                callBack.getAlunoProvaFromDB(alunosProvas);
            }
        }
    }
}
