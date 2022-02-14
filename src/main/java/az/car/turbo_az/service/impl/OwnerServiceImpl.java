package az.car.turbo_az.service.impl;

import az.car.turbo_az.dto.request.OwnerRequest;
import az.car.turbo_az.entity.Owner;
import az.car.turbo_az.exception.BusinessExceptionEnum;
import az.car.turbo_az.exception.CommonResponse;
import az.car.turbo_az.exception.NotFoundException;
import az.car.turbo_az.mapper.OwnerMapper;
import az.car.turbo_az.repository.CarRepository;
import az.car.turbo_az.repository.OwnerRepository;
import az.car.turbo_az.repository.PhoneRepository;
import az.car.turbo_az.service.OwnerService;
import az.car.turbo_az.utils.FinUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository ownerRepository;
    private final PhoneRepository phoneRepository;
    private final CarRepository carRepository;
    private final OwnerMapper ownerMapper;

    @Override
    public CommonResponse create(OwnerRequest request) {
        CommonResponse response = new CommonResponse();
        if (FinUtil.checkAllFins(request.getFin(),
                ownerRepository.findAll().stream().map(Owner::getFin).collect(Collectors.toList()))) {
            response.setItem(ownerMapper.toResponse(ownerRepository.save(ownerMapper.toEntity(request))));
            return response;
        } else throw new NotFoundException(BusinessExceptionEnum.OWNER_FIN_ALREADY_EXIST, request.getFin());
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
