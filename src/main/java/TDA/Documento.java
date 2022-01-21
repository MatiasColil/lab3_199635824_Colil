package TDA;
import java.util.ArrayList;
import java.util.Date;

/**
 * Una clase para representar un documento
 * Una instancia de documento tendra el contenido del documento
 * un ID que lo identifica, una fecha de creacion del documento,
 * el nombre del documento, fecha de creacion del documento,
 * nombre del usuario que creo el docuemnto y
 * una lista con las versiones del documento
 * @version 1.0, 20/01/22
 * @author Matias Colil
 */

public class Documento {

    private String usuario;
    private String nombreDoc;
    private String contenidoDoc;
    private int iD;
    private Date fechaCreacion;
    private ArrayList<Version> versionesDoc;


    /**
     * Constructor que me crea la instancia documento y recibe los siguientes parametros
     * @param nombreUser nombre del usuario que creo el documento
     * @param nombreDoc nombre del documento
     * @param contenidoDoc contenido del documento
     * @param iD ID del documento
     * @param fechaCreacion fecha de creacion del documento
     * @return documento
     */
    public Documento Documento(String nombreUser, String nombreDoc, String contenidoDoc, int iD, Date fechaCreacion) {
        Date fecha = new Date();
        this.usuario = nombreUser;
        this.nombreDoc = nombreDoc;
        this.contenidoDoc = contenidoDoc;
        this.iD = iD;
        this.fechaCreacion = fechaCreacion;
        ArrayList<Version> primeraVersion = new ArrayList<>();
        Version primera = new Version();
        primera.Version(contenidoDoc,1,fecha);
        primeraVersion.add(primera);
        this.versionesDoc = primeraVersion;

        return this;
    }

    /**
     * Metodo que retorna el nombre del usuario
     * @return usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Metodo que retorna el ID del documento
     * @return ID
     */
    public int getiD() {
        return iD;
    }

    /**
     * Metodo que retorna el nombre del documento
     * @return nombreDoc
     */
    public String getNombreDoc() {
        return nombreDoc;
    }

    /**
     * Metodo que retorna la lista de versiones del documento
     * @return versionesDoc
     */
    public ArrayList<Version> getVersionesDoc() {
        return versionesDoc;
    }

    /**
     * Metodo que retorna el contenido del documento
     * @return contenidoDoc
     */
    public String getContenidoDoc() {
        return contenidoDoc;
    }

    /**
     * Metodo que modifica el contenido de la instancia documento
     * @param contenidoDoc
     */
    public void setContenidoDoc(String contenidoDoc) {
        this.contenidoDoc = contenidoDoc;
    }

    /**
     * Metodo que modifica la lista de la instancia documento
     * @param versionesDoc
     */
    public void setVersionesDoc(ArrayList<Version> versionesDoc) {
        this.versionesDoc = versionesDoc;
    }

    /**
     * Metodo que retorna un string con todos los datos de la instancia documento
     * @return
     */
    @Override
    public String toString() {
        return "Documento{" +
                "usuario='" + usuario + '\'' +
                ", nombreDoc='" + nombreDoc + '\'' +
                ", contenidoDoc='" + contenidoDoc + '\'' +
                ", iD=" + iD +
                ", fechaCreacion=" + fechaCreacion +
                ", versionesDoc=" + versionesDoc +
                '}';
    }
}