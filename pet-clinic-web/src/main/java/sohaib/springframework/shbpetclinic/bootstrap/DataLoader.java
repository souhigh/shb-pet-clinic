package sohaib.springframework.shbpetclinic.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sohaib.springframework.shbpetclinic.model.*;
import sohaib.springframework.shbpetclinic.services.OwnerService;
import sohaib.springframework.shbpetclinic.services.PetTypeService;
import sohaib.springframework.shbpetclinic.services.SpecialityService;
import sohaib.springframework.shbpetclinic.services.VetService;

import java.time.LocalDate;


@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

@Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count =  petTypeService.findAll().size();
        if (count == 0){
            LoadData();
        }
    }

    private void LoadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);


        Owner owner1 = new Owner();
        owner1.setFirstName("Sohaib");
        owner1.setLastName("Drio");
        owner1.setAddress("Complexe Youssef");
        owner1.setCity("Marrakesh");
        owner1.setTelephone("0699164261");

        Pet sohaPet = new Pet();
        sohaPet.setPetType(savedCatType);
        sohaPet.setOwner(owner1);
        sohaPet.setBirthDate(LocalDate.now());
        sohaPet.setName("Minouch");
        owner1.getPets().add(sohaPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Talha");
        owner2.setLastName("Drio");
        owner2.setAddress("Zaraba");
        owner2.setCity("Youssoufia");
        owner2.setTelephone("06171727339");

        Pet talhaPet = new Pet();
        talhaPet.setPetType(savedDogType);
        talhaPet.setOwner(owner2);
        talhaPet.setBirthDate(LocalDate.now());
        talhaPet.setName("Caniche");
        owner2.getPets().add(talhaPet);

        ownerService.save(owner2);

        System.out.println("Load Owners ...");

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadioligy = specialityService.save(radiology);


        Speciality surgey = new Speciality();
        radiology.setDescription("Surgey");
        Speciality savedSurgey = specialityService.save(surgey);


        Vet vet1 = new Vet();
        vet1.setFirstName("Omar");
        vet1.setLastName("veti");
        vet1.getSpecialties().add(savedRadioligy);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Salma");
        vet2.setLastName("Vitinira");
        vet2.getSpecialties().add(savedSurgey);
        vetService.save(vet2);

        System.out.println("Load Vets ...");
    }
}
