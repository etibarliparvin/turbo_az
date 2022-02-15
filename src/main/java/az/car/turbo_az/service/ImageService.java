package az.car.turbo_az.service;

import az.car.turbo_az.exception.CommonResponse;
import org.springframework.core.io.InputStreamResource;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

    CommonResponse uploadImage(MultipartFile file) throws Exception;

    CommonResponse uploadImages(MultipartFile[] files) throws Exception;

//    InputStreamResource downloadImage(Long id) throws Exception;
}
