package br.net.intuitiva.crud.api.service;

import br.net.intuitiva.crud.api.model.Instrument;
import br.net.intuitiva.crud.api.persistence.InstrumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class InstrumentService {


    @Autowired
    private UserService userService;

    private InstrumentRepository instrumentRepository;

    @Autowired
    public InstrumentService(InstrumentRepository instrumentRepository) {
        this.instrumentRepository = instrumentRepository;
    }

    public List<Instrument> listAll() {
        return instrumentRepository.listAll();
    }

    public Instrument save(Instrument instrument) {
        Assert.notNull(instrument, "Instrument cannot be null");
        if (instrument.getId() == null) {
            return this.create(instrument);
        }
        instrument = this.update(instrument);
        Assert.notNull(instrument, "Instrument not found");
        return instrument;
    }

    public Instrument create(Instrument instrument){
        Assert.notNull(this.userService.find(instrument.getUserId()), "user " + instrument.getUserId() + " not found");
        return instrumentRepository.create(instrument);
    }

    public Instrument update(Instrument instrument){
        Assert.notNull(this.userService.find(instrument.getUserId()), "user " + instrument.getUserId() + " not found");
        return instrumentRepository.update(instrument);
    }

    public Instrument delete(Long id){
        return instrumentRepository.delete(id);
    }

    public Instrument find(Long id) {
        return instrumentRepository.find(id);
    }

    public List<Instrument> reset() {
        instrumentRepository.reset();
        return this.listAll();
    }
}
