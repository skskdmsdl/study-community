package com.developer.community.model.entity;

import com.developer.community.model.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;

@Entity
@Table(name = "study")
@Getter
@Setter
@SQLDelete(sql = "UPDATE study SET deleted_at = NOW() where id=?")
@Where(clause = "deleted_at is NULL")
@NoArgsConstructor
public class StudyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "body", columnDefinition = "TEXT")
    private String body;

    @Column(name = "recruitment")   // 0이면 모집 중, 1이면 모집 완료
    private Integer recruitment;

    @Column(name = "subject")
    private String subject;

    @Column(name = "on_offline")   // 0이면 전체, 1이면 온라인, 2이면 오프라인
    private Integer onOffline;

    @Column(name = "member_count")
    private Integer memberCount;

    @ManyToOne // 하나의 유저가 여러 post 쓸 수 있음
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Column(name = "registered_at")
    private Timestamp registeredAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @Column(name = "deleted_at")
    private Timestamp deletedAt;

    @PrePersist
    void registeredAt() {
        this.registeredAt = Timestamp.from(Instant.now());
        this.recruitment = 0;
        this.subject = "선택안함";
        this.onOffline = 0;
    }

    @PreUpdate
    void updatedAt() {
        this.updatedAt = Timestamp.from(Instant.now());
    }

    public static StudyEntity of(String title, String body, Integer recruitment, String subject, Integer onOffline,
                                 Integer memberCount, UserEntity userEntity) {
        StudyEntity entity = new StudyEntity();
        entity.setTitle(title);
        entity.setBody(body);
        entity.setRecruitment(recruitment);
        entity.setSubject(subject);
        entity.setOnOffline(onOffline);
        entity.setMemberCount(memberCount);
        entity.setUser(userEntity);
        return entity;
    }

    @Builder
    public StudyEntity(String title, String body, Integer recruitment, String subject, Integer onOffline,
                               Integer memberCount, UserEntity userEntity) {
        this.title = title;
        this.body = body;
        this.recruitment = recruitment;
        this.subject = subject;
        this.onOffline = onOffline;
        this.memberCount = memberCount;
        this.user = userEntity;

    }

    // study update
    public void updateStudy(String title, String body, Integer recruitment, String subject, Integer onOffline, Integer memberCount) {
        this.title = title;
        this.body = body;
        this.recruitment = recruitment;
        this.subject = subject;
        this.onOffline = onOffline;
        this.memberCount = memberCount;
    }
}
