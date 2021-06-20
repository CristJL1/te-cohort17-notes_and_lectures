package com.techelevator.pet;

import java.util.List;

public interface PetDAO {

    // retrieve all pets
    List<Pet> getAllPets();

    // get a specific pet
    Pet getAPet (Long petId);

    // add a pet
    void addPet (Pet aPet);

    //update a pet
    Pet updatePet (Pet aPet);


}
