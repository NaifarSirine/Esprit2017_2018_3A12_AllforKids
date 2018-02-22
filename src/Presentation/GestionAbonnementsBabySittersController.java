/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author PC
 */
public class GestionAbonnementsBabySittersController implements Initializable {

    @FXML
    private TextField txt_rech;
    @FXML
    private Button btn_notification;
    @FXML
    private Label lab_nb_abs;
    @FXML
    private TableView<?> table_abonnements;
    @FXML
    private TableColumn<?, ?> col_bbs;
    @FXML
    private TableColumn<?, ?> col_prenom;
    @FXML
    private TableColumn<?, ?> col_adresse;
    @FXML
    private TableColumn<?, ?> col_Email;
    @FXML
    private Label lab_bbs;
    @FXML
    private Label lab_email;
    @FXML
    private Label lab_etat;
    @FXML
    private ImageView img_photo;
    @FXML
    private Button btn_logout;
    @FXML
    private Label lab_note;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void afficherAbnTraitement(ActionEvent event) {
    }

    @FXML
    private void logout(ActionEvent event) {
    }
    
}
