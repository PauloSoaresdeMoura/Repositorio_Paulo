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
import android.widget.ImageButton;
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
    private static ImageButton imgbLimpar;

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
        imgbLimpar   = findViewById(R.id.imgbLimpar);

        imgOperacao.setVisibility(View.INVISIBLE);

        ArrayAdapter<String> adapterOpcoesMatematicas = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,
                getResources().getStringArray(R.array.operacoes_matematica));
        adapterOpcoesMatematicas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spiOpcoes.setAdapter(adapterOpcoesMatematicas);
        spiOpcoes.setOnItemSelectedListener(this);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Pega a opção selecionada no Spinner
                String opcaoSelecionada = spiOpcoes.getSelectedItem().toString();

                if (opcaoSelecionada.isEmpty()){
                    Toast.makeText(MainActivity.this, "Escolha um operador matemático!",
                            Toast.LENGTH_SHORT).show();

                } else if (edtOperador1.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Adicione o primeiro valor!",
                            Toast.LENGTH_SHORT).show();

                } else if (edtOperador2.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Adicione o segundo valor!",
                            Toast.LENGTH_SHORT).show();

                } else if (opcaoSelecionada.equals(DIVIDIR)){
                    tvResultado.setText(dividir());

                } else if (opcaoSelecionada.equals(MULTIPLICAR)){
                    tvResultado.setText(multiplicar());

                } else if (opcaoSelecionada.equals(SOMAR)){
                    tvResultado.setText(somar());

                } else if (opcaoSelecionada.equals(SUBTRAIR)){
                    tvResultado.setText(subtrair());
                }
            }
        });

        imgbLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spiOpcoes.setAdapter(adapterOpcoesMatematicas);
                edtOperador1.setText("");
                edtOperador2.setText("");
                tvResultado.setText("");
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
            edtOperador1.setHint("Dividendo");
            edtOperador2.setHint("Divisor");

        } else if (adapterView.getItemAtPosition(i).toString().equals(MULTIPLICAR)){
            imgOperacao.setImageDrawable(getResources().getDrawable(R.drawable.multiplica, getTheme()));
            edtOperador1.setHint("Multiplicando");
            edtOperador2.setHint("Multiplicador");

        } else if (adapterView.getItemAtPosition(i).toString().equals(SOMAR)){
            imgOperacao.setImageDrawable(getResources().getDrawable(R.drawable.soma, getTheme()));
            edtOperador1.setHint("Parcela");
            edtOperador2.setHint("Parcela");

        } else if (adapterView.getItemAtPosition(i).toString().equals(SUBTRAIR)){
            imgOperacao.setImageDrawable(getResources().getDrawable(R.drawable.subtracao, getTheme()));
            edtOperador1.setHint("Minuendo");
            edtOperador2.setHint("Subtraendo");

        } else {
            imgOperacao.setVisibility(View.INVISIBLE);
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    //Métodos de validação
    private String dividir(){
        String resultado = "";
        int n1 = Integer.valueOf(edtOperador1.getText().toString()).intValue();
        int n2 = Integer.valueOf(edtOperador2.getText().toString()).intValue();
        resultado = String.valueOf(n1 / n2);

       return "O resultado da divisão é: " + resultado;
    }

    private String multiplicar(){
        String resultado = "";
        int n1 = Integer.valueOf(edtOperador1.getText().toString()).intValue();
        int n2 = Integer.valueOf(edtOperador2.getText().toString()).intValue();
        resultado = String.valueOf(n1 * n2);

        return "O resultado da multiplicação é: " + resultado;
    }

    private String somar(){
        String resultado = "";
        int n1 = Integer.valueOf(edtOperador1.getText().toString()).intValue();
        int n2 = Integer.valueOf(edtOperador2.getText().toString()).intValue();
        resultado = String.valueOf(n1 + n2);

        return "O resultado da soma é: " +  resultado;
    }

    private String subtrair(){
        String resultado = "";
        int n1 = Integer.valueOf(edtOperador1.getText().toString()).intValue();
        int n2 = Integer.valueOf(edtOperador2.getText().toString()).intValue();
        resultado = String.valueOf(n1 - n2);

        return "O resultado da subtração é: " + resultado;
    }

    private boolean validarTermoVazio(EditText editText){

        return editText.getText().toString().isEmpty();
    }


}