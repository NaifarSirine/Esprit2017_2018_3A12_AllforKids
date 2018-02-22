/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Services.ProprietaireGarderieService;
import Utils.isInteger;
import Utils.isValidPassword;
import edu.entites.ProprietaireGarderie;
import edu.entites.User;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author PC
 */
public class ModifierCompteGarderieController implements Initializable {

    @FXML
    private TextField Telephone;
    @FXML
    private TextField Adresse;
    @FXML
    private TextField Email;
    @FXML
    private TextField Login;
    @FXML
    private TextField Password;
    @FXML
    private TextField Password2;
    @FXML
    private Label label_erreur;
    String login="";
    String pass="";
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
        ProprietaireGarderie p=new ProprietaireGarderie();
        ProprietaireGarderieService ps=new ProprietaireGarderieService();
        p=ps.consulterCompte(User.MyUser.getId());
        System.out.println(p.toString());
        Telephone.setText(p.getNumTel().substring(4));
        Adresse.setText(p.getAdresse());
        Email.setText(p.getEmail());
        Login.setText(p.getLogin());
        Password.setText(p.getPassword());
        Password2.setText(p.getPassword());
        login=p.getLogin();
        pass=p.getPassword();
    }    
    public void Annuler(ActionEvent event) throws IOException
    {
        ((Node)event.getSource()).getScene().getWindow().hide();
            Stage stage=new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("ConsulterComptePG.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
    }
    public void Consulter(ActionEvent event) throws IOException
    {
        if ((Telephone.getText().equals(""))&&(Login.getText().equals(""))&&(Adresse.getText().equals(""))&&(Email.getText().equals(""))&&(Password.getText().equals(""))&&(Password2.getText().equals("")))
        {
            label_erreur.setText("un ou plusieurs champs sont vides");
        }
        else
        {
            String masque = "^[a-zA-Z]+[a-zA-Z0-9\\._-]*[a-zA-Z0-9]@[a-zA-Z]+"
                        + "[a-zA-Z0-9\\._-]*[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}$";
                Pattern pattern = Pattern.compile(masque);
                Matcher controler = pattern.matcher(Email.getText());
                if (!controler.matches())
                { 
                  label_erreur.setText("Adresse mail invalide");
                  Email.setText("");
                }
                else{
        if (isInteger.isInteger(Telephone.getText()))
        {
            ProprietaireGarderieService ps=new ProprietaireGarderieService();
            if ((ps.login_existe(Login.getText()))&&(!Login.getText().equals(login)))
            {
                label_erreur.setText("Ce login existe deja ");
                Login.setText("");
            }
            else{
        ((Node)event.getSource()).getScene().getWindow().hide();
        if ((Password.getText().equals(Password2.getText()))){
            if (!Password.getText().equals(pass))
            {
                if (!isValidPassword.isValidPassword(Password.getText()))
                {
                    label_erreur.setText("Password non valide");
                }
            }
            else{
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation modification");
        alert.setHeaderText("Look, a Confirmation Dialog");
        alert.setContentText("Are you ok with this?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            Stage stage=new Stage();
           ProprietaireGarderieService pg= new ProprietaireGarderieService();
           ProprietaireGarderie p=new ProprietaireGarderie();
           p.setId(User.MyUser.getId());
           p.setNumTel("+216"+Telephone.getText());
           p.setAdresse(Adresse.getText());
           p.setEmail(Email.getText());
           p.setLogin(Login.getText());
           p.setPassword(Password.getText());
           pg.modifierCompte(p);
           Alert alert1 = new Alert(AlertType.INFORMATION);
           alert1.setTitle("I have a great message for you!");
           alert1.setHeaderText(null);
           alert1.setContentText("Modification réussite !");
           alert1.showAndWait();
            Parent root = FXMLLoader.load(getClass().getResource("ConsulterComptePG.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else {
            Stage stage=new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("ConsulterComptePG.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
           }}}
        else {
            label_erreur.setText("Les champs password et password2 ne sont pas identiques ");
        }
        }
        }
    
    else 
    {
        label_erreur.setText("Numero de téléphone invalide");
        Telephone.setText("");
    }
    
}
    }}
}
