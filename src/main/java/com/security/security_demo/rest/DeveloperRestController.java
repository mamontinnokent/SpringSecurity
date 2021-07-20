package com.security.security_demo.rest;


import com.security.security_demo.model.Developer;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/v1/developers")
public class DeveloperRestController {
    private final List<Developer> DEVELOPERS = Stream.of(
            new Developer(1l, "Ivan", "Ivanov"),
            new Developer(2l, "Petr", "Petrov"),
            new Developer(3l, "Sergey", "Sergeev")
    ).collect(Collectors.toList());


    @GetMapping
    public List<Developer> getAll() {
        return DEVELOPERS;
    }

    @GetMapping("/{id}")
    public Developer getById(@PathVariable Long id) {
        return DEVELOPERS.stream().filter(developer -> developer.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @PostMapping("/add")
    public Developer add(@RequestBody Developer developer) {
        DEVELOPERS.add(developer);
        return developer;
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id) {
        return DEVELOPERS.remove(id);
    }
}
