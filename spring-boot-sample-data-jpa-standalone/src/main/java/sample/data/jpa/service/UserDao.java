package sample.data.jpa.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import sample.data.jpa.domain.User;

// Imports ...

@Transactional
public interface UserDao extends JpaRepository<User, Long> {

  /**
   * This method will find a User instance in the database by its email.
   * Note that this method is not implemented and its working code will be
   * automagically generated from its signature by Spring Data JPA.
   */
  public User findByName(String name);
  public User findByEmail(String Email);

  public User findById(long id);

}