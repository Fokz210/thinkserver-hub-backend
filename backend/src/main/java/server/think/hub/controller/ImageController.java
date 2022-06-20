package server.think.hub.controller;

import org.apache.coyote.http11.upgrade.UpgradeProcessorInternal;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

@RestController
@RequestMapping("/api/image")
public class ImageController {
    @PostMapping(value = "/convert-to/{format}", produces = MediaType.ALL_VALUE)
    public @ResponseBody byte[] convertTo(@RequestParam("image")MultipartFile multipartImage, @PathVariable String format) {
        try {
            BufferedImage image = ImageIO.read(multipartImage.getInputStream());
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write(image, format, os);
            return os.toByteArray();
        } catch (java.io.IOException e) {
            return new byte[0];
        }
    }

    @GetMapping("/formats")
    public String[] getFormats() {
        return ImageIO.getWriterFormatNames();
    }
}
