package sohaib.springframework.shbpetclinic.services;

import sohaib.springframework.shbpetclinic.model.Owner;



public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);


}
