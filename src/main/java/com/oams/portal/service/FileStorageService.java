package com.oams.portal.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;

public interface FileStorageService {

    public String saveFile(MultipartFile file) throws IOException;

    public String loadFile(String fileName) throws MalformedURLException;

    public String saveImg(MultipartFile file) throws IOException;

    public Resource loadImg(String fileName) throws MalformedURLException;


    
}
