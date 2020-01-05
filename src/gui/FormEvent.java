package gui;

import java.util.EventObject;

public class FormEvent extends EventObject {
    private  String name;
    private  String last_Name;
    private  int ageCategory;
    private  String empCat;
    private String ratesId;
    private boolean rates;

    /**
     * where source-gui.FormPanel
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public FormEvent(Object source) {
        super(source);
    }
    public FormEvent(Object source, String name, String last_Name , int ageCat, String empCat, String ratesId, boolean rates)  {
        super(source);

        this.name = name;
        this.last_Name = last_Name;
        this.ageCategory = ageCat;
        this.empCat = empCat;
        this.ratesId = ratesId;
        this.rates = rates;
    }

    public String getRatesId() {
        return ratesId;
    }

    public boolean isRates() {
        return rates;
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

    public int getAgeCategory() {
        return ageCategory;
    }

    public String getEmploymentCategory()
    {
        return empCat;
    }

}
