package com.codegym.model.repository;

import com.codegym.model.bean.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepositoryImpl implements ProductRepository{
    private static final Map<Integer, Product> products;

    static {

        products = new HashMap<>();
        products.put(1, new Product(1,"Z1000", 20000, "Phan khoi lon", "Kawasaki"));
        products.put(2, new Product(2,"Z800", 15000, "Phan khoi lon", "Kawasaki"));
        products.put(3, new Product(3,"CB2000", 20000, "Phan khoi lon", "Honda"));

    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(),product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id,product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public Product findByName(String name) {
        List<Product> list = new ArrayList<>(products.values());
        for(Product product : list){
            if(name.equals(product.getName())){
                return product;
            }
        }
        return null;
    }
}
