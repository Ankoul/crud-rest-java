package br.net.intuitiva.crud.api.persistence;

import br.net.intuitiva.crud.api.model.Instrument;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InstrumentRepository {

    private static final List<Instrument> INSTRUMENTS = new ArrayList<>();
    private static long lastId = 0;

    private final String[] names = {"Bamboo slit drum", "Balafon", "Cajón", "Castanets", "Glockenspiel"};
    private final String[] images = {
            "https://en.wikipedia.org/wiki/File:TamTam.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fd/Balafoon.jpg/150px-Balafoon.jpg",
            "https://upload.wikimedia.org/wikipedia/en/thumb/b/b5/Lewi_Custom_Reserv%C3%A9_free.png/150px-Lewi_Custom_Reserv%C3%A9_free.png",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a5/Castagnetten.jpg/150px-Castagnetten.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/7/72/Glockenspiel.jpg/150px-Glockenspiel.jpg",
    };

    public InstrumentRepository() {
        this.init();
    }

    public List<Instrument> listAll() {
        return INSTRUMENTS;
    }

    public Instrument create(Instrument instrument) {
        instrument.setId(++lastId);
        if (INSTRUMENTS.size() == 20) {
            INSTRUMENTS.remove(0);
        }
        INSTRUMENTS.add(instrument);
        return instrument;
    }

    public Instrument update(Instrument instrument) {
        for (int i = 0; i < INSTRUMENTS.size(); i++) {
            if (INSTRUMENTS.get(i).getId().equals(instrument.getId())) {
                INSTRUMENTS.set(i, instrument);
                return instrument;
            }
        }
        return null;
    }

    public Instrument delete(Long id) {
        for (int i = 0; i < INSTRUMENTS.size(); i++) {
            if (INSTRUMENTS.get(i).getId().equals(id)) {
                return INSTRUMENTS.remove(i);
            }
        }
        return null;
    }


    public Instrument find(Long id) {
        for (int i = 0; i < INSTRUMENTS.size(); i++) {
            if (INSTRUMENTS.get(i).getId().equals(id)) {
                return INSTRUMENTS.get(i);
            }
        }
        return null;
    }

    public void reset() {
        INSTRUMENTS.clear();
        lastId = 0;
        init();
    }

    private void init() {
        for (int i = 0; INSTRUMENTS.size() < 5; i++) {
            final Instrument instrument = new Instrument();
            instrument.setId(++lastId);
            instrument.setName(names[i]);
            instrument.setImage(images[i]);
            instrument.setUserId(lastId *2);
            INSTRUMENTS.add(instrument);
        }
    }
}
