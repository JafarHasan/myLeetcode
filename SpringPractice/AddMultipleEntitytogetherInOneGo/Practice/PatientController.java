package com.Acciojob_Practice_Project.July2024.Practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("AddAllEntity")
public class PatientController {
    @Autowired
    private PatService patService;

    @PostMapping("add")
    public String addAllThreeEntityInOne(@RequestBody CombineEntity combineEntity){
        return patService.addAllThreeEntityInOne(combineEntity);
    }
}
