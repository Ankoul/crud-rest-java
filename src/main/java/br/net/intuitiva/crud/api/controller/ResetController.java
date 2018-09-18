package br.net.intuitiva.crud.api.controller;

import br.net.intuitiva.crud.api.service.InstrumentService;
import br.net.intuitiva.crud.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/v1/reset")
public class ResetController {

    private final UserService userService;
    private InstrumentService instrumentService;

    @Autowired
    public ResetController(UserService userService, InstrumentService instrumentService) {
        this.userService = userService;
        this.instrumentService = instrumentService;
    }

    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
    public void reset() {
        this.userService.reset();
        this.instrumentService.reset();
    }

}
