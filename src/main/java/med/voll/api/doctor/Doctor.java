package med.voll.api.doctor;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.address.Address;
import med.voll.api.doctor.data.DoctorRegisterData;
import med.voll.api.doctor.data.DoctorUpdateData;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.IDENTITY;

@Table(name = "doctors")
@Entity(name = "Doctor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Doctor {

    @Id @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;
    private String crm;

    @Enumerated(STRING)
    private Speciality speciality;

    @Embedded
    private Address address;

    private boolean active;

    public Doctor(DoctorRegisterData data) {
        active = true;
        name = data.name();
        email = data.email();
        phone = data.phone();
        crm = data.crm();

        speciality = data.speciality();

        address = new Address(data.addressData());
    }

    public void updateData(DoctorUpdateData data){
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
        this.active = false;
    }
}
