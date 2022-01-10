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

    public void create(Usuario user, String nombreDoc, String contenidoDoc, Date fecha){
        Documento newDoc = new Documento();
        this.cantidadDocumentos=this.cantidadDocumentos+1;
        newDoc.Documento(user.getUsername(),nombreDoc,contenidoDoc, this.cantidadDocumentos, fecha);
        this.documentos.add(newDoc);

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