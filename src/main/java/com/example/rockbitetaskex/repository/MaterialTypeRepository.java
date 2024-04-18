package com.example.rockbitetaskex.repository;

import com.example.rockbitetaskex.model.MaterialType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialTypeRepository extends JpaRepository<MaterialType, Long> {
}
