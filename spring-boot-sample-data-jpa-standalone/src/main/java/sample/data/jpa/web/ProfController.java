package sample.data.jpa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sample.data.jpa.DTO.AppointmentDTO;
import sample.data.jpa.DTO.DTO;
import sample.data.jpa.DTO.ErrorDTO;
import sample.data.jpa.DTO.ProfDTO;
import sample.data.jpa.domain.Appointment;
import sample.data.jpa.domain.Prof;
import sample.data.jpa.domain.User;
import sample.data.jpa.service.ProfDao;
import sample.data.jpa.service.UserDao;

import javax.validation.Valid;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@RestController

public class ProfController {


    @Autowired
    private UserDao userDao;
    private ProfDao profDao;

    @PostMapping("prof/create/{name}/{email}/{password}")
    @ResponseBody
    public DTO create(@PathVariable String name, @PathVariable String email, @PathVariable String password) {
        try {
            User prof = new Prof(name,password,"",1).setEmail(email);
        System.out.print(prof);
            userDao.save(prof);
            return new ProfDTO(prof);
        } catch (Exception ex) {
            return new ErrorDTO(ex);
        }
    }

    /**
     * GET /delete  --> Delete the prof having the passed id.
     */
    @DeleteMapping("prof/{id}")
    @ResponseBody
    public String delete(@PathVariable long id) {
        try {
            Prof prof = profDao.findById(id);
            profDao.delete(prof);
        } catch (Exception ex) {
            return "Error deleting the prof:" + ex.toString();
        }
        return "Prof succesfully deleted!";
    }

    /**
     * PUT /update  --> Update the email and the name for the prof in the
     * database having the passed id.
     */
    @PutMapping("prof/update")
    @ResponseBody
    public DTO updateProf(@Valid @RequestBody ProfDTO profdto) {
        try {
            userDao.save(profdto.toProf());
        } catch (Exception ex) {
            return new ErrorDTO(ex);
        }
        return profdto;
    }

    @RequestMapping("prof/get-by-email/{email}")
    @ResponseBody
    public DTO getByEmail(@PathVariable("email") String email) {
        try {
            Prof prof = (Prof) userDao.findByEmail(email);
            return new ProfDTO(prof);
        } catch (Exception ex) {
            return new ErrorDTO(ex);
        }

    }

    /**
     * GET /get-by-id  --> Return the id for the prof having the passed
     * email.
     */
    @RequestMapping("prof/get-by-id/{id}")
    @ResponseBody
    public DTO getById(@PathVariable long id) {
        try {
            User prof = userDao.findById(id);
            return new ProfDTO(prof);
        } catch (Exception ex) {
            return new ErrorDTO(ex);
        }

    }

    @RequestMapping("prof/get-all-appointments/{id}")
@ResponseBody
    public List<? extends DTO> getappointments(@PathVariable long id){
        try{
           ProfDTO profdto = (ProfDTO)getById(id);
            List <Appointment> app = profdto.getAppointments();
             List <AppointmentDTO> apps =  new ArrayList<AppointmentDTO>();
             for (Appointment a : app) {
                 apps.add(new AppointmentDTO(a));
                 return apps ;
            }
        }
        catch (Exception ex ) {
            List<DTO> errlist = new ArrayList<DTO>();
            errlist.add(new ErrorDTO(ex));
            return errlist;
        }
        return null;
    }
}
