package com.gltech.demo.cow;

import java.time.LocalDate;
import java.util.List;

import com.gltech.demo.bull.Bull;
import com.gltech.demo.herd.Herd;
import com.gltech.demo.herd.HerdHistory;
import com.gltech.demo.milking.Milking;
import com.gltech.demo.milktest.MilkTest;
import com.gltech.demo.vetbill.VetBill;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;

@Entity
public class Cow {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 10, unique = true)
    private String tag;

    @Column(nullable = false)
    private LocalDate birthDate;

    @Column(nullable = false, length = 25)
    private String status;

    @ManyToOne
    private Bull father;

    @ManyToOne
    private Cow mother;

    @ManyToOne
    private Herd herd;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Cow> calves;

    @OneToMany(fetch = FetchType.LAZY)
    @OrderBy("date DESC")
    private List<VetBill> vetBills;

    @OneToMany(fetch = FetchType.LAZY)
    @OrderBy("start DESC")
    private List<HerdHistory> herdHistory;

    @OneToMany(fetch = FetchType.LAZY)
    @OrderBy("date DESC")
    private List<MilkTest> milkTests;

    @OneToMany(fetch = FetchType.LAZY)
    @OrderBy("start DESC")
    private List<Milking> milkings;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Bull getFather() {
        return father;
    }

    public void setFather(Bull father) {
        this.father = father;
    }

    public Cow getMother() {
        return mother;
    }

    public void setMother(Cow mother) {
        this.mother = mother;
    }

    public Herd getHerd() {
        return herd;
    }

    public void setHerd(Herd herd) {
        this.herd = herd;
    }

    public List<Cow> getCalves() {
        return calves;
    }

    public void setCalves(List<Cow> calves) {
        this.calves = calves;
    }

    public List<VetBill> getVetBills() {
        return vetBills;
    }

    public void setVetBills(List<VetBill> vetBills) {
        this.vetBills = vetBills;
    }

    public List<HerdHistory> getHerdHistory() {
        return herdHistory;
    }

    public void setHerdHistory(List<HerdHistory> herdHistory) {
        this.herdHistory = herdHistory;
    }

    public List<MilkTest> getMilkTests() {
        return milkTests;
    }

    public void setMilkTests(List<MilkTest> milkTests) {
        this.milkTests = milkTests;
    }

    public List<Milking> getMilkings() {
        return milkings;
    }

    public void setMilkings(List<Milking> milkings) {
        this.milkings = milkings;
    }
}
