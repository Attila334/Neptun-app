package controller;

import repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SubjectPageController {

    @Autowired
    private SubjectRepository subjectRepository;

    @GetMapping("/subjects")
    public String subjectPage(Model model) {
        model.addAttribute("subjects", subjectRepository.findAll());
        return "subjects"; // Betölti a subjects.html oldalt
    }
}
