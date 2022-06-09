package formacao.desenvolvedores.tecnologia.uno.calcular;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
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
    //Declaração dos atributos
    public static final String DIVIDIR      = "Dividir";
    public static final String MULTIPLICAR  = "Multiplicar";
    public static final String SOMAR        = "Somar";
    public static final String SUBTRAIR     = "Subtrair";
    public static final String RAIZQUADRADA = "RaizQuadrada";
    public static final String POTENCIA     = "Potencia";
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

                } else if (opcaoSelecionada.equals(RAIZQUADRADA)){

                }

            }
        });

        //Método p/ limpar as views
        imgbLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spiOpcoes.setAdapter(adapterOpcoesMatematicas);
                edtOperador1.setText("");
                edtOperador1.setHint("");
                edtOperador2.setText("");
                edtOperador2.setHint("");
                tvResultado.setText("");
            }
        });
    }

    //Método p/ selecionar as operações matemáticas
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l){

        imgOperacao.setVisibility(View.VISIBLE);

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

        } else if (adapterView.getItemAtPosition(i).toString().equals(RAIZQUADRADA)){
            imgOperacao.setImageDrawable(getResources().getDrawable(R.drawable.raiz, getTheme()));


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
        int dividendo = Integer.valueOf(edtOperador1.getText().toString()).intValue();
        int divisor = Integer.valueOf(edtOperador2.getText().toString()).intValue();
        resultado = String.valueOf(dividendo / divisor);

       return "O resultado da divisão é: " + resultado;
    }

    private String multiplicar(){
        String resultado = "";
        int multiplicando = Integer.valueOf(edtOperador1.getText().toString()).intValue();
        int multiplicador = Integer.valueOf(edtOperador2.getText().toString()).intValue();
        resultado = String.valueOf(multiplicando * multiplicador);

        return "O resultado da multiplicação é: " + resultado;
    }

    private String somar(){
        String resultado = "";
        int parcela1 = Integer.valueOf(edtOperador1.getText().toString()).intValue();
        int parcela2 = Integer.valueOf(edtOperador2.getText().toString()).intValue();
        resultado = String.valueOf(parcela1 + parcela2);

        return "O resultado da soma é: " +  resultado;
    }

    private String subtrair(){
        String resultado = "";
        int minuendo = Integer.valueOf(edtOperador1.getText().toString()).intValue();
        int subtraendo = Integer.valueOf(edtOperador2.getText().toString()).intValue();
        resultado = String.valueOf(minuendo - subtraendo);

        return "O resultado da subtração é: " + resultado;
    }

    private static String raiz(){
        String resultado = "";
        int x = Integer.valueOf(edtOperador1.getText().toString()).intValue();

        resultado = String.valueOf(Math.sqrt(x));

        return "A raiz quadrada é: " + resultado;
    }



}