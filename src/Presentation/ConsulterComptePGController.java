/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Services.ProprietaireGarderieService;
import edu.entites.ProprietaireGarderie;
import edu.entites.User;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author PC
 */
public class ConsulterComptePGController implements Initializable {

    @FXML
    private TextField Nom;
    @FXML
    private TextField Prenom;
    @FXML
    private TextField Tel;
    @FXML
    private TextField Adresse;
    @FXML
    private TextField Email;
    @FXML
    private TextField Login;
    @FXML
    private Button Modifier;
    @FXML
    private Button Retour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Nom.setEditable(false);
        Prenom.setEditable(false);
        Tel.setEditable(false);
        Adresse.setEditable(false);
        Email.setEditable(false);
        Login.setEditable(false);
        ProprietaireGarderie p=new ProprietaireGarderie();
        ProprietaireGarderieService ps=new ProprietaireGarderieService();
        p=ps.consulterCompte(User.MyUser.getId());
        System.out.println(p.toString());
        Nom.setText(p.getNom());
        Prenom.setText(p.getPrenom());
        Tel.setText(p.getNumTel());
        Adresse.setText(p.getAdresse());
        Email.setText(p.getEmail());
        Login.setText(p.getLogin());
    } 
    public void Retour(ActionEvent event) throws IOException 
    {
        ((Node)event.getSource()).getScene().getWindow().hide();
    }
    public void Supprimer(ActionEvent event) throws IOException 
    {
        
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation suppression");
        alert.setHeaderText("Look, a Confirmation Dialog");
        alert.setContentText("Are you ok with this?");
       ProprietaireGarderie p=new ProprietaireGarderie();
       p.setId(User.MyUser.getId());
       ProprietaireGarderieService ps=new ProprietaireGarderieService();
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            ps.supprimerCompte(p);
            Alert alert1 = new Alert(AlertType.INFORMATION);
            alert1.setTitle("Aurevoir");
            alert1.setContentText("Bye bye");
            User.MyUser=new User();
            Platform.exit();
        } else {
            Stage stage=new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("ConsulterComptePG.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
}
    }
     public void Modifier(ActionEvent event) throws IOException 
     {
            ((Node)event.getSource()).getScene().getWindow().hide();
            Stage stage=new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("ModifierCompteGarderie.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
     }
    
}
