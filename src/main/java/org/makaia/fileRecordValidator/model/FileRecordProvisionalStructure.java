package org.makaia.fileRecordValidator.model;

import org.makaia.fileRecordValidator.exceptions.ApiException;

import java.util.List;

public class FileRecordProvisionalStructure {
    private String fileType;
    private List<String> fileRecord;

    public FileRecordProvisionalStructure(String fileType, List<String> fileRecord) {
        this.fileType = fileType;
        this.fileRecord = fileRecord;
    }

    public String getFileType() {
        return fileType;
    }

    public List<String> getFileRecord() {
        return fileRecord;
    }

    public VerifiableFileRecord generateFileRecordStructure() throws ApiException {
        if(fileType == null || fileRecord == null){
            throw new ApiException(400,"Los campos fileType y " +
                    "fileRecord no pueden ser nulos");
        }else if (fileType.equals("Excel")) {
            if(fileRecord.size() != 14){
                throw new ApiException(400, "El " +
                        "número de campos del registro no coincide con el " +
                        "requerido para un archivo de Excel");
            }else {
                return new ExcelFileRecord(fileRecord.get(0), fileRecord.get(1),
                        fileRecord.get(2), fileRecord.get(3), fileRecord.get(4),
                        fileRecord.get(5), fileRecord.get(6), fileRecord.get(7),
                        fileRecord.get(8), fileRecord.get(9), fileRecord.get(10),
                        fileRecord.get(11), fileRecord.get(12), fileRecord.get(13));
            }

        } else if (fileType.equals("csv")) {
            if(fileRecord.size() != 9){
                throw new ApiException(400, "El " +
                        "número de campos del registro no coincide con el " +
                        "requerido para un archivo csv");
            }else {
                return new CsvFileRecord(fileRecord.get(0), fileRecord.get(1),
                        fileRecord.get(2), fileRecord.get(3), fileRecord.get(4),
                        fileRecord.get(5), fileRecord.get(6), fileRecord.get(7),
                        fileRecord.get(8));
            }
        }else{
            throw new ApiException(400, "El tipo de " +
                    "archivo '" + fileType + "' no se encuentra definido");
        }
    }
}