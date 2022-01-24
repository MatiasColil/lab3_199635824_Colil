package TDA;

import java.util.ArrayList;
import java.util.Date;

/**
 * Una clase que me representa una plataforma de documentos colaborativos
 * la cual tiene una lista de usuarios registrados, una lista de documentos,
 * un usuario activo, cantidad de documentos de la plataforma
 * @version 1.0, 20/01/22
 * @author Matias Colil
 */
public class Paradigmadoc {

    private ArrayList<Usuario> usuariosRegistrados = new ArrayList<>();
    private ArrayList<Documento> documentos = new ArrayList<>();
    private int cantidadDocumentos=0;
    private Usuario usuarioActivo;
    private boolean boolUsuario = false;

    /**
     * Metodo que modifica el usuario activo de la plataforma
     * @param usuarioActivo
     */
    public void setUsuarioActivo(Usuario usuarioActivo) {
        this.usuarioActivo = usuarioActivo;
        this.boolUsuario = true;
    }

    /**
     * Metodo que retorna la lista de usuarios registrados
     * @return usuariosRegistrados
     */
    public ArrayList<Usuario> getUsuariosRegistrados() {
        return usuariosRegistrados;
    }

    /**
     * Metodo que retorna la lista de documentos
     * @return documentos
     */
    public ArrayList<Documento> getDocumentos() {
        return documentos;
    }

    /**
     * Metodo que retorna el usuario activo de la plataforma
     * @return usuarioActivo
     */
    public Usuario getUsuarioActivo() {
        return usuarioActivo;
    }

    /**
     * Metodo que me cambia el valor de verdad del estado usuario
     * @return boolUsuario
     */
    public boolean estadoUsuario(){
        return boolUsuario;
    }

