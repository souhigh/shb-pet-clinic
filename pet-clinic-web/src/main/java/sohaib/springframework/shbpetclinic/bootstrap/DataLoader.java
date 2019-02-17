package sohaib.springframework.shbpetclinic.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sohaib.springframework.shbpetclinic.model.Owner;
import sohaib.springframework.shbpetclinic.model.PetType;
import sohaib.springframework.shbpetclinic.model.Vet;
import sohaib.springframework.shbpetclinic.services.OwnerService;
import sohaib.springframework.shbpetclinic.services.PetTypeService;
import sohaib.springframework.shbpetclinic.services.VetService;


@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;


    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);


        Owner owner1 = new Owner();
        owner1.setFirstName("Sohaib");
        owner1.setLastName("Drio");


        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Talha");
        owner2.setLastName("Drio");

        ownerService.save(owner2);

        System.out.println("Load Owners ...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Omar");
        vet1.setLastName("veti");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Salma");
        vet2.setLastName("Vitinira");

        vetService.save(vet2);

        System.out.println("Load Vets ...");


    }
}
