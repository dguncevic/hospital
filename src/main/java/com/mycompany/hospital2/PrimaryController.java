package com.mycompany.hospital2;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.hospital.beans.*;
import com.hospital.beans.User;
import com.hospital.tools.Password;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import javafx.util.Duration;

public class PrimaryController implements Initializable {

    @FXML
    private AnchorPane loginPane;
    @FXML
    private Label lblWrongLogin;
    @FXML
    private ImageView img;
    @FXML
    private TextField txtUser;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private AnchorPane adminPane;
    @FXML
    private AnchorPane patientPane;
    @FXML
    private Label lblHello;
    @FXML
    private ImageView imgInfo;
    @FXML
    private ImageView imgKalendar;
    @FXML
    private ImageView imgPovijest;
    @FXML
    private Label lblRaspored;
    @FXML
    private Label lblPovijestBolesti;
    @FXML
    private Label lblPovijestBolesti1;
    @FXML
    private Label lblVrijeme;
    @FXML
    private AnchorPane infoPane;
    @FXML
    private Label lblIme;
    @FXML
    private Label lblAge;
    @FXML
    private Label lblOib;
    @FXML
    private Label lblEmail;
    @FXML
    private Label lblPrezime;
    @FXML
    private Label lblSpol;
    @FXML
    private Label lblTelefon;
    @FXML
    private Label lblOdijel;
    @FXML
    private ImageView imgOsobe;
    @FXML
    private Label lblGrad;
    @FXML
    private Label lblAdresa;
    @FXML
    private Label lblStatus;
    @FXML
    private Label lblRole;
    @FXML
    private ImageView imgReturn;
    @FXML
    private AnchorPane kalendarPane;
    @FXML
    private ImageView imgReturnKalendar;
    @FXML
    private AnchorPane povijestPane;
    @FXML
    private ImageView imgReturnPovijest;
    @FXML
    private ComboBox<Bolest> comboBoxBolesti;
    @FXML
    private Label lblNalaz;
    @FXML
    private ImageView addDoctor;
    @FXML
    private Label lblVrijemeAdmin;
    @FXML
    private Label lblPozdravAdmin;
    @FXML
    private Label lblAddDoctor;
    private AnchorPane addDoctorPane;
    @FXML
    private TextField txtDoctorIme;
    @FXML
    private TextField txtDoctorAdresa;
    @FXML
    private TextField txtDoctorPrezime;
    @FXML
    private TextField txtDoctorBrojTelefona;
    @FXML
    private DatePicker dpDoctorDatumRodjenja;
    @FXML
    private ComboBox<String> cbDoctorSpol;
    @FXML
    private TextField txtDoctorOib;
    @FXML
    private ComboBox<Odijel> cbDoctorOdijel;
    @FXML
    private Button buttonDoctorSave;
    @FXML
    private ComboBox<City> cbDoctorGradovi;
    @FXML
    private ComboBox<Role> cbRole;
    @FXML
    private ComboBox<Zupanije> cbZupanije;
    @FXML
    private TextField txtDoctorEmail;
    @FXML
    private Label lblNewUserInformation;
    @FXML
    private AnchorPane doctorPane;
    @FXML
    private Label lblHelloDoctor;
    @FXML
    private ImageView addPatient;
    @FXML
    private ImageView addTermin;
    @FXML
    private Label lblVrijemeDoctor;
    @FXML
    private Label lblAddTermin;
    @FXML
    private Label lblAddPatient;
    @FXML
    private Label lblSearchPatient;
    @FXML
    private ImageView imgSearchPatient;
    @FXML
    private TableView table;

