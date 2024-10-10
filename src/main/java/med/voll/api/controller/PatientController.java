package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.patient.Patient;
import med.voll.api.patient.data.PatientListData;
import med.voll.api.patient.data.PatientRegisterData;
import med.voll.api.patient.PatientRepository;
import med.voll.api.patient.data.PatientUpdateData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pacientes")
public class PatientController {

    @Autowired
    private PatientRepository repository;

    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid PatientRegisterData data){
        repository.save(new Patient(data));
    }

    @GetMapping
    public Page<PatientListData> list(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable){
        return repository.findAll(pageable).map(PatientListData::new);
    }

    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid PatientUpdateData data){
        final Patient patient = repository.getReferenceById(data.id());
        patient.updateData(data);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable long id){
        final Patient patient = repository.getReferenceById(id);
        patient.delete();
    }
}
