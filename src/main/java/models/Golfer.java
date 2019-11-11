package models;

import enums.ScoringSystem;

public class Golfer implements Comparable {


    private int gross;
    private int nett;
    private int handicap;
    private int position;
    private int pts;
    private String forename;
    private String surname;
    private String fullName;
    private String[] parts;
    private String placing;
    private String countback;

    private String[] partsOfScore;
    private String[] partsOfName;

    public String getPlacing() {
        return placing;
    }

    public String getCountback() {
        return countback;
    }

    public int getPosition() {
        return position;
    }

    void setPosition(int position) {
        this.position = position;
    }

    public int getGross() {
        return gross;
    }

    public int getNett() {
        return nett;
    }

    public int getHandicap() {
        return handicap;
    }

    public String getFullName() {
        return fullName;
    }

    public int getPts() {
        return pts;
    }

    @Override
    public int compareTo(Object obj) {
        Golfer that = (Golfer) obj;
        if (Integer.compare(this.gross, that.gross) == 0) {
            if (this.surname.compareTo(that.surname) == 0) {
                return this.forename.compareTo(that.forename);
            } else {
                return this.surname.compareTo(that.surname);
            }
        } else {
            return Integer.compare(this.gross, that.gross);
        }
    }
}
