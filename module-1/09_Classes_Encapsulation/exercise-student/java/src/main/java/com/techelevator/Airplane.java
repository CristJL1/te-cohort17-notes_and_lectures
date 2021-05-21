package com.techelevator;

public class Airplane {

    private String planeNumber;

    private int totalFirstClassSeats;

    private int bookedFirstClassSeats;

    private int availableFirstClassSeats;

    private int totalCoachSeats;

    private  int bookedCoachSeats;

    private int availableCoachSeats;

    public String getPlaneNumber() {
        return planeNumber;
    }

    public int getTotalFirstClassSeats() {
        return totalFirstClassSeats;
    }

    public int getBookedFirstClassSeats() {
        return bookedFirstClassSeats;
    }

    public int getAvailableFirstClassSeats() {

        availableFirstClassSeats = totalFirstClassSeats - bookedFirstClassSeats;

        return availableFirstClassSeats;
    }

    public int getTotalCoachSeats() {
        return totalCoachSeats;
    }

    public int getBookedCoachSeats() {
        return bookedCoachSeats;
    }

    public int getAvailableCoachSeats() {

        availableCoachSeats = totalCoachSeats - bookedCoachSeats;

        return availableCoachSeats;
    }


    public Airplane (String tailNumber, int firstClassSeats, int coachSeats) {

        planeNumber = tailNumber;

        totalFirstClassSeats = firstClassSeats;

        totalCoachSeats = coachSeats;

        bookedCoachSeats = 0;

        bookedFirstClassSeats = 0;

        availableCoachSeats = coachSeats;

        availableFirstClassSeats = firstClassSeats;

    }

    public boolean reserveSeats (boolean forFirstClass, int totalNumberOfSeats) {



            if (forFirstClass && availableFirstClassSeats >= totalNumberOfSeats) {

                bookedFirstClassSeats = bookedFirstClassSeats + totalNumberOfSeats;

            } else if (!forFirstClass && availableCoachSeats >= totalNumberOfSeats) {
                bookedCoachSeats = bookedCoachSeats + totalNumberOfSeats;
            }
            else {
                return false;
            }
        return true;


    }






}
