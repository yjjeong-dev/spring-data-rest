package yjjeong.jpa.springdata.team.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yjjeong.jpa.springdata.team.entity.Team;

/**
 * @author yjjeong
 */
public interface TeamRepository extends JpaRepository<Team, Long> {

}