package med.voll.api.address;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String street, district, zipcode, city, uf, number, complement;

    public Address(AddressData data){
        this.street = data.street();
        this.district = data.district();
        this.zipcode = data.zipcode();
        this.city = data.city();
        this.uf = data.uf();
        this.number = data.number();
        this.complement = data.complement();
    }

    public void updateData(AddressData addressData) {
        if (addressData.street() != null){
            street = addressData.street();
        }
        if (addressData.district() != null){
            street = addressData.district();
        }
        if (addressData.zipcode() != null){
            street = addressData.zipcode();
        }
        if (addressData.city() != null){
            street = addressData.city();
        }
        if (addressData.uf() != null){
            street = addressData.uf();
        }
        if (addressData.number() != null){
            street = addressData.number();
        }
        if (addressData.complement() != null){
            street = addressData.complement();
        }
    }
}
