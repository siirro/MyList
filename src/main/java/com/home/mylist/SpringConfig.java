package com.home.mylist;

import com.home.mylist.repository.JDBCMemberRepository;
import com.home.mylist.repository.JDBCTemplateMemberRepository;
import com.home.mylist.repository.MemberRepository;
import com.home.mylist.repository.MemoryMemberRepository;
import com.home.mylist.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    //    @Bean
//    public MemberService memberService() {
//        return new MemberService(memberRepository());
//    }
//
    @Bean
    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//        return new JDBCMemberRepository(dataSource);
        return new JDBCTemplateMemberRepository(dataSource);
    }
}
