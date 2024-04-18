package com.example.rockbitetaskex.controller;

import com.example.rockbitetaskex.exceptions.MaterialNotFoundException;
import com.example.rockbitetaskex.model.Material;
import com.example.rockbitetaskex.model.MaterialType;
import com.example.rockbitetaskex.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/controller/material")
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    @RequestMapping(value = "{materialId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Material> getMaterial(@PathVariable("materialId") Long id) {
        Material material = this.materialService.getById(id);

        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (material == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(material, HttpStatus.OK);
    }

    @RequestMapping(value = "{materialId}/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void addMaterialTypeMaterial(@PathVariable("materialId") Long materialId, @RequestBody @Validated MaterialType materialType) {
        Material material = this.materialService.getById(materialId);

        if (material != null) {
            material.addMaterialType(materialType);
            materialService.save(material);
        } else {
            throw new MaterialNotFoundException("Material with id " + materialId + "not found");
        }
    }
}
