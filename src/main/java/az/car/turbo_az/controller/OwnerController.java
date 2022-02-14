package az.car.turbo_az.controller;

import az.car.turbo_az.dto.request.OwnerRequest;
import az.car.turbo_az.exception.CommonResponse;
import az.car.turbo_az.service.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/owner")
@RequiredArgsConstructor
public class OwnerController {

    private final OwnerService ownerService;

    @PostMapping
    public ResponseEntity<CommonResponse> create(@RequestBody OwnerRequest request) {
        System.out.println("Geldi");
        return ResponseEntity.ok(ownerService.create(request));
    }
}
