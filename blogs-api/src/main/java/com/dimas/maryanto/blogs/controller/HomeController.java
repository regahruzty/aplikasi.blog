package com.dimas.maryanto.blogs.controller;

import com.dimas.maryanto.blogs.model.Lecture;
import com.dimas.maryanto.blogs.model.Page;
import com.dimas.maryanto.blogs.model.Tag;
import com.dimas.maryanto.blogs.repository.LectureRepository;
import com.dimas.maryanto.blogs.repository.PageRepository;
import com.dimas.maryanto.blogs.repository.TagRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
public class HomeController {

    private final static Logger console = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private PageRepository pageRepository;
    @Autowired
    private TagRepository tagRepository;
    @Autowired
    private LectureRepository lectureRepository;

    @GetMapping({"/index", "/home"})
    public String home(Model model) {
        model.addAttribute("listPage", pageRepository.findAll());
        return "/pages/index";
    }

    @GetMapping("/tags/manage/{idPage}")
    public String showTagsByPage(@PathVariable(name = "idPage") Page page, Model model) {
        model.addAttribute("p", page);
        List<Tag> listTags = page.getListTags();
        List<String> ids = listTags.stream().map(Tag::getId).collect(Collectors.toList());
        if (ids.size() >= 1)
            model.addAttribute("tagList", tagRepository.cariBerdasarkanYangUdahAda(ids));
        else
            model.addAttribute("tagList", tagRepository.findAll());

        return "/pages/manage-tags";
    }

    @PostMapping("/pages/manage/tag/new")
    public String submitNewTagInPage(@ModelAttribute Page page) {
        Page oldPage = pageRepository.findOne(page.getId());
        List<Tag> oldListTags = oldPage.getListTags();
        oldListTags.addAll(page.getListTags());
        pageRepository.save(oldPage);
        return "redirect:/tags/manage/" + page.getId();
    }

    @GetMapping("/pages/{pageId}/{tagId}")
    public String removeTagByPage(
            @PathVariable(name = "pageId") Page page,
            @PathVariable(name = "tagId") Tag tag) {
        page.getListTags().remove(tag);
        pageRepository.save(page);
        return "redirect:/tags/manage/" + page.getId();
    }

    @GetMapping("/pages/{pageId}/lecture/new")
    public String newLectureByPage(@PathVariable(name = "pageId") Page page, Lecture lecture, Model model) {
        lecture.setPage(page);
        model.addAttribute("lecture", lecture);
        return "/pages/lecture-new";
    }

    @PostMapping("/pages/lecture/new")
    public String submitNewLecture(@ModelAttribute Lecture lecture) {
        lectureRepository.save(lecture);
        return "redirect:/index";
    }

    @GetMapping("/pages/{pageId}/materi")
    public String manageMateri(@PathVariable(name = "pageId") Page page, Model model) {
        model.addAttribute("page", page);
        model.addAttribute("listMateri", lectureRepository.findByPage(page));
        return "/pages/materi-list";
    }
}
