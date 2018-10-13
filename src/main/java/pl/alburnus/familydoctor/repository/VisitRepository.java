package pl.alburnus.familydoctor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.alburnus.familydoctor.model.Visit;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Long> {
}
