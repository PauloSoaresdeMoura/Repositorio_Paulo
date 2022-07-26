package formacao.desenvolvedores.tecnologia.uno.mor_integracao_com_java.utils_app;

import formacao.desenvolvedores.tecnologia.uno.mor_integracao_com_java.database_app.DatabaseApp;

public class UtilsApp {
    public static final String TAG = "UtilsApp";
    private static DataBaseCrudOperations dataBaseCrudoperations;

    public enum DataBaseCrudOperations{
        CREATE,
        READ,
        UPDATE,
        DELETE,
        NOME

    }
}
