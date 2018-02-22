/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Services.DemandeAjoutGarderieService;
import Services.GarderieService;
import Utils.Mail;
import Utils.PostFile;
import Utils.isInteger;
import edu.entites.DemandeAjoutGarderie;
import edu.entites.Garderie;
import edu.entites.User;
import java.io.File;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.mail.MessagingException;
import org.apache.commons.validator.routines.UrlValidator;


/**
 * FXML Controller class
 *
 * @author PC
 */
public class AjoutGarderieController implements Initializable {
    @FXML
    private TextField Nom;
    @FXML
    private TextField Adresse;
    @FXML
    private TextField Site;
    
    @FXML
    private TextField P1;
    @FXML
    private TextField Email;
    @FXML
    private TextField Tel;
    @FXML
    private TextField P2;
    @FXML
    private ComboBox<String> Ville;
    @FXML
    private TextArea Description;
    @FXML
    private Button Ajouter;
    @FXML
    private Button Annuler;
    @FXML
    private Button Pr1;
    @FXML
    private Button Pr2;
    
    @FXML
    private Button Logo;
    @FXML
    private Label label_erreur;
    
    private String pathLo="" ;
    private String path="" ;
    private String path2="";
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {       
        ObservableList<String> Villes=FXCollections.observableArrayList("Ariana","Béja","Ben Arous","Bizerte","Gabès","Gafsa","Jendouba","Kairaouan","Kasserine","Kébili","Kef","Mahdia","Manouba","Médenine","Monastir","Nabeul","Sfax","Sidi Bouzid","Siliana","Tataouine","Tozeur","Tunis","Zaghouan");
        Ville.setItems(Villes);
        Ville.setValue("Tunis");
    }    
    @FXML
    public void Ajouter(ActionEvent event) throws IOException, MessagingException
    {
        label_erreur.setText("");
        if ((Nom.getText().equals(""))&&(Adresse.getText().equals(""))&&(Site.getText().equals(""))&&(Email.getText().equals(""))&&(Description.getText().equals(""))&&(Tel.getText().equals("")))
            {
               label_erreur.setText("un ou plusieurs champs sont vides");
            }
            else
            {
                if ((path.equals(""))&&(path2.equals(""))&&(pathLo.equals("")))
                {
                    label_erreur.setText("Vérifier que vous avez joindre le logo et les preuves ");
                }
                else{
                if(Nom.getText().matches("^[a-zA-Z]+$"))
                {
                    UrlValidator urlValidator = new UrlValidator();
                    if (urlValidator.isValid("http://"+Site.getText()))
                    {
                        if ( isInteger.isInteger(Tel.getText())==true)
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
          
           
        Garderie G=new Garderie();
        GarderieService gs= new GarderieService();
        DemandeAjoutGarderie dg=new DemandeAjoutGarderie();
        DemandeAjoutGarderieService dgs=new DemandeAjoutGarderieService();
        G.setNom(Nom.getText());
        G.setLogo(pathLo);
        G.setDescription(Description.getText());
        G.setNumTel("+216"+Tel.getText());
        G.setEmail(Email.getText());
        G.setAdresse(Adresse.getText());
        G.setSite(Site.getText());
        G.setNom(Nom.getText());
        G.setVille(Ville.getValue());
        G.setProprietaire(User.MyUser.getId());
        gs.ajouterGarderie(G);
        int id=gs.ChercherIdGarderie(G);
        dg.setPreuve(path);
        dg.setPreuve2(path2);
        dg.setId_egc(id);
        dg.setId_user(User.MyUser.getId());
        dgs.ajouterDemandeAjoutGarderie(dg);
        ((Node)event.getSource()).getScene().getWindow().hide();
        String contenu = "Bonjour,\n"
                + "Ceci est un mail de confirmation pour l'ajout d'une garderie dont son nom est "+G.getNom()+".\nVotre demande est sera bientot traité.\nCordialement.\nEquipe All For Kids";
           Mail.sendMail(User.MyUser.getEmail(),"Confirmation d'ajout d'un demande",contenu);
           Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
           alert1.setTitle("I have a great message for you!");
           alert1.setHeaderText(null);
           alert1.setContentText("Demande ajouté ! Une confirmation sera envoyer à"+User.MyUser.getEmail());
           alert1.showAndWait();
           Stage stage=new Stage();
           Parent root = FXMLLoader.load(getClass().getResource("ConsulterDemandeGarderie.fxml"));
           Scene scene = new Scene(root);
           stage.setScene(scene);
                }   }
                    else { label_erreur.setText("Le numéro de téléphone contient que 8 chiffres  ");}
                    }
                    else {label_erreur.setText("Site non valide ");}
                }
           else { label_erreur.setText("Le champs nom conteint que des lettres ");}
            }}
    }
    @FXML
    private void Annuler(ActionEvent event) throws IOException {
           ((Node)event.getSource()).getScene().getWindow().hide();
            Stage stage=new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("ConsulterListeGarderie.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
      
    }
    @FXML
    private void Preuve1(ActionEvent event) throws IOException, Exception {
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
             
         }
    }
    @FXML
    private void Preuve2(ActionEvent event) throws IOException, Exception {
         FileChooser fc = new FileChooser();
         File selectedFile=fc.showOpenDialog(null);
         fc.setTitle("Open Resource File");
         fc.getExtensionFilters().addAll(
         new FileChooser.ExtensionFilter("JPG", "*.jpg"),
         new FileChooser.ExtensionFilter("PNG", "*.png")
         );
         if(selectedFile!=null)
         {
              String p=selectedFile.getPath();
              path2=selectedFile.getName();
              PostFile.upload(p);
             
         }
    }
    @FXML
    private void Logo2(ActionEvent event) throws IOException, Exception {
         FileChooser fc = new FileChooser();
         File selectedFile=fc.showOpenDialog(null);
         fc.setTitle("Open Resource File");
         fc.getExtensionFilters().addAll(
         new FileChooser.ExtensionFilter("JPG", "*.jpg"),
         new FileChooser.ExtensionFilter("PNG", "*.png")
         );
         if(selectedFile!=null)
         {
              String p=selectedFile.getPath();
              pathLo=selectedFile.getName();
              PostFile.upload(p);
             
         }
    }
 
    
}
