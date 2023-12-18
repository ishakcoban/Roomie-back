package com.example.roomie.utils;

import com.example.roomie.entity.Advert;
import com.example.roomie.entity.AdvertPhoto;
import com.example.roomie.modal.enums.DateStatus;
import com.example.roomie.modal.enums.PriceStatus;
import com.example.roomie.modal.request.AdvertRequest;
import com.example.roomie.modal.request.FilterAdvertRequest;
import io.micrometer.common.util.StringUtils;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.stream.Collectors;


public class AdvertSpecifications {

    public static Specification<Advert> getFilterQuery(FilterAdvertRequest filterAdvertRequest) {

        return (root, query, cb) -> {
            Predicate conjunction = cb.conjunction();

            if (StringUtils.isNotBlank(filterAdvertRequest.getCity())) {
                conjunction = cb.and(conjunction,cb.equal(root.get("city"),filterAdvertRequest.getCity()));
            }
            if (StringUtils.isNotBlank(filterAdvertRequest.getCity()) && StringUtils.isNotBlank(filterAdvertRequest.getDistrict())) {
                conjunction = cb.and(conjunction,cb.equal(root.get("district"),filterAdvertRequest.getDistrict()));
            }
            if (StringUtils.isNotBlank(filterAdvertRequest.getCity()) && StringUtils.isNotBlank(filterAdvertRequest.getDistrict()) && StringUtils.isNotBlank(filterAdvertRequest.getNeighbourhood())) {
                conjunction = cb.and(conjunction,cb.equal(root.get("neighbourhood"),filterAdvertRequest.getNeighbourhood()));
            }
            if (filterAdvertRequest.getRooms() > 0) {
                conjunction = cb.and(conjunction,cb.equal(root.get("rooms"),filterAdvertRequest.getRooms()));
            }
            if (filterAdvertRequest.getFloorArea() > 0) {
                conjunction = cb.and(conjunction,cb.equal(root.get("floorArea"),filterAdvertRequest.getFloorArea()));
            }
            if (filterAdvertRequest.getMinPrice() >= 0 && filterAdvertRequest.getMaxPrice() > 0) {
                conjunction = cb.and(conjunction,cb.between(root.get("price"), filterAdvertRequest.getMinPrice(),filterAdvertRequest.getMaxPrice()));
            }

            if(filterAdvertRequest.getPriceStatus() == PriceStatus.toHIGHEST){
                query.orderBy(cb.asc(root.get("price")));
            }

            if(filterAdvertRequest.getPriceStatus() == PriceStatus.toLOWEST){
                query.orderBy(cb.desc(root.get("price")));
            }

            if(filterAdvertRequest.getDateStatus() == DateStatus.toNEAREST){
                query.orderBy(cb.asc(root.get("updatedOn")));
            }

            if(filterAdvertRequest.getDateStatus() == DateStatus.toFURTHEST){
                query.orderBy(cb.desc(root.get("updatedOn")));
            }

            return conjunction;
        };
    }

}
