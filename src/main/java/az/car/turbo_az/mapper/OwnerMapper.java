package az.car.turbo_az.mapper;

import az.car.turbo_az.dto.request.OwnerRequest;
import az.car.turbo_az.entity.Owner;
import org.springframework.stereotype.Component;

@Component
public class OwnerMapper {

    public Owner toEntity(OwnerRequest request) {
        Owner owner = new Owner();
        owner.setName(request.getName());
        owner.setSurname(request.getSurname());
        owner.setFin(request.getFin());
        owner.setBirthdate(request.getBirthdate());
    }
}
