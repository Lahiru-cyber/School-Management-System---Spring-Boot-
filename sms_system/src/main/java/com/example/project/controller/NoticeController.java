package com.example.project.controller;

import com.example.project.entity.Notice;
import com.example.project.services.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@RestController
public class NoticeController {
    @Autowired
    NoticeService noticeService;

    //Display all the notices
    @GetMapping("/displaynotice")
    public List<Notice> getNotice(){
        return noticeService.DisplayNotice();

    }
    //Display notice by id
    @GetMapping("/notice/{id}")
    public Notice getNotice(@PathVariable("id")int id){
        return noticeService.getNoticeById(id);
    }

    //Insert notices
    @PostMapping("/notice")
    public Notice addNotice(@RequestBody Notice notice){
        return noticeService.saveNotice(notice);
    }

    //Update notice by id
    @PutMapping("/updateNotice")
    private Notice update(@RequestBody Notice notice)
    {
        noticeService.updateNotice(notice);
        return notice;
    }
    //Delete notice by id
    @DeleteMapping(value = "/deletenotice/{id}")
    public ResponseEntity<?> noticeDelete(@PathVariable ("id") int id) {

        return noticeService.deleteNotice(id);
    }

}


