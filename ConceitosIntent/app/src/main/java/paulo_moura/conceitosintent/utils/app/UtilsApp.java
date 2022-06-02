package paulo_moura.conceitosintent.utils.app;

import android.content.Context;
import android.widget.Toast;

public class UtilsApp {
    //Escopo de classe
    private int soma = 0;

    public UtilsApp(){ }

    //converte p/ tipos primitivos do java
    public static int convertToInt(double valorDouble){
        return (int) valorDouble;

    }

    public static int convertToInt(Context context, String objstring){
        try {
            return Integer.parseInt(objstring);
        }catch (NumberFormatException e){
            Toast.makeText(context, "Por favor, informe um valor numérico válido", Toast.LENGTH_SHORT).show();
            return 0;
        }

    }

    /*public int convertToInt(String objstring){
        return Integer.valueOf(objstring);

    } */

    public static int convertToInt(byte valorByte){
        return (int) valorByte;
    }

    public static int convertToInt(short valorShort){
        return (int) valorShort;
    }

    public static int convertToInt(long valorLong){
        return (int) valorLong;
    }


}
