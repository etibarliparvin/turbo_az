package az.car.turbo_az.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BusinessExceptionEnum {

    OWNER_BY_ID_NOT_FOUND("Owner by id: %s not found",
            "404", "The current employee not found in our database"),
    OWNER_LIST_IS_EMPTY("Owner list is empty",
            "404", "There is not owner in our database"),
    CAR_BY_ID_NOT_FOUND("Car by id: %s not found",
            "404", "The current car not found in our database"),
    CAR_LIST_IS_EMPTY("Car list is empty",
            "404", "There is not car in our database");

    private String msg;
    private String code;
    private String description;
}
