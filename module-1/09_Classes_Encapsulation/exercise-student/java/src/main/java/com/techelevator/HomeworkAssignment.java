package com.techelevator;

public class HomeworkAssignment {

        private int earnedMarks;

        private int possibleMarks;

        private String submitterName;

        private String letterGrade;

    public int getEarnedMarks() {
        return earnedMarks;
    }

    public void setEarnedMarks(int earnedMarks) {
        this.earnedMarks = earnedMarks;
    }

    public int getPossibleMarks() {
        return possibleMarks;
    }

    public String getSubmitterName() {
        return submitterName;
    }

    public String getLetterGrade() {

        double percentScore = ((double)earnedMarks/(double)possibleMarks);

        if (percentScore >= .9) {
            letterGrade = "A";
        }
        else if (percentScore >= .8 && percentScore <= .89) {
            letterGrade = "B";
        }
        else if (percentScore >= .7 && percentScore <= .79 ) {
            letterGrade = "C";
        }

        else if (percentScore >= .6 && percentScore <= .69) {
            letterGrade = "D";
        }
        else {
            letterGrade = "F";
        }
        return letterGrade;
    }

    public HomeworkAssignment () {

        possibleMarks = 100;
        submitterName = "";
        earnedMarks = 0;
        letterGrade = null;


    }





    public HomeworkAssignment (int score, String name) {

    earnedMarks = score;
    submitterName = name;
    possibleMarks = 100;
    letterGrade = null;


    }












}
