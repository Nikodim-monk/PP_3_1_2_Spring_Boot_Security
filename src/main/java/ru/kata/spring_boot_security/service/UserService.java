package ru.kata.spring_boot_security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.kata.spring_boot_security.model.User;
import ru.kata.spring_boot_security.repository.UserRepository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {//implements UserDetailsService {
    @Autowired
    private UserRepository repository;

//    public User getByName(String name) {
//        return repository.getByName(name);
//    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
////        User user = getByName(username);
////        if (user == null) {
////            throw new UsernameNotFoundException(String.format("User '%s' not found", username));
////        }
////        return new org.springframework.security.core.userdetails.User(
////                user.getName(), user.getPassword(), mapRolesToAuthorityes(user.getRoles()));
//        return null;
//    }
//
//    private Collection<? extends GrantedAuthority> mapRolesToAuthorityes(Collection<Role> roles) {
//        return roles.stream().map(r -> new SimpleGrantedAuthority(r.getRole())).collect(Collectors.toList());
//    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public void addNewUser(User user) {
        repository.save(user);
    }

    public User getUserById(long id) {
        return repository.findById(id).orElse(null);
    }

    public void updateUser(User user) {
        repository.saveAndFlush(user);
    }

    public void UserDelete(long id) {
        repository.deleteById(id);
    }
}
