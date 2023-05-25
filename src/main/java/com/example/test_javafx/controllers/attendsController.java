package com.example.test_javafx.controllers;

import com.example.test_javafx.Navigation;
import com.example.test_javafx.models.DataModel;
import com.example.test_javafx.models.Student;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class attendsController implements Initializable {
    @FXML
    public TableView<Student> table;

    @FXML
    private AnchorPane rootPane;
    public TableColumn name;
    public TableColumn gpa;
    public TableColumn attend;
    public TableColumn phoneNumber;
    public TableColumn universityId;

    Navigation navigation = new Navigation();
    DataModel model = new DataModel();
    public void initialize(URL url, ResourceBundle rb) {
        //make sure the property value factory should be exactly same as the getStudentId from your model class
        attend.setCellValueFactory(new PropertyValueFactory<>(""));
       name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        universityId.setCellValueFactory(new PropertyValueFactory<>("universityId"));
        gpa.setCellValueFactory(new PropertyValueFactory<>("gpa"));
        phoneNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));


        table.setItems(FXCollections.observableArrayList(model.getStudents()));
    }
    public void back(ActionEvent actionEvent) {
        navigation.navigateTo(rootPane,navigation.TEACHER_FXML);
    }

    public void atend(ActionEvent actionEvent) {
    }
}