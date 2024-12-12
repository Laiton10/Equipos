package Equipos;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("unidad-equipos");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

            Equipo equipo = em.find(Equipo.class, 11);
//          em.persist(equipo);
//          System.out.println("Equipo creado: " + equipo);

            Jugador jugador1 = em.find(Jugador.class, 19);
//          Jugador jugador2 = new Jugador("Victor Valdés", 190f, 85f, equipo);
           // Jugador jugador3 = new Jugador("EL BICHO", 187f, 83f, equipo);
            //Jugador jugador4 = new Jugador("LA PULGA", 170f, 62f, equipo);

         // em.persist(jugador1);
         // em.persist(jugador2);
         // em.persist(jugador3);
         // em.persist(jugador4);
         // System.out.println("Jugadores creados: " + jugador1 + ", " + jugador2);


          Equipo equipoBuscado = em.find(Equipo.class, 11);
          System.out.println(equipoBuscado);

          Set<Jugador> jugadores = equipoBuscado.getJugadores();
          System.out.println("Jugadores del equipo: " + jugadores);

          jugador1.setNombre("Neymara Junior");
          em.merge(jugador1);
          System.out.println("Jugador actualizado: " + jugador1);

       // em.remove(em.find(Jugador.class, 2));

        equipoBuscado.ordenarJugadores();

        em.getTransaction().commit();

    }
}
