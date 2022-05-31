package paulo_moura.conceitosintent;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE = 5;
    private Button btnPergunta;
    private TextView tvExibirResposta, tvRespostaDada;
    private EditText edtPerguntar;
    private ImageButton imgbLimparPergunta;
    private ActivityResultLauncher<Intent> activityResultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvExibirResposta   = findViewById(R.id.tvExibirResposta);
        btnPergunta        = findViewById(R.id.btnPergunta);
        edtPerguntar       = findViewById(R.id.edtPerguntar);
        imgbLimparPergunta = findViewById(R.id.imgbLimparPergunta);
        tvRespostaDada     = findViewById(R.id.tvRespostaDada);


        tvRespostaDada.setVisibility(View.INVISIBLE);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setTitle("Activity de Perguntas");
        }

        btnPergunta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (! edtPerguntar.getText().toString().isEmpty()){
                    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.R) {
                        Intent intent = new Intent(MainActivity.this, RespostaActivity.class);

                        String myString = edtPerguntar.getText().toString();
                        intent.putExtra("Pergunta", myString);

                        if (!tvExibirResposta.getText().toString().isEmpty()) {
                            String myResposta = tvExibirResposta.getText().toString();
                            intent.putExtra("Resposta", myResposta);
                        }

                        startActivityForResult(intent, REQUEST_CODE);
                    }else {
                        openActivityForResult();
                    }

                }else{
                    Toast.makeText(MainActivity.this, "Por favor, digite uma pergunta.", Toast.LENGTH_SHORT).show();
                }
            }



        });

        activityResultLauncher =registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK){
                            Intent data = result.getData();
                            tvRespostaDada.setVisibility(View.VISIBLE);
                            tvExibirResposta.setText(data.getExtras().getString("returnData"));
                        }
                    }
                });

       imgbLimparPergunta.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               edtPerguntar.setText("");
           }
       });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if ((requestCode == REQUEST_CODE) && (resultCode == RESULT_OK)){

            String returnString = data.getExtras().getString("returnData");

            if (returnString != null){
                if (!returnString.isEmpty()){
                   tvRespostaDada.setVisibility(View.VISIBLE);
                   tvExibirResposta.setText(returnString);
                }
            }
        }
    }

    private void openActivityForResult(){
        Intent intent = new Intent(MainActivity.this, RespostaActivity.class);

       //duas formas de fazer a mesma coisa, salvar e chamar resultados

        /*String myString = edtPerguntar.getText().toString();
        intent.putExtra("Pergunta", myString);*/

        intent.putExtra("Pergunta", edtPerguntar.getText().toString());
        activityResultLauncher.launch(intent);

    }
}