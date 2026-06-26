package gymmanagementsystemcom.example.demo.repository;

import gymmanagementsystemcom.example.demo.model.GymClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GymClassRepository extends JpaRepository<GymClass, Long> {
}