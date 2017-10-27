package com.dimas.maryanto.blogs.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "lectures")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lecture {

    @Id
    @GenericGenerator(name = "gen_lecture", strategy = "uuid2")
    @GeneratedValue(generator = "gen_lecture")
    private String id;

    @Column(name = "title", nullable = false, length = 50)
    private String title;

    //    @Lob
    private String article;

    @ManyToOne
    @JoinColumn(name = "page_id", nullable = false)
    private Page page;
}
