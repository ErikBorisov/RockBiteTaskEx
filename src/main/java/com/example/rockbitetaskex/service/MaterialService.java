package com.example.rockbitetaskex.service;

import com.example.rockbitetaskex.model.Material;
import com.example.rockbitetaskex.model.Warehouse;

public interface MaterialService {

    Material save(Material material, Warehouse warehouse);

}
