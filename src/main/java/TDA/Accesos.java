package TDA;

public class Accesos {
    private int iD;
    private String permiso;

    public Accesos(int iD, String permiso) {
        this.iD = iD;
        this.permiso = permiso;
    }

    public int getiD() {
        return iD;
    }

    public String getPermiso() {
        return permiso;
    }

    @Override
    public String toString() {
        return "Accesos{" +
                "iD=" + iD +
                ", permiso='" + permiso + '\'' +
                '}';
    }
}
