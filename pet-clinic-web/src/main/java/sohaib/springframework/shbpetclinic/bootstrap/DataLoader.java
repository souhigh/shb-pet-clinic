package sohaib.springframework.shbpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sohaib.springframework.shbpetclinic.model.Owner;
import sohaib.springframework.shbpetclinic.model.Vet;
import sohaib.springframework.shbpetclinic.services.OwnerService;
import sohaib.springframework.shbpetclinic.services.VetService;
import sohaib.springframework.shbpetclinic.services.map.OwnerServiceMap;
import sohaib.springframework.shbpetclinic.services.map.VetServiceMap;


@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }


    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Sohaib");
        owner1.setLastName("Drio");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Talha");
        owner2.setLastName("Drio");

        ownerService.save(owner2);

        System.out.println("Load Owners ...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Omar");
        vet1.setLastName("veti");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Salma");
        vet2.setLastName("Vitinira");

        vetService.save(vet2);

        System.out.println("Load Vets ...");


    }
}
