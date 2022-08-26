package ru.kata.spring_boot_security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kata.spring_boot_security.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//    User getByName(String name);
}
