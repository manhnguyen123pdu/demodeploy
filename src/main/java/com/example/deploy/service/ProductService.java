package com.example.deploy.service;

import com.example.deploy.entity.Product;
import com.example.deploy.repo.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product getById(Integer id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm id = " + id));
    }

    public Product create(Product p) {
        p.setMaSanPham(null);
        return productRepository.save(p);
    }

    public Product update(Integer id, Product p) {
        Product existing = getById(id);
        existing.setTenSanPham(p.getTenSanPham());
        existing.setDanhMuc(p.getDanhMuc());
        existing.setNhaCungCap(p.getNhaCungCap());
        existing.setGia(p.getGia());
        existing.setSoLuongTon(p.getSoLuongTon());
        existing.setMoTa(p.getMoTa());
        existing.setHinhAnh(p.getHinhAnh());
        existing.setTrangThai(p.getTrangThai());
        return productRepository.save(existing);
    }

    public void delete(Integer id) {
        productRepository.deleteById(id);
    }

    public List<Product> search(String keyword) {
        return productRepository.findByTenSanPhamContainingIgnoreCase(keyword);
    }
}