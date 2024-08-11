package controller;

import Model.PrimaryEntity;
import Model.SecondaryEntity;
import service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyController {

    @Autowired
    private MyService myService;

    // Endpoint to save a primary entity
    @PostMapping("/primary")
    public PrimaryEntity savePrimaryEntity(@RequestBody PrimaryEntity primaryEntity) {
        return myService.savePrimaryEntity(primaryEntity);
    }

    // Endpoint to save a secondary entity
    @PostMapping("/secondary")
    public SecondaryEntity saveSecondaryEntity(@RequestBody SecondaryEntity secondaryEntity) {
        return myService.saveSecondaryEntity(secondaryEntity);
    }

    // Endpoint to get all primary entities
    @GetMapping("/primary")
    public List<PrimaryEntity> getAllPrimaryEntities() {
        return myService.findAllPrimaryEntities();
    }

    // Endpoint to get all secondary entities
    @GetMapping("/secondary")
    public List<SecondaryEntity> getAllSecondaryEntities() {
        return myService.findAllSecondaryEntities();
    }

    // Endpoint to get a primary entity by ID
    @GetMapping("/primary/{id}")
    public PrimaryEntity getPrimaryEntityById(@PathVariable Long id) {
        return myService.findPrimaryEntityById(id);
    }

    // Endpoint to get a secondary entity by ID
    @GetMapping("/secondary/{id}")
    public SecondaryEntity getSecondaryEntityById(@PathVariable Long id) {
        return myService.findSecondaryEntityById(id);
    }
}
