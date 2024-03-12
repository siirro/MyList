package com.home.mylist.service;

import com.home.mylist.domain.Member;
import com.home.mylist.repository.MemberRepository;
import com.home.mylist.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 회원 가입
    public Long join(Member member) {
        //같은 이름이 있는 중복 회원X
        //옵셔널이니까 null이 들어올수도있음. ispresent를 사용해서 null이 아니라면 중복회원!
//        Optional<Member> result = memberRepository.findByName(member.getName());
//        result.ifPresent(m -> {
//            throw new IllegalStateException("이미 존재하는 회원입니다.")
//        });

        //위에꺼를 정리하면? 이렇게 되어요! 근데 외부로 추출했어요! 컨트롤알트M
        validateDupplicateMember(member);

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDupplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /*
    * 전체 회원 조회
    * */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
