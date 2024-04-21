package com.example.rockbitetaskex.service;

import com.example.rockbitetaskex.model.MaterialType;
import com.example.rockbitetaskex.model.User;
import com.example.rockbitetaskex.model.Warehouse;

public interface WarehouseService {

//    Warehouse save(Warehouse warehouse, User user);

    void save(Warehouse warehouse);

    Warehouse getById(Long id);

    void delete(Long id);

    void moveMaterialBetweenWarehouses(Long warehouse1ID, Long warehouse2Id, Long materialId);

    Long getMaterialQuantityInWarehouse(Long warehouseId, Long materialId);
}
