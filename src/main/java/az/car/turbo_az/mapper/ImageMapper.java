package az.car.turbo_az.mapper;

import az.car.turbo_az.dto.response.ImageResponse;
import az.car.turbo_az.entity.Image;
import org.springframework.stereotype.Component;

@Component
public class ImageMapper {

    public ImageResponse toResponse(Image image) {
        ImageResponse response = new ImageResponse();
        response.setId(image.getId());
        response.setName(image.getName());
        response.setType(image.getType());
        response.setData(image.getData());
        response.setCreatedAt(image.getCreatedAt());
        response.setModifiedAt(image.getModifiedAt());
        return response;
    }
}
