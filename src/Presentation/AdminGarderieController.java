/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import Services.DemandeAjoutGarderieService;
import Services.GarderieService;
import Utils.EtatDemandeAjout;
import edu.entites.DemandeAjoutGarderie;
import edu.entites.Garderie;
import edu.entites.ProprietaireGarderie;
import edu.entites.User;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import static java.time.zone.ZoneRulesProvider.refresh;
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
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author PC
 */
public class AdminGarderieController implements Initializable {

    @FXML
    private TextField txt_rech;
    @FXML
    private TableView<Garderie> tableGarderie;
    @FXML
    private TableColumn<Garderie, String> col_nomGarderie;
    
    @FXML
    private TableColumn<Garderie, String> col_description;
    @FXML
    private TableColumn<Garderie, String> col_numTel;
    @FXML
    private TableColumn<Garderie, String> col_email;
    @FXML
    private TableColumn<Garderie, String> col_adresse;
    @FXML
    private TableColumn<Garderie, String> col_ville;
    @FXML
    private TableColumn<Garderie, String> col_site;
    
    
    @FXML
    private ImageView lab_preuve2;
    @FXML
    private ImageView lab_preuve1;
    @FXML
    private Button btn_accepter;
    @FXML
    private Button btn_refuser;
    @FXML
    private ImageView img_logo;
    @FXML
    private Label lab_nomPrenom;
    @FXML
    private Label lab_email;
    @FXML
    private Label lab_etat;
    @FXML
    private Label lab_numTel;
    @FXML
    private Label pg,np,n,id,p1,p2,lg,m,et;
    public static int id_garderie;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btn_accepter.setVisible(false);
        btn_refuser.setVisible(false);
        pg.setVisible(false);
        np.setVisible(false);
        lab_nomPrenom.setVisible(false);
        n.setVisible(false);
        lab_numTel.setVisible(false);
        m.setVisible(false);
        lab_email.setVisible(false);
        id.setVisible(false);
        p1.setVisible(false);
        p2.setVisible(false);
        lg.setVisible(false);
        et.setVisible(false);
        lab_etat.setVisible(false);
        ObservableList<Garderie> data;
        GarderieService bs =new GarderieService();
      
        List<Garderie> liste = bs.consulterGarderie3(); 
        System.out.println(liste.toString());
        data = FXCollections.observableArrayList();
        liste.stream().forEach((j) -> {
            data.add(j);
        });

        tableGarderie.setItems(data);
        col_nomGarderie.setCellValueFactory(new PropertyValueFactory<>("nom"));
        col_adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        col_description.setCellValueFactory(new PropertyValueFactory<>("description"));
        col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
       
        col_numTel.setCellValueFactory(new PropertyValueFactory<>("numTel"));
        col_site.setCellValueFactory(new PropertyValueFactory<>("site"));
        col_ville.setCellValueFactory(new PropertyValueFactory<>("ville"));
       
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

        sortedData.comparatorProperty().bind(tableGarderie.comparatorProperty());

        tableGarderie.setItems(sortedData);
             showPGarderieDetails(null);
       
        tableGarderie.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> showPGarderieDetails(newValue));
   
      
    }    
    
     private void showPGarderieDetails(Garderie a) {
     
    if (a != null) {
        btn_accepter.setVisible(true);
        btn_refuser.setVisible(true);
        pg.setVisible(true);
        np.setVisible(true);
        lab_nomPrenom.setVisible(true);
        n.setVisible(true);
        lab_numTel.setVisible(true);
        m.setVisible(true);
        lab_email.setVisible(true);
        id.setVisible(true);
        p1.setVisible(true);
        p2.setVisible(true);
        lg.setVisible(true);
        et.setVisible(true);
        lab_etat.setVisible(true);
        lab_nomPrenom.setText(a.getProprietaire().getNom()+" "+a.getProprietaire().getPrenom());
        lab_numTel.setText(a.getProprietaire().getNumTel());
        lab_email.setText(a.getProprietaire().getEmail());  
        DemandeAjoutGarderieService ds = new DemandeAjoutGarderieService(); 
        DemandeAjoutGarderie demande = ds.consulterDemandeGarderie(a.getId());
        id_garderie=a.getId();
        Image image0 = new Image("http://localhost/"+a.getLogo());
        img_logo.setFitWidth(150);
        img_logo.setFitHeight(150);
        img_logo.setImage(image0);
        Image image = new Image("http://localhost/"+demande.getPreuve());
        lab_preuve1.setFitWidth(150);
        lab_preuve1.setFitHeight(150);
        lab_preuve1.setImage(image);
        Image image2 = new Image("http://localhost/"+demande.getPreuve2());
        lab_preuve2.setFitWidth(150);
        lab_preuve2.setFitHeight(150);
        lab_preuve2.setImage(image2);
        lab_etat.setText("En Traitement");
    } else {
        lab_nomPrenom.setText("");
        lab_numTel.setText("");
        lab_email.setText("");
        lab_etat.setText("");
        lab_preuve1.setImage(null);
        lab_preuve2.setImage(null);
        lab_etat.setText("");
        
    }
    }    

    @FXML
    private void accepter(ActionEvent event) throws IOException {
        DemandeAjoutGarderieService ds = new DemandeAjoutGarderieService(); 
        DemandeAjoutGarderie demande = ds.consulterDemandeGarderie(id_garderie);
        ds.modifierEtat(id_garderie, EtatDemandeAjout.Acceptee);
        this.initialize(null,null);
    }

    @FXML
    private void refuser(ActionEvent event) throws IOException {
        DemandeAjoutGarderieService ds = new DemandeAjoutGarderieService(); 
        DemandeAjoutGarderie demande = ds.consulterDemandeGarderie(id_garderie);
        ds.modifierEtat(id_garderie, EtatDemandeAjout.Refusee);
        this.initialize(null,null);
            
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
     
}

