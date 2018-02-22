/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import edu.entites.User;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author PC
 */
public class MenuPGController implements Initializable {

    @FXML
    private Button ConsulterCompte;
    @FXML
    private Button ConsulterMesGarderies;
    @FXML
    private ImageView MesGarderies;
    @FXML
    private Button Deconnecter;
    @FXML
    private Button Demande;
    @FXML
    private Button Abonnement; 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
        @FXML
    private void ConsulterCompte(ActionEvent event) throws IOException {
            Stage stage=new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("ConsulterComptePG.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
    }
    @FXML
    private void Abonnement(ActionEvent event) throws IOException {
            Stage stage=new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("AbonnementPG.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
    }

    @FXML
    private void MesGarderies(ActionEvent event) throws IOException {
            Stage stage=new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("ConsulterListeGarderie.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
    }
    @FXML
    private void ConsulterDemande(ActionEvent event) throws IOException {
            Stage stage=new Stage();
            //Parent root = FXMLLoader.load(getClass().getResource("ConsulterDemandeGarderie.fxml"));
            Parent root = FXMLLoader.load(getClass().getResource("ConsulterDemandeGarderie.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
         
    }
    @FXML
    private void Deconnecter(ActionEvent event) throws IOException
    {
        
        ((Node)event.getSource()).getScene().getWindow().hide();
        Stage stage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Authentification.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show(); 
        User.MyUser=new User();
    }

}
    

