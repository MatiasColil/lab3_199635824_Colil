package TDA;

import java.util.ArrayList;

public class Usuario {
    //Atributos del TDA Usuario
    private String username;
    private String password;
    private ArrayList<Acceso> accesosUser;



    public Usuario CrearUsuario(String newusername, String newpassword) {
        this.username = newusername;
        this.password = newpassword;
        ArrayList<Acceso> accesosUsuario = new ArrayList<>();
        this.accesosUser = accesosUsuario;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<Acceso> getAccesosUser() {
        return accesosUser;
    }

    public void setAccesosUser(ArrayList<Acceso> accesosUser) {
        this.accesosUser = accesosUser;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", accesosUser=" + accesosUser +
                '}';
    }
}
