package com.example.rockbitetaskex.service.impl;

import com.example.rockbitetaskex.model.User;
import com.example.rockbitetaskex.model.Warehouse;
import com.example.rockbitetaskex.repository.WarehouseRepository;
import com.example.rockbitetaskex.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WarehouseServiceImpl implements WarehouseService {

    @Autowired
    private WarehouseRepository warehouseRepository;

    @Override
    public Warehouse save(Warehouse warehouse, User user) {
        warehouse.setUser(user);
        return warehouseRepository.save(warehouse);
    }
}
