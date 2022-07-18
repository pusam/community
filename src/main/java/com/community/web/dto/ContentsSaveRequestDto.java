package com.community.web.dto;

import com.community.domain.contents.Contents;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ContentsSaveRequestDto {
    private Long contentId;
    private Long userId;
    private Long topicId;
    private String title;
    private String text;
    private String createIp;

    public ContentsSaveRequestDto(Contents contents) {
        this.contentId = contents.getContentId();
        this.userId = contents.getUserId();
        this.topicId = contents.getTopicId();
        this.title = contents.getTitle();
        this.text = contents.getText();
        this.createIp = contents.getCreateIp();
    }

    public Contents toEntity() {
        return Contents.builder()
                .contentId(contentId)
                .userId(userId)
                .topicId(topicId)
                .title(title)
                .text(text)
                .createIp(createIp)
                .build();
    }
}