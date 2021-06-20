package com.techelevator.pet;

// POJO for the pet table

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Pet {

    private Long petId;

    private String name;

    private int petType;

    private int ownerId;

    private LocalDateTime whenAdded;

    private LocalDateTime lastUpdate;

    public Long getPetId() {
        return petId;
    }

    public void setPetId(Long petId) {
        this.petId = petId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPetType() {
        return petType;
    }

    public void setPetType(int petType) {
        this.petType = petType;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public LocalDateTime getWhenAdded() {
        return whenAdded;
    }

    public void setWhenAdded(LocalDateTime whenAdded) {
        this.whenAdded = whenAdded;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "pet{" +
                "petId=" + petId +
                ", name='" + name + '\'' +
                ", petType=" + petType +
                ", ownerId=" + ownerId +
                ", whenAdded=" + whenAdded +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
