package com.gltech.demo.bull;

import java.util.List;
import java.util.Objects;

import com.gltech.demo.cow.Cow;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Bull {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 10, unique = true)
    private String number;

    @Column(length = 12, unique = true)
    private String bullId;

    private boolean artificialInsemination;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Cow> calves;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getBullId() {
        return bullId;
    }

    public void setBullId(String bullId) {
        this.bullId = bullId;
    }

    public boolean isArtificialInsemination() {
        return artificialInsemination;
    }

    public void setArtificialInsemination(boolean artificialInsemination) {
        this.artificialInsemination = artificialInsemination;
    }

    public List<Cow> getCalves() {
        return calves;
    }

    public void setCalves(List<Cow> calves) {
        this.calves = calves;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bull bull = (Bull) o;
        return id == bull.id;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }
}
