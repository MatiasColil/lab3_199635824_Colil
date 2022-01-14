package TDA;
import java.util.ArrayList;
import java.util.Date;

public class Documento {

    private String usuario;
    private String nombreDoc;
    private String contenidoDoc;
    private int iD;
    private Date fechaCreacion;
    private ArrayList<Version> versionesDoc;


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

    public String getUsuario() {
        return usuario;
    }

    public int getiD() {
        return iD;
    }

    public String getNombreDoc() {
        return nombreDoc;
    }

    public ArrayList<Version> getVersionesDoc() {
        return versionesDoc;
    }

    public String getContenidoDoc() {
        return contenidoDoc;
    }

    public void setContenidoDoc(String contenidoDoc) {
        this.contenidoDoc = contenidoDoc;
    }

    public void setVersionesDoc(ArrayList<Version> versionesDoc) {
        this.versionesDoc = versionesDoc;
    }
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