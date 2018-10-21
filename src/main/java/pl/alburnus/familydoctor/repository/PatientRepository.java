package pl.alburnus.familydoctor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.alburnus.familydoctor.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    // FIXME ignoreCaseSensitive
    Boolean existsByNicknameIsNot(String nickname);

}
