package controller;

import gui.FormEvent;
import model.AgeCategory;
import model.Database;
import model.EmploymentCategory;
import model.Person;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Controller {
    Database db = new Database();


    public List<Person> getPeople()
    {
        return db.getPeople();
    }


    public void removePerson(int index)
    {
        db.removePerson(index);
    }








    public  void  addPerson (FormEvent ev) {
        //-- var think up
        String name = ev.getName();
        String last_Name = ev.getLast_Name();
        int ageCatId = ev.getAgeCategory();
        String empCat = ev.getEmploymentCategory();
        boolean rates = ev.isRates();
        String ratesId = ev.getRatesId();

        AgeCategory ageCategory = null;

        switch (ageCatId) {
            case 0:
                ageCategory = AgeCategory.child;
                break;

            case 1:
                ageCategory = AgeCategory.adult;
                break;
            case 2:
                ageCategory = AgeCategory.senior;
                break;
        }

        EmploymentCategory empCategory;

        if (empCat.equals("employed")) {
            empCategory = EmploymentCategory.employed;

        } else if (empCat.equals("self-employed")) {
            empCategory = EmploymentCategory.selfEmployed;

        } else if (empCat.equals("unemployed")) {
            empCategory = EmploymentCategory.unemployed;
        } else {
            empCategory = EmploymentCategory.other;
            System.err.println(empCat);
        }


        Person person = new Person(name, last_Name, ageCategory, empCategory, ratesId, rates);
        db.addPerson(person);
    }
    public void saveToFile (File file) throws IOException
    {
        db.saveToFile(file);
    }

    public void loadFromFile (File file) throws IOException
    {
        db.loadFromFile(file);
    }
}


