package Repository;

import Model.SecondaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecondaryEntityRepository extends JpaRepository<SecondaryEntity, Long> {
}