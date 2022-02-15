package az.car.turbo_az.mapper;

import az.car.turbo_az.dto.request.OwnerRequest;
import az.car.turbo_az.dto.response.OwnerResponse;
import az.car.turbo_az.entity.Owner;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OwnerMapper {

    private final AddressMapper addressMapper;
    private final PhoneMapper phoneMapper;
    private final CarMapper carMapper;

    public Owner toEntity(OwnerRequest request) {
        Owner owner = new Owner();
        owner.setName(request.getName());
        owner.setSurname(request.getSurname());
        owner.setFin(request.getFin());
        owner.setBirthdate(request.getBirthdate());
        owner.setAddress(addressMapper.toEntity(request.getAddress(), owner));
        owner.setPhones(request.getPhones().stream().map(phoneMapper::toEntity).collect(Collectors.toList()));
        owner.setCars(request.getCars().stream().map(carMapper::toEntity).collect(Collectors.toList()));
//        owner.setPhones(request.getPhones().stream().map(a -> phoneMapper.toEntity(a, owner)).collect(Collectors.toList()));
//        owner.setCars(request.getCars().stream().map(a -> carMapper.toEntity(a, owner)).collect(Collectors.toList()));
        return owner;
    }

    public OwnerResponse toResponse(Owner owner) {
        OwnerResponse response = new OwnerResponse();
        response.setId(owner.getId());
        response.setName(owner.getName());
        response.setSurname(owner.getSurname());
        response.setFin(owner.getFin());
        response.setBirthdate(owner.getBirthdate());
        response.setCreatedAt(owner.getCreatedAt());
        response.setModifiedAt(owner.getModifiedAt());
        response.setIsActive(owner.getIsActive());
        response.setAddress(addressMapper.toResponse(owner.getAddress()));
        response.setPhones(owner.getPhones().stream().map(phoneMapper::toResponse).collect(Collectors.toList()));
        response.setCars(owner.getCars().stream().map(carMapper::toResponse).collect(Collectors.toList()));
        return response;
    }
}
