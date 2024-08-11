package service;

import Model.PrimaryEntity;
import Model.SecondaryEntity;
import Repository.PrimaryEntityRepository;
import Repository.SecondaryEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyService {

    @Autowired
    private PrimaryEntityRepository primaryRepository;

    @Autowired
    private SecondaryEntityRepository secondaryRepository;

    // Example method to save an entity to the primary data source
    public PrimaryEntity savePrimaryEntity(PrimaryEntity primaryEntity) {
        return primaryRepository.save(primaryEntity);
    }

    // Example method to save an entity to the secondary data source
    public SecondaryEntity saveSecondaryEntity(SecondaryEntity secondaryEntity) {
        return secondaryRepository.save(secondaryEntity);
    }

    // Example method to find all entities from the primary data source
    public List<PrimaryEntity> findAllPrimaryEntities() {
        return primaryRepository.findAll();
    }

    // Example method to find all entities from the secondary data source
    public List<SecondaryEntity> findAllSecondaryEntities() {
        return secondaryRepository.findAll();
    }

    // Example method to find an entity by ID in the primary data source
    public PrimaryEntity findPrimaryEntityById(Long id) {
        return primaryRepository.findById(id).orElse(null);
    }

    // Example method to find an entity by ID in the secondary data source
    public SecondaryEntity findSecondaryEntityById(Long id) {
        return secondaryRepository.findById(id).orElse(null);
    }
}
