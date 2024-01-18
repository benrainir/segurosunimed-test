package com.example.api.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.api.domain.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CustomerRepository extends JpaRepository<Customer, Long>, JpaSpecificationExecutor<Customer> {


	/*
       Page<Customer> findAll(Pageable pageable);

	List<Customer> findAllByOrderByNameAsc();

	@Query("SELECT c FROM Customer c " +
           "JOIN c.addresses a " +
           "WHERE (:name IS NULL OR c.name = :name) AND " +
           "(:email IS NULL OR c.email = :email) AND " +
           "(:gender IS NULL OR c.gender = :gender) AND " +
           "(:city IS NULL OR a.localidade = :city) AND " +
           "(:state IS NULL OR a.uf = :state)")
    Page<Customer> findByAllFilters(@Param("name") String name,
                                    @Param("email") String email,
                                    @Param("gender") String gender,
                                    @Param("city") String city,
                                    @Param("state") String state,
                                    Pageable pageable);

	List<Customer> findByName(String name);

	List<Customer> findByEmail(String email);

	List<Customer> findByGender(String gender);
*/

}
