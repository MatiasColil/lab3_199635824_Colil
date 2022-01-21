package TDA;

import java.util.Date;

/**
 * Una clase para representar una version de un documento
 * Una instancia de version tendra el contenido del documento version
 * un ID que lo identifica y una fecha de modificacion del documento
 * @version 1.0, 20/01/22
 * @author Matias Colil
 */

public class Version {
    private String contenido;
    private int iD;
    private Date fecha;

    /**
     *  Constructor que me crea una instancia de version y recibe los siguientes parametros
     * @param contenido contenido de la version
     * @param iD ID de la version
     * @param fechaModificacion fecha de modificacion del documento
     * @return version
     */
    public Version Version(String contenido, int iD, Date fechaModificacion) {
        this.contenido = contenido;
        this.iD = iD;
        this.fecha = fechaModificacion;
        return this;
    }

    /**
     * Metodo que retorna el contenido de una version
     * @return contenido
     */
    public String getContenido() {
        return contenido;
    }

    /**
     * Metodo que retorna el ID de una version
     * @return iD
     */
    public int getiD() {
        return iD;
    }

    /**
     * Metodo que retorna le fecha de una version
     * @return fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Metodo que retorna un string con todos los datos de la instancia version
     * @return string
     */
    @Override
    public String toString() {
        return "Versiones{" +
                "contenido='" + contenido + '\'' +
                ", iD=" + iD +
                ", fecha=" + fecha +
                '}';
    }
}
