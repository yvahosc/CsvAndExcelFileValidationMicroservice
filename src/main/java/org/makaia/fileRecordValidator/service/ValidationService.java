package org.makaia.fileRecordValidator.service;

import org.makaia.fileRecordValidator.exceptions.ApiException;
import org.makaia.fileRecordValidator.model.FileRecordProvisionalStructure;
import org.makaia.fileRecordValidator.model.VerifiableFileRecord;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ValidationService {

    public ResponseEntity<Boolean> validateFileRecord(FileRecordProvisionalStructure fileRecord)
            throws ApiException
    {
        VerifiableFileRecord structuredFileRecord = fileRecord.generateFileRecordStructure();
        return ResponseEntity.ok(structuredFileRecord.isAValidFileRecord());
    }
}
