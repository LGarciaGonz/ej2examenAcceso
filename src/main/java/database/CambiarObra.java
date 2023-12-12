package database;

import Libs.Leer;
import entities.EmpleadoEntity;
import entities.ObraEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.ArrayList;

public class CambiarObra {

    static EntityManager em = EmfSingleton.getInstance().getEmf().createEntityManager();
    static EntityManagerFactory emf = EmfSingleton.getInstance().getEmf();


    public static void listarEmpleados() {

        System.out.println("\n*-*-*[ LISTADO DE EMPLEADOS ]*-*-*");

        int contador = 1;

        Query listadoEmpleados = em.createQuery("from EmpleadoEntity ");

        ArrayList<EmpleadoEntity> listaEmpleados = (ArrayList<EmpleadoEntity>) listadoEmpleados.getResultList();

        // MOSTRAR LOS EMPLEADOS Y SUS DATOS ------------------------------
        for (EmpleadoEntity e : listaEmpleados) {
            System.out.println("\n***[ EMPLEADO " + contador + " ]***");
            System.out.println("- NOMBRE: " + e.getNombre());
            System.out.println("- OBRA ASIGNADA: " + e.getNombreObra());
            contador++;
        }

        em.close();

        // Recoger el nombre del empleado del usuario.
        String nombreEmpleado = Leer.pedirCadena("Introduce el nombre del empleado: ");

        // Llamada a la función.
        comprobacionesCambio(nombreEmpleado);
    }

    public static void comprobacionesCambio(String nombreEmpleado) {

        // Aquí comienza nuestro contexto de persistencia asociado a nuestro EntityManager (em).
        EntityManager em2 = emf.createEntityManager();

        String nuevaObra = Leer.pedirCadena("\nIntroduce el nombre de la nueva obra a asignar: ");

        try {
            EntityTransaction transaction = em2.getTransaction();

            // Comenzamos a crear el contexto de persistencia.
            transaction.begin();

            // Se añade la relación del objeto e con su registro de la base de datos al contexto de persistencia.
            EmpleadoEntity empleado = em2.find(EmpleadoEntity.class, nombreEmpleado);

            // A partir de aquí trabajamos sobre el objeto instanciado qu erepresenta un registro de la base de datos.
            System.out.println("Obra anterior asignada: " + empleado.getNombreObra());

            // Las modificaciones del objeto están asociadas al contexto de persistencia pero no están en la base de datos.
            empleado.setNombreObra(nuevaObra);
            System.out.println("Obra modificada: " + empleado.getNombreObra());

            // Al hacer el commit los cambios se pasan a la base de datos.
            transaction.commit();

        } catch (Exception e) {
            System.err.println(">>>ERROR: " + e.getMessage());
        } finally {
            // Asegurar que la conexión se cierra y el contexto de persistencia termina.
            em2.close();
        }

    }

}
