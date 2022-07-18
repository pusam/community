package com.community.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ContentsUpdateRequestDto {
    private Long topicId;
    private String title;
    private String text;

    @Builder
    public ContentsUpdateRequestDto(Long topicId, String title, String text) {
        this.topicId = topicId;
        this.title = title;
        this.text = text;
    }
}