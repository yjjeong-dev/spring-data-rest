package yjjeong.jpa.springdata.team.entity;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.jpa.repository.EntityGraph;

/**
 * TODO 1. 왜 테스트 코드는 쿼리가 한개 인가? 트랜잭션과 Persistence Context Answer - 트랜잭션 내에서는 이미
 * 등록된 객체들의 정보를 알기 떄문에 쿼리를 다시 날리지않는다
 * TODO 2. Member 정보만 쿼리 한번으로 가져오는 방법은 ?
 * (fetch = FetchType.LAZY)
 * 
 * 
 */
//https://data-make.tistory.com/628
@Entity
@Getter
@Setter
@ToString
@Table(name = "player")
@NamedEntityGraph(name = "Player.team",
        attributeNodes = @NamedAttributeNode("team"))
public class Player {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Team team;

}
