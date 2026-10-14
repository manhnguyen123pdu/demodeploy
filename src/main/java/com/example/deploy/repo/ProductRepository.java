package com.example.deploy.repo;
import com.example.deploy.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByDanhMuc(String danhMuc);
    List<Product> findByTenSanPhamContainingIgnoreCase(String keyword);
    List<Product> findByTrangThai(Boolean trangThai);
}