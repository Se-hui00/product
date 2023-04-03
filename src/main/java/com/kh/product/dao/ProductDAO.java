package com.kh.product.dao;

//인터페이스

import java.util.List;
import java.util.Optional;

public interface ProductDAO {

  /**
   * 등록
   * @param product 상품정보
   * @return 상품아이디
   */
  Long save(Product product);

  /**
   * 조회
   * @param pid 상품아이디
   * @return 상품정보
   */
  Optional<Product> findById(Long pid);

  /**
   * 수정
   * @param pid 상품아이디
   * @param product 상품정보
   * @return 수정된 레코드 수
   */
  int update(Long pid, Product product);

  /**
   * 삭제
   * @param pid 상품아이디
   * @return 삭제된 레코드 수
   */
  int delete(Long pid);

  /**
   * 전체조회
   * @return 상품목록
   */
  List<Product> findAll();
}
