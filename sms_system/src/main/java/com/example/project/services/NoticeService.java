package com.example.project.services;

import com.example.project.entity.Notice;
import com.example.project.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class NoticeService {
    @Autowired
    private NoticeRepository noticeRepository;

    public List<Notice> DisplayNotice(){

        return noticeRepository.findAll();
    }
    public Notice getNoticeById(int id){
        return noticeRepository.findById(id).get();
    }

    public Notice saveNotice(Notice noticeData){
        Notice notice =new Notice();
        notice.setNoticeName(noticeData.getNoticeName());
        notice.setNotice(noticeData.getNotice());
        noticeRepository.save(notice);

        return notice;
    }

    public void updateNotice(Notice notice)
    {
        noticeRepository.save(notice);
    }

    public ResponseEntity<?> deleteNotice(int id){
        noticeRepository.deleteById(id);
        return new ResponseEntity<String>("Deleted", HttpStatus.OK);
    }




}
