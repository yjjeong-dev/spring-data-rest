package yjjeong.jpa.springdata.notice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yjjeong.jpa.springdata.notice.entity.Notice;

/**
 * @author yjjeong
 */
public interface NoticeRepository extends JpaRepository<Notice, Long> {

}
