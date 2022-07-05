package melanich.SAO_web.controller;

import melanich.SAO_web.model.Animal;
import melanich.SAO_web.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/animals")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @GetMapping("/add")
    public String showAnimalForm(Model model) {
        Animal animal = new Animal();
        model.addAttribute("animal", animal);
        return "animal";
    }

    @PostMapping("/add")
    public String addAnimal(@ModelAttribute(value = "animal") Animal animal) {
        animalService.saveOrUpdate(animal);
        return "redirect:/animals/getAll";
    }

    @GetMapping("/edit/{id}")
    @ResponseBody
    public String showAnimal(Model model, @PathVariable(value = "id") Long id) {
        Animal animal = animalService.getById(id);
        return animal.toString();
    }

    @GetMapping("/getAll")
    @ResponseBody
    public List<Animal> animals(){
        return animalService.animals();
    }
}
