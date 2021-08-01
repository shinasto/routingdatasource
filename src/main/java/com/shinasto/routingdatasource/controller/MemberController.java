package com.shinasto.routingdatasource.controller;

import com.shinasto.routingdatasource.common.data.ResponseData;
import com.shinasto.routingdatasource.data.MemberDto;
import com.shinasto.routingdatasource.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
public class MemberController {

  @Autowired MemberService memberService;

  @GetMapping("/{id}")
  public Object getMemberById(@PathVariable(name = "id") final Integer id) {
    MemberDto member = this.memberService.getMemberById(id);
    return ResponseData.of(member);
  }
}
