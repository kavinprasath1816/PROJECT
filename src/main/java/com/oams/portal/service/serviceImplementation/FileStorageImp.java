package com.oams.portal.service.serviceImplementation;

import com.oams.portal.config.FileStorageProperties;
import com.oams.portal.service.FileStorageService;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

@Service
public class FileStorageImp implements FileStorageService{

    private final Path fileStorageLocation;

    public FileStorageImp(FileStorageProperties fileStorageProperties)
    {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir()).toAbsolutePath().normalize();

        try{
            Files.createDirectories(this.fileStorageLocation);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public String loadFile(String fileName) throws MalformedURLException {
        return this.fileStorageLocation.resolve(fileName).normalize().toString();
    }

    @Override
    public String saveFile(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try{
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(),targetLocation,StandardCopyOption.REPLACE_EXISTING);
            return fileName;
        }
        catch(IOException ex){
            throw new IOException("Error in file",ex);
        }
    }


    @Override
    public Resource loadImg(String fileName) throws MalformedURLException {
        Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
        Resource resource = new UrlResource(filePath.toUri());
        return resource;
    }


    @Override
    public String saveImg(MultipartFile file) throws IOException {
        File f = new File(file.getOriginalFilename());
        f.createNewFile();
        FileOutputStream fout = new FileOutputStream(f);
        fout.write(file.getBytes());
        fout.close();
        ImageIO.read(f);

        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        try {
            if (fileName.contains(". ."))
                throw new Exception("Invalid file");
        } catch (Exception e) {
            e.printStackTrace();
        }
        String newFileName = System.currentTimeMillis() + "_" + fileName;
        Path targetLocation = this.fileStorageLocation.resolve(newFileName);
        Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

        return newFileName;
    }


    
}
