/*
 * JBoss, Home of Professional Open Source
 * Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package Trakker.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("serial")
@Entity
@XmlRootElement
@SequenceGenerator(name="seq", initialValue=100, allocationSize=1)
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Member implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
    private Long id;

    @NotNull
    @Size(min = 1, max = 25)
    @Pattern(regexp = "[^0-9]*", message = "Must not contain numbers")
    private String username;

    @NotNull
    @NotEmpty
    @Email
    private String email;

    @NotNull
    @Size(min = 10, max = 12)
    @Digits(fraction = 0, integer = 12)

    @Column(name = "phone_number")
    private String phoneNumber;

    @NotNull
    @Digits(fraction = 0,integer= 3)
    private int weight;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateOfBirth;
    private String basalInsulin;
    private String bolusInsulin;
    private int height;
    private int maxBloodGlucose;
    private int minBloodGlucose;
    private int targetBloodGlucose;
    private String password;
    private String lastName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getBolusInsulin() {
        return bolusInsulin;
    }

    public void setBolusInsulin(String bolusInsulin) {
        this.bolusInsulin = bolusInsulin;
    }

    public String getBasalInsulin() {
        return basalInsulin;
    }

    public void setBasalInsulin(String basalInsulin) {
        this.basalInsulin = basalInsulin;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getMaxBloodGlucose() {
        return maxBloodGlucose;
    }

    public void setMaxBloodGlucose(int maxBloodGlucose) {
        this.maxBloodGlucose = maxBloodGlucose;
    }

    public int getMinBloodGlucose() {
        return minBloodGlucose;
    }

    public void setMinBloodGlucose(int minBloodGlucose) {
        this.minBloodGlucose = minBloodGlucose;
    }

    public int getTargetBloodGlucose() {
        return targetBloodGlucose;
    }

    public void setTargetBloodGlucose(int targetBloodGlucose) {
        this.targetBloodGlucose = targetBloodGlucose;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
