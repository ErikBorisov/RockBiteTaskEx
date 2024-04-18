package com.example.rockbitetaskex.service.impl;

import com.example.rockbitetaskex.model.User;
import com.example.rockbitetaskex.model.Warehouse;
import com.example.rockbitetaskex.repository.WarehouseRepository;
import com.example.rockbitetaskex.service.WarehouseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class WarehouseServiceImpl implements WarehouseService {

    @Autowired
    private WarehouseRepository warehouseRepository;

//    @Override
//    public Warehouse save(Warehouse warehouse, User user) {
//        warehouse.setUser(user);
//        return warehouseRepository.save(warehouse);
//    }

    @Override
    public void save(Warehouse warehouse) {
        warehouseRepository.save(warehouse);
    }

    @Override
    public Warehouse getById(Long id) {
        log.info("In WarehouseServiceImpl getById {}: ", id);
        return warehouseRepository.getOne(id);
    }

    @Override
    public void delete(Long id) {
        warehouseRepository.deleteById(id);
    }
}
