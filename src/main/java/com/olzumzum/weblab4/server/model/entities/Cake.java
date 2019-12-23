package com.olzumzum.weblab4.server.model.entities;

import javax.persistence.*;

@Entity
@Table(name = "Cake")
public class Cake {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cake_id")
    private int id;

    @Column(name = "assortment_cake_id")
    private int assortmentCakeId;

    @Column(name = "item_product_id")
    private int itemProductId;

    public int getAssortmentCakeId() {
        return assortmentCakeId;
    }

    public void setAssortmentCakeId(int assortmentCakeId) {
        this.assortmentCakeId = assortmentCakeId;
    }

    public int getItemProductId() {
        return itemProductId;
    }

    public void setItemProductId(int itemProductId) {
        this.itemProductId = itemProductId;
    }
}
