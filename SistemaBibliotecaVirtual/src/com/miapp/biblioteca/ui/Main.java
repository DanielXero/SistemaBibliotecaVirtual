package com.miapp.biblioteca.ui;

import com.miapp.biblioteca.domain.Libro;
import com.miapp.biblioteca.domain.Usuario;
import com.miapp.biblioteca.service.LibroService;
import com.miapp.biblioteca.service.UsuarioService;


import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase Main para la interacción con el usuario a través de la consola, permitiendo gestionar libros,
 * usuarios, préstamos y devoluciones en una biblioteca virtual.
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //lista de usuarios nuevos que se van a dar de alta en el sistema
        ArrayList<Usuario> usuarios = new ArrayList<>();
        UsuarioService us = new UsuarioService(usuarios);

        //Listas de libros que van a ingresar a la biblioteca
        ArrayList<Libro> biblioteca = new ArrayList<>();
        LibroService ls = new LibroService(biblioteca);

        int opcion;

        do {
            System.out.println("\n=== Sistema Biblioteca Virtual ===");
            System.out.println("1 -  Gestionar Libros");
            System.out.println("2 -  Gestionar Usuarios");
            System.out.println("3 -  Prestamos");
            System.out.println("4 -  Devoluciones");
            System.out.println("5 -  Listar Libros Prestados");
            System.out.println("6 -  Mostrar Calificaciones");
            System.out.println("0 -  Salir");
            System.out.println("=== Seleccione una Opción ===");
            System.out.print("Opción: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1:
                    showMenuLibrary(ls, sc);
                    break;
                case 2:
                    showMenuUsers(us, sc);
                    break;
                case 3:
                    System.out.println("\n\t\t***** Prestamos *****\n");
                    if (us.isListaUsuariosVacia() || ls.isBibliotecaVacia()) {
                        System.out.println("No se puede realizar prestamos de libros porque la biblioteca está vacia" +
                                " o no existe usuarios.");
                    } else {
                        System.out.println("\nListado de Libros");
                        ls.listarBiblioteca();
                        System.out.print("\nIngrese el titulo del libro: ");
                        String nombreTitulo = sc.nextLine();
                        System.out.println("\nListado de usuarios");
                        us.listarUsuarios();
                        System.out.print("\nIngrese el ID del usuario a prestar: ");
                        int idUser = Integer.parseInt(sc.nextLine());

                        Libro libro = ls.buscarLibroTitulo(nombreTitulo);
                        Usuario user = us.buscarUsuarioId(idUser);

                        if (libro == null || user == null) {
                            System.out.println("El usuario o el libro no existe!!!");
                        }else {

                            us.prestarLibro(user, libro);
                        }

                    }
                    break;
                case 4:
                    System.out.println("\n\t\t***** Devoluciones *****\n");
                    if (us.isListaUsuariosVacia() || ls.isBibliotecaVacia()) {
                        System.out.println("No se puede realizar devoluciones libros porque la biblioteca está vacía" +
                                " o no existe usuarios.");
                    } else {

                        System.out.print("\nIngrese el titulo del libro a devolver: ");
                        String nombreLibro = sc.nextLine();

                        System.out.print("\nIngrese el ID del usuario que pidió prestado: ");
                        int idUser = Integer.parseInt(sc.nextLine());

                        System.out.print("Ingrese una calificacion del libro: ");
                        String calificacion = sc.nextLine();

                        Libro libro = ls.buscarLibroTitulo(nombreLibro);
                        Usuario user = us.buscarUsuarioId(idUser);

                        if (libro == null || user == null) {
                            System.out.println("El usuario o el libro no existe!!!");
                        }else {
                            us.devolverLibro(user, libro, calificacion);
                        }

                    }
                    break;
                case 5:
                    System.out.println("\n\t\t***** Listar Libros Prestados *****\n");
                    if (us.isListaUsuariosVacia() || ls.isBibliotecaVacia()) {
                        System.out.println("Biblioteca vacía o no existe usuarios registrados");
                    } else {
                        us.listarLibrosPrestados();
                    }
                    break;
                case 6:
                    System.out.println("\n\t\t***** Mostrar Calificaciones *****\n");
                    if (us.isListaUsuariosVacia() || ls.isBibliotecaVacia()) {
                        System.out.println("Biblioteca vacía o no existe usuarios registrados");
                    } else {
                        us.mostrarCalifaciones();
                    }
                    break;
                case 0:
                    System.out.println("Muchas Gracias");
                    break;
                default:
                    System.out.println("Opción Incorrecta!!!");
                    break;
            }
        }while (opcion != 0);
    }

    /**
     * Muestra el menú de gestión de usuarios y maneja la interacción con el usuario.
     * @param us Servicio de usuario para realizar operaciones relacionadas con los usuarios.
     * @param sc Scanner para leer la entrada del usuario.
     */
    public static void showMenuUsers(UsuarioService us, Scanner sc) {


        int opcion;

        do {
            System.out.println("\n=== Gestionar Usuarios ===");
            System.out.println("1 -  Crear Usuario");
            System.out.println("2 -  Actualizar Usuario");
            System.out.println("3 -  Buscar Usuario por ID");
            System.out.println("4 -  Listar Usuario");
            System.out.println("5 -  Eliminar Usuario");
            System.out.println("0 -  Volver al Menu Principal");
            System.out.println("=== Seleccione una Opción ===");
            System.out.print("Opción: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1:
                    System.out.println("\t\t***** Crear Usuario *****\n");
                    System.out.print("Ingrese el nombre: ");
                    String nombre = sc.nextLine();

                    us.crearUsuario(nombre);
                    break;
                case 2:
                    System.out.println("\n\t\t***** Actualizar Usuario *****\n");
                    if (us.isListaUsuariosVacia()) {
                        System.out.println("La Lista de Usuarios esta vacía!!!");
                    } else {
                        System.out.print("Igrese el ID del Usuario a actualizar: ");
                        int id = Integer.parseInt(sc.nextLine());
                        System.out.print("Ingrese el nuevo nombre del usuario: ");
                        String nuevoNombre = sc.nextLine();

                        us.actualizarUsuario(id, nuevoNombre);

                    }
                    break;

                case 3:
                    System.out.println("\n\t\t***** Buscar Usuario por ID *****\n");
                    if (us.isListaUsuariosVacia()) {
                        System.out.println("La Lista de Usuarios esta vacía!!!");
                    } else {
                        System.out.print("Ingrese el ID del usuario a buscar: ");
                        int buscarId = Integer.parseInt(sc.nextLine());
                        var usuarioBuscado = us.buscarUsuarioId(buscarId);

                        if (usuarioBuscado == null) {
                            System.out.println("El usuario con el ID: " + buscarId + " no existe!!!");
                        } else {
                            System.out.println(usuarioBuscado);
                        }
                    }

                    break;
                case 4:
                    System.out.println("\n\t\t***** Listados de Usuarios *****\n");

                    if (us.isListaUsuariosVacia()) {
                        System.out.println("La Lista de Usuarios esta vacía!!!");
                    } else {
                        us.listarUsuarios();
                    }

                    break;
                case 6:
                    if (us.isListaUsuariosVacia()) {
                        System.out.println("La Lista de Usuarios esta vacía!!!");
                    } else {
                        System.out.println("\n\t\t***** Eliminar Usuario *****\n");
                        System.out.print("Ingrese el ID del usuario a eliminar: ");
                        int idUser = Integer.parseInt(sc.nextLine());
                        if(us.eliminarUsuario(idUser)) {
                            System.out.println("El ususario con el ID: " + idUser + " ha sido eliminado exitosamente");
                        } else {
                            System.out.println("El ususario con el ID: " + idUser + " no existe en la lista de usuarios ");
                        }
                    }
                    break;
                case 0:
                    System.out.println("Hasta Luego");
                    break;
                default:
                    System.out.println("Opción Incorrecta!!!");
                    break;
            }
        }while (opcion != 0);

    }

    /**
     * Muestra el menú de gestión de libros y maneja la interacción con el usuario.
     * @param ls Servicio de libro para realizar operaciones relacionadas con los libros.
     * @param sc Scanner para leer la entrada del usuario.
     */
    public static void showMenuLibrary(LibroService ls, Scanner sc){

        int opcion;

        do {
            System.out.println("\n=== Gestionar Libros ===");
            System.out.println("1 -  Crear Libro");
            System.out.println("2 -  Actualizar Libro");
            System.out.println("3 -  Buscar Libro por ISBN");
            System.out.println("4 -  Buscar Libro por Genero");
            System.out.println("5 -  Listar Libros");
            System.out.println("6 -  Eliminar Libro");
            System.out.println("0 -  Volver al Menu Principal");
            System.out.println("=== Seleccione una Opción ===");
            System.out.print("Opción: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1:
                    System.out.println("\t\t***** Crear Libro *****\n");
                    System.out.print("Ingrese título: ");
                    String titulo = sc.nextLine();
                    System.out.print("Ingrese el autor: ");
                    String autor = sc.nextLine();
                    System.out.print("Ingrese el ISBN: ");
                    String isbn = sc.nextLine();
                    System.out.print("Ingrese el genero: ");
                    String genero = sc.nextLine();
                    ls.crearLibro(titulo, autor, isbn, genero);
                    break;
                case 2:
                    System.out.println("\n\t\t***** Actualizar Libro *****\n");
                    if (ls.isBibliotecaVacia()) {
                        System.out.println("La biblioteca está vacía");
                    } else {
                        System.out.print("Igrese el ISBN del libro a actualizar: ");
                        String nuevoIsbn = sc.nextLine();
                        System.out.print("Ingrese el nuevo título: ");
                        String nuevoTitulo = sc.nextLine();
                        System.out.print("Ingrese el nuevo autor: ");
                        String nuevoAutor = sc.nextLine();
                        System.out.print("Ingrese el nuevo género: ");
                        String nuevoGenero = sc.nextLine();

                        ls.actualizarLibro(nuevoIsbn, nuevoTitulo, nuevoAutor, nuevoGenero);

                    }
                    break;

                case 3:
                    System.out.println("\n\t\t***** Buscar Libro por ISBN *****\n");
                    if (ls.isBibliotecaVacia()) {
                        System.out.println("La biblioteca está vacía");
                    } else {
                        System.out.print("Ingrese el ISBN del libro a buscar:");
                        String buscarIsbn = sc.nextLine();
                        var libroBuscado = ls.buscarLibroIsbn(buscarIsbn);

                        if (libroBuscado == null) {
                            System.out.println("El libro con la ISBN: " + buscarIsbn + " no existe!!!");
                        } else {
                            System.out.println(libroBuscado);
                        }
                    }

                    break;
                case 4:
                    System.out.println("\n\t\t***** Buscar Libro por Genero *****\n");
                    if (ls.isBibliotecaVacia()) {
                        System.out.println("La biblioteca está vacía");
                    } else {
                        System.out.print("Ingrese el genero del libro: ");
                        String generoLibro = sc.nextLine();

                        if (ls.buscarLibroGenero(generoLibro) == null) {
                            System.out.println("El genero " + generoLibro + " no existe!!!");
                        } else {
                            System.out.println(ls.buscarLibroTitulo(generoLibro));
                        }
                    }

                    break;
                case 5:
                    System.out.println("\n\t\t***** Listados de Libros *****\n");

                    if (ls.isBibliotecaVacia()) {
                        System.out.println("La biblioteca está vacía");
                    } else {
                        ls.listarBiblioteca();
                    }

                    break;
                case 6:
                    if (ls.isBibliotecaVacia()) {
                        System.out.println("La biblioteca está vacía");
                    } else {
                        System.out.println("\n\t\t***** Eliminar Libro *****\n");
                        System.out.print("Ingrese el ISBN del libro a eliminar: ");
                        String auxIsbn = sc.nextLine();
                        if(ls.eliminarLibro(auxIsbn)) {
                            System.out.println("El libro con la isbn: " + auxIsbn + " ha sido eliminado exitosamente");
                        } else {
                            System.out.println("Eli libro con la isbn: " + auxIsbn + " no existe en la biblioteca ");
                        }
                    }
                    break;
                case 0:
                    System.out.println("Hasta Luego");
                    break;
                default:
                    System.out.println("Opción Incorrecta!!!");
                    break;
            }
        }while (opcion != 0);

    }
}
