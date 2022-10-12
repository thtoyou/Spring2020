package sample.data.jpa.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import sample.data.jpa.domain.Prof;

@Transactional
public interface ProfDao extends JpaRepository<Prof, Long> {
    public Prof findByName(String name);
    public Prof findById(long id);

    Object findByEmail(String email);
}
