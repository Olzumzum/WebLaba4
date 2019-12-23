package com.olzumzum.weblab4.server.model.entities;

import javax.persistence.*;

@Entity
@Table(name = "AssortmentCake")
public class AssortmentCake {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "assortment_cake_id")
    private int assortment_cake_id;

    private String assortment_cake_name;

    public String getAssortment_cake_name() {
        return assortment_cake_name;
    }

    public void setAssortment_cake_name(String assortment_cake_name) {
        this.assortment_cake_name = assortment_cake_name;
    }

    public AssortmentCake() {
    }
}
