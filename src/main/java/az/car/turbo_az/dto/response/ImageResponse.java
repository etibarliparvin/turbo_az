package az.car.turbo_az.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ImageResponse {

    private Long id;
    private String name;
    private String type;
    private byte[] data;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
