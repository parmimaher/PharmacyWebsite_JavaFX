package curs8;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.util.ArrayList;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author vali
 */
public class Curs8Controller implements Initializable {
	@FXML
    private TableView<Pharmacy> tabela_Pharmacies;
    @FXML
    private Tab tab_Pharmacies;
    @FXML
    private TableColumn<Pharmacy, Integer> atribut_id_pharmacy;
    @FXML
    private TableColumn<Pharmacy, String> atribut_pharmacy_name;
    @FXML
    private TableColumn<Pharmacy, String> atribut_pharmacy_website;
    @FXML
    private Button buton_IncarcarePharmacies;
    @FXML
    private Button buton_AddPharmacies;
    @FXML
    private Button buton_ModifyPharmacies;
    @FXML
    private Button buton_DeletePharmacies;
    @FXML
	private TextField inputpharmacy_name = new TextField();
    @FXML
	private TextField inputpharmacy_website = new TextField();
    @FXML
	private TextField inputpharmacy_name1 = new TextField();
    @FXML
	private TextField inputpharmacy_website1 = new TextField();
    @FXML
    private TableColumn<Pharmacy, CheckBox> atribut_SelectPharmacy;

    @FXML
    private TableView<Location> tabela_Locations;
    @FXML
    private Tab tab_Locations;
    @FXML
    private TableColumn<Location, Integer> atribut_id_pharmacyL;
    @FXML
    private TableColumn<Location, Integer> atribut_id_location;
    @FXML
    private TableColumn<Location, String> atribut_city;
    @FXML
    private TableColumn<Location, String> atribut_adress;
    @FXML
    private TableColumn<Location, String> atribut_phone;
    @FXML
    private Button buton_IncarcareLocations;
    @FXML
    private Button buton_AddLocations;
    @FXML
    private Button buton_ModifyLocations;
    @FXML
    private Button buton_DeleteLocations;
    @FXML
	private TextField inputid_pharmacy = new TextField();
	@FXML
	private TextField inputcity = new TextField();
	@FXML
	private TextField inputadress  = new TextField();
	@FXML
	private TextField inputphone = new TextField();
	@FXML
	private TextField inputcity1 = new TextField();
	@FXML
	private TextField inputadress1 = new TextField();
	@FXML
	private TextField inputphone1 = new TextField();
	@FXML
    private TableColumn<Location, CheckBox> atribut_SelectLocation;
    
    @FXML
    private TableView<Employee> tabela_Employees;
    @FXML
    private Tab tab_Employees;
    @FXML
    private TableColumn<Employee, Integer> atribut_id_pharmacyE;
    @FXML
    private TableColumn<Employee, Integer> atribut_id_employee;
    @FXML
    private TableColumn<Employee, String> atribut_employee_name;
    @FXML
    private TableColumn<Employee, String> atribut_employee_surname;
    @FXML
    private TableColumn<Employee, String> atribut_employee_position;
    @FXML
    private TableColumn<Employee, Integer> atribut_salary;
    @FXML
    private Button buton_IncarcareEmployees;
    @FXML
    private Button buton_AddEmployees;
    @FXML
    private Button buton_ModifyEmployees;
    @FXML
    private Button buton_DeleteEmployees;
    @FXML
	private TextField inputemployee_name = new TextField();
	@FXML
	private TextField inputemployee_surname = new TextField();
	@FXML
	private TextField inputemployee_position = new TextField();
	@FXML
	private TextField inputsalary = new TextField();
	@FXML
	private TextField inputemployee_name1 = new TextField();
	@FXML
	private TextField inputemployee_surname1 = new TextField();
	@FXML
	private TextField inputemployee_position1 = new TextField();
	@FXML
	private TextField inputsalary1 = new TextField();
	@FXML
	private TextField inputid_pharmacy1 = new TextField();
	@FXML
    private TableColumn<Employee, CheckBox> atribut_SelectEmployee;
    
