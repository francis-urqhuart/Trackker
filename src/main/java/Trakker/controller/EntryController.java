package Trakker.controller;

import Trakker.model.Diary;
import Trakker.model.Entry;
import Trakker.service.EntryServices;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
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

    @PostConstruct
    public void initNewEntry() {
        newEntry= new Entry();
    }

    public void create() throws Exception {
        try {
            entryServices.create(newEntry);
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Created!", "Entry creation successful");
            facesContext.addMessage(null, m);
            initNewEntry();
        } catch (Exception e) {
            String errorMessage = getRootErrorMessage(e);
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, "Entry creation unsuccessful");
            facesContext.addMessage(null, m);
        }
    }

    private String getRootErrorMessage(Exception e) {
        // Default to general error message that registration failed.
        String errorMessage = "Creation failed. See server log for more information";
        if (e == null) {
            // This shouldn't happen, but return the default messages
            return errorMessage;
        }

        // Start with the exception and recurse to find the root cause
        Throwable t = e;
        while (t != null) {
            // Get the message from the Throwable class instance
            errorMessage = t.getLocalizedMessage();
            t = t.getCause();
        }
        // This is the root cause message
        return errorMessage;
    }
}
