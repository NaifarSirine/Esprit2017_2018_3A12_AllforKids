/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Services.AbonnementGarderieService;
import Services.DemandeAjoutGarderieService;
import Services.EvaluationGarderieService;
import Services.GarderieService;
import Utils.EtatAbonnement;
import edu.entites.AbonnementGarderie;
import edu.entites.EvaluationGarderie;
import edu.entites.Garderie;
import edu.entites.User;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.controlsfx.control.Rating;

/**
 * FXML Controller class
 *
 * @author PC
 */
public class GarderiePController implements Initializable {

    @FXML
    private TextField txt_rech;
    @FXML
    private TableView<Garderie> tab_Garderie;
    @FXML
    private TableColumn<Garderie, String> NomGarderie;
    @FXML
    private TableColumn<Garderie, String> Ville;
    @FXML
    private TableColumn<Garderie, String> NumTel;
    
    @FXML
    private ImageView img_photo;
    @FXML
    private Button btn_evaluer;
    @FXML
    private Button btn_abonner;
    @FXML
    private Rating Etoile;
    @FXML
    private ImageView logo;
    @FXML
    private Label lab_ville;
    @FXML
    private Label lab_gaderie;
    @FXML
    private Label lab_email;
    @FXML
    private Label lab_numTel;
    @FXML
    private Label lab_note;
    @FXML
    private Label lab_description;
    @FXML
    private Label details;
    @FXML
    private Label g;
    @FXML
    private Label d;
    @FXML
    private Label l;
    @FXML
    private Label v;
    @FXML
    private Label e;
    @FXML
    private Label t;
    @FXML
    private Label n;
    
    
    public static int id_garderie=0;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            Etoile.setVisible(false);
            btn_evaluer.setVisible(false);
            btn_abonner.setVisible(false);
            details.setVisible(false);
            lab_gaderie.setVisible(false);
            g.setVisible(false);
            d.setVisible(false);
            lab_description.setVisible(false);
            l.setVisible(false);
            v.setVisible(false);
            lab_ville.setVisible(false);
            e.setVisible(false);
            lab_email.setVisible(false);
            t.setVisible(false);
            lab_numTel.setVisible(false);
            n.setVisible(false);
            lab_note.setVisible(false);
       ObservableList<Garderie> data;
        GarderieService bs =new GarderieService();
        
        List<Garderie> liste = bs.consulterGarderie(); 
        System.out.println(liste.toString());
        data = FXCollections.observableArrayList();
        liste.stream().forEach((j) -> {
            data.add(j);
        });

        tab_Garderie.setItems(data);
        NomGarderie.setCellValueFactory(new PropertyValueFactory<>("nom"));
        Ville.setCellValueFactory(new PropertyValueFactory<>("ville"));
        NumTel.setCellValueFactory(new PropertyValueFactory<>("numTel"));
       
        FilteredList<Garderie> filteredData = new FilteredList<>(data, p -> true);

