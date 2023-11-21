package com.example.roomie.entity;

import com.example.roomie.utils.AuditorEntity;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "advertPhotos")
public class AdvertPhoto extends AuditorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private int photoOrder;
    private String fileName;
    private String contentType;
    private byte[] fileData;

    @ManyToOne
    @JoinColumn(name = "advert_id")
    private Advert advert;

}
