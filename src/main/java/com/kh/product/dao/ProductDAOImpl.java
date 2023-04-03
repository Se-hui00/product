package com.kh.product.dao;

//구현체

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor  //final 멤버필드를 매개값으로 하는 생성자 자동생성
public class ProductDAOImpl implements ProductDAO {

  //호출하려면 -> DB 주소를 알아야 함
  private final NamedParameterJdbcTemplate template;

  /**
   * 등록
   *
   * @param product 상품정보
   * @return 상품아이디
   */
  @Override
  public Long save(Product product) {

    //1.검증된 sql 준비
    StringBuffer sb = new StringBuffer();
    sb.append("insert into product(pid, pname, quantity, price) ");
    sb.append("       values(product_pid_seq.nextval, :pname, :quantity, :price) ");

    //2.파라미터 값을 매핑 -case1)bean
    SqlParameterSource param = new BeanPropertySqlParameterSource(product); //파라미터 값 매핑
    KeyHolder keyHolder = new GeneratedKeyHolder();                         //매핑값 받아올 객체

    template.update(sb.toString(), param, keyHolder, new String[]{"pid"});  //(쿼리, 파라미터 치환값, 값을 전달받을 객체, 읽어들이는 방법)

    long pid = keyHolder.getKey().longValue();  //키홀더를 통해 키를 받아옴

    return pid;
  }

  /**
   * 조회
   *
   * @param pid 상품아이디
   * @return 상품정보
   */
  @Override
  public Optional<Product> findById(Long pid) {
    return Optional.empty();
  }

  /**
   * 수정
   *
   * @param pid     상품아이디
   * @param product 상품정보
   * @return 수정된 레코드 수
   */
  @Override
  public int update(Long pid, Product product) {
    return 0;
  }

  /**
   * 삭제
   *
   * @param pid 상품아이디
   * @return 삭제된 레코드 수
   */
  @Override
  public int delete(Long pid) {
    return 0;
  }

  /**
   * 전체조회
   *
   * @return 상품목록
   */
  @Override
  public List<Product> findAll() {
    return null;
  }
}
