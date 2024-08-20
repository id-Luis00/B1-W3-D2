package luisquiroz.entities;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "eventi")
public class Evento {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String titolo;
    @Column
    private LocalDate data_evento;
    @Column
    private String descrizione;
    @Column
    @Enumerated (EnumType.STRING)
    private Event_type tipo_evento;
    @Column
    private int numMax_partecipanti;


    public Evento() {
    }

    public Evento(String titolo, LocalDate data_evento, String descrizione, Event_type tipo_evento, int numMax_partecipanti) {
        this.titolo = titolo;
        this.data_evento = data_evento;
        this.descrizione = descrizione;
        this.tipo_evento = tipo_evento;
        this.numMax_partecipanti = numMax_partecipanti;
    }




    public long getId() {
        return id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getData_evento() {
        return data_evento;
    }

    public void setData_evento(LocalDate data_evento) {
        this.data_evento = data_evento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Event_type getTipo_evento() {
        return tipo_evento;
    }

    public void setTipo_evento(Event_type tipo_evento) {
        this.tipo_evento = tipo_evento;
    }

    public int getNumMax_partecipanti() {
        return numMax_partecipanti;
    }

    public void setNumMax_partecipanti(int numMax_partecipanti) {
        this.numMax_partecipanti = numMax_partecipanti;
    }


    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", data_evento=" + data_evento +
                ", descrizione='" + descrizione + '\'' +
                ", tipo_evento=" + tipo_evento +
                ", numMax_partecipanti=" + numMax_partecipanti +
                '}';
    }
}
