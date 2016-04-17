package Trakker.controller;

import Trakker.model.Entry;
import Trakker.service.EntryServices;

import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by thufir on 17.04.16.
 */

@Model
public class EntryController {

    @Inject
    private FacesContext facesContext;

    @Inject
    private EntryServices entryServices;

    @Produces
    @Named
    private Entry newEntry;
}
