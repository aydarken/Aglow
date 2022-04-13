package kz.iitu.aglow.service;

import kz.iitu.aglow.model.User;
import kz.iitu.aglow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        repository.findAll().forEach(users::add);
        return users;
    }

    public Optional<User> getUser(long id) {
        return repository.findById(id);
    }

    public void addUser(User user) {
        repository.save(user);
    }

    public void updateUser(long id, User newUser) {
        repository.findById(id).map(user -> {
            user.setPhoneNumber(newUser.getPhoneNumber());
            user.setHSSReqID(newUser.getHSSReqID());
            return user;
        }).orElseGet(() -> {
            newUser.setUser_id(id);
            return repository.save(newUser);
        });
    }

    public void deleteUser(long id) {
        repository.deleteById(id);
    }

}