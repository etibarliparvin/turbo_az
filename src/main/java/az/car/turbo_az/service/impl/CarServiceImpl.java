package az.car.turbo_az.service.impl;

import az.car.turbo_az.dto.request.CarRequest;
import az.car.turbo_az.entity.Car;
import az.car.turbo_az.exception.BusinessExceptionEnum;
import az.car.turbo_az.exception.CommonResponse;
import az.car.turbo_az.exception.NotFoundException;
import az.car.turbo_az.mapper.CarMapper;
import az.car.turbo_az.repository.CarRepository;
import az.car.turbo_az.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
        CommonResponse response = new CommonResponse();
        response.setItem(carMapper.toResponse(carRepository.save(carMapper.toEntity(request))));
        return response;
    }

    @Override
    public CommonResponse findById(Long id) {
        CommonResponse response = new CommonResponse();
        Optional<Car> found = carRepository.findById(id);
        if (found.isPresent()) {
            if (!found.get().getIsSold()) {
                response.setItem(carMapper.toResponse(found.get()));
                return response;
            }
            throw new NotFoundException(BusinessExceptionEnum.CAR_IS_SOLD_OUT);
        }
        throw new NotFoundException(BusinessExceptionEnum.CAR_BY_ID_NOT_FOUND, id);
    }

    @Override
    public CommonResponse findAll() {
        CommonResponse response = new CommonResponse();
        List<Car> found = carRepository.findAll();
        if (!found.isEmpty()) {
            List<Car> cars = found.stream().filter(a -> !a.getIsSold()).collect(Collectors.toList());
            if (!cars.isEmpty()) {
                response.setItem(cars.stream().map(carMapper::toResponse).collect(Collectors.toList()));
                return response;
            }
            throw new NotFoundException(BusinessExceptionEnum.CAR_LIST_IS_EMPTY);
        }
        throw new NotFoundException(BusinessExceptionEnum.CAR_LIST_IS_EMPTY);
    }

    @Override
    public CommonResponse update(Long id, CarRequest request) {
        CommonResponse response = new CommonResponse();
        Optional<Car> found = carRepository.findById(id);
        if (found.isPresent()) {
            if (!found.get().getIsSold()) {
                Car car = found.get();
                if (request.getMark() != null)
                    car.setMark(request.getMark());
                if (request.getModel() != null)
                    car.setModel(request.getModel());
                if (request.getYear() != null)
                    car.setYear(request.getYear());
                if (request.getCost() != null)
                    car.setCost(request.getCost());
                if (request.getEngine() != null)
                    car.setEngine(request.getEngine());
                if (request.getKm() != null)
                    car.setKm(request.getKm());
                if (request.getColor() != null)
                    car.setColor(request.getColor());
                car.setModifiedAt(LocalDateTime.now());
                response.setItem(carRepository.save(car));
                return response;
            }
            throw new NotFoundException(BusinessExceptionEnum.CAR_IS_SOLD_OUT);
        }
        throw new NotFoundException(BusinessExceptionEnum.CAR_BY_ID_NOT_FOUND, id);
    }
}
