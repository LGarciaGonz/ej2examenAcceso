package database;

import Libs.Leer;
import entities.ObraEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

import java.util.Date;

public class InsObra {

    static EntityManager em = EmfSingleton.getInstance().getEmf().createEntityManager();

    public static void crearObraNueva() {

        // VARIABLES -------------
        String nombre;
        String direccion;
        Date entrega;

        System.out.println("\n*****[ CREAR NUEVA OBRA ]*****");

        nombre = Leer.pedirCadena("Introduzca nombre de la obra: ");
        direccion = Leer.pedirCadena("Introduzca dirección de la obra: ");
        entrega = Leer.pedirDate("Introduzca fecha de entrega: ");

        EntityManagerFactory emf = EmfSingleton.getInstance().getEmf();

        // Aquí comienza nuestro contexto de persistencia asociado a nuestro EntityManager (em).
        EntityManager em = emf.createEntityManager();

        try {
            EntityTransaction transaction = em.getTransaction();

            // Comenzar a crear el contexto de persistencia.
            transaction.begin();

            // Crear la nueva obra.
            ObraEntity nuevaObra = new ObraEntity();

            nuevaObra.setNombre(nombre);
            nuevaObra.setDireccion(direccion);
            nuevaObra.setEntrega((java.sql.Date) entrega);

            em.persist(nuevaObra);   // Objeto persistido.

            // Al hacer el commit los cambios se pasan a la base de datos.
            transaction.commit();

            System.out.println("\n>>> *****{ OBRA CREADA CORRECTAMENTE }*****\n");

        } catch (Exception e) {
            System.err.println(">>> ERROR EN LA CREACIÓN DE LA OBRA: " + e.getMessage());
        } finally {
            // Asegurar que la conexión se cierra y el contexto de persistencia termina.
            em.close();
        }


    }

}
