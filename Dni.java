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
public class Dni implements Serializable {

    private int numero;//8 caracteres
    private char letra;

    Dni(int dni, char letra) {
        this.numero = dni;
        this.letra = letra;

    }

    Dni(Dni d) {
        this.numero = d.getLetra();
        this.letra = d.getLetra();
    }

    Dni(String d) {//DNI como String
        if (d.length() == 9) {
            String numCadena = d.substring(0, 8);//Cojo los 8 digitos en String
            numero = (int) Long.parseLong(numCadena);// Lo transforma en numero
            letra = d.charAt(8);
        } else {
            numero = 0;
            letra = ' ';
        }

    }

    public void mostrar() {//Muestra el DNI
        System.out.println("DNI: " + this.numero + letra);
    }

    public long getNumero() {//Muestra los numeros
        return numero;
    }

    public char getLetra() {//Muestra la letra
        return letra;
    }

    public void setDni(int dni, char letra) {//Cambia la letra y numeros.
        Dni aux = new Dni(dni, letra);
        if (aux.esValido()) {
            this.numero = dni;
            this.letra = letra;
        }
    }

    public boolean esValido() {//Comrpueba que el DNI es correcto.
        char vector[] = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};

        int pos = numero % 23;

        char letraC = vector[pos];
        if (letraC == this.letra) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "" + numero + letra;
    }

}
