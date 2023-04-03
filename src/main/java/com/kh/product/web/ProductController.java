package com.kh.product.web;

import com.kh.product.dao.Product;
import com.kh.product.svc.ProductSVC;
import com.kh.product.web.form.SaveForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/products")
@RequiredArgsConstructor  //final 멤버필드를 매개값으로 하는 생성자를 자동 생성
public class ProductController {

  private final ProductSVC productSVC;

  //등록
  // 1)등록 양식
  @GetMapping("/add")
  public String save(Model model) {
    SaveForm saveForm = new SaveForm();
    model.addAttribute("saveForm", saveForm);
    return "product/saveForm";
  }

  // 2)등록처리
  @PostMapping("/add")
  public String save(SaveForm saveForm) {
    log.info("saveForm={}", saveForm);
    //데이터 검증

    //글로벌 오류

    //등록
    Product product = new Product();
    product.setPname(saveForm.getPname());
    product.setQuantity(saveForm.getQuantity());
    product.setPrice(saveForm.getPrice());

    Long savePid = productSVC.save(product);

    return "redirect:/products/{id}/detail";

  }




  //조회

  //수정

  //삭제

  //전체조회
}
