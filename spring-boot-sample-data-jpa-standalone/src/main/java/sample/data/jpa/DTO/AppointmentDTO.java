package sample.data.jpa.DTO;

import sample.data.jpa.domain.Appointment;
import sample.data.jpa.domain.Prof;
import sample.data.jpa.domain.User;

import java.time.Duration;
import java.util.Date;

public class AppointmentDTO implements DTO{
    private Date start;
    private int length;
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

    public Date getStart() {
        return start;
    }

    public void setStart(Date  start) {
        this.start = start;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
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
