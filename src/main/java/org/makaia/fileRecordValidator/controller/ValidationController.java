package org.makaia.fileRecordValidator.controller;

import org.makaia.fileRecordValidator.exceptions.ApiException;
import org.makaia.fileRecordValidator.model.FileRecordProvisionalStructure;
import org.makaia.fileRecordValidator.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/file-records")
public class ValidationController {
    ValidationService validationService;

    @Autowired()
    public ValidationController(ValidationService validationService){
        this.validationService = validationService;
    }

    @PostMapping()
    public ResponseEntity<Boolean> validateFileRecord(
            @RequestBody() FileRecordProvisionalStructure fileRecord) throws ApiException {
        return validationService.validateFileRecord(fileRecord);
    }
}