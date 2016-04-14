package Trakker.service;

/**
 * Created by thufir on 13.03.16.
 */

import Trakker.model.Diary;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.logging.Logger;

@Stateless
public class DiaryServices {

    @Inject
    private Logger log;

    @Inject
    private EntityManager em;

    @Inject
    private Event<Diary> diaryEventSrc;

    public void create(Diary argdiary) throws Exception {
        log.info("Persisting " + argdiary.getName());
        em.persist(argdiary);
        diaryEventSrc.fire(argdiary);
    }

}
