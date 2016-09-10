package com.javarush.test.level29.lesson15.big01.human;
public class UniversityPerson extends Human{
    private University university;
    protected String name;
    protected int age;
    public UniversityPerson(String name, int age){
        super(name , age);
    }
    public University getUniversity() {
        return university;
    }
    public void setUniversity(University university) {
        this.university = university;
    }
}