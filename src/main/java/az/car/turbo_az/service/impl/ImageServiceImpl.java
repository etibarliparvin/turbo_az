package az.car.turbo_az.service.impl;

import az.car.turbo_az.repository.OwnerRepository;
import az.car.turbo_az.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final OwnerRepository ownerRepository;

}
