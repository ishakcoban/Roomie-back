package com.example.roomie.utils;

import com.example.roomie.entity.Advert;
import com.example.roomie.modal.request.FilterAdvertRequest;
import io.micrometer.common.util.StringUtils;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;



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

            query.orderBy(cb.desc(root.get("updatedOn")));
            return conjunction;
        };
    }

}
