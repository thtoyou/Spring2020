package sample.data.jpa.service;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import sample.data.jpa.domain.Appointment;
import sample.data.jpa.domain.Prof;
import sample.data.jpa.domain.User;

import java.util.List;

@Transactional
public interface AppointmentDao extends JpaRepository<Appointment, Long> {
    public Appointment findById (long id);

    public List<Appointment> findByUser (User user);

    public List<Appointment> findByProf (Prof prof);
}
