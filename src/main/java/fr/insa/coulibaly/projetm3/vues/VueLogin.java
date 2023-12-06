/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.coulibaly.projetm3.vues;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import fr.insa.coulibaly.projetm3.model.GestionBDD;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

/**
 *
 * @author Amadou Coulibaly
 */
@PageTitle("Login")
@Route(value = "")
public class VueLogin extends VerticalLayout {

    private Connection conn;
    private TextField tfNom;
    private Button bLogin;
    private Button bInscription;
    private TextArea taMessage;
    private HorizontalLayout hlEntete;

    public VueLogin() {
        try {
            this.conn = GestionBDD.connectSurServeurM3();
            this.setWidthFull();
            this.tfNom = new TextField("Nom");
            this.bLogin = new Button("Login");
            this.bLogin.addClickListener((t) -> {
                String nom = this.tfNom.getValue();
                try {
                    boolean existe = GestionBDD.testeLogin(this.conn, nom);
                    if (existe) {
                        this.taMessage.setValue(
                                this.taMessage.getValue()
                                + "bonjour " + nom + "\n");
                    } else {
                        this.taMessage.setValue(
                                this.taMessage.getValue()
                                + nom + " n'est pas inscrit"+ "\n");
                        
                    }
                } catch (SQLException ex) {
                    Notification.show("Probleme BDD");
                }

            });
            this.bInscription = new Button("Inscription");
            this.bInscription.addClickListener((t) -> {
                String nom = this.tfNom.getValue();
                try {
                    Optional<String> ok = GestionBDD.inscription(this.conn, nom);
                    if (ok.isPresent()) {
                        this.taMessage.setValue(
                                this.taMessage.getValue()
                                +  nom + " inscrit : pass : " +ok.get() + "\n");
                    } else {
                        this.taMessage.setValue(
                                this.taMessage.getValue()
                                + nom + " existe deja"+ "\n");
                        
                    }
                } catch (SQLException ex) {
                    Notification.show("Probleme BDD");
                }

            });
            this.bInscription.getStyle().set("background-color", "rgb(255, 255, 128)");
            this.taMessage = new TextArea("Message");
            this.taMessage.setWidth("100%");
            this.taMessage.setHeight("12em");
            this.hlEntete = new HorizontalLayout(this.tfNom, this.bLogin, this.bInscription);
            this.add(this.hlEntete, this.taMessage);
        } catch (SQLException ex) {
            this.add(new H3("Pas de BDD Probleme"));
        }
    }

}
