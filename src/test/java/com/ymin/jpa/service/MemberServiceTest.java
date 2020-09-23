package com.ymin.jpa.service;

import com.ymin.jpa.domain.Member;
import com.ymin.jpa.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@SpringBootTest
@RunWith(SpringRunner.class)
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
        assertEquals(member, memberRepository.findById(saved));
    }

    @Test(expected = IllegalStateException.class)
    public void 중복_회원_예외() throws Exception{

        //Given
        Member member1 = new Member();
        member1.setName("kim");

        Member member2 = new Member();
        member2.setName("kim");

        //When
        memberService.join(member1);
        memberService.join(member2); //예외가 발생해야 한다.

        //Then
        fail("에외가 발생해야 한다.");
    }
}
