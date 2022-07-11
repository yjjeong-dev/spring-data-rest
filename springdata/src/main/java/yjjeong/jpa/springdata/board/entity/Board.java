package yjjeong.jpa.springdata.board.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
public class Board {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private int age;

    @Column
    private String name;

    public Board() {
    }

    @Builder
    public Board(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }
}