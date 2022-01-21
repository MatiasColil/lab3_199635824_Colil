import TDA.*;

import java.util.Date;

/**
 * Clase MAIN en la que se ejecuta
 */
public class Main {

    public static void main(String[] args) {
        Date fechaActual = new Date();
        Paradigmadoc plataforma = new Paradigmadoc();
        Menu menuParadigmadocs = new Menu();

        Usuario usuario1 = new Usuario();
        Usuario usuario2 = new Usuario();
        Usuario usuario3 = new Usuario();
        Usuario usuario4 = new Usuario();
        Usuario usuario5 = new Usuario();

        usuario1.CrearUsuario("Tono1000","tonodios");
        usuario2.CrearUsuario("Pablito roman","programacion");
        usuario3.CrearUsuario("sample","prueba");
        usuario4.CrearUsuario("Mativan","like");
        usuario5.CrearUsuario("Guai","guaixp");

        plataforma.registrarUsuario(usuario1.getUsername(), usuario1.getPassword());
        plataforma.registrarUsuario(usuario2.getUsername(), usuario2.getPassword());
        plataforma.registrarUsuario(usuario3.getUsername(), usuario3.getPassword());
        plataforma.registrarUsuario(usuario4.getUsername(), usuario4.getPassword());
        plataforma.registrarUsuario(usuario5.getUsername(), usuario5.getPassword());

        plataforma.create(usuario1,"primer doc user 1","contenido user 1",fechaActual);
        plataforma.create(usuario2,"primer doc user 2","contenido user 2",fechaActual);
        plataforma.create(usuario3,"primer doc user 3","contenido user 3",fechaActual);
        plataforma.create(usuario4,"primer doc user 4","contenido user 4",fechaActual);
        plataforma.create(usuario5,"primer doc user 5","contenido user 5",fechaActual);

        plataforma.create(usuario1,"segundo doc user 1","segundo contenido user 1",fechaActual);
        plataforma.create(usuario2,"segundo doc user 2","segundo contenido user 2",fechaActual);
        plataforma.create(usuario3,"segundo doc user 3","segundo contenido user 3",fechaActual);
        plataforma.create(usuario4,"segundo doc user 4","segundo contenido user 4",fechaActual);
        plataforma.create(usuario5,"segundo doc user 5","segundo contenido user 5",fechaActual);


        do {
            if (plataforma.estadoUsuario()== false){
                menuParadigmadocs.menuInicial(plataforma);
            }
            else{
                menuParadigmadocs.menuUsuario(plataforma);
            }
        }while (true);







    }
}