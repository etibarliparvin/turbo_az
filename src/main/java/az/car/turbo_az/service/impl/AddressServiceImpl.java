package az.car.turbo_az.service.impl;

import az.car.turbo_az.dto.request.AddressRequest;
import az.car.turbo_az.entity.Address;
import az.car.turbo_az.exception.BusinessExceptionEnum;
import az.car.turbo_az.exception.CommonResponse;
import az.car.turbo_az.exception.NotFoundException;
import az.car.turbo_az.mapper.AddressMapper;
import az.car.turbo_az.repository.AddressRepository;
import az.car.turbo_az.service.AddressService;
import az.car.turbo_az.utils.EmailUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    @Override
    public CommonResponse create(AddressRequest request) {
        CommonResponse response = new CommonResponse();
        if (EmailUtil.checkAllEmails(request.getEmail(),
                addressRepository.findAll().stream().map(Address::getEmail).collect(Collectors.toList()))) {
            response.setItem(addressMapper.toResponse(addressRepository.save(addressMapper.toEntity(request))));
        } else throw new NotFoundException(BusinessExceptionEnum.EMAIL_THE_SAME);
        return response;
    }

    @Override
    public CommonResponse findById(Long id) {
        CommonResponse response = new CommonResponse();
        Optional<Address> found = addressRepository.findById(id);
        if (found.isPresent()) {
            response.setItem(addressMapper.toResponse(found.get()));
            return response;
        }
        throw new NotFoundException(BusinessExceptionEnum.ADDRESS_BY_ID_NOT_FOUND, id);
    }

    @Override
    public CommonResponse findAll() {
        CommonResponse response = new CommonResponse();
        List<Address> found = addressRepository.findAll();
        if (!found.isEmpty()) {
            response.setItem(found.stream().map(addressMapper::toResponse).collect(Collectors.toList()));
            return response;
        }
        throw new NotFoundException(BusinessExceptionEnum.ADDRESS_LIST_IS_EMPTY);
    }

    @Override
    public CommonResponse update(Long id, AddressRequest request) {
        CommonResponse response = new CommonResponse();
        Optional<Address> found = addressRepository.findById(id);
        if (found.isPresent()) {
            Address address = found.get();
            if (request.getCountry() != null)
                address.setCountry(request.getCountry());
            if (request.getCity() != null)
                address.setCity(request.getCity());
            if (request.getStreet() != null)
                address.setStreet(request.getStreet());
            if (request.getEmail() != null) {
                if (EmailUtil.checkOneEmail(request.getEmail(), found.get().getEmail())) {
                    if (EmailUtil.checkAllEmails(request.getEmail(),
                            addressRepository.findAll().stream().map(Address::getEmail).collect(Collectors.toList()))) {
                        address.setEmail(request.getEmail());
                    } else throw new NotFoundException(BusinessExceptionEnum.EMAIL_THE_SAME);
                }
            }
            address.setModifiedAt(LocalDateTime.now());
            response.setItem(addressRepository.save(address));
            return response;
        }
        throw new NotFoundException(BusinessExceptionEnum.ADDRESS_BY_ID_NOT_FOUND, id);
    }
}
