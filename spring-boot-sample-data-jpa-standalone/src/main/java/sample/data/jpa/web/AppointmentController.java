package sample.data.jpa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sample.data.jpa.DTO.AppointmentDTO;
import sample.data.jpa.DTO.DTO;
import sample.data.jpa.DTO.ErrorDTO;
import sample.data.jpa.domain.Appointment;
import sample.data.jpa.service.AppointmentDao;
import sample.data.jpa.service.ProfDao;
import sample.data.jpa.service.UserDao;

import java.text.SimpleDateFormat;
import java.time.Duration;

@Controller
@RequestMapping("/appointment")
public class AppointmentController {
    @Autowired
    private AppointmentDao appointmentDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private ProfDao profDao;
/*
date : yyyy-mm-dd
time : int in seconds
 */
    @PostMapping("/create/{userid}/{profid}/{date}/{length}")
    @ResponseBody
    public DTO create(@PathVariable long userid, @PathVariable long profid, @PathVariable SimpleDateFormat date, @PathVariable Duration length) {
        try {
            Appointment app = new Appointment();
            app.setUser(userDao.findById(userid))
                    .setProf(profDao.findById(profid))
                    .setStart(date)
                    .setLength(length);

            appointmentDao.save(app);
    return new AppointmentDTO(app);
        } catch (Exception ex) {
            return new ErrorDTO(ex);
        }
    }

    /**
     * GET /delete  --> Delete the appointment having the passed id.
     */
    @DeleteMapping()
    @ResponseBody
    public String delete(long id) {
        try {
            Appointment app = appointmentDao.findById(id);
            appointmentDao.delete(app);
        } catch (Exception ex) {
            return "Error deleting the user:" + ex.toString();
        }
        return "User succesfully deleted!";
    }

    @RequestMapping("/get-by-id/{id}")
    @ResponseBody
    public DTO getById(@PathVariable long id) {
        try {
            Appointment app = appointmentDao.findById(id);
            return new AppointmentDTO(app);
        } catch (Exception ex) {
            return new ErrorDTO(ex);
        }

    }
}
