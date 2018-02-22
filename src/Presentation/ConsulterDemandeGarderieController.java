/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Services.DemandeAjoutGarderieService;
import Services.GarderieService;
import edu.entites.DemandeAjoutGarderie;
import edu.entites.Garderie;
import edu.entites.User;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author PC
 */
public class ConsulterDemandeGarderieController implements Initializable {

    @FXML
    private TableView<Garderie> TableGarderie=new TableView<>();
    @FXML
    private TableColumn<Garderie,String> Nom_Garderie =new TableColumn<>();;
    @FXML
    private TableColumn<Garderie, String> Description=new TableColumn<>();;
    @FXML
    private Button Retour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<Garderie> data;
        Garderie g=new Garderie();
        GarderieService gs=new GarderieService();
        List<Garderie> LC=gs.consulterGarderie2(User.MyUser.getId());
        data = FXCollections.observableArrayList();
        LC.stream().forEach((j) -> {
            data.add(j);
        });
        TableGarderie.setItems(data);
        Nom_Garderie.setCellValueFactory(new PropertyValueFactory<Garderie,String>("nom"));
        Description.setCellValueFactory(new PropertyValueFactory<Garderie,String>("description"));
    }
    @FXML
    public void Retour(ActionEvent event) throws IOException
    {
            ((Node)event.getSource()).getScene().getWindow().hide();
            
    }
    
    
}
