/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.coulibaly.projetm3.vuesV2;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import fr.insa.coulibaly.projetm3.model.GestionBDD;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Amadou Coulibaly
 */
@PageTitle("Login")
@Route(value = "V2")
public class VuePrincipale extends VerticalLayout {

    private Connection conn;
    private String curUser;
    
    private HorizontalLayout hlEntete;
    
    private VerticalLayout contenu;

    public VuePrincipale() {
        try {
            // pour test : BdD en mémoire
            this.conn = GestionBDD.connectSurBDDEnMemoire();
            // sinon, vrai BdD : mais vous devez changer dans la méthode
            // pour mettre vos identifiants
            // this.conn = GestionBDD.connectSurServeurM3();
            this.setWidthFull();
            this.contenu = new VerticalLayout();
            this.contenu.setSizeFull();
            this.changeContenu(new AvantLogin(this));
            this.hlEntete = new HorizontalLayout();
            this.hlEntete.setWidthFull();
            this.changeEntete(new EnteteAvantLogin(this));
            this.add(this.hlEntete, this.contenu);
        } catch (SQLException ex) {
            this.add(new H3("Pas de BDD Probleme"));
        }
    }
    
    public void changeContenu(Component c) {
        this.contenu.removeAll();
        this.contenu.add(c);
    }

    public void changeEntete(Component c) {
        this.hlEntete.removeAll();
        this.hlEntete.add(c);
    }

    /**
     * @return the conn
     */
    public Connection getConn() {
        return conn;
    }

    /**
     * @return the curUser
     */
    public String getCurUser() {
        return curUser;
    }

    /**
     * @param curUser the curUser to set
     */
    public void setCurUser(String curUser) {
        this.curUser = curUser;
    }

}
