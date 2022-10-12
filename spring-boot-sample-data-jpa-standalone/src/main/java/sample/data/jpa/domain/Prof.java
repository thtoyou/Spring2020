package sample.data.jpa.domain;

import org.springframework.stereotype.Component;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Entity
@Component
public class Prof extends User {

    private String name;
    private String poste;

    private Time length;
    private List<Appointment> appointments = new ArrayList<Appointment>();

    public Prof(String name, String password, String poste, Time length) {
        this.name = name;
        this.setPassword(password);
        this.poste = poste;
        this.length = length;
    }

    public Prof() {
        this.length = new Time(1);
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public Time getLength() {
        return length;
    }

    public void setLength(Time length) {
        this.length = length;
    }

    @OneToMany(mappedBy = "prof", cascade = CascadeType.ALL)
    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    @Override
    public String getName() {
        return name;
    }
}
