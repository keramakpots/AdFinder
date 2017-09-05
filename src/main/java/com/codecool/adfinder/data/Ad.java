package com.codecool.adfinder.data;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Builder
@Entity
public class Ad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(unique = true)
    private String url;
    private String street;
    @Column(length = 6000)
    private String description;
    private String publishTime;
    private Integer price;
    private Integer rooms;
    private String title;
}