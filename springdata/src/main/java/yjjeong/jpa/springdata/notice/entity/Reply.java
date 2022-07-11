package yjjeong.jpa.springdata.notice.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@Builder
@ToString
@Table(name = "reply")
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "reply_id")
    private long replyId;

    @Column(name = "notice_id")
    private Long noticeId;

    @Column(name = "user_id")
    private Long userId;

    @Column
    private String password;

    @Column
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
}
