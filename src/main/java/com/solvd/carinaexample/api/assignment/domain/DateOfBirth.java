package com.solvd.carinaexample.api.assignment.domain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DateOfBirth {
    @JsonProperty("date")
    private String date;
    @JsonProperty("age")
    private int age;

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "DateOfBirth{" +
                "date='" + date + '\'' +
                ", age=" + age +
                '}';
    }
}