    private static final Duration TRANSITION_DURATION = Duration.millis(200);
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");
    User user;
    Image return1 = new Image("return.png");
    Image return2 = new Image("return2.png");
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    String getUserByUsername = "http://localhost:8080/api/getuserbyusername?username=";
    String url = "http://localhost:8080/api/";
    AnchorPane previousPane;
    ObservableList<ObservableList> data;
    @FXML
    private ComboBox<String> cbSearchKrtierij;
    @FXML
    private TextField txtSearch;
    @FXML
    private AnchorPane addUserPane;
    @FXML
    private AnchorPane addTerminPane;
    private TextField txtVrijemeDolaska;
    @FXML
    private DatePicker dpDatumDolaska;
    @FXML
    private ComboBox<User> cbPacijenti;
    @FXML
    private Button buttonTerminSave;
    @FXML
    private Label lblNewUserInformation1;
    @FXML
    private TextArea txtOpisTermina;
    private AnchorPane updateUser;
    @FXML
    private Button buttonUpdate;
    @FXML
    private Label lblNewUserInformation11;
    @FXML
    private AnchorPane updateUserPane;
    @FXML
    private Button buttonSearch;
    @FXML
    private ComboBox<String> cbHours;
    @FXML
    private ComboBox<String> cbMinutes;
    @FXML
    private ImageView pregledajTermine;
    @FXML
    private Label lblTermini;
    @FXML
    private TextField txtUpdateIme;
    @FXML
    private TextField txtUpdatePrezime;
    @FXML
    private TextField txtUpdateAdresa;
    @FXML
    private TextField txtUpdateOib;
    @FXML
    private TextField txtUpdateEmail;
    @FXML
    private DatePicker cbUpdateDateOfBirth;
    @FXML
    private ComboBox<String> cbUpdateSpol;
    @FXML
    private ComboBox<Zupanije> cbUpdateZupanije;
    @FXML
    private ComboBox<City> cbUpdateGrad;
    @FXML
    private ComboBox<Role> cbUpdateRole;
    @FXML
    private ComboBox<Status> cbUpdateStatus;
    @FXML
    private ComboBox<Odijel> cbUpdateOdijel;
    @FXML
    private TextField txtUpdatePhoneNumber;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        img.setImage(new Image("hospital.png"));
        patientPane.setVisible(false);
        for (int i = 0; i <= 23; i++) {
            if (i < 10) {
                cbHours.getItems().add("0" + i);
            } else {
                cbHours.getItems().add("" + i);
            }

        }
        for (int i = 0; i <= 59; i++) {
            if (i < 10) {
                cbMinutes.getItems().add("0" + i);
            } else {
                cbMinutes.getItems().add("" + i);
            }

        }
    }

    @FXML
    private void mouseExitedLogin(MouseEvent event) {
    }

    @FXML
    private void mouseEnteredLogin(MouseEvent event) {
    }

    @FXML
    private void loginClicked(MouseEvent event) throws Exception {

        user = getUserByUsername(txtUser.getText());

        if (user.getUsername() == null) {
            notifyWrongLogin("Wrong username...");
            return;
        }

        System.out.println("Hashiran moj password:" + Password.hashPassword(txtPassword.getText()));

        boolean isPasswordCorrect = Password.checkPassword(txtPassword.getText(), user.getPassword());

        if (isPasswordCorrect) {

            if (user.getRole().getRoleName().toLowerCase().equals("admin")) {
                patientPane.setVisible(false);
                transition(patientPane, adminPane);
                postaviVrijeme();
                postaviPersonalInfo();
            } else if (user.getRole().getRoleName().toLowerCase().equals("doktor")) {
                patientPane.setVisible(false);
                postaviVrijeme();
                postaviPersonalInfo();
                transition(loginPane, doctorPane);
                previousPane = loginPane;
            } else if (user.getRole().getRoleName().toLowerCase().equals("pacijent")) {
                transition(loginPane, patientPane);
                previousPane = loginPane;
                postaviVrijeme();
                postaviPersonalInfo();
            }

        } else {
            notifyWrongLogin("Wrong password...");
            return;
        }

    }

    @FXML
    private void patientInfoExited(MouseEvent event) {

        postaviVisuale(lblPovijestBolesti, false, imgInfo, 1);
    }

    @FXML
    private void patientInfoEntered(MouseEvent event) {

        postaviVisuale(lblPovijestBolesti, true, imgInfo, 1.5);
    }

    @FXML
    private void patientInfoClicked(MouseEvent event) {

        transition(patientPane, infoPane);
        previousPane = patientPane;
    }

    @FXML
    private void patientKalendarExited(MouseEvent event) {

        postaviVisuale(lblRaspored, false, imgKalendar, 1);
    }

    @FXML
    private void patientKalendarEntered(MouseEvent event) {

        postaviVisuale(lblRaspored, true, imgKalendar, 1.5);
    }

    @FXML
    private void patientPovijestBolestiExited(MouseEvent event) {

        postaviVisuale(lblPovijestBolesti1, false, imgPovijest, 1);
    }

    @FXML
    private void patientPovijestBolestiEntered(MouseEvent event) {

        postaviVisuale(lblPovijestBolesti1, true, imgPovijest, 1.5);
    }

    @FXML
    private void patientPovijestBolestiClicked(MouseEvent event) {

        transition(patientPane, povijestPane);
        previousPane = patientPane;
    }

    public void postaviVisuale(Label label, boolean bolean, ImageView image, double broj) {
        label.setVisible(bolean);
        image.setScaleX(broj);
        image.setScaleY(broj);
    }

    public void notifyWrongLogin(String str) {
        lblWrongLogin.setText(str);
        lblWrongLogin.setVisible(true);
    }

    public void postaviVrijeme() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            LocalTime currentTime = LocalTime.now();
            String formattedTime = currentTime.format(TIME_FORMATTER);
            lblVrijeme.setText(formattedTime);
            lblVrijemeAdmin.setText(formattedTime);
            lblVrijemeDoctor.setText(formattedTime);
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    @FXML
    private void returnExited(MouseEvent event) {
        imgReturn.setImage(return1);
    }

    @FXML
    private void returnEntered(MouseEvent event) {
        imgReturn.setImage(return2);
    }

    @FXML
    private void returnClicked(MouseEvent event) {

        transition(infoPane, previousPane);
        previousPane = infoPane;
    }

    @FXML
    private void patientKalendarClicked(MouseEvent event) {

        transition(patientPane, kalendarPane);
        previousPane = patientPane;
        imgReturnKalendar.setImage(return1);
        txtSearch.setVisible(false);
        cbSearchKrtierij.setVisible(false);
        buttonSearch.setVisible(false);
        setAllTermine("where patient_firstname = '" + user.getFirstName() + "' and patient_lastname= '" + user.getLastName() + "';");

    }

    @FXML
    private void kalendarReturnExited(MouseEvent event) {
        imgReturnKalendar.setImage(return1);

    }

    @FXML
    private void kalendarReturnEntered(MouseEvent event) {
        imgReturnKalendar.setImage(return2);
    }

    @FXML
    private void kalendarReturnClicked(MouseEvent event) {
        imgReturnKalendar.setVisible(true);

        transition(kalendarPane, previousPane);
        previousPane = kalendarPane;
    }

    @FXML
    private void povijestReturnExited(MouseEvent event) {
        imgReturnPovijest.setImage(return1);
    }

    @FXML
    private void povijestReturnEntered(MouseEvent event) {
        imgReturnPovijest.setImage(return2);
    }

    @FXML
    private void povijestReturnClicked(MouseEvent event) {

        transition(povijestPane, previousPane);
        previousPane = povijestPane;

    }

    private void transition(AnchorPane pane1, AnchorPane pane2) {
        FadeTransition fadeOut = new FadeTransition(Duration.millis(500), pane1);
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.0);
        fadeOut.setOnFinished((event) -> {
            pane1.setVisible(false);
            pane2.setVisible(true);
            FadeTransition fadeIn = new FadeTransition(Duration.millis(500), pane2);
            fadeIn.setFromValue(0.0);
            fadeIn.setToValue(1.0);
            fadeIn.play();
        });
        fadeOut.play();
    }

    private String executeApi(String surl, String method) {

        String result = "";
        try {
            URL url = new URL(surl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod(method);

            conn.connect();

            try ( Scanner scanner = new Scanner(url.openStream())) {
                while (scanner.hasNext()) {
                    result += scanner.nextLine();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;

    }

    private String executeApi2(String surl, String query) throws Exception {
        String url = surl;
        String data = query;
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", "Java client");
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
        con.setDoOutput(true);
        OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
        wr.write(data);
        wr.flush();
        wr.close();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        System.out.println(response.toString());
        return response.toString();
    }

    private String executeApi3(String surl, String query, String method) throws Exception {
        String url = surl;
        String data = query;
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod(method);
        con.setRequestProperty("User-Agent", "Java client");
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
        con.setDoOutput(true);
        OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
        wr.write(data);
        wr.flush();
        wr.close();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        System.out.println(response.toString());
        return response.toString();
    }

    private User getUserByUsername(String username) {

        Gson gson = new Gson();
        String json = executeApi(getUserByUsername + username, "GET");
//        String json = executeApi3(url+"getuserbyusername", "");
        User person = gson.fromJson(json, User.class);

        return person;
    }

    private void postaviPersonalInfo() {

        String username = txtUser.getText();
        lblHello.setText("Dobar dan, " + getUserByUsername(username).getFirstName() + ".");
        lblPozdravAdmin.setText("Dobar dan, " + getUserByUsername(username).getFirstName());
        lblHelloDoctor.setText("Dobar dan, " + getUserByUsername(username).getFirstName() + ".");
        lblIme.setText("Ime: " + getUserByUsername(username).getFirstName());
        lblPrezime.setText("Prezime: " + getUserByUsername(username).getLastName());
        lblAge.setText("Datum rođenja: " + sdf.format(getUserByUsername(username).getDateOfBirth()));
        lblSpol.setText("Spol: " + getUserByUsername(username).getSpol());
        lblOib.setText("Oib: " + getUserByUsername(username).getOib());
        lblAdresa.setText("Adresa: " + getUserByUsername(username).getAdress());
        lblGrad.setText("Grad: " + getUserByUsername(username).getCity());
        lblRole.setText("Role: " + getUserByUsername(username).getRole());
        lblStatus.setText("Status: " + getUserByUsername(username).getStatus());
        lblOdijel.setText("Odijel: " + getUserByUsername(username).getOdijel());
        lblEmail.setText("Email: " + getUserByUsername(username).getEmail());
        lblTelefon.setText("Telefon: " + getUserByUsername(username).getPhoneNumber());
    }

    @FXML
    private void addDoctorExited(MouseEvent event) {
        postaviVisuale(lblAddDoctor, false, addDoctor, 1);
    }

    @FXML
    private void addDoctorEntered(MouseEvent event) {
        postaviVisuale(lblAddDoctor, true, addDoctor, 1.5);
    }

    @FXML
    private void addDoctorClicked(MouseEvent event) {
        patientPane.setVisible(false);
        transition(adminPane, addUserPane);
        previousPane = adminPane;

        cbDoctorOdijel.setItems(getAllOdijeli());
        cbDoctorSpol.getItems().add("MALE");
        cbDoctorSpol.getItems().add("FEMALE");
        cbZupanije.setItems(getAllStates());
        cbRole.setItems(getAllRoles());

        cbZupanije.setOnAction(t -> {
            cbDoctorGradovi.getItems().clear();
            cbDoctorGradovi.setItems(getAllCitiesFromState(cbZupanije.getSelectionModel().getSelectedItem().getId()));
        });

        buttonDoctorSave.setOnMouseClicked(t -> {

            String username = txtDoctorIme.getText().toLowerCase() + txtDoctorPrezime.getText().toLowerCase();
            String password = Password.hashPassword(username);

            String s = url + "addnewuser?firstName=" + txtDoctorIme.getText() + "&lastName=" + txtDoctorPrezime.getText() + "&username=" + username + "&password=" + password + "&city=" + cbDoctorGradovi.getSelectionModel().getSelectedItem().getId() + "&adresa=" + txtDoctorAdresa.getText() + "&odijel=" + cbDoctorOdijel.getSelectionModel().getSelectedItem().getId() + "&email=" + txtDoctorEmail.getText() + "&dateOfBirth=" + dpDoctorDatumRodjenja.getValue() + "&spol=" + cbDoctorSpol.getSelectionModel().getSelectedItem() + "&phoneNumber=" + txtDoctorBrojTelefona.getText() + "&oib=" + txtDoctorOib.getText() + "&status=1&role=" + cbRole.getSelectionModel().getSelectedItem().getId();
            s = s.replaceAll(" ", "%20");
            executeApi(s, "GET");

            transition(addUserPane, previousPane);

        });
    }

    private ObservableList<Odijel> getAllOdijeli() {

        ObservableList<Odijel> odijeli = FXCollections.observableArrayList();
        Gson gson = new Gson();
        String json = executeApi(url + "getallodijeli", "GET");
        JsonArray array = gson.fromJson(json, JsonArray.class);
        for (JsonElement element : array) {
            Odijel temp = gson.fromJson(element, Odijel.class);
            odijeli.add(temp);
        }
        return odijeli;
    }

    private ObservableList<Zupanije> getAllStates() {

        ObservableList<Zupanije> zupanije = FXCollections.observableArrayList();
        Gson gson = new Gson();
        String json = executeApi(url + "getallstates", "GET");
        JsonArray array = gson.fromJson(json, JsonArray.class);
        for (JsonElement element : array) {
            Zupanije temp = gson.fromJson(element, Zupanije.class);
            zupanije.add(temp);
        }
        return zupanije;

    }

    private ObservableList<Role> getAllRoles() {

        ObservableList<Role> roles = FXCollections.observableArrayList();
        Gson gson = new Gson();
        String json = executeApi(url + "getallroles", "GET");
        JsonArray array = gson.fromJson(json, JsonArray.class);
        for (JsonElement element : array) {
            Role temp = gson.fromJson(element, Role.class);
            roles.add(temp);
        }
        return roles;
    }

    private ObservableList<Status> getAllStatusi() {

        ObservableList<Status> statusi = FXCollections.observableArrayList();
        Gson gson = new Gson();
        String json = executeApi(url + "getallstatusi", "GET");
        JsonArray array = gson.fromJson(json, JsonArray.class);
        for (JsonElement element : array) {
            Status temp = gson.fromJson(element, Status.class);
            statusi.add(temp);
        }
        return statusi;
    }

    private ObservableList<City> getAllCitiesFromState(int id) {
        ObservableList<City> cities = FXCollections.observableArrayList();
        Gson gson = new Gson();
        String json = executeApi(url + "getcitiesbystateid?id=" + id, "GET");
        JsonArray array = gson.fromJson(json, JsonArray.class);
        for (JsonElement element : array) {
            City temp = gson.fromJson(element, City.class);
            cities.add(temp);
        }
        return cities;
    }

    @FXML
    private void addPatientExited(MouseEvent event) {
        postaviVisuale(lblAddPatient, false, addPatient, 1);
    }

    @FXML
    private void addPatientEntered(MouseEvent event) {
        postaviVisuale(lblAddPatient, true, addPatient, 1.5);

    }

    @FXML
    private void addPatientClicked(MouseEvent event) {
    }

    @FXML
    private void addTerminExited(MouseEvent event) {
        postaviVisuale(lblAddTermin, false, addTermin, 1);

    }

    @FXML
    private void addTerminEntered(MouseEvent event) {
        postaviVisuale(lblAddTermin, true, addTermin, 1.5);
    }

    @FXML
    private void addTerminClicked(MouseEvent event) {

        transition(doctorPane, addTerminPane);
        previousPane = doctorPane;

        ObservableList<User> pacijenti;
        try {
            pacijenti = getAllUsers("select * from allpatientdata where rolename = 'Pacijent';");
            cbPacijenti.getItems().addAll(pacijenti);
        } catch (Exception ex) {
            Logger.getLogger(PrimaryController.class.getName()).log(Level.SEVERE, null, ex);
        }

        buttonTerminSave.setOnMouseClicked((t) -> {

            String vrijeme = dpDatumDolaska.getValue().toString() + " " + cbHours.getValue() + ":" + cbMinutes.getValue() + ":00";

            String s = url + "addnewtermin";
            String s2 = "patientid=" + cbPacijenti.getValue().getId() + "&doctorid=" + user.getId() + "&vrijemedolaska=" + vrijeme + "&opis=" + txtOpisTermina.getText();

            try {
                executeApi2(s, s2);
            } catch (Exception ex) {
                Logger.getLogger(PrimaryController.class.getName()).log(Level.SEVERE, null, ex);
            }

            transition(addTerminPane, doctorPane);
        });
    }

    @FXML
    private void searchPatientDoctorExited(MouseEvent event) {
        postaviVisuale(lblSearchPatient, false, imgSearchPatient, 1);

    }

    @FXML
    private void searchPatientDoctorEntered(MouseEvent event) {
        postaviVisuale(lblSearchPatient, true, imgSearchPatient, 1.5);
    }

    @FXML
    private void searchPatientDoctorClicked(MouseEvent event) {
        transition(doctorPane, kalendarPane);
        previousPane = doctorPane;
        txtSearch.setVisible(true);
        cbSearchKrtierij.setVisible(true);
        buttonSearch.setVisible(true);

        setAllPatientsToTable();

    }

    private ObservableList<User> getAllUsers(String query) throws Exception {

        ObservableList<User> users = FXCollections.observableArrayList();
        Gson gson = new Gson();
        System.out.println(query);
        String json = executeApi2("http://localhost:8080/api/getallusers", "query=" + query);
        JsonArray array = gson.fromJson(json, JsonArray.class);
        for (JsonElement element : array) {
            User temp = gson.fromJson(element, User.class);
            users.add(temp);
        }
        return users;

    }

    private User getUserByQuery(String query) throws Exception {
        User temp = new User();
        Gson gson = new Gson();
        String json = executeApi2("http://localhost:8080/api/getuserbyquery", "query=" + query);
        temp = gson.fromJson(json, User.class);
        return temp;
    }

    private int getColCount(String query) {
        Gson gson = new Gson();

        query = query.replaceAll(" ", "%20");
        String json = executeApi(url + "getcolcount2?query=" + query, "GET");
        int a = gson.fromJson(json, int.class);

        return a;
    }

    private ObservableList<String> getColNames(String query) {
        ObservableList<String> names = FXCollections.observableArrayList();
        Gson gson = new Gson();

        query = query.replaceAll(" ", "%20");
        String json = executeApi(url + "getcolnames2?query=" + query, "GET");
        JsonArray array = gson.fromJson(json, JsonArray.class);
        for (JsonElement element : array) {
            String colName = gson.fromJson(element, String.class);
            names.add(colName);
        }
        return names;
    }

    private ObservableList<String> getAllStrings(User user) {

        ObservableList<String> lista = FXCollections.observableArrayList();

        lista.add("" + user.getId());
        lista.add(user.getFirstName());
        lista.add(user.getLastName());
        lista.add("" + user.getDateOfBirth());
        lista.add(user.getAdress());
        lista.add("" + user.getOib());
        lista.add(user.getEmail());
        lista.add("" + user.getPhoneNumber());
        lista.add("" + user.getSpol());
        lista.add("" + user.getDateEntered());
        lista.add("" + user.getDateModified());
        lista.add("" + user.getRole().getId());
        lista.add("" + user.getRole());
        lista.add("" + user.getStatus().getStatus());
        lista.add("" + user.getOdijel().getId());
        lista.add("" + user.getOdijel().getImeOdijela());
        lista.add("" + user.getCity().getCityName());

        return lista;
    }

    private ObservableList<String> getAllStringsTermini(Termini termin) {

        ObservableList<String> lista = FXCollections.observableArrayList();

        lista.add("" + termin.getId());
        lista.add("" + termin.getPatientid());
        lista.add("" + termin.getDoctorid());
        lista.add(termin.getPatient_firstname());
        lista.add(termin.getPatient_lastname());
        lista.add(termin.getDoctor_firstname());
        lista.add(termin.getDoctor_lastname());
        lista.add(termin.getOpis());
        lista.add("" + termin.getVrijemedolaska());
        lista.add("" + termin.getVrijemekreiranjatermina());

        return lista;
    }

    private ObservableList<Termini> getAllTermini(String query) {

        ObservableList<Termini> termini = FXCollections.observableArrayList();
        Gson gson = new Gson();

        query = query.replaceAll(" ", "%20");
        String json = executeApi(url + "getalltermini?query=" + query, "GET");
        JsonArray array = gson.fromJson(json, JsonArray.class);
        for (JsonElement element : array) {
            Termini temp = gson.fromJson(element, Termini.class);
            termini.add(temp);
        }
        return termini;

    }

    private void setAllPatientsToTable() {

        table.getItems().clear();
        table.getColumns().clear();
        data = FXCollections.observableArrayList();
//        String pacijentquerry = "select * from allpatiendata where rolename = 'Pacijent'";

        for (int i = 0; i < getColCount("select * from allpatientdata where rolename = 'Pacijent'"); i++) {
            //We are using non property style for making dynamic table
            final int j = i;
            TableColumn col = new TableColumn(getColNames("select * from allpatientdata where rolename = 'Pacijent'").get(i));
            cbSearchKrtierij.getItems().add(getColNames("select * from allpatientdata where rolename = 'Pacijent'").get(i));
            col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {
                    return new SimpleStringProperty(param.getValue().get(j).toString());
                }

            });
            table.getColumns().add(col);
        }
        cbSearchKrtierij.getSelectionModel().select(1);
        ObservableList<User> pacijenti;
        try {
            pacijenti = getAllUsers("select * from allpatientdata where rolename = 'Pacijent'");
            for (int i = 0; i < pacijenti.size(); i++) {
                ObservableList<String> row = FXCollections.observableArrayList();

                row.addAll(getAllStrings(pacijenti.get(i)));

                System.out.println(pacijenti.get(i));
                data.add(row);
            }
        } catch (Exception ex) {
            Logger.getLogger(PrimaryController.class.getName()).log(Level.SEVERE, null, ex);
        }

        table.setItems(data);
        table.refresh();

        table.setOnMouseClicked((t) -> {
            if (t.getClickCount() == 2) {
                ObservableList<String> selectedRow = (ObservableList<String>) table.getSelectionModel().getSelectedItem();

                System.out.println(selectedRow.get(0) + " - " + selectedRow.get(1) + " - " + selectedRow.get(2));

                User myUser = null;
                try {
                    myUser = getUserByQuery("select * from alluserdata where id = " + selectedRow.get(0) + " ;");
                    System.out.println(myUser);
                } catch (Exception ex) {
                    Logger.getLogger(PrimaryController.class.getName()).log(Level.SEVERE, null, ex);
                }

                transition(kalendarPane, updateUserPane);
                txtUpdateIme.setText(myUser.getFirstName());
                txtUpdatePrezime.setText(myUser.getLastName());

                cbUpdateDateOfBirth.setValue(LocalDate.of(myUser.getDateOfBirth().getYear(), myUser.getDateOfBirth().getMonth(), myUser.getDateOfBirth().getDate()));
                txtUpdateAdresa.setText(myUser.getAdress());
                txtUpdateOib.setText(myUser.getOib());
                txtUpdateEmail.setText(myUser.getEmail());
                txtUpdatePhoneNumber.setText(myUser.getPhoneNumber());

                ArrayList<String> spolovi = new ArrayList<>();
                spolovi.add("MALE");
                spolovi.add("FEMALE");

                cbUpdateSpol.getItems().addAll(spolovi);
                cbUpdateSpol.getSelectionModel().select(myUser.getSpol().toString());
                cbUpdateOdijel.setItems(getAllOdijeli());
                cbUpdateOdijel.getSelectionModel().select(myUser.getOdijel());
                cbUpdateZupanije.setItems(getAllStates());
//                cbUpdateZupanije.getSelectionModel().select(myUser.getCity().getCityState());
                cbUpdateZupanije.setOnAction((z) -> {
                    cbUpdateGrad.getItems().clear();
                    cbUpdateGrad.setItems(getAllCitiesFromState(cbUpdateZupanije.getSelectionModel().getSelectedItem().getId()));
                });
                cbUpdateRole.setItems(getAllRoles());
                cbUpdateRole.getSelectionModel().select(myUser.getRole());
                cbUpdateStatus.setItems(getAllStatusi());
                cbUpdateStatus.getSelectionModel().select(myUser.getStatus());

            }

        });
    }

    private void setAllTermine(String kriterij) {

        table.getItems().clear();
        table.getColumns().clear();
        data = FXCollections.observableArrayList();
        String s = "select * from allpatienttermins " + kriterij + ";";
        s = s.replaceAll(" ", "%20");

        for (int i = 0; i < getColCount(s); i++) {
            //We are using non property style for making dynamic table
            final int j = i;
            TableColumn col = new TableColumn(getColNames(s).get(i));

            col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {
                    return new SimpleStringProperty(param.getValue().get(j).toString());
                }

            });
            table.getColumns().add(col);
        }

        ObservableList<Termini> termini = getAllTermini(s);

        for (int i = 0; i < termini.size(); i++) {
            ObservableList<String> row = FXCollections.observableArrayList();

            row.addAll(getAllStringsTermini(termini.get(i)));

            System.out.println(termini.get(i).toString());
            data.add(row);
        }
        table.setItems(data);
        table.refresh();

        table.setOnMouseClicked((t) -> {
            if (t.getClickCount() == 2) {
                ObservableList<String> selectedRow = (ObservableList<String>) table.getSelectionModel().getSelectedItem();
                System.out.println(selectedRow.get(0) + " " + selectedRow.get(1) + " " + selectedRow.get(2));
            }

        });
    }

    @FXML
    private void btnSearchClicked(MouseEvent event) throws Exception {

        String sqlquery = "select * from allpatientdata where lower(" + cbSearchKrtierij.getSelectionModel().getSelectedItem() + ") = '" + txtSearch.getText().toLowerCase() + "';";
        System.out.println(sqlquery);
        table.getItems().clear();
        table.getColumns().clear();
        table.refresh();
        cbSearchKrtierij.getItems().clear();

        data = FXCollections.observableArrayList();

        for (int i = 0; i < getColCount("select * from allpatientdata where rolename = 'Pacijent'"); i++) {
            //We are using non property style for making dynamic table
            final int j = i;
            TableColumn col = new TableColumn(getColNames("select * from allpatientdata where rolename = 'Pacijent'").get(i));
            cbSearchKrtierij.getItems().add(getColNames("select * from allpatientdata where rolename = 'Pacijent'").get(i));
            col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {
                    return new SimpleStringProperty(param.getValue().get(j).toString());
                }

            });
            table.getColumns().add(col);
        }
        cbSearchKrtierij.getSelectionModel().select(1);
        ObservableList<User> pacijenti = getAllUsers(sqlquery);

        for (int i = 0; i < pacijenti.size(); i++) {
            ObservableList<String> row = FXCollections.observableArrayList();

            row.addAll(getAllStrings(pacijenti.get(i)));

            System.out.println(pacijenti.get(i));
            data.add(row);
        }
        table.setItems(data);
        table.refresh();

