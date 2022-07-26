package formacao.desenvolvedores.tecnologia.uno.mor_integracao_com_java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;

import formacao.desenvolvedores.tecnologia.uno.mor_integracao_com_java.database_app.async_crud.AsyncAlunoCRUD;
import formacao.desenvolvedores.tecnologia.uno.mor_integracao_com_java.database_app.tabelas.Aluno;
import formacao.desenvolvedores.tecnologia.uno.mor_integracao_com_java.utils_app.UtilsApp;

public class MainActivity extends AppCompatActivity {
    private Context context;
    private Aluno aluno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aluno = new Aluno();
        aluno.setNome("Paulo");
        aluno.setCelular("49999999");
        aluno.setEmail("email.com");
        aluno.setGithub_usuario("psm");

        @Override
                protected void onResume(){
            super.onResume();

            context = getApplicationContext();

            AsyncAlunoCRUD asyncAlunoCRUD = new AsyncAlunoCRUD(UtilsApp.DataBaseCrudOperations.CREATE)
                    , context
                    , thhis;

            AsyncAlunoCRUD.execute(aluno);
        }


    }
}