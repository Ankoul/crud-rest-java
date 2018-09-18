package br.net.intuitiva.crud.api.controller;

import br.net.intuitiva.crud.api.model.User;
import br.net.intuitiva.crud.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;


@RestController
@RequestMapping(value = "/v1/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public List<User> listUsers() {
        return userService.listAll();
    }

    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
    public User create(@RequestBody @Valid @NotNull User user) {
        return userService.create(user);
    }

    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.PUT, produces = "application/json")
    public User save(@RequestBody @Valid @NotNull User user) {
        return userService.save(user);
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public User delete(@PathVariable @Valid @NotNull Long id) {
        return userService.delete(id);
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public User find(@PathVariable @Valid @NotNull Long id) {
        return userService.find(id);
    }

}
