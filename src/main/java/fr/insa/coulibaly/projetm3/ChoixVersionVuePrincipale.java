/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.coulibaly.projetm3;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

/**
 *
 * @author francois
 */
@PageTitle("Login")
@Route(value = "")
public class ChoixVersionVuePrincipale extends VerticalLayout{
    
    public ChoixVersionVuePrincipale() {
        this.add(new H1("Petit programme de démo vaadin et BdD"));
        this.add(new Paragraph("Compagnon pour le module d'informatique Base de Données à l'INSA Strasbourg"));
        this.add(new Paragraph(new Text("Cliquez ") ,
                new Anchor("V1","ici"),
                new Text(" pour une première version avec une page fixe")));
        this.add(new Paragraph(new Text("Cliquez ") ,
                new Anchor("V2","ici"),
                new Text(" pour une deuxieme version avec une page dynamique (l'entete et le contenu change avant/après login)")));
        this.add(new Paragraph(new Text("Cliquez ") ,
                new Anchor("V3","ici"),
                new Text(" pour une troisième version : même chose que la deuxième version"
                        + " avec affichage possible de la liste des joueurs (accessible par bouton après login)")));
    }
    
}
