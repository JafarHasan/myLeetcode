package com.Acciojob_Practice_Project.July2024.AssociateTwoEntities;


import jakarta.persistence.*;
import lombok.*;
@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Book1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;
    private Integer noOfPages;
    private String name;

    @JoinColumn
    @ManyToOne//Many book could be written by one author
    private Author1 author1;
}
