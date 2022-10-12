package sample.data.jpa.DTO;

import sample.data.jpa.domain.Appointment;
import sample.data.jpa.domain.Prof;
import sample.data.jpa.domain.User;

import java.text.SimpleDateFormat;
import java.time.Duration;

public class AppointmentDTO implements DTO{
    private SimpleDateFormat start;
    private Duration length;
    private Prof prof;
    private User user;
    private Long id;

    public AppointmentDTO() {
    }

    public AppointmentDTO(Appointment app) {
        this.id = app.getId();
        this.user = app.getUser();
        this.prof = app.getProf();
        this.length = app.getLength();
        this.start = app.getStart();

    }

    public SimpleDateFormat getStart() {
        return start;
    }

    public void setStart(SimpleDateFormat start) {
        this.start = start;
    }

    public Duration getLength() {
        return length;
    }

    public void setLength(Duration length) {
        this.length = length;
    }

    public Prof getProf() {
        return prof;
    }

    public void setProf(Prof prof) {
        this.prof = prof;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