    private ObservableList<Location> dateLocations;
    private ObservableList<Employee> dateEmployees;
    private ObservableList<Pharmacy> datePharmacies;
    private DBOperations jb;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        jb = new DBOperations();
    } 
    
    @FXML
    private void incarcaPharmacies(ActionEvent event) throws SQLException, Exception {
        jb.connect();
        datePharmacies = FXCollections.observableArrayList();

        ResultSet rs = jb.vedeTabel("pharmacies");
        //jb.afisare(rs);
        //System.out.println("test");
        while (rs.next()) {
        	CheckBox Select = new CheckBox("");
            datePharmacies.add(new Pharmacy(rs.getInt("id_pharmacy"), rs.getString("pharmacy_name"), 
            		rs.getString("pharmacy_website"), Select));
        }

        atribut_id_pharmacy.setCellValueFactory(new PropertyValueFactory<>("id_pharmacy"));
        atribut_pharmacy_name.setCellValueFactory(new PropertyValueFactory<>("pharmacy_name"));
        atribut_pharmacy_website.setCellValueFactory(new PropertyValueFactory<>("pharmacy_website"));
        atribut_SelectPharmacy.setCellValueFactory(new PropertyValueFactory<>("Select"));
        
        tabela_Pharmacies.setItems(null);
        tabela_Pharmacies.setItems(datePharmacies);
        jb.disconnect();
    }

    @FXML
    private void incarcaLocations(ActionEvent event) throws SQLException, Exception {
        jb.connect();
        dateLocations = FXCollections.observableArrayList();

        ResultSet rs = jb.vedeLocation();
        //jb.afisare(rs);
        //System.out.println("test");
        while (rs.next()) {
        	CheckBox Select = new CheckBox("");
            dateLocations.add(new Location(rs.getInt("id_location"), rs.getInt("id_pharmacy"), rs.getString("city"), rs.getString("adress"), rs.getString("phone"),Select));
        }

        atribut_id_location.setCellValueFactory(new PropertyValueFactory<>("id_location"));
        atribut_id_pharmacyL.setCellValueFactory(new PropertyValueFactory<>("id_pharmacy"));
        atribut_city.setCellValueFactory(new PropertyValueFactory<>("city"));
        atribut_adress.setCellValueFactory(new PropertyValueFactory<>("adress"));
        atribut_phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        atribut_SelectLocation.setCellValueFactory(new PropertyValueFactory<>("Select"));
        
        tabela_Locations.setItems(null);
        tabela_Locations.setItems(dateLocations);
        jb.disconnect();
    }

    @FXML
    private void incarcaEmployees(ActionEvent event) throws SQLException, Exception {
        jb.connect();
        dateEmployees = FXCollections.observableArrayList();
        
        ResultSet rs = jb.vedeEmployee();
        while (rs.next()) {
        	CheckBox Select = new CheckBox("");
            dateEmployees.add(new Employee(rs.getInt("id_employee"), rs.getInt("id_pharmacy"), 
            		rs.getString("employee_name"), rs.getString("employee_surname"), rs.getString("employee_position"), rs.getInt("salary"),Select));
        }

        atribut_id_employee.setCellValueFactory(new PropertyValueFactory<>("id_employee"));
        atribut_id_pharmacyE.setCellValueFactory(new PropertyValueFactory<>("id_pharmacy"));
        atribut_employee_name.setCellValueFactory(new PropertyValueFactory<>("employee_name"));
        atribut_employee_surname.setCellValueFactory(new PropertyValueFactory<>("employee_surname"));
        atribut_employee_position.setCellValueFactory(new PropertyValueFactory<>("employee_position"));
        atribut_salary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        atribut_SelectEmployee.setCellValueFactory(new PropertyValueFactory<>("Select"));

        tabela_Employees.setItems(null);
        tabela_Employees.setItems(dateEmployees);
        jb.disconnect();
    } 
   
   @FXML
   private void adaugaPharmacy(ActionEvent event) throws SQLException, Exception {
   	jb.connect();
       
       String pharmacy_name = inputpharmacy_name1.getText();
       String pharmacy_website = inputpharmacy_website1.getText();
       
       jb.adaugaPharmacy(pharmacy_name, pharmacy_website);
       
       datePharmacies = FXCollections.observableArrayList();

       ResultSet rs = jb.vedeTabel("pharmacies");
       while (rs.next()) {
       	CheckBox Select = new CheckBox("");
       		datePharmacies.add(new Pharmacy(rs.getInt("id_pharmacy"),rs.getString("pharmacy_name"), 
       				rs.getString("pharmacy_website"),Select)); 
       }
       
       inputpharmacy_name1.clear();
       inputpharmacy_website1.clear();
       
       tabela_Pharmacies.setItems(null);
       tabela_Pharmacies.setItems(datePharmacies);
       jb.disconnect();
   }
  
    
   @FXML
   private void adaugaLocation(ActionEvent event) throws SQLException, Exception {
	   jb.connect();
	   	
   	   Integer id_pharmacy = Integer.parseInt(inputid_pharmacy.getText());
       String city = inputcity1.getText();
       String adress = inputadress1.getText();
       String phone = inputphone1.getText();
       
       jb.adaugaLocation(id_pharmacy, city, adress, phone);
       
       dateLocations = FXCollections.observableArrayList();

       ResultSet rs = jb.vedeLocation();
       while (rs.next()) {
       	CheckBox Select = new CheckBox("");
        dateLocations.add(new Location(rs.getInt("id_location"),rs.getInt("id_pharmacy"), rs.getString("city"), 
        		rs.getString("adress"), rs.getString("phone"),Select));
       }
       
       inputid_pharmacy.clear();
       inputcity1.clear();
       inputadress1.clear();
       inputphone1.clear();
       
       tabela_Locations.setItems(null);
       tabela_Locations.setItems(dateLocations);
       jb.disconnect();
	   }
   
   @FXML
   private void adaugaEmployee(ActionEvent event) throws SQLException, Exception {
	   	jb.connect();
	   	
	   	   Integer id_pharmacy = Integer.parseInt(inputid_pharmacy1.getText());
	       String employee_name = inputemployee_name1.getText();
	       String employee_surname = inputemployee_surname1.getText();
	       String employee_position = inputemployee_position1.getText();
	       Integer salary = Integer.parseInt(inputsalary1.getText());
	       
	       jb.adaugaEmployee(id_pharmacy, employee_name, employee_surname, employee_position, salary);
	       
	       dateEmployees = FXCollections.observableArrayList();

	       ResultSet rs = jb.vedeEmployee();
	       while (rs.next()) {
	       	CheckBox Select = new CheckBox("");
            dateEmployees.add(new Employee(rs.getInt("id_employee"), rs.getInt("id_pharmacy"), rs.getString("employee_name"), rs.getString("employee_surname"), rs.getString("employee_position"), rs.getInt("salary"),Select));
	       }
	       
	       inputid_pharmacy1.clear();
	       inputemployee_name1.clear();
	       inputemployee_surname1.clear();
	       inputemployee_position1.clear();
	       inputsalary1.clear();
	       
	       tabela_Employees.setItems(null);
	       tabela_Employees.setItems(dateEmployees);
	       jb.disconnect();
	   }
  
  @FXML
  private void stergeEmployees(ActionEvent event) throws SQLException, Exception {
  	jb.connect();
      
      for(int i = 0; i < tabela_Employees.getItems().size(); i ++) {
      	if(tabela_Employees.getItems().get(i).getSelect().isSelected()) {
      		long pk = tabela_Employees.getItems().get(i).getid_employee();
      		jb.stergeTabela("employees", "id_employee", pk);
      	}
      }
      
    dateEmployees = FXCollections.observableArrayList();

    ResultSet rs = jb.vedeEmployee();
    while (rs.next()) {
    	CheckBox Select = new CheckBox("");
        dateEmployees.add(new Employee(rs.getInt("id_employee"), rs.getInt("id_pharmacy"), rs.getString("employee_name"), rs.getString("employee_surname"), rs.getString("employee_position"), rs.getInt("salary"),Select));
    }
    
    tabela_Employees.setItems(null);
    tabela_Employees.setItems(dateEmployees);
      
      
      jb.disconnect();
  }
  
  @FXML
  private void stergeLocations(ActionEvent event) throws SQLException, Exception {
  	jb.connect();
      
      for(int i = 0; i < tabela_Locations.getItems().size(); i ++) {
      	if(tabela_Locations.getItems().get(i).getSelect().isSelected()) {
      		long pk = tabela_Locations.getItems().get(i).getid_location();
      		jb.stergeTabela("locations", "id_location", pk);
      	}
      }
      
    dateLocations = FXCollections.observableArrayList();

    ResultSet rs = jb.vedeLocation();
    while (rs.next()) {
    	CheckBox Select = new CheckBox("");
        dateLocations.add(new Location(rs.getInt("id_location"),rs.getInt("id_pharmacy"), rs.getString("city"), rs.getString("adress"), rs.getString("phone"),Select));
    }
    
    tabela_Locations.setItems(null);
    tabela_Locations.setItems(dateLocations);
      
      
      jb.disconnect();
  }
  
  @FXML
  private void stergePharmacies(ActionEvent event) throws SQLException, Exception {
  	jb.connect();
      
      for(int i = 0; i < tabela_Pharmacies.getItems().size(); i ++) {
      	if(tabela_Pharmacies.getItems().get(i).getSelect().isSelected()) {
      		long pk = tabela_Pharmacies.getItems().get(i).getid_pharmacy();
      		jb.stergeTabela("pharmacies", "id_pharmacy", pk);
      	}
      }
      
      datePharmacies = FXCollections.observableArrayList();

      ResultSet rs = jb.vedeTabel("pharmacies");
      //jb.afisare(rs);
      //System.out.println("test");
      while (rs.next()) {
      	CheckBox Select = new CheckBox("");
          datePharmacies.add(new Pharmacy(rs.getInt("id_pharmacy"), rs.getString("pharmacy_name"), 
        		  rs.getString("pharmacy_website"), Select));
      }
      
      tabela_Pharmacies.setItems(null);
      tabela_Pharmacies.setItems(datePharmacies);      
      
      jb.disconnect();
  }
  
  @FXML
  private void modificaEmployees(ActionEvent event) throws SQLException, Exception {
  	jb.connect();
  	ArrayList<String> campuri = new ArrayList<>();
  	ArrayList<String> valori = new ArrayList<>();
  	
      String employee_name = inputemployee_name.getText();
      if(!employee_name.isEmpty()) {
      	valori.add(employee_name);
      	campuri.add("employee_name");
      }
      String employee_surname = inputemployee_surname.getText();
      if(!employee_surname.isEmpty()) {
      	valori.add(employee_surname);
      	campuri.add("employee_surname");
      }
      String employee_position = inputemployee_position.getText();
      if(!employee_position.isEmpty()) {
      	valori.add(employee_position);
      	campuri.add("employee_position");
      }
      String salary = inputsalary.getText();
      if(!salary.isEmpty()) {
      	valori.add(salary);
      	campuri.add("salary");
      }
      
      String[] campuri_array = campuri.toArray(new String[0]);
      String[] valori_array = valori.toArray(new String[0]);
      
      for(int i = 0; i < tabela_Employees.getItems().size(); i ++) {
      	if(tabela_Employees.getItems().get(i).getSelect().isSelected()) {
      		long pk = tabela_Employees.getItems().get(i).getid_employee();
      		jb.modificaTabela("employees", "id_employee", pk, campuri_array, valori_array);
      	}
      }
      
      dateEmployees = FXCollections.observableArrayList();

      ResultSet rs = jb.vedeEmployee();
      while (rs.next()) {
      	CheckBox Select = new CheckBox(null);
        dateEmployees.add(new Employee(rs.getInt("id_employee"), rs.getInt("id_pharmacy"), rs.getString("employee_name"), rs.getString("employee_surname"), rs.getString("employee_position"), rs.getInt("salary"),Select));
      }
      
      inputemployee_name.clear();
      inputemployee_surname.clear();
      inputemployee_position.clear();
      inputsalary.clear();
      
      tabela_Employees.setItems(null);
      tabela_Employees.setItems(dateEmployees);
      jb.disconnect();
  }
  
  @FXML
  private void modificaLocations(ActionEvent event) throws SQLException, Exception {
  	jb.connect();
  	ArrayList<String> campuri = new ArrayList<>();
  	ArrayList<String> valori = new ArrayList<>();
  	
      String city = inputcity.getText();
      if(!city.isEmpty()) {
      	valori.add(city);
      	campuri.add("city");
      }
      String adress = inputadress.getText();
      if(!adress.isEmpty()) {
      	valori.add(adress);
      	campuri.add("adress");
      }
      String phone = inputphone.getText();
      if(!phone.isEmpty()) {
      	valori.add(phone);
      	campuri.add("phone");
      }
      
      String[] campuri_array = campuri.toArray(new String[0]);
      String[] valori_array = valori.toArray(new String[0]);
      
      for(int i = 0; i < tabela_Locations.getItems().size(); i ++) {
      	if(tabela_Locations.getItems().get(i).getSelect().isSelected()) {
      		long pk = tabela_Locations.getItems().get(i).getid_location();
      		jb.modificaTabela("locations", "id_location", pk, campuri_array, valori_array);
      	}
      }
      
      dateLocations = FXCollections.observableArrayList();

      ResultSet rs = jb.vedeLocation();
      while (rs.next()) {
      	CheckBox Select = new CheckBox("");
        dateLocations.add(new Location(rs.getInt("id_location"),rs.getInt("id_pharmacy"), rs.getString("city"), 
        		rs.getString("adress"), rs.getString("phone"),Select));
      }
      
      inputcity.clear();
      inputadress.clear();
      inputphone.clear();
      
      tabela_Locations.setItems(null);
      tabela_Locations.setItems(dateLocations);
      jb.disconnect();
  }
  
  @FXML
  private void modificaPharmacies(ActionEvent event) throws SQLException, Exception {
  	jb.connect();
  	ArrayList<String> campuri = new ArrayList<>();
  	ArrayList<String> valori = new ArrayList<>();
  	
      String pharmacy_name = inputpharmacy_name.getText();
      if(!pharmacy_name.isEmpty()) {
      	valori.add(pharmacy_name);
      	campuri.add("pharmacy_name");
      }
      String pharmacy_website = inputpharmacy_website.getText();
      if(!pharmacy_website.isEmpty()) {
      	valori.add(pharmacy_website);
      	campuri.add("pharmacy_website");
      }
      
      String[] campuri_array = campuri.toArray(new String[0]);
      String[] valori_array = valori.toArray(new String[0]);
      
      for(int i = 0; i < tabela_Pharmacies.getItems().size(); i ++) {
      	if(tabela_Pharmacies.getItems().get(i).getSelect().isSelected()) {
      		long pk = tabela_Pharmacies.getItems().get(i).getid_pharmacy();
      		jb.modificaTabela("pharmacies", "id_pharmacy", pk, campuri_array, valori_array);
      	}
      }
      
      datePharmacies = FXCollections.observableArrayList();

      ResultSet rs = jb.vedeTabel("pharmacies");
      //jb.afisare(rs);
      //System.out.println("test");
      while (rs.next()) {
      	CheckBox Select = new CheckBox("");
          datePharmacies.add(new Pharmacy(rs.getInt("id_pharmacy"), rs.getString("pharmacy_name"), rs.getString("pharmacy_website"), Select));
      }
      
      inputpharmacy_name.clear();
      inputpharmacy_website.clear();
      
      tabela_Pharmacies.setItems(null);
      tabela_Pharmacies.setItems(datePharmacies);
      jb.disconnect();
  }

}