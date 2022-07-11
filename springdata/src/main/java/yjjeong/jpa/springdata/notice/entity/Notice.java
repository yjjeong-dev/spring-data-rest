package yjjeong.jpa.springdata.notice.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name = "notice")
@NoArgsConstructor
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "notice_id")
    private Long noticeId;

    @Column(name = "member_id")
    private Long memberId;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "member_id", insertable = false, updatable = false)
    private Notice notice;

    @Builder
    public Notice(Long noticeId, Long memberId, String password, String title, String content, Date date) {
        super();
        this.noticeId = noticeId;
        this.memberId = memberId;
        this.title = title;
        this.content = content;
        this.password = password;
        this.date = date;
    }

}
