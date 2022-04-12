package com.example.ewwithpostgres.repository;

import com.example.ewwithpostgres.model.Advertising;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvertisingRepository extends JpaRepository<Advertising, Long> {
}
