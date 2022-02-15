package az.car.turbo_az.mapper;

import az.car.turbo_az.dto.request.CarRequest;
import az.car.turbo_az.dto.response.CarResponse;
import az.car.turbo_az.entity.Car;
import az.car.turbo_az.entity.Owner;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CarMapper {

    private final ImageMapper imageMapper;

    public Car toEntity(CarRequest request) {
        Car car = new Car();
        car.setMark(request.getMark());
        car.setModel(request.getModel());
        car.setYear(request.getYear());
        car.setCost(request.getCost());
        car.setEngine(request.getEngine());
        car.setKm(request.getKm());
        car.setColor(request.getColor());
        return car;
    }

    public Car toEntity(CarRequest request, Owner owner) {
        Car car = new Car();
        car.setMark(request.getMark());
        car.setModel(request.getModel());
        car.setYear(request.getYear());
        car.setCost(request.getCost());
        car.setEngine(request.getEngine());
        car.setKm(request.getKm());
        car.setColor(request.getColor());
        car.setOwner(owner);
        return car;
    }

    public CarResponse toResponse(Car car) {
        CarResponse response = new CarResponse();
        response.setId(car.getId());
        response.setMark(car.getMark());
        response.setModel(car.getModel());
        response.setYear(car.getYear());
        response.setCost(car.getCost());
        response.setEngine(car.getEngine());
        response.setKm(car.getKm());
        response.setColor(car.getColor());
        response.setCreatedAt(car.getCreated_at());
        response.setModifiedAt(car.getModifiedAt());
//        response.setImages(car.getImages().stream().map(imageMapper::toResponse).collect(Collectors.toList()));
        return response;
    }
}
