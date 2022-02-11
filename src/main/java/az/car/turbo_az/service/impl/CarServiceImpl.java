package az.car.turbo_az.service.impl;

import az.car.turbo_az.dto.request.CarRequest;
import az.car.turbo_az.dto.response.CarResponse;
import az.car.turbo_az.entity.Car;
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
    public CarResponse create(CarRequest request) {
        return carMapper.toResponse(carRepository.save(carMapper.toEntity(request)));
    }

    @Override
    public CarResponse findById(Long id) {
        Optional<Car> found = carRepository.findById(id);
        if (found.isPresent()) {
            return carMapper.toResponse(found.get());
        }
        throw new RuntimeException("Car by id not found");
    }

    @Override
    public List<CarResponse> findAll() {
        return carRepository.findAll().stream().map(carMapper::toResponse).collect(Collectors.toList());
    }

    @Override
    public CarResponse update(Long id, CarRequest request) {
        Optional<Car> found = carRepository.findById(id);
        if (found.isPresent()) {
            Car car = carMapper.toEntity(request);
            car.setId(id);
            car.setCreated_at(found.get().getCreated_at());
            return carMapper.toResponse(carRepository.save(car));
        }
        throw new RuntimeException("Car by id not found");
    }
}
