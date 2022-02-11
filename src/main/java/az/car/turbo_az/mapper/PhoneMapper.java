package az.car.turbo_az.mapper;

import az.car.turbo_az.dto.request.PhoneRequest;
import az.car.turbo_az.dto.response.PhoneResponse;
import az.car.turbo_az.entity.Owner;
import az.car.turbo_az.entity.Phone;
import org.springframework.stereotype.Component;

@Component
public class PhoneMapper {

    public Phone toEntity(PhoneRequest request) {
        Phone phone = new Phone();
        phone.setPhoneNumber(request.getPhoneNumber());
        return phone;
    }

    public Phone toEntity(PhoneRequest request, Owner owner) {
        Phone phone = new Phone();
        phone.setPhoneNumber(request.getPhoneNumber());
        phone.setOwner(owner);
        return phone;
    }

    public PhoneResponse toResponse(Phone phone) {
        PhoneResponse response = new PhoneResponse();
        response.setId(phone.getId());
        response.setPhoneNumber(phone.getPhoneNumber());
        response.setCreatedAt(phone.getCreatedAt());
        response.setModifiedAt(phone.getModifiedAt());
        return response;
    }
}
