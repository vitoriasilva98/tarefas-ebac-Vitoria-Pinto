package br.com.ebac.animal_service.controllers;

import br.com.ebac.animal_service.dto.FuncionarioDTO;
import br.com.ebac.animal_service.entidades.Animal;
import br.com.ebac.animal_service.repositorios.AnimalRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/animais")
public class AnimalController {

    private AnimalRepository repository;

    public AnimalController(AnimalRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    private List<Animal> findAll() {
        return repository.findAll();
    }

    @PostMapping
    private Animal create(@RequestBody Animal animal) {
        return repository.save(animal);
    }

    @GetMapping("not-adopted")
    private List<Animal> findNotAdopted() {
        return repository.findNotAdopted();
    }

    @GetMapping("adopted")
    private List<Animal> findAdopted() {
        return repository.findAdopted();
    }

    // ex: http://localhost:8081/animais/count-rescued-by-employee?startDate=2024-01-01&endDate=2024-07-06
    @GetMapping("count-rescued-by-employee")
    private List<FuncionarioDTO> create(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return repository.countAnimalsResgatadosByFuncionarioAndDateRange(startDate, endDate);
    }
}
