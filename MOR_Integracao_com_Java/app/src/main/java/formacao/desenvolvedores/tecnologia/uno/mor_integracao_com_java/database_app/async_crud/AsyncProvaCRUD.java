package formacao.desenvolvedores.tecnologia.uno.mor_integracao_com_java.database_app.async_crud;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.List;

import formacao.desenvolvedores.tecnologia.uno.mor_integracao_com_java.database_app.DatabaseApp;
import formacao.desenvolvedores.tecnologia.uno.mor_integracao_com_java.database_app.dbcallbacks.IAlunoDbCallback;
import formacao.desenvolvedores.tecnologia.uno.mor_integracao_com_java.database_app.dbcallbacks.IProvaDbCallback;
import formacao.desenvolvedores.tecnologia.uno.mor_integracao_com_java.database_app.tabelas.Aluno;
import formacao.desenvolvedores.tecnologia.uno.mor_integracao_com_java.database_app.tabelas.Prova;
import formacao.desenvolvedores.tecnologia.uno.mor_integracao_com_java.utils_app.UtilsApp;

public class AsyncProvaCRUD extends AsyncTask<Prova, Integer, List<Prova>> {
    private static String TAG = "AsyncProvaCRUD";
    private UtilsApp.DataBaseCrudOperations dbOperations;
    private Context contextActivityOrFragment;
    private List<Prova> lista = null;

    //Evitar leak de memória
    private WeakReference<IProvaDbCallback> dbCallBack;

    public AsyncProvaCRUD(UtilsApp.DataBaseCrudOperations dbOperations
            , Context context
            , IProvaDbCallback callBack){
        this.dbOperations              = dbOperations;
        this.contextActivityOrFragment = context;
        dbCallBack                     = new WeakReference(callBack);
    }

    @Override
    protected List<Prova> doInBackground(Prova... provas) {
        try{
            DatabaseApp databaseApp = DatabaseApp.getInstance(contextActivityOrFragment);
            lista                   = null;

            switch (dbOperations){
                case CREATE:{
                    for(Prova prova : provas) {
                        databaseApp.provasDAO().insertProva(prova);
                    }
                    break;
                }
                case READ:{
                    lista = databaseApp.provasDAO().getAllProva();
                    break;
                }
                case UPDATE:{
                    databaseApp.provasDAO().updateProva(provas[0]);
                    break;
                }
                case DELETE:{
                    databaseApp.provasDAO().deleteProva(provas[0]);
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
    protected void onPostExecute(List<Prova> provas) {
        super.onPostExecute(provas);

        if(dbOperations == UtilsApp.DataBaseCrudOperations.CREATE
                || dbOperations == UtilsApp.DataBaseCrudOperations.READ) {
            if (dbCallBack != null) {
                IProvaDbCallback callBack = dbCallBack.get();
                callBack.getProvaFromDB(provas);
            }
        }
    }
}
