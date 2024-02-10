package com.solvd.carinaexample.api.assignment.domain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RandomUser {
    private String gender;
    private Name name;
    private String email;
    @JsonProperty("dob")
    private DateOfBirth dateOfBirth;
    private String phone;
    private String cell;
    private String nat;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public DateOfBirth getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(DateOfBirth dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getNat() {
        return nat;
    }

    public void setNat(String nat) {
        this.nat = nat;
    }

    @Override
    public String toString() {
        return "RandomUser{" +
                "gender='" + gender + '\'' +
                ", name=" + name +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", phone='" + phone + '\'' +
                ", cell='" + cell + '\'' +
                ", nat='" + nat + '\'' +
                '}';
    }
}
