package com.techelevator;

public class FruitTree {

        private String typeOfFruit;

        private  int piecesOfFruitLeft;




    public String getTypeOfFruit() {
        return typeOfFruit;
    }

    public int getPiecesOfFruitLeft() {
        return piecesOfFruitLeft;
    }

    public boolean pickFruit(int numberOfPiecesToRemove) {

        if (piecesOfFruitLeft >= numberOfPiecesToRemove) {
            piecesOfFruitLeft = piecesOfFruitLeft - numberOfPiecesToRemove;
            return true;
        }
        else {
            return false;
        }



    }



    public FruitTree () {

        typeOfFruit = null;
        piecesOfFruitLeft = 0;

    }

    public FruitTree (String fruitType, int startingPiecesOfFruit) {

        typeOfFruit = fruitType;
        piecesOfFruitLeft = startingPiecesOfFruit;


    }





}
