package az.car.turbo_az.controller;

import az.car.turbo_az.dto.request.CarRequest;
import az.car.turbo_az.dto.response.CarResponse;
import az.car.turbo_az.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @PostMapping
    public ResponseEntity<CarResponse> create(@RequestBody CarRequest request) {
        return ResponseEntity.ok(carService.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(carService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<CarResponse>> findAll() {
        return ResponseEntity.ok(carService.findAll());
    }

    @PutMapping
    public ResponseEntity<CarResponse> update(@PathVariable Long id, @RequestBody CarRequest request) {
        return ResponseEntity.ok(carService.update(id, request));
    }
}
