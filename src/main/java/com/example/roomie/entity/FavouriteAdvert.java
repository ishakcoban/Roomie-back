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
@Table(name = "favouriteAdverts")
public class FavouriteAdvert extends AuditorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "advert_id")
    private Advert advert;

}

