package com.example.rockbitetaskex.controller;

import com.example.rockbitetaskex.exceptions.UserNotFoundException;
import com.example.rockbitetaskex.exceptions.WarehouseNotFoundException;
import com.example.rockbitetaskex.model.Material;
import com.example.rockbitetaskex.model.User;
import com.example.rockbitetaskex.model.Warehouse;
import com.example.rockbitetaskex.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/controller/warehouse")
public class WarehouseController {

    @Autowired
    private WarehouseService warehouseService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Warehouse> getWarehouse(@PathVariable("id") Long id) {
        Warehouse warehouse = this.warehouseService.getById(id);

        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (warehouse == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(warehouse, HttpStatus.OK);
    }

    @RequestMapping(value = "/{warehouseId}/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void addWarehouseMaterial(@PathVariable("warehouseId") Long warehouseId, @RequestBody @Validated Material material) {
        Warehouse warehouse = warehouseService.getById(warehouseId);

        if (warehouse != null) {
            warehouse.addMaterial(material);
            warehouseService.save(warehouse);
        } else {
            throw new UserNotFoundException("User with id " + warehouseId + "is not found");
        }
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Warehouse> deleteWarehouse(@PathVariable("id") Long warehouseId) {
        Warehouse warehouse = this.warehouseService.getById(warehouseId);

        if (warehouse == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        warehouseService.delete(warehouseId);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
