package az.car.turbo_az.mapper;

import az.car.turbo_az.dto.request.AddressRequest;
import az.car.turbo_az.dto.response.AddressResponse;
import az.car.turbo_az.entity.Address;
import az.car.turbo_az.entity.Owner;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {

    public Address toEntity(AddressRequest request) {
        Address address = new Address();
        address.setCountry(request.getCountry());
        address.setCity(request.getCity());
        address.setStreet(request.getStreet());
        address.setEmail(request.getEmail());
        return address;
    }

    public Address toEntity(AddressRequest request, Owner owner) {
        Address address = new Address();
        address.setCountry(request.getCountry());
        address.setCity(request.getCity());
        address.setStreet(request.getStreet());
        address.setEmail(request.getEmail());
        address.setOwner(owner);
        return address;
    }

    public AddressResponse toResponse(Address address) {
        AddressResponse response = new AddressResponse();
        response.setId(address.getId());
        response.setCountry(address.getCountry());
        response.setCity(address.getCity());
        response.setStreet(address.getStreet());
        response.setEmail(address.getEmail());
        response.setCreatedAt(address.getCreatedAt());
        response.setModifiedAt(address.getModifiedAt());
        return response;
    }
}
