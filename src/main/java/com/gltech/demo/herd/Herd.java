package com.gltech.demo.herd;

import java.util.List;

import com.gltech.demo.cow.Cow;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Herd {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany
    private List<Cow> cows;

    @OneToMany
    private List<HerdHistory> herdHistories;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Cow> getCows() {
        return cows;
    }

    public void setCows(List<Cow> cows) {
        this.cows = cows;
    }

    public List<HerdHistory> getHerdHistories() {
        return herdHistories;
    }

    public void setHerdHistories(List<HerdHistory> herdHistories) {
        this.herdHistories = herdHistories;
    }
}