        txt_rech.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(person -> {
                
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                
                String lowerCaseFilter = newValue.toLowerCase();

                if (person.getNom().toLowerCase().contains(lowerCaseFilter)) {
                    return true; 
                } 
                else if (person.getVille().toLowerCase().contains(lowerCaseFilter)) {
                    return true; 
                } 
                return false; 
            });
        });
        
        
        SortedList<Garderie> sortedData = new SortedList<>(filteredData);

        sortedData.comparatorProperty().bind(tab_Garderie.comparatorProperty());

        tab_Garderie.setItems(sortedData);

             showGarderieDetails(null);
       
        tab_Garderie.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> showGarderieDetails(newValue));
    }   
    
         private void showGarderieDetails(Garderie a) {
     
    if (a != null) {
            details.setVisible(true);
            lab_gaderie.setVisible(true);
            g.setVisible(true);
            d.setVisible(true);
            lab_description.setVisible(true);
            l.setVisible(true);
            v.setVisible(true);
            lab_ville.setVisible(true);
            e.setVisible(true);
            lab_email.setVisible(true);
            t.setVisible(true);
            lab_numTel.setVisible(true);
            n.setVisible(true);
            lab_note.setVisible(true);
        btn_abonner.setDisable(false);
        btn_abonner.setText("Abonner");
        System.out.println("***+****+*****+"+a.toString());
        EvaluationGarderieService e=new EvaluationGarderieService();
        id_garderie=a.getId();
        lab_gaderie.setText(a.getNom());
        lab_email.setText(a.getEmail());
        lab_description.setText(a.getDescription());
        logo.setFitWidth(80);
        logo.setFitHeight(80);
        Image i=new Image("http://localhost/"+a.getLogo());
        logo.setImage(i);
        lab_note.setText((e.CalculerMoyenneNote(a.getId()))+"");
        lab_ville.setText(a.getAdresse()+"Ville :"+a.getVille());
        lab_numTel.setText(a.getNumTel());
        
        AbonnementGarderie g= new AbonnementGarderie();
        AbonnementGarderieService as=new AbonnementGarderieService();
        edu.entites.Parent p=new edu.entites.Parent();
        p.setId(User.MyUser.getId());
        Garderie z=new Garderie();
        z.setId(id_garderie);
        g=as.RechercherAbonnementGarderieParent(p,z);
        if (g==null)
        {
            Etoile.setVisible(false);
            btn_evaluer.setVisible(false);
            btn_abonner.setVisible(true);
            return;
        }
        if (g.getEtat().equals(EtatAbonnement.Acceptee))
        {
            EvaluationGarderieService s=new EvaluationGarderieService();
            EvaluationGarderie n=new EvaluationGarderie();
            n=s.RechercheEvaluationParent(p,z);
            if (n==null)
            {
            Etoile.setVisible(true);
            btn_evaluer.setVisible(true);
            btn_abonner.setVisible(false);
            return;
            }
            else 
            {
            Etoile.setVisible(false);
            btn_evaluer.setVisible(true);
            btn_evaluer.setText("Déja évalué !");
            btn_evaluer.setDisable(true);
            btn_abonner.setVisible(false);
            return;
            }
           
        }
         if(g.getEtat().equals(EtatAbonnement.EnTraitement))
        {
            Etoile.setVisible(false);
            btn_evaluer.setVisible(false);
            btn_abonner.setVisible(true);
            btn_abonner.setText("Demande En traitement");
            btn_abonner.setDisable(true);
            return;
        }
        if(g.getEtat().equals(EtatAbonnement.Refusee))
        {
            AbonnementGarderieService f=new AbonnementGarderieService();
            f.supprimerDemandeAbonnement(g);
            Etoile.setVisible(false);
            btn_evaluer.setVisible(false);
            btn_abonner.setText("Réabonnez_vous");
            btn_abonner.setVisible(true);
            return;
        }
        
    } else {
        
        lab_gaderie.setText("");
        lab_email.setText("");
        lab_note.setText("");
        lab_ville.setText("");
        lab_numTel.setText("");
        lab_ville.setText("");
        Etoile.setVisible(false);
        btn_evaluer.setVisible(false);
        btn_abonner.setVisible(false);
        return;
        
       
    }
   

    }    

    @FXML
    private void evaluer(ActionEvent event) {
        EvaluationGarderie eg=new EvaluationGarderie();
        EvaluationGarderieService egs=new EvaluationGarderieService();
        Etoile.setPartialRating(false);
        eg.setNote((int)Etoile.getRating());
        eg.setId_user(User.MyUser.getId());
        eg.setId_egc(id_garderie);
        egs.ajouterEvaluationGarderie(eg);
        lab_note.setText((egs.CalculerMoyenneNote(id_garderie)+""));
        
    }
    @FXML
    private void Deconnecter(ActionEvent event) throws IOException {
        ((Node)event.getSource()).getScene().getWindow().hide();
        Stage stage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Authentification.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show(); 
        User.MyUser=new User();
    }
     @FXML
    private void abonner(ActionEvent event) throws IOException {
        
        AbonnementGarderie a=new AbonnementGarderie(0,EtatAbonnement.EnTraitement,User.MyUser.getId(),id_garderie);
        AbonnementGarderieService as=new AbonnementGarderieService();
        as.AjoutAbonnement(a);
        lab_gaderie.setText("");
        lab_email.setText("");
        lab_note.setText("");
        lab_ville.setText("");
        lab_numTel.setText("");
        lab_ville.setText("");
        Etoile.setVisible(false);
        logo.setImage(null);
        btn_evaluer.setVisible(false);
        btn_abonner.setVisible(false);
        this.initialize(null,null);
        
    }
    
}