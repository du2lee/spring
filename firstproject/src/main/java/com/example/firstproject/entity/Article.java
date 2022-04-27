package com.example.firstproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.ToString;

@Entity // DB가 해당 객체를 인식 가능
@AllArgsConstructor
@ToString
public class Article {

    @Id
    @GeneratedValue // 자동생성 (1, 2, 3, ...)
    private Long id;

    @Column
    private String title;

    @Column
    private String content;

}
