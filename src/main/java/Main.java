import database.CambiarObra;
import database.InsObra;
import org.hibernate.boot.model.relational.Database;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // DECLARACIONES
        Scanner sc = new Scanner(System.in);
        boolean salir = false;
        String opcion = "";

        // BUCLE PARA MOSTRAR EL MENÚ DE OPCIONES
        while (!salir) {

            System.out.println("\n---[ CONSTRUCTORA ]---");
            System.out.println("1. Dar de alta nueva obra\n" +
                    "2. Cambiar obra asignada a un empleado\n");

            opcion = sc.nextLine();                                                                         // Leer y guardar la opción del usuario.

            // ESTRUCTURA PARA LA LLAMADA A LOS MÉTODOS
            switch (opcion) {
                case "0":
                    salir = true;                                                                           // Fin de la ejecución del menú.
                    break;

                case "1":
                    InsObra.crearObraNueva();
                    break;

                case "2":
                    CambiarObra.listarEmpleados();
                    break;

                default:
                    System.err.println("\n>>> OPCIÓN NO VÁLIDA: Introduzca una opción del menú");        // Informar al usuario de un error cometido.
                    break;
            }
        }

    }
}
