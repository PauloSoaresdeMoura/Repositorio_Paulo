package formacao.desenvolvedores.tecnologia.uno.calcular;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    public static final String DIVIDIR     = "Dividir";
    public static final String MULTIPLICAR = "Multiplicar";
    public static final String SOMAR       = "Somar";
    public static final String SUBTRAIR    = "Subtrair";
    private static EditText edtOperador1, edtOperador2;
    private static TextView tvResultado;
    private static Spinner spiOpcoes;
    private static Button btnCalcular;
    private static ImageView imgOperacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResultado  = findViewById(R.id.tvResultado);
        spiOpcoes    = findViewById(R.id.spiOpcoes);
        edtOperador1 = findViewById(R.id.edtOperador1);
        edtOperador2 = findViewById(R.id.edtOperador2);
        btnCalcular  = findViewById(R.id.btnCalcular);
        imgOperacao  = findViewById(R.id.imgOperacao);

        imgOperacao.setVisibility(View.INVISIBLE);

        ArrayAdapter<String> adapterOpcoesMatematicas = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,
                getResources().getStringArray(R.array.operacoes_matematica));
        adapterOpcoesMatematicas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spiOpcoes.setAdapter(adapterOpcoesMatematicas);
        spiOpcoes.setOnItemSelectedListener(this);

        String opcaoSelecionada = spiOpcoes.getSelectedItem().toString();

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l){

        //Toast.makeText(MainActivity.this, adapterView.getItemAtPosition(i).toString(),
                //Toast.LENGTH_SHORT).show();

        imgOperacao.setVisibility(View.VISIBLE);

        //imgOperacao.setImageDrawable(getResources().getDrawable(R.drawable.soma, getTheme());

        if (adapterView.getItemAtPosition(i).toString().equals(DIVIDIR)){
            imgOperacao.setImageDrawable(getResources().getDrawable(R.drawable.divisao, getTheme()));

        } else if (adapterView.getItemAtPosition(i).toString().equals(MULTIPLICAR)){
            imgOperacao.setImageDrawable(getResources().getDrawable(R.drawable.multiplica, getTheme()));

        } else if (adapterView.getItemAtPosition(i).toString().equals(SOMAR)){
            imgOperacao.setImageDrawable(getResources().getDrawable(R.drawable.soma, getTheme()));

        } else if (adapterView.getItemAtPosition(i).toString().equals(SUBTRAIR)){
            imgOperacao.setImageDrawable(getResources().getDrawable(R.drawable.subtracao, getTheme()));

        } else {
            //Log.d(TAG, "Nenhuma operação matemática foi selecionada!");

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}