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
public class Pharmacy {

    private final IntegerProperty id_pharmacy;
    private final StringProperty pharmacy_name;
    private final StringProperty pharmacy_website;
    private ObjectProperty<CheckBox> Select;

    public Pharmacy(Integer id_pharmacy, String pharmacy_name, String pharmacy_website, CheckBox Select) {
        this.id_pharmacy = new SimpleIntegerProperty(id_pharmacy);
        this.pharmacy_name = new SimpleStringProperty(pharmacy_name);
        this.pharmacy_website = new SimpleStringProperty(pharmacy_website);
        this.Select = new SimpleObjectProperty<>(Select);
    }

    public Integer getid_pharmacy() {
        return id_pharmacy.get();
    }

    public String getpharmacy_name() {
        return pharmacy_name.get();
    }

    public String getpharmacy_website() {
        return pharmacy_website.get();
    }
    
    
    

    public void setid_pharmacy(Integer valoare) {
        id_pharmacy.set(valoare);
    }

    public void setpharmacy_name(String valoare) {
        pharmacy_name.set(valoare);
    }

    public void setpharmacy_website(String valoare) {
        pharmacy_website.set(valoare);
    }
    
    
    

    public IntegerProperty id_pharmacyProperty() {
        return id_pharmacy;
    }

    public StringProperty pharmacy_nameProperty() {
        return pharmacy_name;
    }

    public StringProperty pharmacy_websiteProperty() {
        return pharmacy_website;
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