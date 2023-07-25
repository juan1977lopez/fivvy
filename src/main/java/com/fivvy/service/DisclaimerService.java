package com.fivvy.service;

import com.fivvy.exception.ResourceNotFoundException;
import com.fivvy.model.AcceptanceEntity;
import com.fivvy.model.DisclaimerEntity;
import com.fivvy.repository.DisclaimerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DisclaimerService {

    private DisclaimerRepository disclaimerRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    public DisclaimerService(DisclaimerRepository disclaimerRepository, SequenceGeneratorService sequenceGeneratorService) {
        this.disclaimerRepository = disclaimerRepository;
        this.sequenceGeneratorService = sequenceGeneratorService;
    }

    public DisclaimerEntity save(DisclaimerEntity disclaimer){

        disclaimer.setId(sequenceGeneratorService.generateSequence(DisclaimerEntity.SEQUENCE_NAME));
        AcceptanceEntity acceptanceEntity = disclaimer.getAcceptanceEntity();
        acceptanceEntity.setDisclaimerId(sequenceGeneratorService.generateSequence(AcceptanceEntity.SEQUENCE_NAME));
        disclaimer.setAcceptanceEntity(acceptanceEntity);

        return disclaimerRepository.save(disclaimer);

    }

    public DisclaimerEntity update(DisclaimerEntity disclaimer) throws ResourceNotFoundException {
        DisclaimerEntity disclaimerUpdate = disclaimerRepository.findDisclaimerById(disclaimer.getId())
                .orElseThrow(() -> new ResourceNotFoundException("not found"));
        disclaimerUpdate.setName(disclaimer.getName());
        disclaimerUpdate.setText(disclaimer.getText());
        disclaimerUpdate.setUpdateAt(disclaimer.getUpdateAt());
        disclaimerUpdate.setVersion(disclaimer.getVersion());
        disclaimerUpdate.setCreateAt(disclaimer.getCreateAt());
        return disclaimerRepository.save(disclaimer);
    }

    public List<DisclaimerEntity> getAll(){
        return disclaimerRepository.findAll();
    }

    public List<AcceptanceEntity> getAllAcceptance(){

        List<DisclaimerEntity> disclaimer = disclaimerRepository.findAll();

        var acceptanceEntities = disclaimer.stream().map(DisclaimerEntity::getAcceptanceEntity).collect(Collectors.toList());
        return acceptanceEntities;
    }
    public List<AcceptanceEntity> findByUserId(Optional<Long> userId){

        List<DisclaimerEntity> disclaimer = disclaimerRepository.findAll();
        List<AcceptanceEntity> acceptanceEntities = null;

        if(userId.isPresent()){
            acceptanceEntities = disclaimer.stream().map(DisclaimerEntity::getAcceptanceEntity).filter(c -> {
                return c.getUserId() == userId;
            }).collect(Collectors.toList());
        }

//        List<AcceptanceEntity> acceptanceEntities = disclaimer.stream().map(s -> s.getAcceptanceEntity()).collect(Collectors.toList());
        return acceptanceEntities;
    }


    public Map<String, Boolean> deleteDisclaimer(Long id) throws ResourceNotFoundException {
        DisclaimerEntity disclaimerDelete = disclaimerRepository.findDisclaimerById(id)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));
        disclaimerRepository.delete(disclaimerDelete);

        Map <String, Boolean> response = new HashMap< >();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
