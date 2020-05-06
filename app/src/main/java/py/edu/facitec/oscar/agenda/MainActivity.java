package py.edu.facitec.oscar.agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText descripcionEditText;
    ListView tareasListView;

    TareaDao tareaDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        descripcionEditText = findViewById(R.id.editTextDescripcion);
        tareasListView = findViewById(R.id.listviewTareas);

        tareaDao = new TareaDao(this);
        cargarTareasRegistradas();
    }

    private void cargarTareasRegistradas() {
        List<Tarea> tareas = tareaDao.obtenerTodos();
        ArrayAdapter<Tarea> arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,tareas);
        tareasListView.setAdapter(arrayAdapter);
    }

    public void guardarTarea(View view) {
        Tarea t = new Tarea();
        t.setDescripcion(descripcionEditText.getText().toString());
        t.setFecha(new Date());
        if(t.getDescripcion().isEmpty()){
            descripcionEditText.setError("Completar la descripcion...");
            return;
        }
        tareaDao.guardar(t);
        descripcionEditText.setText(null);
        cargarTareasRegistradas();
    }
}
