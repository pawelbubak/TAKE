package lab.bookings.controllers;

import lab.bookings.models.Apartment;
import lab.bookings.repositories.ApartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/apartments")
public class ApartmentController {
    private final ApartmentRepository repository;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("apartment", new Apartment());
        model.addAttribute("apartments", repository.findAll());
        return "apartments";
    }

    @PostMapping
    public String create(@Valid Apartment apartment, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("apartments", repository.findAll());
            return "apartments";
        } else {
            repository.save(apartment);
            return "redirect:/apartments";
        }
    }
}

