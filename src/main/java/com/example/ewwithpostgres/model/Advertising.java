package com.example.ewwithpostgres.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "advertises")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Advertising {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String description;
    private int price;
    private String name;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "added_at")
    private LocalDateTime addedAt;

    public Advertising(String type,
                       String description,
                       int price,
                       String userName,
                       String phoneNumber,
                       LocalDateTime addedAt) {
        this.type = type;
        this.description = description;
        this.price = price;
        this.name = userName;
        this.phoneNumber = phoneNumber;
        this.addedAt = addedAt;
    }
}
