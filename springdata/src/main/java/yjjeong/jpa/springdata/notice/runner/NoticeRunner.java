package yjjeong.jpa.springdata.notice.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import yjjeong.jpa.springdata.notice.entity.Member;
import yjjeong.jpa.springdata.notice.repository.MemberRepository;

//@Component
@PropertySource({"classpath:action.properties"})
public class NoticeRunner implements ApplicationRunner {

    @Value("${repository.create}")
    private boolean create;
    @Value("${repository.read}")
    private boolean read;
    @Value("${repository.update}")
    private boolean update;
    @Value("${repository.delete}")
    private boolean delete;

    @Autowired
    MemberRepository memberRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Member member = Member.builder().password("petra@one1").name("parkew").gender("M").phone("010-1577-3082")
                .email("parkew@sinsiway.com").build();

        if (create) {
            member = memberRepository.save(member);
        } else {
            member.setMemberId(Long.valueOf(1));
        }

        memberRepository.findAll();

        memberRepository.findById(member.getMemberId());

        if (delete) {
            memberRepository.deleteById(member.getMemberId());
        }
    }
}
