/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.coulibaly.projetm3.vuesV2;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import fr.insa.coulibaly.projetm3.model.GestionBDD;
import java.sql.SQLException;
import java.util.Optional;

/**
 *
 * @author Amadou Coulibaly
 */
public class EnteteAvantLogin extends HorizontalLayout {
    
    private VuePrincipale main;
    
    private TextField tfNom;
    private Button bLogin;
    private Button bInscription;
    
    public EnteteAvantLogin(VuePrincipale main) {
        this.main = main;
        
        this.tfNom = new TextField("Nom");
        this.bLogin = new Button("Login");
        this.bLogin.addClickListener((t) -> {
            String nom = this.tfNom.getValue();
            try {
                boolean existe = GestionBDD.testeLogin(this.main.getConn(), nom);
                if (existe) {
                    this.main.setCurUser(nom);
                    this.main.changeContenu(new ApresLogin(this.main));
                    this.main.changeEntete(new EnteteApresLogin(this.main));
                } else {
                    Notification.show(nom + " n'est pas inscrit");
                    
                }
            } catch (SQLException ex) {
                Notification.show("Probleme BDD");
            }
            
        });
        this.bInscription = new Button("Inscription");
        this.bInscription.addClickListener((t) -> {
            String nom = this.tfNom.getValue();
            try {
                Optional<String> ok = GestionBDD.inscription(this.main.getConn(), nom);
                if (ok.isPresent()) {
                    Notification.show(nom + " inscrit : pass : " + ok.get());
                } else {
                    Notification.show(nom + " existe deja");
                    
                }
            } catch (SQLException ex) {
                Notification.show("Probleme BDD");
            }
            
        });
        this.bInscription.getStyle().set("background-color", "rgb(255, 255, 128)");
        this.add(this.tfNom, this.bLogin, this.bInscription);
    }
    
}
