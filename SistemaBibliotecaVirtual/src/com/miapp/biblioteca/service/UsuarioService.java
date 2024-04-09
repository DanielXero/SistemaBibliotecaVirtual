package com.miapp.biblioteca.service;

import com.miapp.biblioteca.domain.Libro;
import com.miapp.biblioteca.domain.Usuario;

import java.util.ArrayList;

/**
 * Servicio encargado de gestionar las operaciones relacionadas con los usuarios
 * de una biblioteca, incluyendo la creación, actualización, eliminación y listado de usuarios.
 * También maneja el préstamo y devolución de libros a los usuarios.
 */
public class UsuarioService {

    private ArrayList<Usuario> usuarios; // Lista de usuarios.

    /**
     * Constructor que inicializa la lista de usuarios.
     *
     * @param usuarios Lista inicial de usuarios.
     */
    public UsuarioService(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    /**
     * Crea un nuevo usuario y lo agrega a la lista de usuarios.
     *
     * @param nombre Nombre del nuevo usuario.
     */
    public void crearUsuario(String nombre) {
        Usuario nuevoUsuario = new Usuario(nombre);
        usuarios.add(nuevoUsuario);
    }

    /**
     * Imprime la lista de todos los usuarios.
     */
    public void listarUsuarios() {
        for (Usuario user : this.usuarios) {
            System.out.println(user);
        }
    }

    /**
     * Verifica si la lista de usuarios está vacía.
     *
     * @return true si la lista está vacía, false en caso contrario.
     */
    public boolean isListaUsuariosVacia() {
        return this.usuarios.isEmpty();
    }

    /**
     * Actualiza el nombre de un usuario basado en su ID.
     *
     * @param id El ID del usuario a actualizar.
     * @param nuevoNombre El nuevo nombre para el usuario.
     */
    public void actualizarUsuario(int id, String nuevoNombre) {
        for (Usuario user : this.usuarios) {
            if (user.getId() == id) {
                user.setNombre(nuevoNombre);
            }
        }
    }

    /**
     * Elimina un usuario de la lista basado en su ID.
     *
     * @param id El ID del usuario a eliminar.
     * @return true si el usuario fue eliminado, false en caso contrario.
     */
    public boolean eliminarUsuario(int id) {
        return this.usuarios.removeIf(user -> user.getId() == id);
    }

    /**
     * Busca un usuario por su ID.
     *
     * @param id El ID del usuario a buscar.
     * @return El usuario encontrado o null si no existe.
     */
    public Usuario buscarUsuarioId(int id) {
        for (Usuario user : usuarios) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    /**
     * Realiza el préstamo de un libro a un usuario, marcando el libro como no disponible en la biblioteca.
     *
     * @param user  El usuario al que se le prestará el libro.
     * @param libro El libro a prestar.
     */
    public void prestarLibro(Usuario user, Libro libro) {
        if (libro.isDisponible()) {
            user.getLibrosPrestados().add(libro);
            libro.setDisponible(false);
            System.out.println("El libro ha sido prestado al usuario: " + user.getNombre());
        } else {
            System.out.println("El libro que buscas no se encuentra disponible");
        }
    }

    /**
     * Devuelve un libro prestado por un usuario, marcando el libro como disponible en la biblioteca.
     *
     * @param user  El usuario que devuelve el libro.
     * @param libro El libro a devolver.
     */
    public void devolverLibro(Usuario user, Libro libro) {
        if (user.getLibrosPrestados().contains(libro)) {
            user.getLibrosPrestados().remove(libro);
            libro.setDisponible(true);
        } else {
            System.out.println("El libro no fue prestado a este usuario");
        }
    }
}