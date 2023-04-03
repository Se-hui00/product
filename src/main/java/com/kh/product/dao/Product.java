package com.kh.product.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data               //@Getter, @Setter, @ToString, @EqualsAndHashCode, @RequireArgsConstructor
@AllArgsConstructor //모든 멤버필드를 매개변수로 하는 생성자 생성
@NoArgsConstructor  //디폴트 생성자
public class Product {
  private Long pid;       //  PID	NUMBER(10,0)
  private String pname;   //  PNAME	VARCHAR2(30 BYTE)
  private Long quantity;  //  QUANTITY	NUMBER(10,0)
  private Long price;     //  PRICE	NUMBER(10,0)
}
