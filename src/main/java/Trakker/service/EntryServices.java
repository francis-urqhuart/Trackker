package Trakker.service;

import Trakker.model.Entry;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.logging.Logger;

/**
 * Created by thufir on 17.04.16.
 */
@Stateless
public class EntryServices {


    @Inject
    private Logger log;

    @Inject
    private EntityManager em;

    @Inject
    private Event<Entry> entryEventSrc;

    public void create(Entry argEntry) throws Exception {
        log.info("Persisting " + argEntry.toString());
        em.persist(argEntry);
        entryEventSrc.fire(argEntry);
    }

}
