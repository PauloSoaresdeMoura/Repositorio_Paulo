package formacao.desenvolvedores.tecnologia.uno.calcular;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.FocusFinder;
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
    public static final String POT10        = "Pot10";
    public static final String LOGARITMO    = "Logaritmo";

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
                    tvResultado.setText(raiz());

                } else if (opcaoSelecionada.equals(POTENCIA)){
                    tvResultado.setText(potencia());

                } else if (opcaoSelecionada.equals(POT10)){
                    tvResultado.setText(pot10());

                } else if (opcaoSelecionada.equals(LOGARITMO)){
                    tvResultado.setText(logaritmo());
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

    private void setEdtOperador2Behavior(boolean block){

        if (block){
            //edtOperador2.setFocusable(false);
            edtOperador2.setEnabled(false);
        } else {
            //edtOperador2.setFocusable(true);
            edtOperador2.setEnabled(true);
        }
    }

    //Método p/ selecionar as operações matemáticas
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l){
        //Inicia com a view no comportamento padrão liberada
        setEdtOperador2Behavior(false);



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
            edtOperador1.setHint("Radicando");
            edtOperador2.setHint("Não editável");
            setEdtOperador2Behavior(false);

        } else if (adapterView.getItemAtPosition(i).toString().equals(POTENCIA)){
            imgOperacao.setImageDrawable(getResources().getDrawable(R.drawable.potencia,getTheme()));
            edtOperador1.setHint("Potência");
            edtOperador2.setHint("Não editável");
            setEdtOperador2Behavior(false);

        } else if (adapterView.getItemAtPosition(i).toString().equals(POT10)){
            imgOperacao.setImageDrawable(getResources().getDrawable(R.drawable.pot10, getTheme()));
            edtOperador1.setHint("Potência de 10");
            edtOperador2.setHint("Não editável");
            setEdtOperador2Behavior(false);

        } else if (adapterView.getItemAtPosition(i).toString().equals(LOGARITMO)){
            imgOperacao.setImageDrawable(getResources().getDrawable(R.drawable.log, getTheme()));
            edtOperador1.setHint("Logaritmo");
            edtOperador2.setHint("Não editável");
            setEdtOperador2Behavior(false);

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
        int raiz = Integer.valueOf(edtOperador1.getText().toString()).intValue();

        resultado = String.valueOf(Math.sqrt(raiz));

        return "A raiz quadrada é: " + resultado;
    }

    private static String potencia(){
        String resultado = "";
        double potencia = Double.parseDouble(edtOperador1.getText().toString());
        double elevado = Double.parseDouble(edtOperador2.getText().toString());
        resultado = String.valueOf(Math.pow(potencia, elevado));

        return "A potência é: " + resultado;
    }

    private static String pot10(){
        String resultado = "";
        double pot10 = Double.parseDouble(edtOperador1.getText().toString());
        double elevado = Double.parseDouble(edtOperador2.getText().toString());

        resultado = String.valueOf(Math.pow(pot10, elevado) );

        return "A potência de 10 é: " + resultado;
    }

    private static String logaritmo(){
        String resultado ="";
        double logaritmo = Double.parseDouble(edtOperador1.getText().toString());

        resultado = String.valueOf(Math.log(logaritmo));

        return "Resultado do log é: " + resultado;
    }

}