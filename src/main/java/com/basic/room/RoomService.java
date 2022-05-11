package com.basic.room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class RoomService {

//    @Qualifier("roomRepositoryOne")
    @Autowired
    RoomRepository roomRepository;

    @PostConstruct
    public void setup(){
        System.out.println(roomRepository.toString());
    }
}
