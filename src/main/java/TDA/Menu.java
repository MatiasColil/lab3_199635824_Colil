package TDA;

import java.util.Scanner;
import java.util.Date;

public class Menu {

    public void menuInicial(Paradigmadocs p){

        try{
            System.out.println("\t Plataforma de documentos colaborativos\n\n" +
                    "Por favor inicie sesion, en caso de no tener cuenta, registrese\n");
            System.out.println("1.- Iniciar sesion");
            System.out.println("2.- Registrarse");
            System.out.println("3.- Cerrar el programa");

            Scanner s = new Scanner(System.in);
            int opcion = s.nextInt();

            switch (opcion){
                case 1:
                    System.out.println("\t Iniciando sesion\n");
                    System.out.println("Ingrese nombre de usuario: ");
                    Scanner sn = new Scanner(System.in);
                    String credencialNombre = sn.nextLine();

                    System.out.println("Ingrese la contraseña: ");
                    Scanner sp = new Scanner(System.in);
                    String credencialContrasenia = sn.nextLine();

                    if (!p.login(credencialNombre,credencialContrasenia)){
                        System.out.println("Nombre o contrañsea incorrecto, ingrese datos correctos.");
                    }
                    else{
                        System.out.println("Inicio de sesion exitoso");
                    }
                    break;
                case 2:
                    System.out.println("\t Registrando a un usuario\n");
                    System.out.println("Ingrese el nombre del usuario a registrar:");
                    Scanner scr = new Scanner(System.in);
                    String nuevoUser = scr.nextLine();

                    System.out.println("Ingrese la contraseña del usuario a registrar: ");
                    Scanner scp = new Scanner(System.in);
                    String nuevaPass = scp.nextLine();

                    if (p.registrarUsuario(nuevoUser,nuevaPass)){
                        p.login(nuevoUser,nuevaPass);
                    }
                    else{
                        System.out.println("Usuario ya registrado en la plataforma...");
                    }
                    break;

                case 3:
                    System.out.println("Saliendo del programa...");
                    System.exit(0);
                    break;
            }


        }
        catch (Exception a){
            System.out.println("Por favor ingrese una opcion valida.");
        }
    }

    public void menuUsuario(Paradigmadocs p){
        try{
            System.out.println("\t Plataforma de documentos colaborativos\n\n");
            System.out.println("Registrado como: " + p.getUsuarioActivo().getUsername());
            System.out.println("\nEscoja su opcion: ");
            System.out.println("1.- Crear nuevo documento");
            System.out.println("2.- Compartir documento");
            System.out.println("3.- Agregar contenido a un documento");
            System.out.println("4.- Restaurar version de un documento");
            System.out.println("5.- Revocar accesso a un documento");
            System.out.println("6.- Buscar en los documentos");
            System.out.println("7.- Visuzalizar documentos");
            System.out.println("8.- Cerrar sesion");
            System.out.println("9.- Cerrar el programa");
            System.out.println("Ingrese su opcion: ");

            Scanner so = new Scanner(System.in);
            int opcion = so.nextInt();

            switch (opcion){
                case 1:
                    Date ahora = new Date();

                    System.out.println("Ingrese el nombre del documento:");
                    Scanner sctitulo = new Scanner(System.in);
                    String titulo = sctitulo.nextLine();

                    System.out.println("Ingrese el contenido del documento:");
                    Scanner scContenido = new Scanner(System.in);
                    String contenido = scContenido.nextLine();

                    p.create(p.getUsuarioActivo(),titulo,contenido,ahora);
                    System.out.println("Documento creado exitosamente");

                    break;
                case 8:
                    System.out.println("Cerrando sesion...");
                    p.logout();
                    break;
                case 9:
                    System.out.println("Saliendo del programa...");
                    System.exit(0);
                    break;

            }
        }
        catch (Exception a){
            System.out.println("Por favor ingrese una opcion valida.");
        }

    }


}
