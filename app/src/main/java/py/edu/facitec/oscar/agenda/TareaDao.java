package py.edu.facitec.oscar.agenda;

import android.content.Context;

public class TareaDao extends DBA<Tarea> {
    public TareaDao(Context context){
        init(context,Tarea.class);
    }
}
