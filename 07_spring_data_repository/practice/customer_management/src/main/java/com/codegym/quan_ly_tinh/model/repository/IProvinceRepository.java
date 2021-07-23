package com.codegym.quan_ly_tinh.model.repository;


import com.codegym.quan_ly_tinh.model.bean.Province;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProvinceRepository extends PagingAndSortingRepository<Province, Long> {
}
