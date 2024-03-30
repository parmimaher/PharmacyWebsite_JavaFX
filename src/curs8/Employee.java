package curs8;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.CheckBox;

/**
 *
 * @author vali
 */
public class Employee {

    private final IntegerProperty id_employee;
    private final IntegerProperty id_pharmacy;
    private final StringProperty employee_name;
    private final StringProperty employee_surname;
    private final StringProperty employee_position;
    private final IntegerProperty salary;
    private ObjectProperty<CheckBox> Select;
    
    public Employee(Integer id_employee,Integer id_pharmacy, String employee_name, String employee_surname, String employee_position, Integer salary, CheckBox Select) {
    	this.id_employee = new SimpleIntegerProperty(id_employee);
    	this.id_pharmacy = new SimpleIntegerProperty(id_pharmacy);
        this.employee_name = new SimpleStringProperty(employee_name);
        this.employee_surname = new SimpleStringProperty(employee_surname);
        this.employee_position = new SimpleStringProperty(employee_position);
        this.salary = new SimpleIntegerProperty(salary);
        this.Select = new SimpleObjectProperty<>(Select);
    }
    
    public Integer getid_employee() {
        return id_employee.get();
    }
    
    public Integer getid_pharmacy() {
        return id_pharmacy.get();
    }

    public String getemployee_name() {
        return employee_name.get();
    }

    public String getemployee_surname() {
        return employee_surname.get();
    }

    public String getemployee_position() {
        return employee_position.get();
    }
    
    public Integer getsalary() {
        return salary.get();
    }


    
    public void setid_employee(Integer valoare) {
        id_employee.set(valoare);
    }
    
    public void setid_pharmacy(Integer valoare) {
    	id_pharmacy.set(valoare);
    }

    public void setemployee_name(String valoare) {
        employee_name.set(valoare);
    }

    public void setemployee_surname(String valoare) {
        employee_surname.set(valoare);
    }

    public void setemployee_position(String valoare) {
        employee_position.set(valoare);
    }
    
    public void setsalary(Integer valoare) {
        salary.set(valoare);
    }

    
    
    
    public IntegerProperty id_employeeProperty() {
        return id_employee;
    }
    
    public IntegerProperty id_pharmacyProperty() {
        return id_pharmacy;
    }


    public StringProperty employee_nameProperty() {
        return employee_name;
    }

    public StringProperty employee_surnameProperty() {
        return employee_surname;
    }

    public StringProperty employee_positionProperty() {
        return employee_position;
    }
    
    public IntegerProperty salaryProperty() {
        return salary;
    }
    
    
    
    
    public CheckBox getSelect() {
        return Select.get();
    }
    
    public void setSelect(CheckBox selected) {
		Select.set(selected);
	}
    
    public ObjectProperty<CheckBox> SelectProperty() {
        return Select;
    }
}