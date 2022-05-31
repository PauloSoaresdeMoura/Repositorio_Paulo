package paulo_moura.conceitosintent;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class RespostaActivity extends AppCompatActivity {
    private static final int REQUEST_CODE = 5;
    private Button btnResponda;
    private TextView tvExibirPergunta;
    private EditText edtResposta;
    private ImageButton imgbLimparResposta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resposta);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Activity de Respostas");
        }

        btnResponda        = findViewById(R.id.btnResponda);
        tvExibirPergunta   = findViewById(R.id.tvExibirPergunta);
        edtResposta        = findViewById(R.id.edtResposta);
        imgbLimparResposta = findViewById(R.id.imgbLimparResposta);

        Bundle extras      = getIntent().getExtras();
        String pergunta = "";

        if (extras != null){
            pergunta = extras.getString("Pergunta");
            tvExibirPergunta.setText(pergunta);
        }

        imgbLimparResposta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        btnResponda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });
    }

    @Override
    public void finish(){
        Intent data = new Intent();

        //O contexto da resposta é salvo aqui
        String returnString = edtResposta.getText().toString();
        data.putExtra("returnData", returnString);

        //O contexto da pergunta é salvo aqui
        setResult(RESULT_OK, data);
        super.finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        switch (item.getItemId()){
            case android.R.id.home:{
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

   /* @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if ((requestCode == REQUEST_CODE) && (resultCode == RESULT_OK)){

            String returnString = data.getExtras().getString("returnData");
            String resposta     = data.getExtras().getString("Resposta");

            if (resposta != null){
                if (!resposta.isEmpty()){
                    edtResposta.setText(resposta);
                }
            }

            tvExibirPergunta.setText(returnString);
        }
    }*/

}