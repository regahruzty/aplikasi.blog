package com.dimas.maryanto.blogs.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pages")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"listTags", "lectureList"})
public class Page {

    @Id
    @GenericGenerator(name = "gen_page", strategy = "uuid2")
    @GeneratedValue(generator = "gen_page")
    private String id;

    @Column(length = 50, nullable = false)
    private String judul;

    @Column(length = 150)
    private String message;

    @Lob
    private String description;

    @Column(nullable = false, name = "img_url")
    private String logoUrl;

    @OneToMany
    @JoinTable(name = "tag_pages",
            joinColumns = @JoinColumn(name = "page_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "tag_id", nullable = false))
    private List<Tag> listTags = new ArrayList<>();

    @OneToMany(mappedBy = "page")
    private List<Lecture> lectureList = new ArrayList<>();
}
