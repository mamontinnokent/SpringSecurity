package com.security.security_demo.rest;

<<<<<<< Updated upstream
import com.security.security_demo.entity.Developer;
=======
import com.security.security_demo.model.Developer;
>>>>>>> Stashed changes
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/v1/developers")
public class DeveloperRestController {
    private List<Developer> DEVELOPERS = Stream.of(
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
}
