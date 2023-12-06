/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.coulibaly.projetm3.vuesV2;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

/**
 *
 * @author Amadou Coulibaly
 */
public class ApresLogin extends VerticalLayout{
    
    private VuePrincipale main;
    
    private TextField tfLogin;
    private Button bTest;
    
    public ApresLogin(VuePrincipale main) {
        this.main = main;
        
        this.add(new H3("panneau test après login"));
        this.tfLogin = new TextField();
        this.tfLogin.setValue(this.main.getCurUser());
        this.tfLogin.setEnabled(false);
        this.bTest = new Button("Test");
        this.bTest.addClickListener((t) -> {
            Notification.show("ici, j'ajoute la gestion après login");
        });
        this.add(this.tfLogin,this.bTest);
    }
    
}
