/*
 * JBoss, Home of Professional Open Source
 * Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package Trakker.data;

import Trakker.model.Diary;
import Trakker.model.Entry;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@ApplicationScoped
public class EntryRepository {

    @Inject
    private EntityManager em;

    public Entry findById(Long id) {
        return em.find(Entry.class, id);
    }


    public List<Entry> findAllOrderedByDate() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Entry> criteria = cb.createQuery(Entry.class);
        Root<Entry> entry = criteria.from(Entry.class);
        criteria.select(entry).orderBy(cb.asc(entry.get("entrydate")));
        return em.createQuery(criteria).getResultList();
    }

    public String getMemberName(Entry argentry) {

        Query q = em.createQuery("select k from Member k where k.id =" + argentry.getMemberID());
        String output = (String) q.getSingleResult().toString();
        return output;
    }

    public String getDiaryName(Entry argentry) {

        return "null";
    }

    public List<Entry> findAllOrderedByDiary() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Entry> criteria = cb.createQuery(Entry.class);
        Root<Entry> entry = criteria.from(Entry.class);
        criteria.select(entry).orderBy(cb.asc(entry.get("diaryID")));
        return em.createQuery(criteria).getResultList();
    }
}
