package com.gltech.demo.milktest;

import java.time.LocalDate;
import java.util.Objects;

import com.gltech.demo.cow.Cow;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class MilkTest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Cow cow;

    private LocalDate date;
    private float time;
    private float weight;
    private float butterfat;
    private float protien;
    private float somaticCellCount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cow getCow() {
        return cow;
    }

    public void setCow(Cow cow) {
        this.cow = cow;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public float getTime() {
        return time;
    }

    public void setTime(float time) {
        this.time = time;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getButterfat() {
        return butterfat;
    }

    public void setButterfat(float butterfat) {
        this.butterfat = butterfat;
    }

    public float getProtien() {
        return protien;
    }

    public void setProtien(float protien) {
        this.protien = protien;
    }

    public float getSomaticCellCount() {
        return somaticCellCount;
    }

    public void setSomaticCellCount(float somaticCellCount) {
        this.somaticCellCount = somaticCellCount;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MilkTest milkTest = (MilkTest) o;
        return id == milkTest.id;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }
}
