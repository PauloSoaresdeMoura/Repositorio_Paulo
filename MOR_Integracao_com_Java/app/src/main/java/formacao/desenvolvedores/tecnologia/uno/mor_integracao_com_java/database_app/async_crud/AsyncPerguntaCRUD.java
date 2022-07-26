package formacao.desenvolvedores.tecnologia.uno.mor_integracao_com_java.database_app.async_crud;

import android.content.Context;
import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.List;

import formacao.desenvolvedores.tecnologia.uno.mor_integracao_com_java.database_app.DatabaseApp;
import formacao.desenvolvedores.tecnologia.uno.mor_integracao_com_java.database_app.dbcallbacks.IPerguntaDbCallback;
import formacao.desenvolvedores.tecnologia.uno.mor_integracao_com_java.database_app.tabelas.Pergunta;
import formacao.desenvolvedores.tecnologia.uno.mor_integracao_com_java.utils_app.UtilsApp;

public class AsyncPerguntaCRUD {
    private static String TAG = "AsyncPerguntaCRUD";
    private UtilsApp.DataBaseCrudOperations dbOperations;
    private Context contextActivityOrFragment;
    private List<Pergunta> lista = null;

    //Evitar leak de memória
    private WeakReference<IPerguntaDbCallback> dbCallBack;

    public AsyncPerguntaCRUD(UtilsApp.DataBaseCrudOperations dbOperations
            , Context context
            , IPerguntaDbCallback callBack){
        this.dbOperations              = dbOperations;
        this.contextActivityOrFragment = context;
        dbCallBack                     = new WeakReference(callBack);
    }


    @Override
    protected List<Pergunta> doInBackground(Pergunta... perguntas) {
        try{
            DatabaseApp databaseApp = DatabaseApp.getInstance(contextActivityOrFragment);
            lista                   = null;

            switch (dbOperations){
                case CREATE:{
                    for(Pergunta pergunta : perguntas) {
                        databaseApp.perguntasDAO().insertPergunta(pergunta);
                    }
                    break;
                }
                case READ:{
                    lista = databaseApp.perguntasDAO().getAllPerguntas();
                    break;
                }
                case UPDATE:{
                    databaseApp.perguntasDAO().updatePerguntas(perguntas[0]);
                    break;
                }
                case DELETE:{
                    databaseApp.perguntasDAO().deletePergunta(perguntas[0]);
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
    protected void onPostExecute(List<Pergunta> perguntas) {
        super.onPostExecute(perguntas);

        if(dbOperations == UtilsApp.DataBaseCrudOperations.CREATE
                || dbOperations == UtilsApp.DataBaseCrudOperations.READ) {
            IPerguntaDbCallback callBack = dbCallBack.get();
            if (callBack != null) {
                callBack.getPerguntaFromDB(perguntas);
            }
        }
    }
}
