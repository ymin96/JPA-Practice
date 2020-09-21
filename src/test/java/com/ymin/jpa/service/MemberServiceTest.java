package com.ymin.jpa.service;

import com.ymin.jpa.domain.Member;
import com.ymin.jpa.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class MemberServiceTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @Test
    public void 회원가입() throws Exception{

        //Given
        Member member = new Member();
        member.setName("kim");

        //When
        Long saved = memberService.join(member);

        //Then
        assertEquals(member, memberRepository.findOne(saved));
    }
}
