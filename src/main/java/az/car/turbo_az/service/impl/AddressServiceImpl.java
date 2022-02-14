package az.car.turbo_az.service.impl;

import az.car.turbo_az.dto.request.AddressRequest;
import az.car.turbo_az.dto.response.AddressResponse;
import az.car.turbo_az.exception.CommonResponse;
import az.car.turbo_az.mapper.AddressMapper;
import az.car.turbo_az.repository.AddressRepository;
import az.car.turbo_az.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    @Override
    public CommonResponse create(AddressRequest request) {
        return null;
    }

    @Override
    public CommonResponse findById(Long id) {
        return null;
    }

    @Override
    public CommonResponse findAll() {
        return null;
    }

    @Override
    public CommonResponse update(Long id, AddressRequest request) {
        return null;
    }
}
