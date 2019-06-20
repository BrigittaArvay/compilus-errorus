package com.codecool.compiluserrorus.service;

import com.codecool.compiluserrorus.model.Member;
import com.codecool.compiluserrorus.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<Member> getFriends() {
        List<Member> friends = this.memberRepository.findAll();
        Member first = friends.get(0);
        friends.remove(first);
        return friends;
    }

    public Member getDummyMember() {
        List<Member> members = this.memberRepository.findAll();
        return members.get(0);
    }
}
