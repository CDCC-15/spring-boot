package org.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity
public class SubCategory extends ModelBase {
    private String name;
    private String code;
    @OneToOne(optional = false)
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

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
}
