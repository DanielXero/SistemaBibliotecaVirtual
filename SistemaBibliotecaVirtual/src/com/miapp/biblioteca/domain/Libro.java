package com.miapp.biblioteca.domain;

/**
 * Esta clase representa un Libro con sus metodos y atributos
 */
public class Libro {

    private int id;


    private String titulo;


    private String autor;


    private String ISBN;


    private String genero;


    private boolean disponible;

    /**
     * Contador estático para llevar la cuenta de los libros creados y asignar ID automáticamente.
     */
    private static int contLibros;

    /**
     * Constructor privado que incrementa y asigna el ID del libro automáticamente.
     */
    private Libro() {
        this.id = ++Libro.contLibros;
    }

    /**
     * Constructor público para crear una instancia de Libro con sus atributos básicos.
     * Establece el libro como disponible por defecto.
     *
     * @param titulo El título del libro.
     * @param autor El autor del libro.
     * @param ISBN El código ISBN del libro.
     * @param genero El género literario del libro.
     */
    public Libro(String titulo, String autor, String ISBN, String genero) {
        this(); // Llama al constructor privado para asignar ID
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        this.genero = genero;
        this.disponible = true; // El libro se crea como disponible por defecto.
    }

    /**
     * Obtiene el ID del libro.
     *
     * @return El ID del libro.
     */
    public int getId() {
        return this.id;
    }

    /**
     * Obtiene el título del libro.
     *
     * @return El título del libro.
     */
    public String getTitulo() {
        return this.titulo;
    }

    /**
     * Establece el título del libro.
     *
     * @param titulo El nuevo título del libro.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Obtiene el autor del libro.
     *
     * @return El autor del libro.
     */
    public String getAutor() {
        return this.autor;
    }

    /**
     * Establece el autor del libro.
     *
     * @param autor El nuevo autor del libro.
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * Obtiene el código ISBN del libro.
     *
     * @return El código ISBN del libro.
     */
    public String getISBN() {
        return this.ISBN;
    }

    /**
     * Establece el código ISBN del libro.
     *
     * @param ISBN El nuevo código ISBN del libro.
     */
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    /**
     * Obtiene el género literario del libro.
     *
     * @return El género literario del libro.
     */
    public String getGenero() {
        return this.genero;
    }

    /**
     * Establece el género literario del libro.
     *
     * @param genero El nuevo género literario del libro.
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Verifica si el libro está disponible.
     *
     * @return true si el libro está disponible, false en caso contrario.
     */
    public boolean isDisponible() {
        return this.disponible;
    }

    /**
     * Establece la disponibilidad del libro.
     *
     * @param disponible El nuevo estado de disponibilidad del libro.
     */
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    /**
     * Retorna el estado del libro.
     * La clase StringBuilder e utiliza para construir y manipular cadenas de caracteres de forma eficiente
     * @return Una cadena que representa al libro.
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Libro -> {");
        sb.append("id = ").append(id);
        sb.append(", titulo = '").append(titulo).append('\'');
        sb.append(", autor = '").append(autor).append('\'');
        sb.append(", ISBN = '").append(ISBN).append('\'');
        sb.append(", genero = '").append(genero).append('\'');
        sb.append(", disponible = ").append(disponible);
        sb.append("}");
        return sb.toString();
    }
}