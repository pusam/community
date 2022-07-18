package com.community.web.dto;
import com.community.domain.contents.Contents;
import lombok.Getter;

@Getter
public class ContentsResponseDto
{
    private Long id;
    private Long topicId;
    private String title;
    private String text;
    public ContentsResponseDto(Contents entity) {
        this.id = entity.getContentId();
        this.topicId = entity.getTopicId();
        this.title = entity.getTitle();
        this.text = entity.getText();
    }
}