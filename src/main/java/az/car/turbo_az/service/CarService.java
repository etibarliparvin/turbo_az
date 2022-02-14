package az.car.turbo_az.service;

import az.car.turbo_az.dto.request.CarRequest;
import az.car.turbo_az.dto.response.CarResponse;
import az.car.turbo_az.exception.CommonResponse;

public interface CarService extends CrudService<CarRequest, CommonResponse> {
}
