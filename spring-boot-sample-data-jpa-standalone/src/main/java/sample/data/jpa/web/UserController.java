package sample.data.jpa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sample.data.jpa.DTO.DTO;
import sample.data.jpa.DTO.ErrorDTO;
import sample.data.jpa.DTO.UserDTO;
import sample.data.jpa.domain.ConcreteUser;
import sample.data.jpa.domain.User;
import sample.data.jpa.service.UserDao;

import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    /**
     * GET /create  --> Create a new user and save it in the database.
     */
    @PostMapping("/user/create/{name}/{password}")
    @ResponseBody
    public DTO create(@PathVariable String name, @PathVariable String password) {
        try {
            User user = new ConcreteUser(name, password);
            userDao.save(user);
            return new UserDTO(user);
        } catch (Exception ex) {
            return new ErrorDTO(ex);
        }
    }

    @PostMapping ("/user/create/{name}/{password}/{email}")
    @ResponseBody
    public DTO create(@PathVariable String name, @PathVariable String password, @PathVariable String email) {
        try {
            User user = new ConcreteUser(name, password)
                    .setEmail(email);
            userDao.save(user);
            return new UserDTO(user);
        } catch (Exception ex) {
            return new ErrorDTO(ex);
        }
    }

    /**
     * GET /delete  --> Delete the user having the passed id.
     */
    @DeleteMapping("/user/{id}")
    @ResponseBody
    public String delete(@PathVariable long id) {
        try {
            User user = userDao.findById(id);
            userDao.delete(user);
        } catch (Exception ex) {
            return "Error deleting the user:" + ex.toString();
        }
        return "User succesfully deleted!";
    }

    /**
     * GET /get-by-email  --> Return the id for the user having the passed
     * email.
     */
    @RequestMapping("/user/get-by-email/{email}")
    @ResponseBody
    public DTO getByEmail(@PathVariable("email") String email) {
        try {
            User user = userDao.findByEmail(email);
            return new UserDTO(user);
        } catch (Exception ex) {
            return new ErrorDTO(ex);
        }

    }

    /**
     * GET /get-by-id  --> Return the id for the user having the passed
     * email.
     */
    @RequestMapping("/user/get-by-id/{id}")
    @ResponseBody
    public DTO getById(@PathVariable long id) {
        try {
            User user = (User) userDao.findById(id);
            return new UserDTO(user);
        } catch (Exception ex) {
            return new ErrorDTO(ex);
        }

    }

    // Private fields

    /**
     * PUT /update  --> Update the email and the name for the user in the
     * database having the passed id.
     */
    @PutMapping("/user/update")
    @ResponseBody
    public DTO updateUser(@Valid @RequestBody UserDTO userdto) {
        try {
            userDao.save(userdto.toUser());
        } catch (Exception ex) {
            return new ErrorDTO(ex);
        }
        return userdto;
    }

}