package com.example.quizapplication;

public class QM {
    private String q,optA,optB,optC,optD,ctA;

    public QM(String q, String optA, String optB, String optC, String optD, String ctA) {
        this.q = q;
        this.optA = optA;
        this.optB = optB;
        this.optC = optC;
        this.optD = optD;
        this.ctA = ctA;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public String getOptA() {
        return optA;
    }

    public void setOptA(String optA) {
        this.optA = optA;
    }

    public String getOptB() {
        return optB;
    }

    public void setOptB(String optB) {
        this.optB = optB;
    }

    public String getOptC() {
        return optC;
    }

    public void setOptC(String optC) {
        this.optC = optC;
    }

    public String getOptD() {
        return optD;
    }

    public void setOptD(String optD) {
        this.optD = optD;
    }

    public String getCtA() {
        return ctA;
    }

    public void setCtA(String ctA) {
        this.ctA = ctA;
    }
}
