package exercise1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    private String[] business = {"", "", ""};
    private String[] computer = {"Java", "Python", "C#"};
    private Boolean[] coursesEnabled = {true, true, true};
    private String selected = "";
    private RadioButton compSciBtn;
    private TextArea selectedCourseList;
    private RadioButton businessBtn;
    private ComboBox<String> courses;

    @Override
    public void start(Stage primaryStage) throws Exception {

        BorderPane pane = new BorderPane();
        Scene scene = new Scene(pane, 900, 450);
        primaryStage.setTitle("Yeoul Kang");
        primaryStage.setScene(scene);


        GridPane section1 = new GridPane();
        pane.setLeft(section1);
        section1.setAlignment(Pos.TOP_CENTER);
        section1.setPadding(new Insets(10, 10, 10, 10));
        section1.setHgap(10);
        section1.setVgap(5);

        section1.add(new Label("Name"), 0, 0);
        TextField name = new TextField();
        section1.add(name, 1, 0);

        section1.add(new Label("Address"), 0, 1);
        TextField address = new TextField();
        section1.add(address, 1, 1);

        section1.add(new Label("Province"), 0, 2);
        TextField province = new TextField();
        section1.add(province, 1, 2);

        section1.add(new Label("City"), 0, 3);
        TextField city = new TextField();
        section1.add(city, 1, 3);

        section1.add(new Label("Postal Code"), 0, 4);
        TextField postalCode = new TextField();
        section1.add(postalCode, 1, 4);

        section1.add(new Label("Phone Number"), 0, 5);
        TextField phoneNumber = new TextField();
        section1.add(phoneNumber, 1, 5);

        section1.add(new Label("Email"), 0, 6);
        TextField email = new TextField();
        section1.add(email, 1, 6);


        HBox buttonArea = new HBox(10);
        buttonArea.setAlignment(Pos.TOP_RIGHT);
        compSciBtn = new RadioButton("Computer Science");
        businessBtn = new RadioButton("Business");
        buttonArea.getChildren().addAll(compSciBtn, businessBtn);


        GridPane section2 = new GridPane();
        pane.setCenter(section2);
        section2.setAlignment(Pos.TOP_CENTER);
        section2.setPadding(new Insets(10, 10, 10, 10));
        section2.setVgap(10);
        section2.setHgap(10);


        section2.add(buttonArea, 1, 0);
        GridPane.setHalignment(buttonArea, HPos.RIGHT);


        VBox checkBoxArea = new VBox(120);
        CheckBox councilCheck = new CheckBox("Student Council");
        CheckBox volunteerCheck = new CheckBox("Volunteer Work");
        checkBoxArea.getChildren().addAll(councilCheck, volunteerCheck);
        section2.add(checkBoxArea, 0, 1);


        VBox courseArea = new VBox(10);
        courses = new ComboBox<>();
        courses.getItems().addAll(computer);
        selectedCourseList = new TextArea();
        selectedCourseList.setPrefRowCount(5);
        courseArea.getChildren().addAll(courses, selectedCourseList);

        // section2 레이아웃에 추가
        section2.add(courseArea, 1, 1);


        ToggleGroup radioGroup = new ToggleGroup();
        compSciBtn.setToggleGroup(radioGroup);
        compSciBtn.setSelected(true);
        businessBtn.setToggleGroup(radioGroup);


        RadioHandler radioHandler = new RadioHandler();
        compSciBtn.setOnAction(radioHandler);
        businessBtn.setOnAction(radioHandler);

        courses.setOnAction(event -> {
            int index = courses.getSelectionModel().getSelectedIndex();
            if (courses.getSelectionModel().getSelectedItem() != null && coursesEnabled[index]) {
                selected += courses.getSelectionModel().getSelectedItem() + "\n";
                selectedCourseList.setText(selected);
                coursesEnabled[index] = false;
            }
        });


        GridPane section4 = new GridPane();
        pane.setBottom(section4);
        section4.setAlignment(Pos.CENTER);
        section4.setPadding(new Insets(10, 10, 10, 10));
        section4.setVgap(10);

        Button display = new Button("Display");
        TextArea displayBox = new TextArea();
        displayBox.setPrefRowCount(5);
        GridPane.setHalignment(display, HPos.CENTER);

        display.setOnAction(event -> {
            String nameT = name.getText();
            String addressT = address.getText();
            String provinceT = province.getText();
            String cityT = city.getText();
            String postalCodeT = postalCode.getText();
            String phoneT = phoneNumber.getText();
            String emailT = email.getText();
            String displayString = String.format("%s, %s, %s, %s, %s, %s, %s",
                    nameT, addressT, provinceT, cityT, postalCodeT, phoneT, emailT);
            String selectedCourses = selectedCourseList.getText().trim();
            if (!selectedCourses.isEmpty()) {
                displayString += "\nCourses:\n" + selectedCourses;
            }
            displayBox.setText(displayString);
        });

        section4.add(display, 0, 0);
        section4.add(displayBox, 0, 1);

        primaryStage.show();
    }


    private class RadioHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            courses.getItems().clear();
            selected = "";
            selectedCourseList.setText(selected);
            for (int i = 0; i < 3; i++) coursesEnabled[i] = true;

            if (event.getSource() == compSciBtn) {
                courses.getItems().addAll(computer);
            } else {
                courses.getItems().addAll(business);
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
