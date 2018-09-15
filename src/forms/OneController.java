package forms;

import entity.Event;
import entity.PriorityAction;
import entity.TypeAction;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.util.Callback;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class OneController {
    @FXML
    ComboBox comboboxTypeAction;
    @FXML
    TextArea disc;
    @FXML
    Button btnAdd;
    @FXML
    Spinner spinnerHour;
    @FXML
    Spinner spinnerMin;
    @FXML
    Spinner spinnerTime;
    @FXML
    ComboBox comboxPr;
    @FXML
    TableView<Event> tbView;
    @FXML
    DatePicker data;


    public void initialize() {
        disc.setPromptText("Write description");

        SpinnerValueFactory<Integer> hourFactory = //
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 24, 0);
        SpinnerValueFactory<Integer> minFactory = //
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 60, 1);
        SpinnerValueFactory<Integer> timeFactory = //
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 300, 0);

        spinnerHour.setValueFactory(hourFactory);
        spinnerMin.setValueFactory(minFactory);
        spinnerTime.setValueFactory(timeFactory);
        TableColumn<Event, String> fDescriptionCol = new TableColumn<>("Description");
        fDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));

        TableColumn<Event, Integer> fTimeCol = new TableColumn<>("Time");
        fTimeCol.setCellValueFactory(new PropertyValueFactory<>("time"));

        TableColumn<Event, TypeAction> fNameCol = new TableColumn<>("Name");
        fNameCol.setCellValueFactory(new PropertyValueFactory<>("name1"));

        TableColumn<Event, PriorityAction> fPriorityCol = new TableColumn<>("Status");
        fPriorityCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        TableColumn<Event, LocalDateTime> fStartActionCol = new TableColumn<>("StartAction");
        fStartActionCol.setCellValueFactory(new PropertyValueFactory<>("startAction"));
        tbView.getColumns().add(fDescriptionCol);
        tbView.getColumns().add(fTimeCol);
        tbView.getColumns().add(fNameCol);
        tbView.getColumns().add(fPriorityCol);
        tbView.getColumns().add(fStartActionCol);
        tbView.setItems(Event.list);
        comboxPr.getStyleClass().add("combobox");
        System.out.println(Event.list);
        ObservableList<TypeAction> col1 = FXCollections.observableArrayList(Arrays.asList(TypeAction.values()));
        comboboxTypeAction.setItems(col1);
        ObservableList<PriorityAction> col2 = FXCollections.observableArrayList(Arrays.asList(PriorityAction.values()));
        comboxPr.setItems(col2);
        btnAdd.setOnAction(e -> addButtonClicked());
        tbView.setOnMouseClicked(e -> click());

//        tbView.setRowFactory();
//        fPriorityCol.setCellValueFactory(column ->
//        return new TableCell<>()
        tbView.setEditable(true);
        tbView.setOnMouseClicked(e -> showContextMenu(e));
//        );
        // fNameCol.setCellValueFactory();
    }

    private void showContextMenu(MouseEvent e) {

        if (e.getButton() == MouseButton.SECONDARY) {
            MenuItem addItem = new MenuItem("Add");
            MenuItem editItem = new MenuItem("Edit");
            MenuItem deleteItem = new MenuItem("Delete");
            deleteItem.setOnAction(b -> delButtonClicked());
            addItem.setOnAction(v -> {
                changeStateComponent(false);
            });
            editItem.setOnAction(c -> {
                changeStateComponent(false);
                Event selected = tbView.getSelectionModel().getSelectedItem();
                data.setValue(selected.getStartAction().toLocalDate());
            });
//            circleItem.setOnAction(e -> draw("Circle"));
//            ellipseItem.setOnAction(e -> draw("Ellipse"));
            ContextMenu ctxMenu =
                    new ContextMenu(addItem, editItem, deleteItem);
            ctxMenu.show(tbView, e.getScreenX(), e.getScreenY());
        }
    }

    private void changeStateComponent(boolean state) {
        comboboxTypeAction.setDisable(state);
        disc.setDisable(state);
        spinnerHour.setDisable(state);
        spinnerMin.setDisable(state);
        spinnerTime.setDisable(state);
        btnAdd.setDisable(state);
        comboxPr.setDisable(state);
        data.setDisable(state);
    }

    public void addButtonClicked() {
        String description = disc.getText();
        LocalDate day = data.getValue();
        PriorityAction outputPriority = (PriorityAction) comboxPr.getValue();
        TypeAction outputTAction = (TypeAction) comboboxTypeAction.getValue();
        int time = (int) spinnerTime.getValue();
        LocalDateTime temp1 = LocalDateTime.of(day.getYear(), day.getMonth(), day.getDayOfMonth(),
                Integer.valueOf(spinnerHour.getValue().toString()), Integer.valueOf(spinnerMin.getValue().toString()));
        Event event = new Event(outputTAction, description, time, outputPriority, temp1);
        disc.setText("");
        spinnerTime.getValueFactory().setValue(0);
        spinnerHour.getValueFactory().setValue(0);
        spinnerMin.getValueFactory().setValue(0);
        data.setValue(LocalDate.of(1900, 01, 01));

        changeStateComponent(true);
    }

    public void delButtonClicked() {
        Event selected = tbView.getSelectionModel().getSelectedItem();
        tbView.getItems().remove(selected);
    }

    public void click() {
        System.out.println("sadsddsad");
        Event selected = tbView.getSelectionModel().getSelectedItem();
        String desc = selected.getDescription();
        disc.setText(desc);

    }
}

//nameColumn.setCellFactory(column -> {
////        return new TableCell<Person, String>() {
////@Override
////protected void updateItem(String item, boolean empty) {
////        super.updateItem(item, empty); //This is mandatory
////
////        if (item == null || empty) { //If the cell is empty
////        setText(null);
////        setStyle("");
////        } else { //If the cell is not empty
////
////        setText(item); //Put the String data in the cell
////
////        //We get here all the info of the Person of this row
////        Person auxPerson = getTableView().getItems().get(getIndex());
////
////        // Style all persons wich name is "Edgard"
////        if (auxPerson.getName().equals("Edgard")) {
////        setTextFill(Color.RED); //The text in red
////        setStyle("-fx-background-color: yellow"); //The background of the cell in yellow
////        } else {
////        //Here I see if the row of this cell is selected or not
////        if(getTableView().getSelectionModel().getSelectedItems().contains(auxPerson))
////        setTextFill(Color.WHITE);
////        else
////        setTextFill(Color.BLACK);
////        }
////        }
////        }
////        };
////        });
// calltypel.setCellFactory(column -> {
//         return new TableCell<CallLogs, String>() {
//@Override
//protected void updateItem(String item, boolean empty) {
//        super.updateItem(item, empty);
//
//        setText(empty ? "" : getItem().toString());
//        setGraphic(null);
//
//        TableRow currentRow = getTableRow();
//
//        //This doesn't work
//        if(item.equals("a")){
//        item.setTextFill(Color.RED);
//        currentRow.setTextFill(Color.PINK);
//        }
//        else{
//        item.setTextFill(Color.GREEN);
//        currentRow.setTextFill(Color.BLUE);
//        }
//
//        }
//        };
//        });