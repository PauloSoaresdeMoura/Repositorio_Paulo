package formacao.desenvolvedores.tecnologia.uno.mor_integracao_com_java.database_app.converter;

import android.util.Log;

import androidx.room.TypeConverter;

import java.util.Date;

public class Converters {
    public static final String TAG = "Converters";

    public Converters() {
    }

    @TypeConverter
    public static String fromLocalDateToString(Date localDate){
       try {
           if (localDate == null){
               return null;
           }else {
               return localDate.toString();
           }
       }catch (Exception e){
           Log.d(TAG, "fromLocalDate: " + e.getMessage());
           e.printStackTrace();
           return null;
       }
    }
}
