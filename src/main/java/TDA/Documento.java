package TDA;
import java.util.ArrayList;
import java.util.Date;
public class Documento {

    private String usuario;
    private String nombreDoc;
    private String contenidoDoc;
    private int iD;
    private Date fechaCreacion;
    private ArrayList<Versiones> versionesDoc;


    public Documento Documento(String nombreUser, String nombreDoc, String contenidoDoc, int iD, Date fechaCreacion) {
        this.usuario = nombreUser;
        this.nombreDoc = nombreDoc;
        this.contenidoDoc = contenidoDoc;
        this.iD = iD;
        this.fechaCreacion = fechaCreacion;
        ArrayList<Versiones> primeraVersion = new ArrayList<>();
        Versiones primera = new Versiones();
        primera.Versiones(contenidoDoc,1);
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

    public ArrayList<Versiones> getVersionesDoc() {
        return versionesDoc;
    }

    public String getContenidoDoc() {
        return contenidoDoc;
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
