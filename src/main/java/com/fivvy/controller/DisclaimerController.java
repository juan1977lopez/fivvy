package com.fivvy.controller;

import com.fivvy.exception.ResourceNotFoundException;
import com.fivvy.model.AcceptanceEntity;
import com.fivvy.model.DisclaimerEntity;
import com.fivvy.service.DisclaimerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/disclaimer")
public class DisclaimerController {

    @Autowired
    private DisclaimerService disclaimerService;

    @PostMapping()
    public DisclaimerEntity save(@RequestBody DisclaimerEntity disclaimer){
        return disclaimerService.save(disclaimer);
    }

    @PutMapping()
    public DisclaimerEntity update(@RequestBody DisclaimerEntity disclaimer) throws ResourceNotFoundException {
        return disclaimerService.update(disclaimer);
    }

    @GetMapping()
    public List<DisclaimerEntity> getAllDisclaimer(){
        return disclaimerService.getAll();
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteDisclaimer(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        return disclaimerService.deleteDisclaimer(id);
    }

    @GetMapping("/search")
    public List<AcceptanceEntity> getAcceptanceList(@RequestParam(value = "userId", required = false) Optional<Long> userId){
        List<AcceptanceEntity> acceptanceEntity = new ArrayList<>();
        if(userId.isPresent()){
            acceptanceEntity = disclaimerService.findByUserId(userId);
        } else
        {
            acceptanceEntity = disclaimerService.getAllAcceptance();
        }
        return acceptanceEntity;

    }

}
