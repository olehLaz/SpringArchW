package ua.arch.actions;

import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ArchivatorZip {
    public byte[] createZipFromMultipart(MultipartFile[] files) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try(ZipOutputStream zipOutputStream = new ZipOutputStream(outputStream)) {
            for (MultipartFile multipartFile: files) {
                if (multipartFile.getOriginalFilename() == null) {
                    continue;
                }
                ZipEntry entry = new ZipEntry(multipartFile.getOriginalFilename());
                zipOutputStream.putNextEntry(entry);
                zipOutputStream.write(multipartFile.getBytes());
                zipOutputStream.closeEntry();
            }
        } catch (IOException e) {
            throw e;
        }
        return outputStream.toByteArray();
    }
}
