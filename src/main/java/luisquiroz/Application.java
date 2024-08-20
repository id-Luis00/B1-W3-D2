package luisquiroz;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import luisquiroz.Exceptions.NotFoundException;
import luisquiroz.dao.eventoDAO;
import luisquiroz.entities.Event_type;
import luisquiroz.entities.Evento;

import java.time.LocalDate;


public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("B1-W3-D2");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        eventoDAO ed = new eventoDAO(em);

        Evento primoEvento = new Evento("Titolo", LocalDate.of(2000, 1, 1), "Descrizione", Event_type.PRIVATO, 200);

        ed.save(primoEvento);

        try {
            Evento foundIt = ed.findById(1);
            System.out.println(foundIt);
        } catch (NotFoundException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            ed.findByIdAndDelete(2);
        } catch (NotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        


        System.out.println("hello world");

        // di norma si chiude sempre l'entity manager (anche se a noi non serve)   ----> BEST PRACTICE
        em.close();
        emf.close();
    }
}
