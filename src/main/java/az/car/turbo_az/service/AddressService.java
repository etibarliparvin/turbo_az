package az.car.turbo_az.service;

import az.car.turbo_az.dto.request.AddressRequest;
import az.car.turbo_az.dto.response.AddressResponse;
import az.car.turbo_az.exception.CommonResponse;

public interface AddressService extends CrudService<AddressRequest, CommonResponse> {
}
