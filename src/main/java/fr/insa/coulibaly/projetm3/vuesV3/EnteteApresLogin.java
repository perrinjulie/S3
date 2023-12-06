/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.coulibaly.projetm3.vuesV3;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

/**
 *
 * @author Amadou Coulibaly
 */
public class EnteteApresLogin extends HorizontalLayout {
    
    private VuePrincipale main;
    
   private Button bLogout;
   private Button bListeJoueurs;
    
    public EnteteApresLogin(VuePrincipale main) {
        this.main = main;
        
        this.bLogout = new Button("Logout");
        this.bLogout.addClickListener((t) -> {
                    this.main.setCurUser("no login");
                    this.main.changeContenu(new AvantLogin(this.main));
                    this.main.changeEntete(new EnteteAvantLogin(this.main));
                
        });
       this.bListeJoueurs = new Button("Liste des Joueurs");
        this.bListeJoueurs.addClickListener((t) -> {
            this.main.changeContenu(new TousLesJoueurs(this.main));
        });
        this.add(this.bLogout,this.bListeJoueurs);
    }
    
}
