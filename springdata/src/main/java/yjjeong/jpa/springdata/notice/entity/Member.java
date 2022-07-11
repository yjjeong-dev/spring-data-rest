package yjjeong.jpa.springdata.notice.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name = "member")
@SequenceGenerator(name = "member_seq_gen", // 시퀀스 제너레이터 이름
        sequenceName = "member_seq", // 시퀀스 이름
        initialValue = 1, // 시작값
        allocationSize = 1 // 메모리를 통해 할당할 범위 사이즈
)
@NoArgsConstructor
public class Member {

    // @GeneratedValue(strategy = GenerationType.AUTO)
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @GeneratedValue(strategy = GenerationType.TABLE)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq_gen")
    @Column(name = "member_id")
    private Long memberId;

    @Column
    private String password;

    @Column
    private String name;

    @Column
    private String gender;

    @Column
    private String phone;

    @Column
    private String email;

    // @OneToMany
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "member_id", insertable = false, updatable = false)
    private List<Notice> notices = new ArrayList<Notice>();

    @Builder
    public Member(Long memberId, String password, String name, String gender, String phone, String email) {
        super();
        this.memberId = memberId;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
    }

}