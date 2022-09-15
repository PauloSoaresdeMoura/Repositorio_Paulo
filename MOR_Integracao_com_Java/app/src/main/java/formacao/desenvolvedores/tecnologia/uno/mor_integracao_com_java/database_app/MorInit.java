package formacao.desenvolvedores.tecnologia.uno.mor_integracao_com_java.database_app;

import android.app.Application;
import android.util.Log;

public class MorInit extends Application {
    public static final String TAG = "MorInit";

    @Override
    public void onCreate() {
        super.onCreate();

        DatabaseApp databaseApp = DatabaseApp.getInstance(this);
        if(databaseApp != null) {
            Log.d(TAG, "Banco criado na inicialização do app.");
        }
    }
}
