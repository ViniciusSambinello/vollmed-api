package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.doctor.Doctor;
import med.voll.api.doctor.data.DoctorListData;
import med.voll.api.doctor.data.DoctorRegisterData;
import med.voll.api.doctor.DoctorRepository;
import med.voll.api.doctor.data.DoctorUpdateData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("medicos")
public class DoctorController {

    @Autowired
    private DoctorRepository repository;

    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid DoctorRegisterData data){
        repository.save(new Doctor(data));
    }

    @GetMapping
    public Page<DoctorListData> list(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable){
        return repository.findAllByActiveTrue(pageable).map(DoctorListData::new);
    }

    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid DoctorUpdateData data){
        final Doctor doctor = repository.getReferenceById(data.id());
        doctor.updateData(data);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable long id){
        final Doctor doctor = repository.getReferenceById(id);
        doctor.delete();
    }

//    @DeleteMapping("/{id}")
//    @Transactional
//    public void delete(@PathVariable Long id){
//        repository.deleteById(id);
//    }
}