    /**
     * Metodo que me verifica si un usuario ya se encuentra registrado
     * @param user nombre del usuario que se compara con los ya registrados de la lista de usuarios
     * @return valor booleano
     */
    public boolean estaUsuario (Usuario user){
        for(int i=0; i< this.usuariosRegistrados.size(); i++){
            if( this.usuariosRegistrados.get(i).getUsername().equals(user.getUsername())){
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo que registra un nuevo usuario. requerimiento funcional authentication
     * @param nombre nombre del usuario
     * @param contrasenia contraseña del usuario
     * @return valor booleano
     */
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

    /**
     * Metodo que logea un usuario en la plataforma, tiene que estar registrado el usuario, requerimiento funcional authentication
     * @param nombre nombre del usuario
     * @param contrasenia contraseña del usuario
     * @return valor booleano
     */
    public boolean login (String nombre, String contrasenia) {
        for (int i = 0; i < this.usuariosRegistrados.size(); i++) {
            if (this.usuariosRegistrados.get(i).getUsername().equals(nombre) && this.usuariosRegistrados.get(i).getPassword().equals(contrasenia)) {
                this.setUsuarioActivo(this.usuariosRegistrados.get(i));
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo que me deslogea un usuario activo, requerimiento funcional authentication
     */
    public void logout(){
        this.usuarioActivo = null;
        this.boolUsuario = false;
    }

    /**
     * Metodo que crea una instancia documento y lo guarda en la lista de documentos, requerimiento funcional create
     * @param user nombre del usuario que crea el documento
     * @param nombreDoc nombre del documento
     * @param contenidoDoc contenido del documento
     * @param fecha fecha de creacion del documento
     */
    public void create(Usuario user, String nombreDoc, String contenidoDoc, Date fecha){
        Documento newDoc = new Documento();
        this.cantidadDocumentos=this.cantidadDocumentos+1;
        newDoc.Documento(user.getUsername(),nombreDoc,contenidoDoc, this.cantidadDocumentos, fecha);
        this.documentos.add(newDoc);
    }

    /**
     * Metodo que comparte un documento con un usuario, requerimiento funcional share
     * @param user nombre del usuario que se le comparte el documento
     * @param iDdocumento ID del documento
     * @param permiso tipo de permiso
     */
    public void share(String user, int iDdocumento, String permiso){
        Acceso nuevoAcceso = new Acceso();
        nuevoAcceso.Acceso(iDdocumento,permiso);

        for (int i = 0; i< this.usuariosRegistrados.size();i++){
            if (this.usuariosRegistrados.get(i).getUsername().equals(user)){
                ArrayList<Acceso> temp = this.usuariosRegistrados.get(i).getAccesosUser();
                temp.add(nuevoAcceso);
                this.usuariosRegistrados.get(i).setAccesosUser(temp);
            }
        }
    }

    /**
     * Metodo que agrega nuevo contenido a un documento, requerimiento funcional add
     * @param iDdocumento ID del documento
     * @param contenidoAgregar contenido a agregar al documento
     */
    public void add(int iDdocumento, String contenidoAgregar){

        for (int i=0;i<this.documentos.size();i++){
            if (this.documentos.get(i).getiD()==iDdocumento){

                Date fechaActual = new Date();
                ArrayList<Version> versionesActuales=this.documentos.get(i).getVersionesDoc();
                String contenidoActual=this.documentos.get(i).getContenidoDoc();
                String contenidoActulizado=contenidoActual+" "+contenidoAgregar;
                int cantidadVersiones = versionesActuales.size() + 1;
                Version nuevaVersion = new Version();
                nuevaVersion.Version(contenidoActulizado,cantidadVersiones, fechaActual);
                versionesActuales.add(nuevaVersion);

                this.documentos.get(i).setContenidoDoc(contenidoActulizado);
                this.documentos.get(i).setVersionesDoc(versionesActuales);

            }
        }
    }

    /**
     * Metodo que devuelve una version antigua del documento y la deja como version activa, requerimiento funcional rollback
     * @param idDocumento ID del documento
     * @param idVersion ID de la version del documento
     */
    public void rollback(int idDocumento, int idVersion){
        for (int i=0;i<this.documentos.size();i++){
            for (int j = 0;j<this.documentos.get(i).getVersionesDoc().size();j++){
                if (this.documentos.get(i).getiD()==idDocumento && this.documentos.get(i).getVersionesDoc().get(j).getiD()== idVersion){

                    Date fechaRestauracion = new Date();
                    ArrayList<Version> versionesActuales = this.documentos.get(i).getVersionesDoc();
                    String contenidoVersionRestaurar = this.documentos.get(i).getVersionesDoc().get(j).getContenido();

                    int cantidadVersiones = versionesActuales.size()+1;
                    Version versionRestaurada = new Version();
                    versionRestaurada.Version(contenidoVersionRestaurar,cantidadVersiones,fechaRestauracion);
                    versionesActuales.add(versionRestaurada);

                    this.documentos.get(i).setContenidoDoc(contenidoVersionRestaurar);
                    this.documentos.get(i).setVersionesDoc(versionesActuales);

                }
            }
        }
    }

    /**
     * Metodo que revoca los accesos a un documento que un usuario dio a otros , requerimiento funcional revokeAccess
     * @param idDocumento ID del documento
     */
    public void revokeAccess(int idDocumento){
        for (int i=0;i<this.usuariosRegistrados.size();i++){
            for (int j=0;j<this.usuariosRegistrados.get(i).getAccesosUser().size();j++){
                if (this.usuariosRegistrados.get(i).getAccesosUser().get(j).getiD()==idDocumento){
                    Acceso accesoBorrar = this.usuariosRegistrados.get(i).getAccesosUser().get(j);

                    this.usuariosRegistrados.get(i).getAccesosUser().remove(accesoBorrar);
                }
            }
        }
    }

    /**
     * Metodo que busca en todos los documentos que un usuario tiene acceso una palabra o frase y retorna una, requerimiento funcional search
     * lista con los documentos que contiene dicha frase o palabra
     * @param versionesDoc lista de versiones de un documento
     * @param frase frase o palabra a buscar
     * @param nombreDoc nombre documento
     * @param idDoc ID del documento
     */
    public void search(ArrayList<Version> versionesDoc, String frase, String nombreDoc, int idDoc){

        boolean bandera = false;
        for (int i=0;i< versionesDoc.size();i++){
            if (versionesDoc.get(i).getContenido().contains(frase)){
                bandera = true;
                i= versionesDoc.size();
            }
        }

        if (bandera){
            System.out.println("Nombre del documento: " +
                    nombreDoc + "\nID del documento: " + idDoc + "\n");
            System.out.println("Versiones: ");
            for (int i=0;i< versionesDoc.size();i++){
                if (versionesDoc.get(i).getContenido().contains(frase)){
                    System.out.println("Contenido: " + versionesDoc.get(i).getContenido() +
                            "\n" + "ID de la version: " +
                            versionesDoc.get(i).getiD() + "\n");
                }
            }
        }
    }

    /**
     * Metodo que retorna un string con lo que tiene la plataforma, requerimiento funcional visualize
     * @param opcion
     * @return string
     */
    public String visualize(int opcion){
        String stringNuevo = new String();
        if (opcion==1){//opcion usuario
            stringNuevo = stringNuevo + "Nombre del usuario: " + getUsuarioActivo().getUsername() + "\n";
            stringNuevo= stringNuevo + "Accesos dados: "+"\n";
            for (int i=0;i<getUsuarioActivo().getAccesosUser().size();i++){
                stringNuevo= stringNuevo + "ID del documento compartido: "+ getUsuarioActivo().getAccesosUser().get(i).getiD()+("\n");
                stringNuevo= stringNuevo + "Permiso dado: "+ getUsuarioActivo().getAccesosUser().get(i).getPermiso() + "\n";
            }
            stringNuevo= stringNuevo + ("Documentos: \n");

            for (int i=0;i<this.documentos.size();i++){
                if (this.documentos.get(i).getUsuario().equals(getUsuarioActivo().getUsername())){
                    stringNuevo= stringNuevo + "Nombre del documento: " + this.documentos.get(i).getNombreDoc() + "\n";
                    stringNuevo= stringNuevo + "ID del documento: " + this.documentos.get(i).getiD() + "\n";
                    stringNuevo= stringNuevo + "Contenido actual del documento: " + this.documentos.get(i).getContenidoDoc() + "\n";
                    stringNuevo= stringNuevo + "Versiones: " + "\n";
                    for (int j=0;j<this.documentos.get(i).getVersionesDoc().size();j++){
                        stringNuevo= stringNuevo + "ID de la version: " + this.documentos.get(i).getVersionesDoc().get(j).getiD() + "\n";
                        stringNuevo= stringNuevo + "Contenido de la version: " + this.documentos.get(i).getVersionesDoc().get(j).getContenido() + "\n";
                        stringNuevo= stringNuevo + "Fecha de la version: " + this.documentos.get(i).getVersionesDoc().get(j).getFecha() + "\n";
                    }
                }
            }

            for (int i=0;i<this.documentos.size();i++) {
                for (int j = 0; j < this.getUsuarioActivo().getAccesosUser().size(); j++) {
                    if (this.documentos.get(i).getiD() == this.getUsuarioActivo().getAccesosUser().get(j).getiD()){
                        stringNuevo= stringNuevo + "Nombre del documento: " + this.documentos.get(i).getNombreDoc() + "\n";
                        stringNuevo= stringNuevo + "ID del documento: " + this.documentos.get(i).getiD() + "\n";
                        stringNuevo= stringNuevo + "Contenido actual del documento: " + this.documentos.get(i).getContenidoDoc() + "\n";
                        stringNuevo= stringNuevo + "Versiones: " + "\n";
                        for (int k=0;k<this.documentos.get(i).getVersionesDoc().size();k++){
                            stringNuevo= stringNuevo + "ID de la version: " + this.documentos.get(i).getVersionesDoc().get(k).getiD() + "\n";
                            stringNuevo= stringNuevo + "Contenido de la version: " + this.documentos.get(i).getVersionesDoc().get(k).getContenido() + "\n";
                            stringNuevo= stringNuevo + "Fecha de la version: " + this.documentos.get(i).getVersionesDoc().get(k).getFecha() + "\n";
                        }
                    }
                }
            }
        }
        else{
            stringNuevo= stringNuevo + "Documentos en la plataforma: " + "\n";
            for (int i=0;i<documentos.size();i++){
                stringNuevo= stringNuevo + "Nombre del documento: " + documentos.get(i).getNombreDoc() + "\n";
                stringNuevo= stringNuevo + "ID del documento: " + documentos.get(i).getiD() + "\n";
                stringNuevo= stringNuevo + "Contenido actual del documento: " + documentos.get(i).getContenidoDoc() + "\n";
                stringNuevo= stringNuevo + "Versiones: " + "\n";
                for (int j=0;j<documentos.get(i).getVersionesDoc().size();j++){
                    stringNuevo= stringNuevo + "ID de la version: " + documentos.get(i).getVersionesDoc().get(j).getiD() + "\n";
                    stringNuevo= stringNuevo + "Contenido de la version: " + documentos.get(i).getVersionesDoc().get(j).getContenido() + "\n";
                    stringNuevo= stringNuevo + "Fecha de la version: " + documentos.get(i).getVersionesDoc().get(j).getFecha() + "\n";
                }
            }
        }

        return stringNuevo;
    }

    /**
     * Metodo que elimina los ultimos N caracteres de un documento, requerimiento funcional extra delete
     * @param idDocumento ID del documento
     * @param cantidadCaracteres cantidad de caracteres
     */
    public void delete(int idDocumento, int cantidadCaracteres){
        for (int i=0;i<this.documentos.size();i++){
            if (this.documentos.get(i).getiD()==idDocumento){

                Date fechaActual = new Date();
                ArrayList<Version> versionesActuales=this.documentos.get(i).getVersionesDoc();
                String contenidoActual=this.documentos.get(i).getContenidoDoc();
                String contenidoActulizado;
                if (contenidoActual.length()>cantidadCaracteres){
                    contenidoActulizado=contenidoActual.substring(0,contenidoActual.length()- cantidadCaracteres);
                }
                else{
                    contenidoActulizado="";
                }
                int cantidadVersiones = versionesActuales.size() + 1;
                Version nuevaVersion = new Version();
                nuevaVersion.Version(contenidoActulizado,cantidadVersiones, fechaActual);
                versionesActuales.add(nuevaVersion);

                this.documentos.get(i).setContenidoDoc(contenidoActulizado);
                this.documentos.get(i).setVersionesDoc(versionesActuales);

            }
        }
    }

    /**
     * Metodo que retorna un string con todos los datos de paradigmadocs
     * @return string
     */
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