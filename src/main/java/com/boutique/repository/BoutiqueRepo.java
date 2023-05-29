package com.boutique.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boutique.entity.Details;

public interface BoutiqueRepo extends JpaRepository<Details, Long> {

}
