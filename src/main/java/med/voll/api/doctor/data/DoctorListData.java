package med.voll.api.doctor.data;

import med.voll.api.doctor.Doctor;
import med.voll.api.doctor.Speciality;

public record DoctorListData(Long id, String name, String email, String crm, Speciality speciality) {

    public DoctorListData(Doctor doctor){
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getSpeciality());
    }
}
