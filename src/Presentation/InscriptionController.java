/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Services.BabySitterService;
import Services.ProprietaireGarderieService;
import Utils.isInteger;
import Utils.isValidPassword;
import edu.entites.BabySitter;
import edu.entites.ProprietaireGarderie;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author PC
 */
public class InscriptionController implements Initializable {

    @FXML
    private Label lab_cin;
    @FXML
    private Label lab_cv;
    @FXML
    private Label lab_photo;
    @FXML
    private TextField txt_nom;
    @FXML
    private TextField txt_prenom;
    @FXML
    private TextField txt_numtel;
    @FXML
    private TextField txt_adresse;
    @FXML
    private TextField txt_email;
    @FXML
    private TextField txt_login;
    @FXML
    private TextField txt_cin;
    @FXML
    private TextField txt_cv;
    @FXML
    private TextField txt_photo;
    @FXML
    private Separator separateur;
    @FXML
    private ComboBox<String> cb_role;
    @FXML
    private Button btn_inscription;
    @FXML
    private Button btn_annuler;
    @FXML
    private PasswordField txt_password;
    @FXML
    private Label label_erreur;
    
    /**
     * Initializes the controller class.
     */
    ObservableList<String> listRoles = FXCollections.observableArrayList("Parent","BabySitter","Propriétaire Garderie","Propriétaire Ecole","","");

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       lab_cin.setVisible(false);
       lab_cv.setVisible(false);
       lab_photo.setVisible(false);
       separateur.setVisible(false);
       txt_cin.setVisible(false);
       txt_cv.setVisible(false);
       txt_photo.setVisible(false);
       cb_role.setItems(listRoles);
       cb_role.setValue("Parent");
       label_erreur.setText("");
       
    }    

    @FXML
    private void role(ActionEvent event) {
        if (cb_role.getValue().toString()=="Parent")
        {  
           lab_photo.setVisible(true); txt_photo.setVisible(true);
           lab_cin.setVisible(false);
           lab_cv.setVisible(false); 
           separateur.setVisible(false);
           txt_cin.setVisible(false);
           txt_cv.setVisible(false);
        }
         else if (cb_role.getValue().toString()=="BabySitter")
         {lab_cin.setVisible(true); txt_cin.setVisible(true);
         lab_cv.setVisible(true); txt_cv.setVisible(true);
         lab_photo.setVisible(true); txt_photo.setVisible(true);
                 }
            if (cb_role.getValue().toString()=="Propriétaire Garderie")
        {  
       lab_cin.setVisible(false);
       lab_cv.setVisible(false);
       lab_photo.setVisible(false);
       separateur.setVisible(false);
       txt_cin.setVisible(false);
       txt_cv.setVisible(false);
       txt_photo.setVisible(false);
        }
    }
    
    

    @FXML
    private void vider(ActionEvent event) {
        txt_adresse.clear(); txt_cin.clear(); txt_cv.clear(); txt_email.clear(); txt_login.clear(); 
        txt_nom.clear(); txt_numtel.clear(); txt_password.clear(); txt_photo.clear(); txt_prenom.clear();

    }

    @FXML
    private void inscription(ActionEvent event) throws IOException {
        label_erreur.setText("");
        if (cb_role.getValue().toString().equals(""))
        {      
            
           Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
           alert1.setTitle("I have a bad message for you!");
           alert1.setHeaderText(null);
           alert1.setContentText(" role n'est pas choisi !");
           alert1.show();
        }
        else if (cb_role.getValue().toString().equals("Propriétaire Garderie"))
        {
            ProprietaireGarderie p=new ProprietaireGarderie();
            ProprietaireGarderieService ps=new ProprietaireGarderieService();
            if ((txt_nom.getText().equals(""))&&(txt_prenom.getText().equals(""))&&(txt_numtel.getText().equals(""))&&(txt_adresse.getText().equals(""))&&(txt_email.getText().equals(""))&&(txt_login.getText().equals(""))&&(txt_password.getText().equals("")))
            {
               label_erreur.setText("un ou plusieurs champs sont vides");
            }
            else
            { 
                if((txt_nom.getText().matches("^[a-zA-Z]+$"))&&((txt_prenom.getText().matches("^[a-zA-Z]+$"))))
                {
                    if ( isInteger.isInteger(txt_numtel.getText())==true)
                {
                    String masque = "^[a-zA-Z]+[a-zA-Z0-9\\._-]*[a-zA-Z0-9]@[a-zA-Z]+"
                        + "[a-zA-Z0-9\\._-]*[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}$";
                Pattern pattern = Pattern.compile(masque);
                Matcher controler = pattern.matcher(txt_email.getText());
                if (!controler.matches())
                { 
                  label_erreur.setText("Adresse mail invalide");
                  txt_email.setText("");
                }
                else{
                ProprietaireGarderieService h=new ProprietaireGarderieService();
                if (h.login_existe(txt_login.getText()))
                {
                    label_erreur.setText("Login existe déja ");
                    txt_login.setText("");
                }
                else{
                    if (isValidPassword.isValidPassword(txt_password.getText()))
                    {
            p.setNom(txt_nom.getText());
            p.setPrenom(txt_prenom.getText());
            p.setNumTel("+216"+txt_numtel.getText());
            p.setAdresse(txt_adresse.getText());
            p.setEmail(txt_email.getText());
            p.setLogin(txt_login.getText());
            p.setPassword(txt_password.getText());
            
            ps.ajouterCompte(p);
            ((Node)event.getSource()).getScene().getWindow().hide();
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
           alert1.setTitle("I have a great message for you!");
           alert1.setHeaderText(null);
           alert1.setContentText("User ajouté ");
           alert1.showAndWait();
           ((Node)event.getSource()).getScene().getWindow().hide();
           Stage stage=new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("Authentification.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();}
                    else
                    {label_erreur.setText("Le format de mdp saisie n'est pas valide ");}
            }
                }
                }
                else {
                label_erreur.setText("Le numéro de téléphone contient que 8 chiffres ");
                }
                }
                else {
                    label_erreur.setText("Les champs nom et prénom contiennent que des lettres ");
                }
            }
        }
        
         else if (cb_role.getValue().toString().equals("BabySitter"))
        { BabySitterService bs = new BabySitterService();
        bs.ajoutBabySitter(new BabySitter(txt_cv.getText(),txt_photo.getText(), txt_cin.getText(), 0 , txt_nom.getText() , txt_prenom.getText(), txt_numtel.getText(), txt_adresse.getText(), txt_email.getText(), txt_login.getText() ,txt_password.getText()));
         }
       
    }
     @FXML
    private void Annuler(ActionEvent event) throws IOException {
            ((Node)event.getSource()).getScene().getWindow().hide();
            Stage stage=new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("Authentification.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
    }

}
