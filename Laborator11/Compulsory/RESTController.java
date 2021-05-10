package com.example.laborator11;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/people")
public class RESTController {
    private final List<Person> people = new ArrayList<>();


    public RESTController() {
        people.add(new Person(1, "Marcus"));
        people.add(new Person(2, "Denis"));
        people.add(new Person(3, "Lucian"));
    }

    public Person findById(Integer id) {
        for (Person it : people) {
            if (it.getId().equals(id)) {
                return it;
            }
        }
        return null;
    }


    @GetMapping
    public List<Person> getProducts() {
        return people;
    }

    @GetMapping("/count")
    public int countProducts() {
        return people.size();
    }

    @GetMapping("/{id}")
    public Person getProduct(@PathVariable("id") int id) {
        return people.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    @PostMapping
    public int createProduct(@RequestParam String name) {
        int id = 1 + people.size();
        people.add(new Person(id, name));
        return id;
    }

    @PostMapping(value = "/obj", consumes = "application/json")
    public ResponseEntity<String> createProduct(@RequestBody Person product) {
        people.add(product);
        return new ResponseEntity<>("Product created successfully", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestParam String name) {
        Person person = findById(id);
        if (person == null) {
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        }
        person.setName(name);
        return new ResponseEntity<>("Product updated successsfully", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        Person person = findById(id);
        if (person == null) {
            return new ResponseEntity<>("Product not found", HttpStatus.GONE);
        }
        people.remove(person);
        return new ResponseEntity<>("Product removed", HttpStatus.OK);
    }
}
