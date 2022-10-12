package sample.data.jpa.DTO;

import sample.data.jpa.domain.User;

public class UserDTO implements DTO {
    private Long id;
    private String name;
    private String email;

    public UserDTO() {
    }
    public UserDTO(User user){
        this.email= user.getEmail();
        this.id = user.getId();
        this.name = user.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public User toUser(){
        return new User().setEmail(this.email).setName(this.name).setId(this.id);
    }
}
