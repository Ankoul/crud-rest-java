package br.net.intuitiva.crud.api.persistence;

import br.net.intuitiva.crud.api.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    private static final List<User> users = new ArrayList<>();
    private static long lastId = 0;

    private final String[] names = {"Terrence Huerta", "Anayah Mayer", "Braden Mcfarlane", "Veer Kearns",
            "Rheanna Berger", "Rickie Cortez", "Emyr Coleman", "Codey Skinner", "Olivia-Mae Price", "Fionnuala Richards",};
    private final String[] numbers = {"048978209643", "048918591092", "048911920493", "048981499320", "048984605555",
            "048955846048", "048988407656", "048998527097", "048952118602", "048917236076",};

    public UserRepository() {
        this.init();
    }

    public List<User> listAll() {
        return users;
    }

    public User create(User user) {
        user.setId(++lastId);
        if(users.size() == 20){
            users.remove(0);
        }
        users.add(user);
        return user;
    }

    public User update(User user) {
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getId().equals(user.getId())){
                users.set(i, user);
                return user;
            }
        }
        return null;
    }

    public User delete(Long id){
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getId().equals(id)){
                return users.remove(i);
            }
        }
        return null;
    }


    public User find(Long id) {
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getId().equals(id)){
                return users.get(i);
            }
        }
        return null;
    }

    public void reset(){
        users.clear();
        lastId = 0;
        init();
    }

    private void init() {
        for (int i=0; users.size() < 10;i++) {
            final User user = new User();
            user.setId(++lastId);
            user.setName(names[i].split(" ")[0]);
            user.setLastName(names[i].split(" ")[1]);
            user.setEmail(names[i].replace(" ", "").toLowerCase() + "@intuitiva.net.br");
            user.setPhone(numbers[i]);
            users.add(user);
        }
    }
}
