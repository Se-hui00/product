package com.kh.product.svc;

//사용자 입장에서의 인터페이스

import com.kh.product.dao.Product;

import java.util.List;
import java.util.Optional;

public interface ProductSVC {
  //등록
  Long save(Product product);

  //조회
  Optional<Product> findById(Long pid);

  //수정
  int update(Long pid, Product product);

  //삭제
  int delete(Long pid);

  //전체조회
  List<Product> findAll();

}
