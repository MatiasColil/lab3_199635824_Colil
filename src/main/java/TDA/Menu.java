package TDA;

import java.util.ArrayList;
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

                case 2:
                    boolean valor = true;
                    boolean valor2 = true;
                    boolean valor3 = true;
                    String permiso = null;
                    int idCompartido = 0;
                    System.out.println("\t Compartir un documento\n");

                    while (valor3){
                        ArrayList<Documento> documentosUsuarios = p.getDocumentos();
                        System.out.println("Recuerde que los ID de los documentos son unicos e incrementales partiendo desde el 1.\n");
                        System.out.println("ingrese el ID del documento que quiere compartir: ");
                        Scanner scid = new Scanner(System.in);
                        idCompartido = scid.nextInt();

                        for (int i=0;i<documentosUsuarios.size();i++){
                            if (documentosUsuarios.get(i).getiD()==idCompartido && p.getUsuarioActivo().getUsername().equals(documentosUsuarios.get(i).getUsuario())){
                                valor3 = false;
                            }
                        }
                        if (valor3){
                            System.out.println("Ingrese un ID de documento que le pertenezca, en caso de no tener " +
                                    " ningun documento propio\n" +
                                    "escriba 0 y presione ENTER para salir de esta opcion\n");
                        }
                        if (idCompartido == 0){
                            break;
                        }
                    }

                    System.out.println("Existen 3 tipos de permisos:\n" +
                            "write: permiso para poder editar el documento\n" +
                            "read: permiso para poder leer el documento\n" +
                            "comment: permiso para poder comentar el documento");

                    while(valor2){
                        System.out.println("Ingrese el tipo de permiso que quiera dar (write, read o comment): ");
                        Scanner scp = new Scanner(System.in);
                        permiso = scp.nextLine();
                        if (permiso.equals("write") || permiso.equals("read") || permiso.equals("comment")){
                            valor2=false;
                        }
                        else{
                            System.out.println("Por favor ingrese un permiso valido...");
                        }
                    }

                    System.out.println("Puede ingresar todos los usuarios a los cuales les quiere compartir el documento" +
                            " pero tendra que hacerlo de uno a uno\n");

                    while (valor){
                        boolean banderaError = false;
                        System.out.println("Si ya ingreso a todos los usuarios a los cuales le queria compartir el" +
                                " documento, escriba 0 y presione ENTER\n");
                        System.out.println("Ingrese el nombre del usuario al cual le quiere compartir el documento: ");
                        Scanner scs = new Scanner(System.in);
                        String userCompartido = scs.nextLine();

                        ArrayList<Usuario> listaUsuarios = p.getUsuariosRegistrados();
                        for (int i =0;i < listaUsuarios.size();i++){
                            if (listaUsuarios.get(i).getUsername().equals(userCompartido)){
                                p.share(userCompartido,idCompartido,permiso);
                                banderaError = true;
                                i= listaUsuarios.size();
                            }
                        }
                        if (!banderaError){
                            System.out.println("Por favor escriba el nombre de un usuario registrado");
                        }

                        if (userCompartido.equals("0")){
                            System.out.println("Saliendo de la opcion compartir documento...");
                            valor = false;
                        }

                    }

                    System.out.println("Permiso dado correctamente...");
                    break;
                case 3:
                    System.out.println("\t Agregar contenido a un documento\n");
                    boolean verificacionGeneral = true;
                    ArrayList<Documento> listaDocumentos = p.getDocumentos();
                    ArrayList<Accesos> accesosUsuario = p.getUsuarioActivo().getAccesosUser();
                    int idDocumento=0;

                    while (verificacionGeneral){
                        System.out.println("Recuerde que los ID de los documentos son unicos e incrementales partiendo desde el 1.\n");
                        System.out.println("Ingrese el ID del documento que desea modificar:");
                        Scanner sciD = new Scanner(System.in);
                        idDocumento = sciD.nextInt();

                        for (int i =0; i<listaDocumentos.size();i++){
                            if (listaDocumentos.get(i).getUsuario().equals(p.getUsuarioActivo().getUsername()) && listaDocumentos.get(i).getiD()==idDocumento){
                                System.out.println("Ingrese el contenido que desea agregar al documento:");
                                Scanner scc = new Scanner(System.in);
                                String contenidoAgregar = scc.nextLine();
                                p.add(idDocumento,contenidoAgregar);
                                verificacionGeneral = false;
                                i= listaDocumentos.size();
                            }
                        }

                        for (int i= 0;i<accesosUsuario.size();i++){
                            if (accesosUsuario.get(i).getiD()==idDocumento && accesosUsuario.get(i).getPermiso().equals("write")){
                                System.out.println("Ingrese el contenido que desea agregar al documento:");
                                Scanner scc = new Scanner(System.in);
                                String contenidoAgregar = scc.nextLine();
                                p.add(idDocumento,contenidoAgregar);
                                verificacionGeneral = false;
                                i= listaDocumentos.size();
                            }
                        }

                        if (verificacionGeneral){
                            System.out.println("Ingrese un ID de documento que le pertenezca o que le hayan compartido con permiso de edicion (write), en caso de no tener " +
                                    " ningun documento propio o compartido \n" +
                                    "escriba 0 y presione ENTER para salir de esta opcion\n");
                        }
                        if (idDocumento == 0){
                            System.out.println("Saliendo de la opcion agregar contenido...");
                            break;
                        }
                    }

                    System.out.println("Contenido agregado correctamente...");
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
