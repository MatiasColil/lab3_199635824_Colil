package TDA;

import java.util.ArrayList;

public class Usuario {
    //Atributos del TDA Usuario
    private String username;
    private String password;
    private ArrayList<Accesos> accesosUser;



    public Usuario CrearUsuario(String newusername, String newpassword) {
        this.username = newusername;
        this.password = newpassword;
        ArrayList<Accesos> accesos = new ArrayList<>();
        this.accesosUser = accesos;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }


    @Override
    public String toString() {
        return "Usuario{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


    public void setUsername(String username) {
        this.username = username;
    }
}
