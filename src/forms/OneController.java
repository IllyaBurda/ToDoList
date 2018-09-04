package forms;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class OneController {
    @FXML
    TextArea disc;
    @FXML
    Button btn;
    @FXML
    TextField name;
    @FXML
    Spinner spinnerHour;
    @FXML
    Spinner spinnerMin;
    @FXML
    ComboBox<String> combox;

    public void initialize() {
        name.setPromptText("Name");
        disc.setPromptText("Write description");

        SpinnerValueFactory<Integer> hourFactory = //
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 24, 0);
        SpinnerValueFactory<Integer> minFactory = //
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 60, 1);

        spinnerHour.setValueFactory(hourFactory);
        spinnerMin.setValueFactory(minFactory);
        /*ObservableList<String> typesOfImportance =
                FXCollections.observableArrayList(
                        "None", "Work", "Hobby", "Recreation", "Shopping", "Errands"
                );*/
        combox.setValue("Deal");
        combox.getItems().addAll("None", "Work", "Hobby", "Recreation", "Shopping", "Errands");


//        combox = new ComboBox<String>();
//        combox.getItems().addAll("Work", "Hobby", "Recreation", "Shopping", "Errands");
        /*ObservableList<String> typesOfImportance = FXCollections.observableArrayList("Work", "Hobby", "Recreation", "Shopping", "Errands");

        combox = new ComboBox<>(typesOfImportance);
        combox.setValue("Hobby");*/

    }

    public void click() {

    }
}
