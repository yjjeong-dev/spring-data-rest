package yjjeong.jpa.springdata.team.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import yjjeong.jpa.springdata.team.entity.Player;

import java.util.List;
import java.util.Optional;

/**
 * @author yjjeong
 */
public interface PlayerRepository extends JpaRepository<Player, Long> {

    @EntityGraph(value = "Player.team", type = EntityGraph.EntityGraphType.LOAD)
    Optional<Player> findById(long id);
}