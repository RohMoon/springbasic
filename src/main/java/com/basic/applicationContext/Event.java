package com.basic.applicationContext;


public class Event {

    Integer id;

//    @NotEmpty//비어 있으면 안된다.
//    String title;
//
//    @NotNull @Min(0)// Null 이면 안됨. 최솟값은 0
//    Integer limit;
//
//    @Email // 이메일 형식이어야함.
//    String email;


    String title; // 비어있으면 안됨.

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
