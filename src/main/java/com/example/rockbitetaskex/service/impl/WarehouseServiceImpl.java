package com.example.rockbitetaskex.service.impl;

import com.example.rockbitetaskex.model.Material;
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

    public void moveMaterialBetweenWarehouses(Long warehouseId1, Long warehouseId2, Long materialId) {
        Warehouse warehouse1 = warehouseRepository.findById(warehouseId1)
                .orElseThrow(() -> new RuntimeException("Source warehouse not found."));
        Warehouse warehouse2 = warehouseRepository.findById(warehouseId2)
                .orElseThrow(() -> new RuntimeException("Target warehouse not found."));


//        Warehouse warehouse1 = warehouseRepository.getOne(warehouse1ID);
//        Warehouse warehouse2 = warehouseRepository.getOne(warehouse2Id);

        Material materialToMove = null;
        for (Material material : warehouse1.getMaterials()) {
            if (material.getId().equals(materialId)) {
                materialToMove = material;
                break;
            }
        }

        if (materialToMove == null) {
            throw new RuntimeException("Material not found exception");
        }

        warehouse1.getMaterials().remove(materialToMove);
        warehouse2.getMaterials().add(materialToMove);

        warehouseRepository.save(warehouse1);
        warehouseRepository.save(warehouse2);
    }

}
