package TDA;

import java.util.ArrayList;
import java.util.Date;

public class Paradigmadocs {
    //Paradigmadocs tiene a los usuarios, documentos mediante arreglos

    private ArrayList<Usuario> usuariosRegistrados = new ArrayList<>();
    private ArrayList<Documento> documentos = new ArrayList<>();
    private int cantidadDocumentos=0;
    private Usuario usuarioActivo;
    private boolean boolUsuario = false;

    //Setter Paradigmadoc
    public void setUsuarioActivo(Usuario usuarioActivo) {
        this.usuarioActivo = usuarioActivo;
        this.boolUsuario = true;
    }

    //Getter Paradigmadoc
    public ArrayList<Usuario> getUsuariosRegistrados() {
        return usuariosRegistrados;
    }

    public ArrayList<Documento> getDocumentos() {
        return documentos;
    }

    public Usuario getUsuarioActivo() {
        return usuarioActivo;
    }

    public boolean estadoUsuario(){
        return boolUsuario;
    }

    public boolean estaUsuario (Usuario user){
        for(int i=0; i< this.usuariosRegistrados.size(); i++){
            if( this.usuariosRegistrados.get(i).getUsername().equals(user.getUsername())){
                return true;
            }
        }
        return false;
    }

    public boolean registrarUsuario(String nombre, String contrasenia){
        Usuario nuevoUser = new Usuario();
        nuevoUser.CrearUsuario(nombre, contrasenia);
        //Una vez creado el usuario, se verifica que no exista
        if (!this.estaUsuario(nuevoUser)){
            this.usuariosRegistrados.add(nuevoUser);
            return true;
        }
        else{
            return  false;
        }
    }

    public boolean login (String nombre, String contrasenia) {
        for (int i = 0; i < this.usuariosRegistrados.size(); i++) {
            if (this.usuariosRegistrados.get(i).getUsername().equals(nombre) && this.usuariosRegistrados.get(i).getPassword().equals(contrasenia)) {
                this.setUsuarioActivo(this.usuariosRegistrados.get(i));
                return true;
            }
        }
        return false;
    }

    public void logout(){
        this.usuarioActivo = null;
        this.boolUsuario = false;
    }

    public void create(Usuario user, String nombreDoc, String contenidoDoc, Date fecha){
        Documento newDoc = new Documento();
        this.cantidadDocumentos=this.cantidadDocumentos+1;
        newDoc.Documento(user.getUsername(),nombreDoc,contenidoDoc, this.cantidadDocumentos, fecha);
        this.documentos.add(newDoc);
    }

    public void share(String user, int iDdocumento, String permiso){
        Accesos nuevoAcceso = new Accesos();
        nuevoAcceso.Accesos(iDdocumento,permiso);

        for (int i = 0; i< this.usuariosRegistrados.size();i++){
            if (this.usuariosRegistrados.get(i).getUsername().equals(user)){
                ArrayList<Accesos> temp = this.usuariosRegistrados.get(i).getAccesosUser();
                temp.add(nuevoAcceso);
                this.usuariosRegistrados.get(i).setAccesosUser(temp);
            }
        }
    }

    public void add(int iDdocumento, String contenidoAgregar){

        for (int i=0;i<this.documentos.size();i++){
            if (this.documentos.get(i).getiD()==iDdocumento){

                Date fechaActual = new Date();
                ArrayList<Versiones> versionesActuales=this.documentos.get(i).getVersionesDoc();
                String contenidoActual=this.documentos.get(i).getContenidoDoc();
                String contenidoActulizado=contenidoActual+" "+contenidoAgregar;
                int cantidadVersiones = versionesActuales.size() + 1;
                Versiones nuevaVersion = new Versiones();
                nuevaVersion.Versiones(contenidoActulizado,cantidadVersiones, fechaActual);
                versionesActuales.add(nuevaVersion);

                this.documentos.get(i).setContenidoDoc(contenidoActulizado);
                this.documentos.get(i).setVersionesDoc(versionesActuales);

            }
        }
    }

    public void rollback(int idDocumento, int idVersion){
        for (int i=0;i<this.documentos.size();i++){
            for (int j = 0;j<this.documentos.get(i).getVersionesDoc().size();j++){
                if (this.documentos.get(i).getiD()==idDocumento && this.documentos.get(i).getVersionesDoc().get(j).getiD()== idVersion){

                    Date fechaRestauracion = new Date();
                    ArrayList<Versiones> versionesActuales = this.documentos.get(i).getVersionesDoc();
                    String contenidoVersionRestaurar = this.documentos.get(i).getVersionesDoc().get(j).getContenido();

                    int cantidadVersiones = versionesActuales.size()+1;
                    Versiones versionRestaurada = new Versiones();
                    versionRestaurada.Versiones(contenidoVersionRestaurar,cantidadVersiones,fechaRestauracion);
                    versionesActuales.add(versionRestaurada);

                    this.documentos.get(i).setContenidoDoc(contenidoVersionRestaurar);
                    this.documentos.get(i).setVersionesDoc(versionesActuales);

                }
            }
        }
    }

    public void revokeAccess(int idDocumento){
        for (int i=0;i<this.usuariosRegistrados.size();i++){
            for (int j=0;j<this.usuariosRegistrados.get(i).getAccesosUser().size();j++){
                if (this.usuariosRegistrados.get(i).getAccesosUser().get(j).getiD()==idDocumento){
                    Accesos accesoBorrar = this.usuariosRegistrados.get(i).getAccesosUser().get(j);

                    this.usuariosRegistrados.get(i).getAccesosUser().remove(accesoBorrar);
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Paradigmadocs{" +
                "usuariosRegistrados=" + usuariosRegistrados +
                ", documentos=" + documentos +
                ", cantidadDocumentos=" + cantidadDocumentos +
                ", usuarioActivo=" + usuarioActivo +
                ", boolUsuario=" + boolUsuario +
                '}';
    }
}