package com.fivvy.service;

import com.fivvy.model.AcceptanceEntity;
import com.fivvy.repository.AcceptanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AcceptanceService {

    private AcceptanceRepository acceptanceRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    public AcceptanceService(AcceptanceRepository acceptanceRepository) {
        this.acceptanceRepository = acceptanceRepository;
        this.sequenceGeneratorService = sequenceGeneratorService;
    }

    public List<AcceptanceEntity> getAllAcceptanceByUserId(Optional<Long> id) {

        return acceptanceRepository.findByUserId(id);
    }

    public List<AcceptanceEntity> getAllAcceptance() {

        return acceptanceRepository.findAll();
    }

}
