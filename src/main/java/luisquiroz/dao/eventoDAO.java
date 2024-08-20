package luisquiroz.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import luisquiroz.Exceptions.NotFoundException;
import luisquiroz.entities.Evento;

public class eventoDAO {


    private final EntityManager em;

    public eventoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Evento evento) {
        // 1. Chiediamo all'entity manager di fornirci una transazione
        EntityTransaction transaction = em.getTransaction();

        // 2. Facciamo partire la transazione
        transaction.begin();

        // 3. Aggiungiamo l'evento al Persistence Context
        em.persist(evento);

        // 4. Concludiamo la transazione
        transaction.commit();

        System.out.println("L'evento " + evento.getTitolo() + " è stato salvato correttamente!");
    }


    public Evento findById(long eventId) {
        Evento found = em.find(Evento.class, eventId); // Primo parametro è la classe dell'entità, secondo è l'id da cercare
        if (found == null) throw new NotFoundException(eventId);
        return found;
    }


    public void findByIdAndDelete(long eventId) {
        // 0. Cerco lo studente nel db
        Evento found = this.findById(eventId);

        // 1. Chiediamo all'entity manager di fornirci una transazione
        EntityTransaction transaction = em.getTransaction();

        // 2. Facciamo partire la transazione
        transaction.begin();

        // 3. Rimuoviamo lo studente dal Persistence Context (a questo step lo studente non è ancora stato rimosso effettivamente dal db)
        em.remove(found);

        // 4. Concludiamo la transazione (qua lo studente verrà effettivamente rimosso)
        transaction.commit();

        System.out.println("L'evento " + found.getTitolo() + " è stato eliminato correttamente!");
    }


}
