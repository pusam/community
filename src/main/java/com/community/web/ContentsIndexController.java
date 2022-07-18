package com.community.web;

import com.community.services.ContentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class ContentsIndexController {
    private final ContentsService contentsService;

    @GetMapping("/contents/list")
    public String findAll(Model model, @PageableDefault(size = 5) Pageable pageable) {
        model.addAttribute("contents", contentsService.findAllDesc(pageable));
        return "contents/contents-list";
    }

    @GetMapping("/contents/save")
    public String save() {
        return "contents/contents-save";
    }

    @GetMapping("/contents/update/{id}")
    public String update(@PathVariable Long id, Model model) {
        model.addAttribute("content", contentsService.findById(id));
        return "contents/contents-update";
    }

}