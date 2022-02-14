package az.car.turbo_az.service.impl;

import az.car.turbo_az.dto.request.PhoneRequest;
import az.car.turbo_az.dto.response.PhoneResponse;
import az.car.turbo_az.exception.CommonResponse;
import az.car.turbo_az.mapper.PhoneMapper;
import az.car.turbo_az.repository.PhoneRepository;
import az.car.turbo_az.service.PhoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PhoneServiceImpl implements PhoneService {

    private final PhoneRepository phoneRepository;
    private final PhoneMapper phoneMapper;

    @Override
    public CommonResponse create(PhoneRequest request) {
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
    public CommonResponse update(Long id, PhoneRequest request) {
        return null;
    }
}
