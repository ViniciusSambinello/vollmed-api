package med.voll.api.patient;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.address.Address;
import med.voll.api.patient.data.PatientRegisterData;
import med.voll.api.patient.data.PatientUpdateData;

import static jakarta.persistence.GenerationType.IDENTITY;

@Table(name = "patients")
@Entity(name = "Patient")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Patient {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;
    private String cpf;

    @Embedded
    private Address address;

    private boolean active;

    public Patient(PatientRegisterData data) {
        active = true;
        name = data.name();
        email = data.email();
        phone = data.phone();
        cpf = data.cpf();

        address = new Address(data.addressData());
    }

    public void updateData(PatientUpdateData data) {
        if (data.name() != null){
            name = data.name();
        }

        if (data.phone() != null){
            phone = data.phone();
        }

        if (data.addressData() != null){
            address.updateData(data.addressData());
        }
    }

    public void delete() {
        active = false;
    }
}
