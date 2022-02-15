package az.car.turbo_az.mapper;

import az.car.turbo_az.entity.Car;
import az.car.turbo_az.entity.Image;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class ImageMapper {

    public Image toEntity(MultipartFile file, String absolutePath) {
        Image image = new Image();
        image.setName(file.getOriginalFilename());
        image.setExtension(file.getContentType());
        image.setFullPath(absolutePath);
        return image;
    }

    public Image toEntity(MultipartFile file, String absolutePath, Car car) {
        Image image = new Image();
        image.setName(file.getOriginalFilename());
        image.setExtension(file.getContentType());
        image.setFullPath(absolutePath);
        image.setCar(car);
        return image;
    }

    public String toResponse(Image image) {
        return image.getFullPath();
    }
}
