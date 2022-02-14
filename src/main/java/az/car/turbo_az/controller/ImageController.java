package az.car.turbo_az.controller;

import az.car.turbo_az.exception.CommonResponse;
import az.car.turbo_az.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/image")
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;

    @PostMapping("/one")
    public ResponseEntity<CommonResponse> one(@RequestParam("file") MultipartFile file) throws Exception {
        return ResponseEntity.ok(imageService.uploadImage(file));
    }

    @PostMapping("/many")
    public ResponseEntity<CommonResponse> many(@RequestParam("file") MultipartFile[] files) throws Exception {
        return ResponseEntity.ok(imageService.uploadImages(files));
    }
}
