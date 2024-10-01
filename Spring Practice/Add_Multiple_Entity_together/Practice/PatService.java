package com.Acciojob_Practice_Project.July2024.Practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatService {

    @Autowired
    private PatRepo patRepo;

    @Autowired
    private DrRepo drRepo;

    @Autowired HosRepo hospitalRepo;

    public String addAllThreeEntityInOne(CombineEntity combineEntity){
        Patient patient=combineEntity.getPatient();
        Doctor dr=combineEntity.getDoctor();
        Hospital hospital=combineEntity.getHospital();
        if(patient!=null)
            patient=patRepo.save(patient);
        if(dr!=null)
            dr=drRepo.save(dr);
        if(hospital!=null)
            hospital=hospitalRepo.save(hospital);
        return "Entity added successfully";
    }
}
