package sohaib.springframework.shbpetclinic.services;

import sohaib.springframework.shbpetclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
