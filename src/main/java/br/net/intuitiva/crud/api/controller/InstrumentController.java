package br.net.intuitiva.crud.api.controller;

import br.net.intuitiva.crud.api.model.Instrument;
import br.net.intuitiva.crud.api.service.InstrumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;


@RestController
@RequestMapping(value = "/v1/instruments")
public class InstrumentController {

    private final InstrumentService instrumentService;

    @Autowired
    public InstrumentController(InstrumentService instrumentService) {
        this.instrumentService = instrumentService;
    }

    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public List<Instrument> list() {
        return instrumentService.listAll();
    }

    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
    public Instrument create(@RequestBody @Valid @NotNull Instrument user) {
        return instrumentService.create(user);
    }

    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.PUT, produces = "application/json")
    public Instrument save(@RequestBody @Valid @NotNull Instrument user) {
        return instrumentService.save(user);
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public Instrument delete(@PathVariable @Valid @NotNull Long id) {
        return instrumentService.delete(id);
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public Instrument find(@PathVariable @Valid @NotNull Long id) {
        return instrumentService.find(id);
    }

}
