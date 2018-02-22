/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Services.GarderieService;
import edu.entites.Garderie;
import edu.entites.User;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author PC
 */
public class ConsulterListeGarderieController implements Initializable {

    @FXML
    private Button RechercherParNom;
    @FXML
    private ComboBox<String> NomUtilisateur;
    @FXML
    private TableView<Garderie> TableGarderie;
    @FXML
    private TableColumn<Garderie, String> Nom;
    @FXML
    private TableColumn<Garderie, String> Description;
    @FXML
    private TableColumn<Garderie, String> Téléphone;
    @FXML
    private TableColumn<Garderie, String> Email;
    @FXML
    private TableColumn<Garderie, String> Adresse;
    @FXML
    private TableColumn<Garderie, String> Site;
    @FXML
    private TableColumn<Garderie, String> Ville;
    @FXML
    private Button Ajouter;
    @FXML
    private Button SupprimerButton;
    @FXML
    private Button ModifierButton;
    @FXML
    private Label label_erreur;
    @FXML
    private Label label_logo;
    @FXML
    private ImageView img_logo;

    /**
     * Initializes the controller class.
     */
    public static Garderie Garderie=new Garderie();
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        label_logo.setVisible(false);
        img_logo.setVisible(false);
        ObservableList<Garderie> data;
        GarderieService gs=new GarderieService();
        ArrayList<Garderie> LC = gs.consulterGarderie(User.MyUser.getId());
        System.out.println(LC.toString());
        data = FXCollections.observableArrayList();
        LC.stream().forEach((j) -> {
            data.add(j);
        });

        TableGarderie.setItems(data);
        Nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        Description.setCellValueFactory(new PropertyValueFactory<>("description"));
        Téléphone.setCellValueFactory(new PropertyValueFactory<>("numTel"));
        Email.setCellValueFactory(new PropertyValueFactory<>("email"));
        Adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        Site.setCellValueFactory(new PropertyValueFactory<>("site"));
        Ville.setCellValueFactory(new PropertyValueFactory<>("ville"));
         TableGarderie.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> showPGarderieDetails(newValue));
         
    }    
    private void showPGarderieDetails(Garderie g) {
        label_logo.setVisible(true);
        img_logo.setVisible(true);
        img_logo.setFitWidth(150);
        img_logo.setFitHeight(150);
        Image i=new Image("http://localhost/"+g.getLogo());
        img_logo.setImage(i);
    }
    @FXML
    private void AjouterGarderie(ActionEvent event) throws IOException {
            ((Node)event.getSource()).getScene().getWindow().hide();
            Stage stage=new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("AjoutGarderie.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show(); 
    }
    @FXML
    private void Modifier(ActionEvent event) throws IOException {
            
            if (TableGarderie.getSelectionModel().getSelectedItem()!=null)
            {
            ((Node)event.getSource()).getScene().getWindow().hide();
            Garderie=TableGarderie.getSelectionModel().getSelectedItem();
            Stage stage=new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("ModifGarderie.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show(); 
            }
            else 
            {
                label_erreur.setText("Choisir une garderie");
            }
    }
    @FXML
    private void Supprimer(ActionEvent event) throws IOException {
        if (TableGarderie.getSelectionModel().getSelectedItem()!=null)
            {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation suppression");
        alert.setHeaderText("Look, a Confirmation Dialog");
        alert.setContentText("Are you ok with this?");
        
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            
            Garderie G=new Garderie();
            G=TableGarderie.getSelectionModel().getSelectedItem();
            GarderieService gs=new GarderieService();
            gs.supprimerGarderie(G);
        } 
        else{
            ((Node)event.getSource()).getScene().getWindow().hide();
            
        }
        
            }
        else 
            {
                label_erreur.setText("Choisir une garderie");
            }
    }

   
}