//        table.setOnMouseClicked((t) -> {
//            if (t.getClickCount() == 2) {
//                ObservableList<String> selectedRow = (ObservableList<String>) table.getSelectionModel().getSelectedItem();
//                System.out.println(selectedRow.get(0) + " - " + selectedRow.get(1) + " - " + selectedRow.get(2));
//
//                ObservableList<User> myUser = null;
//                try {
//                    myUser = getAllUsers("select * from alluserdata where id = " + selectedRow.get(0) + " ;");
//                    System.out.println(myUser);
//                } catch (Exception ex) {
//                    Logger.getLogger(PrimaryController.class.getName()).log(Level.SEVERE, null, ex);
//                }
//
////                transition(kalendarPane, updateUserPane);
//                txtUpdateIme.setText(myUser.get(0).getFirstName());
//                txtUpdatePrezime.setText(myUser.get(0).getLastName());
//
//                cbUpdateDateOfBirth.setValue(LocalDate.of(myUser.get(0).getDateOfBirth().getYear(), myUser.get(0).getDateOfBirth().getMonth(), myUser.get(0).getDateOfBirth().getDate()));
//                txtUpdateAdresa.setText(myUser.get(0).getAdress());
//                txtUpdateOib.setText(myUser.get(0).getOib());
//                txtUpdateEmail.setText(myUser.get(0).getEmail());
//                txtUpdatePhoneNumber.setText(myUser.get(0).getPhoneNumber());
//
//                ArrayList<String> spolovi = new ArrayList<>();
//                spolovi.add("MALE");
//                spolovi.add("FEMALE");
//
//                cbUpdateSpol.getItems().addAll(spolovi);
//                cbUpdateOdijel.setItems(getAllOdijeli());
//                cbUpdateZupanije.setItems(getAllStates());
//                cbUpdateZupanije.setOnAction((z) -> {
//                    cbUpdateGrad.getItems().clear();
//                    cbUpdateGrad.setItems(getAllCitiesFromState(cbUpdateZupanije.getSelectionModel().getSelectedItem().getId()));
//                });
//                cbUpdateRole.setItems(getAllRoles());
//                cbUpdateStatus.setItems(getAllStatusi());
//            }
//        });
    }

    @FXML
    private void terminiExited(MouseEvent event) {
        postaviVisuale(lblTermini, false, pregledajTermine, 1);
    }

    @FXML
    private void terminiEntered(MouseEvent event) {
        postaviVisuale(lblTermini, true, pregledajTermine, 1.5);
    }

    @FXML
    private void terminiClicked(MouseEvent event) {
        previousPane = doctorPane;
        transition(previousPane, kalendarPane);
        txtSearch.setVisible(false);
        cbSearchKrtierij.setVisible(false);
        buttonSearch.setVisible(false);
        setAllTermine("where doctorid = " + user.getId() + ";");
    }
}
