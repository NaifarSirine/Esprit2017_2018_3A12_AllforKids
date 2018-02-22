/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Services.GarderieService;
import Utils.PostFile;
import Utils.isInteger;
import edu.entites.Garderie;
import java.io.File;
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
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.commons.validator.routines.UrlValidator;

/**
 * FXML Controller class
 *
 * @author PC
 */
public class ModifGarderieController implements Initializable {

    @FXML
    private TextField Site;
    @FXML
    private TextField Email;
    @FXML
    private TextField Tel;
    @FXML
    private TextArea Description;
    @FXML
    private Button Ajouter;
    @FXML
    private Button Annuler;
    @FXML
    private Button modif_logo;
    @FXML
    private ImageView img_logo;
    @FXML
    private Label label_erreur;
     private String path;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Email.setText(ConsulterListeGarderieController.Garderie.getEmail());
        Description.setText(ConsulterListeGarderieController.Garderie.getDescription());
        Site.setText(ConsulterListeGarderieController.Garderie.getSite());
        Tel.setText(ConsulterListeGarderieController.Garderie.getNumTel().substring(4));
        img_logo.setFitWidth(150);
        img_logo.setFitHeight(150);
        Image i=new Image("http://localhost/"+ConsulterListeGarderieController.Garderie.getLogo());
        img_logo.setImage(i);
        path=ConsulterListeGarderieController.Garderie.getLogo();
    }    

    @FXML
    private void Ajouter(ActionEvent event) throws IOException {
        if ((Email.getText().equals(""))&&(Description.getText().equals(""))&&(Site.getText().equals(""))&&(Tel.getText().equals("")))
        {
            label_erreur.setText("un ou plusieurs champs sont vides");
        }
        else
        {
         if (!isInteger.isInteger(Tel.getText()))
         {
             label_erreur.setText("Le numéro de téléphone est composé de 8 chiffres ");
             Tel.setText("");
         }
         else{
             UrlValidator urlValidator = new UrlValidator();
         if (!urlValidator.isValid("http://"+Site.getText()))
                    {
                    label_erreur.setText("Site non valide ");
                    Site.setText("");
                    }
         else{
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
        ((Node)event.getSource()).getScene().getWindow().hide();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation modification");
        alert.setHeaderText("Look, a Confirmation Dialog");
        alert.setContentText("Are you ok with this?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
           Stage stage=new Stage();
           GarderieService pg= new GarderieService();
           Garderie p=new Garderie();
           p.setLogo(path);
           p.setEmail(Email.getText());
           p.setDescription(Description.getText());
           p.setSite(Site.getText());
           p.setNumTel("+216"+Tel.getText());
           p.setId(ConsulterListeGarderieController.Garderie.getId());
           pg.modifierGarderie(p);
           ConsulterListeGarderieController.Garderie=new Garderie();
           Alert alert1 = new Alert(AlertType.INFORMATION);
           alert1.setTitle("I have a great message for you!");
           alert1.setHeaderText(null);
           alert1.setContentText("Modification réussite !");
           alert1.showAndWait();
            Parent root = FXMLLoader.load(getClass().getResource("ConsulterListeGarderie.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            
        } else {
            Stage stage=new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("ConsulterListeGarderie.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            ConsulterListeGarderieController.Garderie=new Garderie();
           }
        }
         }
         }
        }
    }

    @FXML
    private void Annuler(ActionEvent event) throws IOException {
            ((Node)event.getSource()).getScene().getWindow().hide();
            Stage stage=new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("ConsulterListeGarderie.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            ConsulterListeGarderieController.Garderie=new Garderie();
    }
    @FXML 
    private void joindre(ActionEvent event) throws Exception
    {
        FileChooser fc = new FileChooser();
         fc.setTitle("Open Resource File");
         fc.getExtensionFilters().addAll(
         new FileChooser.ExtensionFilter("JPG", "*.jpg"),
         new FileChooser.ExtensionFilter("PNG", "*.png")
         );
         File selectedFile=fc.showOpenDialog(null);
         if(selectedFile!=null)
         {
              String p=selectedFile.getPath();
              path=selectedFile.getName();
              PostFile.upload(p);
              img_logo.setFitWidth(150);
              img_logo.setFitHeight(150);
              Image i=new Image("http://localhost/"+path);
              img_logo.setImage(i);
             
         }
    }
    
}
