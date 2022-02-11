package az.car.turbo_az.mapper;

import az.car.turbo_az.dto.request.CarRequest;
import az.car.turbo_az.dto.response.CarResponse;
import az.car.turbo_az.entity.Car;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {

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
        response.setAddedToSystem(car.getCreated_at());
        return response;
    }
}
