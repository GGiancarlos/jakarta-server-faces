package org.example.controller;

import org.primefaces.PrimeFaces;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class LoginSession implements Serializable {
    private String coUsua;
    private String dePassUsua;

    static final String usuario = "ADMIN";
    static final String clave = "123";

    public String getCoUsua() {
        return coUsua;
    }

    public void setCoUsua(String coUsua) {
        this.coUsua = coUsua;
    }

    public String getDePassUsua() {
        return dePassUsua;
    }

    public void setDePassUsua(String dePassUsua) {
        this.dePassUsua = dePassUsua;
    }

    public String login() {
        if (coUsua.equals(usuario) && dePassUsua.equals(clave)) {
            return "persona?faces-redirect=true";
        }
        return "";
    }

    public void cancelar() {
        this.coUsua = "";
        this.dePassUsua = "";
        PrimeFaces.current().resetInputs("form:panel");
    }
}
