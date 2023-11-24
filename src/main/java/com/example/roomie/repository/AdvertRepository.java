package com.example.roomie.repository;

import com.example.roomie.entity.Advert;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdvertRepository extends JpaRepository<Advert, String> {

    List<Advert> findAllByUserId(String userId);
   // List<Advert> findAllByCity(String city);
    //OrderByUpdatedOnAscAndPriceDesc
  /* List<Location> findAllByCityOrderByUpdatedOnDesc(String city);
    List<Location> findAllByCityAndDistrictOrderByUpdatedOnDesc(String city,String district);

    List<Location> findAllByCityAndDistrictAndNeighbourhoodOrderByUpdatedOnDesc(String city,String district,String neighbourhood);
*/
}
