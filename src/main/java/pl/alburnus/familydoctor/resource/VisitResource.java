package pl.alburnus.familydoctor.resource;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.alburnus.familydoctor.model.Visit;
import pl.alburnus.familydoctor.repository.VisitRepository;

import java.util.List;

@RestController
@RequestMapping("/api/v1/visit")
public class VisitResource {

    private final VisitRepository visitRepository;

    public VisitResource(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @GetMapping("/patient/{idPatient}")
    @ResponseStatus(HttpStatus.OK)
    public List<Visit> getAllVisitByPatientId(@PathVariable("idPatient") Long idPatient) {
        return visitRepository.getAllByPatientId(idPatient);
    }

    @PostMapping
    public void create(@RequestBody Visit visit) {
        visitRepository.save(visit);
    }

    @DeleteMapping("/{visitId}")
    public void delete(@PathVariable("visitId") Long idVisit) {
        visitRepository.deleteById(idVisit);
    }

    @PutMapping
    public void update(@RequestBody Visit visit) {

        visitRepository.getOne(visit.getId());
    }
}
