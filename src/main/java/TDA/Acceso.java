package TDA;

/**
 * Una Clase que representa el acceso que tiene un usuario a un documento compartido,
 * cada acceso esta representado por el ID del documento compartido
 * y por el tipo de permiso dado
 * @version 1.0, 20/01/22
 * @author Matias Colil
 */

public class Acceso {
    private int iD; //ID del documento compartido
    private String permiso; //tipo de permiso dado

    /**
     * Constructor que me crea una instancia acceso y recibe los siguientes parametros
     * @param iD ID del documento.
     * @param permiso tipo de permiso.
     */
    public Acceso Acceso(int iD, String permiso) {
        this.iD = iD;
        this.permiso = permiso;
        return this;
    }

    /**
     * Retorna el ID de una instancia acceso
     * @return iD
     */
    public int getiD() {
        return iD;
    }

    /**
     * Retorna el permiso de una instancia acceso
     * @return permiso
     */
    public String getPermiso() {
        return permiso;
    }

    /**
     * Retorna un string con los datos de una instancia acceso
     * @return string
     */
    @Override
    public String toString() {
        return "Accesos{" +
                "iD=" + iD +
                ", permiso='" + permiso + '\'' +
                '}';
    }
}
