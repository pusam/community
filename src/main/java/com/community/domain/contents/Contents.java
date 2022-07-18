package com.community.domain.contents;

import com.community.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Getter
@Entity
@DynamicInsert
public class Contents extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contentId;
    private Long userId;
    private Long topicId;
    private String title;
    private String text;
    private String createIp;

    @Builder
    public Contents(Long contentId, Long userId, Long topicId, String title, String text, String createIp) {
        this.contentId = contentId;
        this.userId = userId;
        this.topicId = topicId;
        this.title = title;
        this.text = text;
        this.createIp = createIp;
    }

    public void update(Long topicId, String title, String text) {
        this.topicId = topicId;
        this.title = title;
        this.text = text;
    }
}