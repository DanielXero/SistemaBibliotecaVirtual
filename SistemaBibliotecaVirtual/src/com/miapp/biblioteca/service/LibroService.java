package com.miapp.biblioteca.service;
import com.miapp.biblioteca.domain.Libro;

import java.util.ArrayList;

/**
 * Clase de servicio para manejar operaciones CRUDS en el Sistema de Biblioteca Virtual.
 * Proporciona funcionalidades para crear, listar, verificar, actualizar y eliminar libros.
 */
public class LibroService {

    private ArrayList<Libro> biblioteca; // Almacena una lista de libros que representa la biblioteca.

    /**
     * Constructor que inicializa la biblioteca con una lista de libros existente.
     *
     * @param biblioteca La lista inicial de libros.
     */
    public LibroService(ArrayList<Libro> biblioteca) {
        this.biblioteca = biblioteca;
    }

    /**
     * Crea y agrega un nuevo libro a la biblioteca.
     *
     * @param titulo El título del libro.
     * @param autor El autor del libro.
     * @param ISBN El ISBN del libro.
     * @param genero El género del libro.
     */
    public void crearLibro(String titulo, String autor, String ISBN, String genero) {
        Libro nuevoLibro = new Libro(titulo, autor, ISBN, genero);
        this.biblioteca.add(nuevoLibro);
        System.out.println("El libro " + nuevoLibro.getTitulo() + " se ha creado exitosamente!!!");
    }

    /**
     * Lista todos los libros disponibles en la biblioteca.
     */
    public void listarBiblioteca() {
        for (Libro libro : this.biblioteca) {
            System.out.println(libro);
        }
    }

    /**
     * Verifica si la biblioteca está vacía.
     *
     * @return true si la biblioteca no tiene libros; de lo contrario, false.
     */
    public boolean isBibliotecaVacia() {
        return this.biblioteca.isEmpty();
    }

    /**
     * Actualiza la información de un libro existente en la biblioteca.
     *
     * @param isbn El ISBN del libro a actualizar.
     * @param nuevoTitulo El nuevo título del libro.
     * @param nuevoAutor El nuevo autor del libro.
     * @param nuevoGenero El nuevo género del libro.
     */
    public void actualizarLibro(String isbn, String nuevoTitulo, String nuevoAutor, String nuevoGenero) {
        for (Libro libro : this.biblioteca) {
            if (isbn.equalsIgnoreCase(libro.getISBN())) {
                libro.setTitulo(nuevoTitulo);
                libro.setAutor(nuevoAutor);
                libro.setGenero(nuevoGenero);
            }
        }
        System.out.println("El libro " + nuevoTitulo + " ha sido actualizado exitosamente!!!");
    }

    /**
     * Elimina un libro de la biblioteca basado en su ISBN.
     *
     * @param ISBN El ISBN del libro a eliminar.
     * @return true si el libro fue eliminado exitosamente; de lo contrario, false.
     */
    public boolean eliminarLibro(String ISBN) {
        return this.biblioteca.removeIf(libro -> libro.getISBN().equalsIgnoreCase(ISBN));
    }

    /**
     * Busca un libro en la biblioteca por su ISBN.
     *
     * @param buscarIsbn El ISBN del libro a buscar.
     * @return El libro encontrado o null si no se encuentra.
     */
    public Libro buscarLibroIsbn(String buscarIsbn) {
        for (Libro libro : this.biblioteca) {
            if (libro.getISBN().equals(buscarIsbn)) {
                return libro;
            }
        }
        return null;
    }

    /**
     * Busca un libro en la biblioteca por su título.
     *
     * @param titulo El título del libro a buscar.
     * @return El libro encontrado o null si no se encuentra.
     */
    public Libro buscarLibroTitulo(String titulo) {
        for (Libro libro : this.biblioteca) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return libro;
            }
        }
        return null;
    }

    /**
     * Verifica la disponibilidad de un libro.
     *
     * @param libro El libro cuya disponibilidad se verificará.
     * @return true si el libro está disponible; de lo contrario, false.
     */
    public boolean verificarDisponibilidad(Libro libro) {
        return libro.isDisponible();
    }
}