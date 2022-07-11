package yjjeong.jpa.springdata.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yjjeong.jpa.springdata.board.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {

    /* interface 내 구현된 메소드명에 따라 SQL 문장을 자동 생성 */
    Board findByNameAndAge(String name, int age);

}