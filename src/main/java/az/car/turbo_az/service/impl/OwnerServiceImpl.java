package az.car.turbo_az.service.impl;

import az.car.turbo_az.dto.request.OwnerRequest;
import az.car.turbo_az.dto.response.OwnerResponse;
import az.car.turbo_az.exception.CommonResponse;
import az.car.turbo_az.mapper.OwnerMapper;
import az.car.turbo_az.repository.OwnerRepository;
import az.car.turbo_az.service.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository ownerRepository;
    private final OwnerMapper ownerMapper;

    @Override
    public CommonResponse create(OwnerRequest request) {
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
    public CommonResponse update(Long id, OwnerRequest request) {
        return null;
    }
}
