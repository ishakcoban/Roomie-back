package com.example.roomie.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "advertPhotos")
public class AdvertPhoto {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String fileName;
    private String contentType;
    private byte[] fileData;

    /*@ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "advert_id")
    private Advert advert;*/

}
