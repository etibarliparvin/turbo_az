package az.car.turbo_az.service.impl;

import az.car.turbo_az.dto.request.CarRequest;
import az.car.turbo_az.dto.response.CarResponse;
import az.car.turbo_az.entity.Car;
import az.car.turbo_az.exception.CommonResponse;
import az.car.turbo_az.mapper.CarMapper;
import az.car.turbo_az.repository.CarRepository;
import az.car.turbo_az.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final CarMapper carMapper;

    @Override
    public CommonResponse create(CarRequest request) {
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
    public CommonResponse update(Long id, CarRequest request) {
        return null;
    }
}
