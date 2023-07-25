package com.fivvy.controller;

import com.fivvy.model.AcceptanceEntity;
import com.fivvy.service.AcceptanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@RestController
//@RequestMapping("/api/v1/acceptance")
public class AcceptanceController {
//
//    @Autowired
//    private AcceptanceService acceptanceService;
//
//    @GetMapping("/search")
//    public List<AcceptanceEntity> getAcceptanceList(@RequestParam(value = "userId", required = false) Optional<Long> userId){
//        List<AcceptanceEntity> acceptanceEntity = new ArrayList<>();
//        if(userId.isPresent()){
//            acceptanceEntity = acceptanceService.getAllAcceptanceByUserId(userId);
//        } else
//        {
//            acceptanceEntity = acceptanceService.getAllAcceptance();
//        }
//        return acceptanceEntity;
//    }
}
