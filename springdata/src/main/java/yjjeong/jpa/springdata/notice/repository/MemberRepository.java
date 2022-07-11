package yjjeong.jpa.springdata.notice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yjjeong.jpa.springdata.notice.entity.Member;

/**
 * @author yjjeong
 */
public interface MemberRepository extends JpaRepository<Member, Long> {

}
