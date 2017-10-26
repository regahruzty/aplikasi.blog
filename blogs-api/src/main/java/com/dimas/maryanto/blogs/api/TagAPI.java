package com.dimas.maryanto.blogs.api;

import com.dimas.maryanto.blogs.model.Tag;
import com.dimas.maryanto.blogs.repository.TagRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tags")
public class TagAPI {

    @Autowired
    private TagRepository tagRepository;
    private final static Logger terminal = LoggerFactory.getLogger(TagAPI.class);

    @GetMapping(value = "/submit")
    public void gettingDataTag(@ModelAttribute Tag tag) {
        terminal.info("{}", tag.toString());
    }

    @PostMapping(value = "/submit", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void gettingDataTagPost(@RequestBody Tag tag) {
        terminal.info("{}", tag.toString());
    }

    @GetMapping(value = "/data", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String exportData() {
        return "{\n" +
                "  \"nama\": \"Dimas maryanto\",\n" +
                "  \"status\" : true\n" +
                "}";
    }

    @GetMapping("/{tagId}")
    public Tag findById(@PathVariable(name = "tagId") Tag tag) {
        return tag;
    }

    @GetMapping(
            value = "/list",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Page<Tag> findAllWithPagination(Pageable page) {
        return tagRepository.findAll(page);
    }


}
