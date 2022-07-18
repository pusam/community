package com.community.web.dto;

import com.community.domain.contents.Contents;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ContentsListResponseDto {
    private Long id;
    private String title;
    private String text;
    private Long userId;
    private Long topicId;
    private LocalDateTime createDt;

    public ContentsListResponseDto(Contents entity) {
        this.id = entity.getContentId();
        this.title = entity.getTitle();
        this.text = entity.getText();
        this.userId = entity.getUserId();
        this.topicId = entity.getTopicId();
        this.createDt = entity.getCreate_dt();
    }
}