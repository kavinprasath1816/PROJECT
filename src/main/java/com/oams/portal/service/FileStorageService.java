package com.oams.portal.service;

import java.io.IOException;
import java.net.MalformedURLException;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {

    public String saveFile(MultipartFile file) throws IOException;

    public Resource loadFile(String fileName) throws MalformedURLException;

    public String saveImg(MultipartFile file) throws IOException;

    public Resource loadImg(String fileName) throws MalformedURLException;


    
}
