package org.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity
public class Item extends ModelBase {
    private String name;
    private String code;
    @OneToOne(optional = false)
    private SubCategory subCategory;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public SubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }
}
