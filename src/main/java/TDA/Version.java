package TDA;

import java.util.Date;

public class Version {
    private String contenido;
    private int iD;
    private Date fecha;

    public Version Version(String contenido, int iD, Date fechaModificacion) {
        this.contenido = contenido;
        this.iD = iD;
        this.fecha = fechaModificacion;
        return this;
    }

    public String getContenido() {
        return contenido;
    }

    public int getiD() {
        return iD;
    }

    @Override
    public String toString() {
        return "Versiones{" +
                "contenido='" + contenido + '\'' +
                ", iD=" + iD +
                ", fecha=" + fecha +
                '}';
    }
}
