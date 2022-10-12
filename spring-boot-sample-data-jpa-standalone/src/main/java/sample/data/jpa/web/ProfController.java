package sample.data.jpa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sample.data.jpa.DTO.AppointmentDTO;
import sample.data.jpa.DTO.DTO;
import sample.data.jpa.DTO.ErrorDTO;
import sample.data.jpa.DTO.ProfDTO;
import sample.data.jpa.domain.Appointment;
import sample.data.jpa.domain.Prof;
import sample.data.jpa.service.ProfDao;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/prof")
public class ProfController {


    @Autowired
    private ProfDao profDao;

    @PostMapping("/create/{name}/{email}/{password}")
    @ResponseBody
    public DTO create(@PathVariable String name, @PathVariable String email, @PathVariable String password) {
        try {
            Prof prof = (Prof) new Prof().setEmail(email).setPassword(password).setName(name);

            profDao.save(prof);
            return new ProfDTO(prof);
        } catch (Exception ex) {
            return new ErrorDTO(ex);
        }
    }

    /**
     * GET /delete  --> Delete the prof having the passed id.
     */
    @DeleteMapping("/delete/{id}")
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
    @PutMapping("/update")
    @ResponseBody
    public DTO updateProf(@Valid @RequestBody ProfDTO profdto) {
        try {
            profDao.save(profdto.toProf());
        } catch (Exception ex) {
            return new ErrorDTO(ex);
        }
        return profdto;
    }

    @RequestMapping("/get-by-email/{email}")
    @ResponseBody
    public DTO getByEmail(@PathVariable("email") String email) {
        try {
            Prof prof = (Prof) profDao.findByEmail(email);
            return new ProfDTO(prof);
        } catch (Exception ex) {
            return new ErrorDTO(ex);
        }

    }

    /**
     * GET /get-by-id  --> Return the id for the prof having the passed
     * email.
     */
    @RequestMapping("/get-by-id/{id}")
    @ResponseBody
    public DTO getById(@PathVariable long id) {
        try {
            Prof prof = profDao.findById(id);
            return new ProfDTO(prof);
        } catch (Exception ex) {
            return new ErrorDTO(ex);
        }

    }

    @RequestMapping("/get-all-appointments/{id}")
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
