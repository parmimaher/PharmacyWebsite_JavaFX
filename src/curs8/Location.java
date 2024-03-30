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
public class Location {

    private final IntegerProperty id_location;
    private final IntegerProperty id_pharmacy;
    private final StringProperty city;
    private final StringProperty adress;
    private final StringProperty phone;
    private ObjectProperty<CheckBox> Select;

    public Location(Integer id_location, Integer id_pharmacy, String city, String adress, String phone, CheckBox Select) {
    	this.id_location = new SimpleIntegerProperty(id_location);
    	this.id_pharmacy = new SimpleIntegerProperty(id_pharmacy);
        this.city = new SimpleStringProperty(city);
        this.adress = new SimpleStringProperty(adress);
        this.phone = new SimpleStringProperty(phone);
        this.Select = new SimpleObjectProperty<>(Select);
    }


    public Integer getid_location() {
        return id_location.get();
    }
    
    public Integer getid_pharmacy() {
        return id_pharmacy.get();
    }
    
    public String getcity() {
        return city.get();
    }

    public String getadress() {
        return adress.get();
    }

    public String getphone() {
        return phone.get();
    }


    
    public void setid_location(Integer valoare) {
        id_location.set(valoare);
    }

    public void setid_pharmacy(Integer valoare) {
    	id_pharmacy.set(valoare);
    }
    
    public void setcity(String valoare) {
        city.set(valoare);
    }

    public void setadress(String valoare) {
        adress.set(valoare);
    }

    public void setphone(String valoare) {
        phone.set(valoare);
    }
    
    
    

    public IntegerProperty id_locationProperty() {
        return id_location;
    }
    
    public IntegerProperty id_pharmacyProperty() {
        return id_pharmacy;
    }

    public StringProperty cityProperty() {
        return city;
    }

    public StringProperty adressProperty() {
        return adress;
    }

    public StringProperty phoneProperty() {
        return phone;
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