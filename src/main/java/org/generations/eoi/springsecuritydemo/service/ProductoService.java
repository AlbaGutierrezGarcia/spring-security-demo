package org.generations.eoi.springsecuritydemo.service;

import org.generations.eoi.springsecuritydemo.entity.Producto;
import org.generations.eoi.springsecuritydemo.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {
    private ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    public Optional<Producto> findById(long id) {
        return productoRepository.findById(id);
    }

    public void save(Producto producto) {
        productoRepository.save(producto);
    }

    public void deleteById(long id) {
        productoRepository.deleteById(id);
    }
}