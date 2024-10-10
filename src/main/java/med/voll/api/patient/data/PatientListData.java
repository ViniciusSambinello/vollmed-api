package med.voll.api.patient.data;

import med.voll.api.patient.Patient;

public record PatientListData(String name, String email, String phone, String cpf) {

    public PatientListData(Patient patient){
        this(patient.getName(), patient.getEmail(), patient.getPhone(), patient.getCpf());
    }
}
