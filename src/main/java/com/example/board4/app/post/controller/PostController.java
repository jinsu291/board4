package com.example.board4.app.post.controller;

import com.example.board4.app.post.entity.Post;
import com.example.board4.app.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    @GetMapping("/write")
    public String showWrite() {
        return "post/write";
    }

    @PostMapping("/write")
    public String write(@RequestParam String subject, @RequestParam String content, @RequestParam String contentHtml,
                      RedirectAttributes redirectAttributes){
        Post newPost = new Post(subject, content, contentHtml);
        Long id = postService.write(newPost);
        System.out.println("id = " + id);

        redirectAttributes.addAttribute("id", id);
        redirectAttributes.addAttribute("status", true);
        return "redirect:/post/{id}";
    }
}
