package com.example.board4.app.post.controller;

import com.example.board4.app.post.entity.Post;
import com.example.board4.app.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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


    @GetMapping("/{id}/modify")
    public String showModify(@PathVariable Long id, Model model){
        Post findPost = postService.findById(id);
        model.addAttribute("post", findPost);
        return "post/modify";
    }

    @PostMapping("/{id}/modify")
    public String showModify(@PathVariable Long id, @RequestParam String subject,
                           @RequestParam String content, @RequestParam String contentHtml)
    {
        Post findPost = postService.findById(id);
        findPost.setSubject(subject);
        findPost.setContent(content);
        findPost.setContentHtml(contentHtml);

        postService.update(findPost);

        return "redirect:/post/{id}";
    }

    @GetMapping("/{id}/remove")
    public String remove(@PathVariable Long id){
        postService.deleteById(id);
        return "redirect:/post";
    }

    @GetMapping("")
    public String main(Model model){
        model.addAttribute("posts", postService.postList());
        return "/post/list";
    }

    @GetMapping("/{id}")
    public String article(@PathVariable long id, Model model){
        model.addAttribute("post", postService.findById(id));
        return "/post/detail";
    }
}
