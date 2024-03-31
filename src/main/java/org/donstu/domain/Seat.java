package org.donstu.domain;

import java.io.Serializable;

public class Seat implements Serializable {
    private String deck;
    private int row;
    private int seat;

    public Seat() {
    }

    public Seat(String deck, int row, int seat) {
        this.deck = deck;
        this.row = row;
        this.seat = seat;
    }

    public String getDeck() {
        return deck;
    }

    public void setDeck(String deck) {
        this.deck = deck;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "deck='" + deck + '\'' +
                ", row=" + row +
                ", seat=" + seat +
                '}';
    }
}
