package com.example.roomie.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "locations")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String city;
    private String district;
    private String neighbourhood;

    @OneToOne(mappedBy = "location")
    private Advert advert;
}
