/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.coulibaly.projetm3.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Amadou Coulibaly
 */
public class Joueur {

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    // -1 si joueur n'est pas (encore) dans la BDD
    private int id;
    private String nom;
    private String pass;

    protected Joueur(int id, String nom, String pass) {
        this.id = id;
        this.nom = nom;
        this.pass = pass;
    }

    public Joueur(String nom, String pass) {
        this(-1, nom, pass);
    }

    public static List<Joueur> tousLesJoueurs(Connection con) throws SQLException {
        List<Joueur> res = new ArrayList<>();
        try ( PreparedStatement pst = con.prepareStatement(
                "select id,nom,pass from li_client")) {
            try ( ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nom = rs.getString("nom");
                    String pass = rs.getString("pass");
                    res.add(new Joueur(id, nom, pass));
                }
            }
        }
        return res;
    }

}
