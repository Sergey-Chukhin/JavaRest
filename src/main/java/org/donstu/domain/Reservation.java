package org.donstu.domain;

import java.io.Serializable;
import java.util.List;

public class Reservation implements Serializable {
    private Voyage voyage;

    private List<Seat> seats;

    public Voyage getPath() {
        return voyage;
    }

    public void setMovie(Voyage voyage) {
        this.voyage = voyage;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
}
