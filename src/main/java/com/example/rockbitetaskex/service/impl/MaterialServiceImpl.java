package com.example.rockbitetaskex.service.impl;

import com.example.rockbitetaskex.model.Material;
import com.example.rockbitetaskex.model.Warehouse;
import com.example.rockbitetaskex.repository.MaterialRepository;
import com.example.rockbitetaskex.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    private MaterialRepository materialRepository;

    @Override
    public Material save(Material material, Warehouse warehouse) {
        material.setWarehouse(warehouse);
        return materialRepository.save(material);
    }
}
