package sample.data.jpa.DTO;

import sample.data.jpa.domain.Appointment;
import sample.data.jpa.domain.Prof;
import sample.data.jpa.domain.User;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class ProfDTO implements DTO {
    private String name;
    private String poste;

    private int length;
    private List<Appointment> appointments = new ArrayList<Appointment>();

    private long id;
    private String email;

    public ProfDTO() {
    }

    public ProfDTO(Prof prof) {
        this.name = prof.getName();
        this.appointments = prof.getAppointments();
        this.poste = prof.getPoste();
        this.length = prof.getLength();
        this.id = prof.getId();
        this.email =prof.getEmail();

    }
    public ProfDTO(User prof) {
        this.name = prof.getName();
        this.id = prof.getId();
        this.email = prof.getEmail();

    }
        public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Prof toProf() {
        return (Prof) new Prof().setId(this.getId()).setEmail(this.email).setName(this.getName());
    }
}
