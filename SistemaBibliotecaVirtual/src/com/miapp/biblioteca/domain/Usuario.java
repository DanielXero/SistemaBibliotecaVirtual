package com.miapp.biblioteca.domain;

import java.util.ArrayList;


/**
 * Esta clase representa un Usuario con sus métodos y atributos
 */
public class Usuario {


    private int id;
    private String nombre;
    private ArrayList<Libro> librosPrestados;
    /**
     * Contador estático para llevar la cuenta de los libros creados y asignar ID automáticamente.
     */
    private static int contUsuarios;


    /**
     * Constructor privado que incrementa y asigna el ID del libro automáticamente.
     */
    private Usuario() {
        this.id = ++Usuario.contUsuarios;
    }
    /**
     * Constructor público para crear una instancia de Libro con sus atributo básico.
     * Este constructor también inicializa la lista de libros prestados.
     *
     * @param nombre El nombre del usuario.
     */
    public Usuario(String nombre) {
        this();
        this.nombre = nombre;
        this.librosPrestados = new ArrayList<>();
    }



    /**
     * Obtiene el nombre del usuario.
     *
     * @return El nombre del usuario.
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Establece el nombre del usuario.
     *
     * @param nombre El nuevo nombre del usuario.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el ID del usuario.
     *
     * @return El ID del usuario.
     */
    public int getId() {
        return this.id;
    }


    /**
     * Obtiene la lista de libros prestados.
     *
     * @return La lista de libros prestados.
     */
    public ArrayList<Libro> getLibrosPrestados() {
        return this.librosPrestados;
    }



    /**
     * Retorna el estado del usuario.
     * La clase StringBuilder e utiliza para construir y manipular cadenas de caracteres de forma eficiente
     * @return Una cadena que representa al usuario.
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Usuario -> {");
        sb.append("id = '").append(id).append('\'');
        sb.append(", nombre = '").append(nombre).append('\'');
        sb.append('}');
        return sb.toString();
    }


}
