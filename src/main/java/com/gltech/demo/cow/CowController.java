package com.gltech.demo.cow;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class CowController {
    private final CowRepository cowRepository;

    public CowController(CowRepository cowRepository) {
        this.cowRepository = cowRepository;
    }

    @GetMapping("/cows")
    List<Cow> all() {
        return cowRepository.findAll();
    }

    @GetMapping("/cows/{id}")
    Cow getCow(@PathVariable Long id) {
        return cowRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not able to find record for the specified ID."));
    }

    @PostMapping("/cows")
    Cow newCow(@RequestBody Cow newCow) {
        return cowRepository.save(newCow);
    }

    @PutMapping("/cows/{id}")
    Cow updateCow(@RequestBody Cow newCow, @PathVariable Long id) {
        return cowRepository.findById(id)
                .map(cow -> {
                    cow.setTag(newCow.getTag());
                    return cowRepository.save(cow);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No able to find record for the specified ID."));
    }

    @DeleteMapping("/cows/{id}")
    void deleteCow(@PathVariable Long id) {
        cowRepository.deleteById(id);
    }
}
