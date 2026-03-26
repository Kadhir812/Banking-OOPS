package com.example.crud.dao;

import java.util.List;

import com.example.crud.dto.Product;

public interface productDAO {
    public void saveData(Product p);
    public List<Product> showAll();
    public void removeById(int produt_id);
    public void updateCityById(int produt_id, String city);
}
