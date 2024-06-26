package com.example.projetjava;
import com.example.projetjava.DataClasses.Etudiant;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.sql.*;
import java.util.Optional;

public class deleteData {
    static private Connection connection;
    static private PreparedStatement preparedStatement;
    static private ResultSet resultSet;

    public static void deleteEtudiant(String cin) {
        if (getData.existeDansEtudiants(cin)==false) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Cin inexistant");
            alert.showAndWait();
        }else {
            String sql = "DELETE FROM etudiant WHERE id = ?";
            connection=database.connectDb();
            try{
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1, cin);
            preparedStatement.executeUpdate();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText("Etudiant supprimé avec succès");
            alert.showAndWait();


            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }

    public static void deleteEnseignant(String cin) {
        if (getData.existeDansEnseignants(cin)==false) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Cin inexistant");
            alert.showAndWait();
        }else {
            String sql = "DELETE FROM enseignant WHERE id = ?";
            connection=database.connectDb();
            try{
                preparedStatement=connection.prepareStatement(sql);
                preparedStatement.setString(1, cin);
                preparedStatement.executeUpdate();
                Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                alert1.setTitle("Confirmation");
                alert1.setHeaderText("Enseignant supprimé avec succès");
                alert1.showAndWait();
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }

    public static void deletePFE(String titre) {
        if (getData.existePfedansPFE(titre)==false) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Titre inexistant");
            alert.showAndWait();
        }else {
            String sql = "DELETE FROM pfe WHERE titre_pfe = ?";
            connection=database.connectDb();
            try{
                preparedStatement=connection.prepareStatement(sql);
                preparedStatement.setString(1, titre);
                preparedStatement.executeUpdate();
                Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                alert1.setTitle("Confirmation");
                alert1.setHeaderText("PFE supprimé avec succès");
                alert1.showAndWait();
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }

    public static void deleteJury(String titre) {
        if (getData.existePfeDansJury(titre)==false) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Titre inexistant");
            alert.showAndWait();
        }else {
            String sql = "DELETE FROM jury WHERE titre_pfe = ?";
            connection=database.connectDb();
            try{
                preparedStatement=connection.prepareStatement(sql);
                preparedStatement.setString(1, titre);
                preparedStatement.executeUpdate();
                Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                alert1.setTitle("Confirmation");
                alert1.setHeaderText("Jury supprimé avec succès");
                alert1.showAndWait();
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }
    public static void deleteSoutenance(String titre) {
        if (getData.existePfedansSoutenance(titre)==false) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Titre inexistant");
            alert.showAndWait();
        }else {
            String sql = "DELETE FROM soutenance WHERE titre_pfe = ?";
            connection=database.connectDb();
            try{
                preparedStatement=connection.prepareStatement(sql);
                preparedStatement.setString(1, titre);
                preparedStatement.executeUpdate();
                Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                alert1.setTitle("Confirmation");
                alert1.setHeaderText("Soutenance supprimé avec succès");
                alert1.showAndWait();
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }

}
