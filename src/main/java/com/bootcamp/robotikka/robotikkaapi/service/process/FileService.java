package com.bootcamp.robotikka.robotikkaapi.service.process;

import com.amazonaws.services.s3.model.ObjectListing;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;

public interface FileService {
    public HashMap<String,String> createFile(MultipartFile file, String directory, String user, int randomId) throws IOException;
    public boolean deleteFile(String directory, String fileName) throws IOException;
    public byte[] downloadFile(String directory, String fileName) throws IOException;
    public ObjectListing allFiles() throws IOException;
}
