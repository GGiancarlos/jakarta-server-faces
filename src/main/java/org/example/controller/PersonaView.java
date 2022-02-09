package org.example.controller;

import org.example.data.model.TblPersona;
import org.example.services.IPersonaService;
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class PersonaView implements Serializable {

    @Autowired
    private IPersonaService personaService;

    List<TblPersona> personas;
    List<TblPersona> filteredPersonaLista;
    private TblPersona selectedPersona;

    public List<TblPersona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<TblPersona> personas) {
        this.personas = personas;
    }

    public List<TblPersona> getFilteredPersonaLista() {
        return filteredPersonaLista;
    }

    public void setFilteredPersonaLista(List<TblPersona> filteredPersonaLista) {
        this.filteredPersonaLista = filteredPersonaLista;
    }

    public TblPersona getSelectedPersona() {
        return selectedPersona;
    }

    public void setSelectedPersona(TblPersona selectedPersona) {
        this.selectedPersona = selectedPersona;
    }

    public String logOut() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "login?face-redirect=true";
    }

    @PostConstruct
    public void init() {
        listarPersona();
    }

    public void listarPersona() {
        personas = personaService.listarPersona();
        filteredPersonaLista = new ArrayList<>();
        this.selectedPersona = new TblPersona();
    }

    public void deletePersona() {
        this.personas.remove(this.selectedPersona);
        personaService.eliminarPersona(this.selectedPersona);
        listarPersona();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sistema", "Persona eliminada"));
        PrimeFaces.current().ajax().update("form:messages", "form:dtPersona", "form:pnlPersona");
    }

    public void guardar() {
        personaService.actualizarPersona(this.selectedPersona);
        listarPersona();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sistema", "Persona actualizada"));
        PrimeFaces.current().ajax().update("form:messages", "form:dtPersona", "form:pnlPersona");
    }

    public void abrirNuevo() {
        this.selectedPersona = new TblPersona();
    }
}
