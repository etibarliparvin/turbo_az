package az.car.turbo_az.controller;

import az.car.turbo_az.dto.request.AddressRequest;
import az.car.turbo_az.exception.CommonResponse;
import az.car.turbo_az.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @PostMapping
    public ResponseEntity<CommonResponse> create(@RequestBody AddressRequest request) {
        return ResponseEntity.ok(addressService.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommonResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(addressService.findById(id));
    }

    @GetMapping
    public ResponseEntity<CommonResponse> findAll() {
        return ResponseEntity.ok(addressService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommonResponse> update(@PathVariable Long id, @RequestBody AddressRequest request) {
        return ResponseEntity.ok(addressService.update(id, request));
    }
}
