package TDA;

import java.util.ArrayList;

/**
 * Una clase para representar a un usuario de una plataforma de documentos colaborativos
 * que tiene un nombre, contraseña y una lista de accesos de documentos compartidos
 * @version 1.0, 20/01/22
 * @author Matias Colil
 */


public class Usuario {
    //Atributos del TDA Usuario
    private String username; //nombre del usuario
    private String password; //contraseña del usuario
    private ArrayList<Acceso> accesosUser; //lista de accesos


    /**
     *Constructor que me crea una instancia de usuario y recibe los siguientes parametros
     * @param newusername nombre del usuario
     * @param newpassword contraseña del usuario
     * @return
     */
    public Usuario CrearUsuario(String newusername, String newpassword) {
        this.username = newusername;
        this.password = newpassword;
        ArrayList<Acceso> accesosUsuario = new ArrayList<>();
        this.accesosUser = accesosUsuario;
        return this;
    }

    /**
     * Metodo que retorna el nombre del usuario
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     *  Metodo que retorna la contraseña del usuario
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     *  Metodo que retorna la lista de accesos compartidos del usuario
     * @return
     */
    public ArrayList<Acceso> getAccesosUser() {
        return accesosUser;
    }

    /**
     *  Metodo que cambia el valor de accesosUser
     * @param accesosUser
     */
    public void setAccesosUser(ArrayList<Acceso> accesosUser) {
        this.accesosUser = accesosUser;
    }

    /**
     *  Metodo que retorna un string con todos los datos de la instancia
     * @return
     */
    @Override
    public String toString() {
        return "Usuario{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", accesosUser=" + accesosUser +
                '}';
    }
}
