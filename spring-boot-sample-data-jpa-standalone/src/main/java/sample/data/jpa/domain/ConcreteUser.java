package sample.data.jpa.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ConcreteUser extends User {

    private List<Appointment> appointments = new ArrayList<Appointment>();

    public ConcreteUser(String name, String passWord) {
        this.setName(name);
        super.setPassword(passWord);
    }

    public ConcreteUser() {
    }


    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonBackReference
    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }


    @Override
    public String toString() {
        return "nom :" + getName() + "id :" + super.getId();
    }
}
