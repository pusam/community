package com.community.services;

import com.community.domain.contents.Contents;
import com.community.domain.contents.ContentsRepository;
import com.community.web.dto.ContentsListResponseDto;
import com.community.web.dto.ContentsResponseDto;
import com.community.web.dto.ContentsSaveRequestDto;
import com.community.web.dto.ContentsUpdateRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ContentsService {
    private final ContentsRepository contentsRepository;

    @Transactional
    public Long save(ContentsSaveRequestDto contentsRequestDto) {
        return contentsRepository.save(contentsRequestDto.toEntity()).getContentId();
    }

    /**
     * 게시글 리스트 조회
     */
/*    @Transactional(readOnly = true)
    public List<ContentsListResponseDto> findAllDesc(Pageable pageable) {
        return contentsRepository.findAllDesc(pageable).stream()
                .map(ContentsListResponseDto::new)
                .collect(Collectors.toList());
    }  */

    @Transactional(readOnly = true)
    public List<ContentsListResponseDto> findAllDesc(Pageable pageable) {
        return contentsRepository.findAllDesc(pageable).stream()
                .map(ContentsListResponseDto::new)
                .collect(Collectors.toList());
    }

    public ContentsResponseDto findById(Long id) {
        Contents entity = contentsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));
        return new ContentsResponseDto(entity);
    }

    @Transactional
    public Long update(Long id, ContentsUpdateRequestDto requestDto) {
        Contents contents = contentsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));
        contents.update(requestDto.getTopicId(), requestDto.getTitle(), requestDto.getText());
        return id;
    }

    @Transactional
    public void delete(Long id) {
        Contents contents = contentsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));
        contentsRepository.delete(contents);
    }


}