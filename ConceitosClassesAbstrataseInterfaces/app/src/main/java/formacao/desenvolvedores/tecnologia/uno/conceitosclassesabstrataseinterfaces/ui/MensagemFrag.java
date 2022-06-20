package formacao.desenvolvedores.tecnologia.uno.conceitosclassesabstrataseinterfaces.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import formacao.desenvolvedores.tecnologia.uno.conceitosclassesabstrataseinterfaces.R;

public class MensagemFrag extends Fragment {

    public MensagemFrag() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layoutFragment = inflater.inflate(R.layout.fragment_mensagem, container, false);


        return layoutFragment;
    }
}