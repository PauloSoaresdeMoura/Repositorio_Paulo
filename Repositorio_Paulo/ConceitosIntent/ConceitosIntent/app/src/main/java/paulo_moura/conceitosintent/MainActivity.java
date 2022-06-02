package paulo_moura.conceitosintent;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
                    Intent intent = new Intent(MainActivity.this, RespostaActivity.class);

                    String myString = edtPerguntar.getText().toString();
                    intent.putExtra("Pergunta", myString);

                    startActivityForResult(intent, REQUEST_CODE);

                }else{
                    Toast.makeText(MainActivity.this, "Por favor, digite uma pergunta.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        if (Build.VERSION.sdk_int < Build.VERSION_CODES.){

        }else {

        }


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

}