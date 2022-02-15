package az.car.turbo_az.service.impl;

import az.car.turbo_az.entity.Image;
import az.car.turbo_az.exception.BusinessExceptionEnum;
import az.car.turbo_az.exception.CommonResponse;
import az.car.turbo_az.exception.NotFoundException;
import az.car.turbo_az.mapper.ImageMapper;
import az.car.turbo_az.repository.ImageRepository;
import az.car.turbo_az.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;
    private final ImageMapper imageMapper;

    @Value("${file.upload-dir}")
    String fileUploadDirectory;

    @Override
    public CommonResponse uploadImage(MultipartFile file) throws Exception {
        CommonResponse response = new CommonResponse();
        try {
            response.setItem(imageRepository.save(upload(file)));
            return response;
        } catch (Exception e) {
            throw new NotFoundException(BusinessExceptionEnum.IMAGE_CAN_NOT_BE_UPLOADED);
        }
    }

    @Override
    public CommonResponse uploadImages(MultipartFile[] files) throws Exception {
        CommonResponse response = new CommonResponse();
        List<Image> images = new ArrayList<>();
        try {
            for (MultipartFile file : files) {
                images.add(imageRepository.save(upload(file)));
            }
            response.setItem(images);
            return response;
        } catch (Exception e) {
            throw new NotFoundException(BusinessExceptionEnum.IMAGE_CAN_NOT_BE_UPLOADED);
        }
    }

//    @Override
//    public InputStreamResource downloadImage(Long id) throws Exception {
//        Optional<Image> found = imageRepository.findById(id);
//        if (found.isPresent()) {
//            Image image = found.get();
//            File file = new File(image.getFullPath());
//            return new InputStreamResource(new FileInputStream(file));
//        }
//        throw new NotFoundException(BusinessExceptionEnum.IMAGE_BY_ID_NOT_FOUND, id);
//    }

    private Image upload(MultipartFile file) throws Exception {
        File myFile = new File(fileUploadDirectory + file.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(myFile);
        fos.write(file.getBytes());
        fos.close();
        return imageMapper.toEntity(file, myFile.getAbsolutePath());
    }
}
