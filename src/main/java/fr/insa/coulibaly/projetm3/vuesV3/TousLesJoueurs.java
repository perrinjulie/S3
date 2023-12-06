/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.coulibaly.projetm3.vuesV3;

import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import fr.insa.coulibaly.projetm3.model.Joueur;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Amadou Coulibaly
 */
public class TousLesJoueurs extends VerticalLayout{
    
    private VuePrincipale main;
    
    private ListeJoueurs gridJoueurs;
    
    
    public TousLesJoueurs(VuePrincipale main) {
        this.main = main;
        
        this.add(new H3("liste des joueurs"));
        try {
            List<Joueur> tous = Joueur.tousLesJoueurs(this.main.getConn());
            this.gridJoueurs = new ListeJoueurs(main, tous);
            this.add(this.gridJoueurs);
        } catch (SQLException ex) {
            this.add(new Paragraph("Problem : " + ex.getLocalizedMessage()));
        }
        
    }
    
}
