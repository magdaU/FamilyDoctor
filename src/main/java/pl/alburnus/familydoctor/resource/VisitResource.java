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

    public VisitResource(VisitRepository visitRepository){
        this.visitRepository=visitRepository;
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Visit> getAll(){
        return visitRepository.findAll();
    }
    @PostMapping
    public void create(@RequestBody Visit visit){
        visitRepository.save(visit);
    }

}
