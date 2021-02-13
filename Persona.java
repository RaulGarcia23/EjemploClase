/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menuserializable;

import java.io.Serializable;

/**
 *
 * @author Usuario
 */
public class Persona implements Serializable {

    private String nombre;
    private String apellidos;
    private Dni dni;//Tiene que ser serializable
    private boolean borrado;

    public Persona(String nombre, String apellidos, String dni) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = new Dni(dni);
    }

    public void mostrar() {
        System.out.println(nombre + " " + apellidos + " DNI:" + dni);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setApellidos(String apellido) {
        this.apellidos = apellido;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setDNI(String dni) {
        this.dni = new Dni(dni);
    }

    public String getDNI() {
        return ""+dni;
    }

    boolean getBorrado() {
        return borrado;
    }

    void setBorrado(boolean b) {
        this.borrado = b;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + '}';
    }

}
