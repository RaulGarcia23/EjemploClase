//Lazaro Aguilera Esteo
package menuserializable;

import java.io.*;
import java.util.Scanner;

public class MenuSerializable {

    static Scanner entrada = new Scanner(System.in);
    static ObjectOutputStream oos;
    static ObjectInputStream ois;

    public static void main(String[] args) {

        boolean salir = false;
        do {
            System.out.println("");
            menu();
            System.out.println("");
            System.out.print("Elige una opcion: ");
            int menu = entrada.nextInt();
            entrada.nextLine();
            switch (menu) {
                case 1:
                    añadirPersonas();
                    break;
                case 2:
                    System.out.print("Introduce el dni que quieres buscar: ");
                    String dni = entrada.nextLine();
                    buscar(dni);
                    break;
                case 3:
                    listarPersonas();
                    break;
                case 4:
                    borrar();
                    break;
                case 0:
                    salir = true;
                    break;
            }
        } while (!salir);

    }

    public static void menu() {
        System.out.println("|-- Menu Serializable --|");
        System.out.println("|--> 1º Añadir Personas-|");
        System.out.println("|--> 2º Buscar Personas-|");
        System.out.println("|--> 3º Listar Personas-|");
        System.out.println("|--> 4º Borrar Personas-|");
        System.out.println("|--> 0º Salir          -|");
        System.out.println("|-----------------------|");

    }

    public static void añadirPersonas() {

        Scanner entrada = new Scanner(System.in);
        String nombre, apellidos, dni;
        Persona p;
        File fichero = new File("fichero.bin");
        try {
            System.out.print("Introduce tu nombre: ");
            nombre = entrada.nextLine();

            System.out.print("Introduce tus apellidos: ");
            apellidos = entrada.nextLine();

            System.out.print("Introduce tu DNI: ");
            dni = entrada.nextLine();

            p = new Persona(nombre, apellidos, dni);
            if (fichero.length() == 0) {
                oos = new ObjectOutputStream(new FileOutputStream(fichero, false));
            } else {
                oos = new MiObjectOutputStream(new FileOutputStream(fichero, true));
            }
            oos.writeObject(p);
            oos.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el fichero");
        } catch (IOException e) {
            System.out.println("Se he producido un error en la lectura");
        }

    }

    public static void buscar(String dni) {
        int contador = 1;
        try {//extrae la infomacion del fichero

            ois = new ObjectInputStream(new FileInputStream("fichero.bin")); //Extrae le fichero
            while (true) {//hace un bucle que muentra todos los objetos
                Persona p3 = (Persona) ois.readObject();//se castea para que pueda escribir los objetos
                if (p3.getDNI().compareTo(dni) == 0) {
                    contador = 0;
                    System.out.println("La " + p3);
                }
            }
        } catch (EOFException e) {
            //hemos leido todos
        } catch (FileNotFoundException fe) {
            System.out.println("No se ha encontrado el fichero");
        } catch (IOException ioe) {
            System.out.println("Error en la Lectura");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error el fichero");
        } finally {
            if (contador == 1) {
                System.out.println("El dni " + dni + " no se encuentra");
            }
            try {
                ois.close();//cierra fichero;
            } catch (IOException ioe) {
                System.out.println("Error en la Lectura");
            }
        }
    }

    public static void listarPersonas() {
        try {//extrae la infomacion del fichero
            ois = new ObjectInputStream(new FileInputStream("fichero.bin")); //Extrae le fichero
            while (true) {//hace un bucle que muentra todos los objetos
                Persona p3 = (Persona) ois.readObject();//se castea para que pueda escribir los objetos
                System.out.println("La " + p3);
            }
        } catch (EOFException e) {
            //hemos leido todos
        } catch (FileNotFoundException fe) {
            System.out.println("No se ha encontrado el fichero");
        } catch (IOException ioe) {
            System.out.println("Error en la Lectura");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error el fichero");
        }
        try {
            ois.close();//cierra fichero;
        } catch (IOException ioe) {
            System.out.println("Error en la Lectura");
        }
    }

    public static void borrar() {
        String fichero = "fichero.bin";
        File nombreFichero = new File(fichero);
        if (nombreFichero.delete()) {
            System.out.println("Fichero borrado");
        } else {
            System.out.println("¡Error. El Fichero no ha sido borrado!");
        }
    }

}
