/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.coulibaly.projetm3.vuesV3;

import com.vaadin.flow.component.grid.Grid;
import fr.insa.coulibaly.projetm3.model.Joueur;
import java.util.List;

/**
 *
 * @author Amadou Coulibaly
 */
public class ListeJoueurs extends Grid<Joueur> {

    private VuePrincipale main;

    public ListeJoueurs(VuePrincipale main,List<Joueur> datas) {
        this.main = main;

        Column<Joueur> cID = this.addColumn(Joueur::getId)
                .setHeader("ID");
        cID.setWidth("3em");
        Column<Joueur> cNom = this.addColumn(Joueur::getNom)
                .setHeader("Nom");
        Column<Joueur> cPass = this.addColumn(Joueur::getPass)
                .setHeader("Pass");
        cNom.setSortable(true);
        this.setItems(datas);
    }

}
