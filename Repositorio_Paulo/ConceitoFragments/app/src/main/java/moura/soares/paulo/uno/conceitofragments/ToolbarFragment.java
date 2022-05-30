package moura.soares.paulo.uno.conceitofragments;

import android.content.Context;
import android.icu.text.Transliterator;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class ToolbarFragment extends Fragment implements SeekBar.OnSeekBarChangeListener {

    private EditText edtInformarTexto;
    private Button btnAlterartexto;
    private SeekBar skbFormatarTexto;
    private ToolbarListener toolbarListener;
    private static int textSize = 10;

    public interface ToolbarListener{
        public void onButtomClick(int position, String texto);

    }

    public ToolbarFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View toolBarLayoutInflated = inflater.inflate(R.layout.fragment_toolbar, container, false);

        edtInformarTexto = toolBarLayoutInflated.findViewById(R.id.edtInformarTexto);
        btnAlterartexto  = toolBarLayoutInflated.findViewById(R.id.btnAlterarTexto);
        skbFormatarTexto = toolBarLayoutInflated.findViewById(R.id.skbFormatarTexto);


        btnAlterartexto.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                buttonClicked(view);
            }
        });

        skbFormatarTexto.setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener)this);

        return toolBarLayoutInflated;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            toolbarListener = (ToolbarListener) context;

        }
        catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
            + "Obrigatório implementar a interface ToolbarListener");
        }
    }

    public void buttonClicked(View view){
        toolbarListener.onButtomClick(
                textSize, edtInformarTexto.getText().toString());
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        textSize = i;

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}