package melanich.SAO_web.service;

import melanich.SAO_web.model.Animal;
import melanich.SAO_web.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    public Animal getById(Long id){
        return animalRepository.findById(id).orElse(null);
    }

    public List<Animal> animals (){
        return animalRepository.findAll();
    }

    public void saveOrUpdate(Animal animal) {
        animalRepository.save(animal);
    }

}
