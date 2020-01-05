package model;

import java.io.Serializable;

public class Person implements Serializable {
    private static final long serialVersionUID = -2270430120263767105L;
    private static int count = 0;


    private  int id;
    private  String name;
    private  String last_Name;
    private  AgeCategory ageCategory;
    private  EmploymentCategory empCat;
    private String ratesId;
    private boolean rates;

    public Person (String name, String last_Name, AgeCategory ageCategory, EmploymentCategory empCat, String ratesId, boolean rates)
    {
        this.name = name;
        this.last_Name = last_Name;
        this. ageCategory = ageCategory;
        this.empCat = empCat;
        this.ratesId = ratesId;
        this.rates = rates;
        this.id = count;
        count++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_Name() {
        return last_Name;
    }

    public void setLast_Name(String last_Name) {
        this.last_Name = last_Name;
    }

    public AgeCategory getAgeCategory() {
        return ageCategory;
    }

    public void setAgeCategory(AgeCategory ageCategory) {
        this.ageCategory = ageCategory;
    }

    public EmploymentCategory getEmpCat() {
        return empCat;
    }

    public void setEmpCat(EmploymentCategory empCat) {
        this.empCat = empCat;
    }

    public String getRatesId() {
        return ratesId;
    }

    public void setRatesId(String ratesId) {
        this.ratesId = ratesId;
    }

    public boolean isRates() {
        return rates;
    }

    public void setRates(boolean rates) {
        this.rates = rates;
    }
}
