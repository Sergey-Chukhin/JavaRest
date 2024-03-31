package org.donstu.domain;

import java.io.Serializable;
import java.util.List;

public class CruiseShip implements Serializable {
    private List<Voyage> voyages;

    private List<Seat> seats;

    private List<Reservation> reservations;

    public List<Voyage> getPaths() {
        return voyages;
    }

    public void setPaths(List<Voyage> voyages) {
        this.voyages = voyages;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
