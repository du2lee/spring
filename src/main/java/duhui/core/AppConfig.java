package duhui.core;

import duhui.core.member.MemberService;
import duhui.core.member.MemberServiceImpl;
import duhui.core.member.MemoryMemberRepository;

public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }


}
