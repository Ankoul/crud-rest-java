package br.net.intuitiva.crud.api.service;

import br.net.intuitiva.crud.api.model.User;
import br.net.intuitiva.crud.api.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class UserService {


    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> listAll() {
        return userRepository.listAll();
    }

    public User save(User user) {
        Assert.notNull(user, "User cannot be null");
        if (user.getId() == null) {
            return userRepository.create(user);
        }
        user = userRepository.update(user);
        Assert.notNull(user, "User not found");
        return user;
    }

    public User create(User user){
        return userRepository.create(user);
    }

    public User delete(Long id){
        return userRepository.delete(id);
    }

    public User find(Long id) {
        return userRepository.find(id);
    }
    public List<User> reset() {
        userRepository.reset();
        return this.listAll();
    }
}
