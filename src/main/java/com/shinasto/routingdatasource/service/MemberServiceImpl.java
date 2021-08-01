package com.shinasto.routingdatasource.service;

import com.shinasto.routingdatasource.data.MemberDto;
import com.shinasto.routingdatasource.entity.Danji;
import com.shinasto.routingdatasource.entity.Member;
import com.shinasto.routingdatasource.repository.DanjiRepository;
import com.shinasto.routingdatasource.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService {

  @Autowired MemberRepository memberRepository;
  @Autowired DanjiRepository danjiRepository;

  @Transactional(readOnly = true)
  public MemberDto getMemberById(final Integer id) {

    Optional<Member> optMember = this.memberRepository.findById(id);
    if(optMember.isPresent()) {
      Optional<Danji> optDanji = this.danjiRepository.findById(1);
      Danji danji = optDanji.get();
      Member member = optMember.get();

      log.info("Member Name={}, Danji Name={}", member.getName(), danji.getName());
      return new MemberDto(member.getId(), member.getName(), member.getAge());
    }

    return null;
  }
}
