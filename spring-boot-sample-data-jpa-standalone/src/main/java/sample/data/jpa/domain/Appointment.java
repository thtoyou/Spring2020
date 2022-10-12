package sample.data.jpa.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.Duration;

@Entity
@NamedQueries({
        @NamedQuery(name = "Appointment.findByProf_Appointments_Id", query = "select a from Appointment a inner join a.prof.appointments appointments where appointments.id = :Id")
})

public class Appointment {
    private SimpleDateFormat start;
    private Duration length;
    private Prof prof;
    private User user;
    private Long id;

    
    

    public Appointment(SimpleDateFormat start, Duration length, Prof prof, User user) {
        this.start = start;
        this.length = length;
        this.prof = prof;
        this.user = user;
    }

    public Appointment() {
    }


    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public Appointment setId(Long id) {
        this.id = id;
        return this;
    }

    public SimpleDateFormat getStart() {
        return start;
    }

    public Appointment setStart(SimpleDateFormat start) {
        this.start = start;
        return this;
    }

    public Duration getLength() {
        return length;
    }

    public Appointment setLength(Duration length) {
        this.length = length;
        return this;
    }

    @ManyToOne
    public Prof getProf() {
        return prof;
    }

    public Appointment setProf(Prof prof) {
        this.prof = prof;
        return this;
    }

    @ManyToOne
    @JsonBackReference
    public User getUser() {
        return user;
    }

    public Appointment setUser(User user) {
        this.user = user;
        return this;
    }


    public void Cancel() {
        this.prof = null;
        this.user = null;
    }

    @Override
    public String toString() {
        return "Appointment at " + start + "with" + prof + "and" + user + "for" + length;
    }


}
