package org.example.livedemoiot2025.controllers;


import org.example.livedemoiot2025.models.Kpi;
import org.example.livedemoiot2025.repos.KpiRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class KpiController {

    private KpiRepo repo;
    private static final Logger logger = LoggerFactory.getLogger(KpiController.class);

    public KpiController(KpiRepo repository) {
        this.repo = repository;
    }


    @RequestMapping("/kpis")
    public List<Kpi> getALlBooks(){
        return repo.findAll();
    }

    @RequestMapping("/kpis/{id}")
    public Kpi getKpiById(@PathVariable Long id){
        return repo.findById(id).get();
    }



    @RequestMapping("/kpis/delete/{id}")
    public List<Kpi> deleteKpiById(@PathVariable Long id){
        repo.deleteById(id);
        return repo.findAll();
    }

    @PostMapping("/kpi/add")
    public List<Kpi> addBook(@RequestBody Kpi b){
        repo.save(b);
        return repo.findAll();
    }


}
