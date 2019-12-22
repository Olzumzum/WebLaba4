package com.olzumzum.weblab4.server.model.entities;

import javax.persistence.*;

/**
 * класс описывает компонент списка ассортимента продукции
 */
@Entity
@Table(name="AssortmentCake")
public class ItemAssortment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "assortment_cake_id")
    private int id;

    @Column(name = "assortment_cake_name", nullable = false)
    private String nameAssortment;

    public ItemAssortment() {
    }

    public ItemAssortment(String nameAssortment) {
        this.nameAssortment = nameAssortment;
    }

    public String getNameAssortment() {
        return nameAssortment;
    }

    public void setNameAssortment(String nameAssortment) {
        this.nameAssortment = nameAssortment;
    }
}
