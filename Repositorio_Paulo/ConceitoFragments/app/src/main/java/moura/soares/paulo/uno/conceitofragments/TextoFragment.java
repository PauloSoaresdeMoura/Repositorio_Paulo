package moura.soares.paulo.uno.conceitofragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TextoFragment extends Fragment {

    private static TextView tvFormatarTexto;

    public TextoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View textoLayoutInflated = inflater.inflate(R.layout.fragment_texto, container, false);

        tvFormatarTexto = textoLayoutInflated.findViewById(R.id.tvFormatarTexto);

        return textoLayoutInflated;
    }

    public void trocarPropriedadesDoTexto(int position, String text){
        tvFormatarTexto.setTextSize(position);
        tvFormatarTexto.setText(text);
    }
}