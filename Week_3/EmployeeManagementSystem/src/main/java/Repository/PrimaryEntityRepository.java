package Repository;

import Model.PrimaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrimaryEntityRepository extends JpaRepository<PrimaryEntity, Long> {
}