package com.example.workintech.OdevPazartesi.animalController;

import com.example.workintech.OdevPazartesi.animalController.Animal;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/workintech/animal")
public class AnimalController {
    private Map<Integer, Animal> animals = new HashMap<>();

    @GetMapping
    public List<Animal> animalList(){
        return animals.values().stream().toList();
    }

    @GetMapping("/{id}")
    public Animal find(@PathVariable Integer id){
        return animals.get(id);
    }

    @PostMapping
    public void addAnimal(@RequestBody Animal animal){
        animals.put(animal.getId(), animal);
    }

    @PutMapping("/{id}")
    public void updateAnimal(@PathVariable Integer id , @RequestBody Animal animal){
        if(animals.containsKey(id)){
            animals.put(id , animal);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteAnimal(@PathVariable Integer id ){
        animals.remove(id);
    }
}