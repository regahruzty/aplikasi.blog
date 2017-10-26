package com.dimas.maryanto.blogs.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tags")
public class Tag {

    @Id
    @GenericGenerator(name = "gen_tag", strategy = "uuid2")
    @GeneratedValue(generator = "gen_tag")
    private String id;

    @Column(length = 20, nullable = false, unique = true)
    private String nama;

}
