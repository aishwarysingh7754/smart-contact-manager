package com.contact.smartcontactmanager.entities;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "CONTACT")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotBlank(message = "name cannot be blank")
    private String name;

    private String nickName;

    @Pattern(regexp = "\\d{10}", message = "Phone number must be 10 digits")
    private String phone;

    private String work;

    @Email(message = "Invalid email format")
    private String email;

    private String image;

    @Column(length = 5000)
    @Size(max = 5000, message = "Description length must be at most 5000 characters")
    private String description;

    @ManyToOne
    private User user;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getdescription() {
        return description;
    }

    public void setdescription(String description) {
        this.description = description;
    }

    public Contact(int id, String name, String nickName, String phone, String work, String email, String image,
            String description, User user) {
        this.id = id;
        this.name = name;
        this.nickName = nickName;
        this.phone = phone;
        this.work = work;
        this.email = email;
        this.image = image;
        this.description = description;
        this.user = user;
    }

    public Contact() {
        super();
    }

    @Override
    public String toString() {
        return "Contact [id=" + id + ", name=" + name + ", nickName=" + nickName + ", phone=" + phone + ", work=" + work
                + ", email=" + email + ", image=" + image + ", description=" + description + ", user=" + user + "]";
    }

}
