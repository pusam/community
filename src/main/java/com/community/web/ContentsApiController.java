package com.community.web;

import com.community.services.ContentsService;
import com.community.web.dto.ContentsSaveRequestDto;
import com.community.web.dto.ContentsUpdateRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class ContentsApiController {
    private final ContentsService contentsService;

    @PostMapping("/contents/save")
    public Long save(@RequestBody ContentsSaveRequestDto contentsRequestDto) {
        contentsRequestDto.setCreateIp("1");
        contentsRequestDto.setUserId((long) 1);
        return contentsService.save(contentsRequestDto);
    }

    @PutMapping("/contents/update/{id}")
    public Long update(@PathVariable Long id, @RequestBody ContentsUpdateRequestDto requestDto) {
        return contentsService.update(id, requestDto);
    }

    @DeleteMapping("/contents/delete/{id}")
    public Long delete(@PathVariable Long id) {
        contentsService.delete(id);
        return id;
    }

}