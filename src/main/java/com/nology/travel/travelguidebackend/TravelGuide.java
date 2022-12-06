package com.nology.travel.travelguidebackend;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class TravelGuide {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String location;
    private String image;
    private String cost;
    private String visit;
    private String dateFrom;
    private String dateTo;
    private String comment;
    private LocalDate dateCreated = LocalDate.now();

    public TravelGuide () {
    }

    public TravelGuide(Long id, String name, String location, String image, String cost, String visit, String dateFrom, String dateTo, String comment, LocalDate dateCreated) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.image = image;
        this.cost = cost;
        this.visit = visit;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.comment = comment;
        this.dateCreated = dateCreated;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getVisit() {
        return visit;
    }

    public void setVisit(String visit) {
        this.visit = visit;
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }
}

