package com.example.api.filter;

import org.springframework.data.jpa.domain.Specification;

import com.example.api.domain.Customer;
import com.example.api.dto.CustomerFilterDTO;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class CustomerSpecification {

    public static Specification<Customer> filterBy(CustomerFilterDTO filter) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (filter.getName() != null && !filter.getName().isEmpty()) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("name")),
                        "%" + filter.getName().toLowerCase() + "%"));
            }

            if (filter.getEmail() != null && !filter.getEmail().isEmpty()) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("email")),
                        "%" + filter.getEmail().toLowerCase() + "%"));
            }

            if (filter.getGender() != null && !filter.getGender().isEmpty()) {
                predicates.add(criteriaBuilder.equal(criteriaBuilder.lower(root.get("gender")),
                        filter.getGender().toLowerCase()));
            }

            if (filter.getCity() != null && !filter.getCity().isEmpty()) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("addresses").get("city")),
                        "%" + filter.getCity().toLowerCase() + "%"));
            }

            if (filter.getState() != null && !filter.getState().isEmpty()) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("addresses").get("state")),
                        "%" + filter.getState().toLowerCase() + "%"));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}

