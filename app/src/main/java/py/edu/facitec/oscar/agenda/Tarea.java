package py.edu.facitec.oscar.agenda;

import androidx.annotation.NonNull;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

@DatabaseTable
public class Tarea {
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField
    private String descripcion;
    @DatabaseField
    private Date fecha;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @NonNull
    @Override
    public String toString() {
        return this.getDescripcion();
    }
}
