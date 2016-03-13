package Trakker.controller;

import Trakker.model.Diary;
import Trakker.model.Member;
import Trakker.service.DiaryServices;
import Trakker.service.MemberRegistration;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by thufir on 13.03.16.
 */
@Model
public class DiaryController {


    @Inject
    private FacesContext facesContext;

    @Inject
    private DiaryServices diaryServices;

    @Produces
    @Named
    private Diary newDiary;

    @PostConstruct
    public void initNewDiary() {
        newDiary = new Diary();
    }

    public void create() throws Exception {
        try {
            diaryServices.create(newDiary);
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Created!", "Dairy creation successful");
            facesContext.addMessage(null, m);
            initNewDiary();
        } catch (Exception e) {
            String errorMessage = getRootErrorMessage(e);
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, "Dairy creation unsuccessful");
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
