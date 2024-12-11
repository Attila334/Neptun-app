package controller;

import entity.Subject;
import repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subjects")
public class SubjectController {

    @Autowired
    private SubjectRepository subjectRepository;

    @GetMapping
    public List<Subject> listSubjects() {
        return subjectRepository.findAll();
    }

    @PostMapping("/enroll")
    public ResponseEntity<String> enrollSubject(@RequestBody Subject subject) {
        if (subjectRepository.existsById(subject.getId())) {
            return ResponseEntity.ok("Enrolled in " + subject.getName());
        }
        return ResponseEntity.status(404).body("Subject not found");
    }
}