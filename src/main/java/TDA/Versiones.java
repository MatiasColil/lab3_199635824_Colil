package TDA;

public class Versiones {
    private String contenido;
    private int iD;

    public Versiones Versiones(String contenido, int iD) {
        this.contenido = contenido;
        this.iD = iD;
        return this;
    }

    @Override
    public String toString() {
        return "Versiones{" +
                "contenido='" + contenido + '\'' +
                ", iD=" + iD +
                '}';
    }
}
