package org.donstu.domain;

import java.io.Serializable;
import java.util.Date;

public class Voyage implements Serializable {
    private String ident;

    private String title;

    private Date startAt;

    private int duration;

    private String deck;

    public Voyage() {
    }

    public Voyage(String ident,String title, Date startAt, int duration, String deck) {
        this.ident = ident;
        this.title = title;
        this.startAt = startAt;
        this.duration = duration;
        this.deck = deck;
    }

    public String getIdent() { return ident; }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStartAt() {
        return startAt;
    }

    public void setStartAt(Date startAt) {
        this.startAt = startAt;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDeck() {
        return deck;
    }

    public void setDeck(String deck) {
        this.deck = deck;
    }
}
