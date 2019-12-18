package ua.arch.controllers;

import ua.arch.exceptions.IOStreamException;
import ua.arch.exceptions.NoFilesException;
import ua.arch.actions.ArchivatorZip;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/")
public class ArchivatorController {

    @RequestMapping("/")
    public String onIndex() {
        return "index";
    }

    @RequestMapping(value = "/archive", method = RequestMethod.POST)
    public ResponseEntity<byte[]> onArchive(@RequestParam MultipartFile[] files) {
        if (files == null) {
            throw new NoFilesException();
        }

        ArchivatorZip zip = new ArchivatorZip();

        byte[] bytes = new byte[0];
        try {
            bytes = zip.createZipFromMultipart(files);
        } catch (IOException e) {
            throw new IOStreamException();
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf("application/zip"));
        headers.setContentDispositionFormData("attachment", "files.zip");
        return new ResponseEntity<>(bytes, headers, HttpStatus.OK);
    }
}
