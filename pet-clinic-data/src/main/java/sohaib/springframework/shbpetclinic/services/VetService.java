package sohaib.springframework.shbpetclinic.services;

import sohaib.springframework.shbpetclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}
