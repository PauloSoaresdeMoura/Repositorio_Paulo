package formacao.desenvolvedores.tecnologia.uno.calcular;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static TextView tvOpcao, tvOperacao, tvResultado;
    private static Spinner spiOpcoes;
    private static EditText edtOperador1, edtOperador2;
    private static ImageView imgOperacao, imgIgual;
    private static Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvOpcao = findViewById(R.id.tvOpcao);
        spiOpcoes = findViewById(R.id.spiOpcoes);
       tvOpcao = findViewById(R.id.tvOpcao);
        tvOperacao   = findViewById(R.id.tvOperacao);
        tvResultado  = findViewById(R.id.tvResultado);
        spiOpcoes    = findViewById(R.id.spiOpcoes);
        edtOperador1 = findViewById(R.id.edtOperador1);
        edtOperador2 = findViewById(R.id.edtOperador2);
        imgOperacao  = findViewById(R.id.imgOperacao);
        imgIgual     = findViewById(R.id.imgIgual);
    }
}
