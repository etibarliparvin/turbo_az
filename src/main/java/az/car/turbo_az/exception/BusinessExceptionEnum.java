package az.car.turbo_az.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BusinessExceptionEnum {

    OWNER_BY_ID_NOT_FOUND("Owner by id: %s not found",
            "404", "The current owner not found in our database"),
    OWNER_LIST_IS_EMPTY("Owner list is empty",
            "404", "There is not owner in our database"),
    CAR_BY_ID_NOT_FOUND("Car by id: %s not found",
            "404", "The current car not found in our database"),
    CAR_IS_SOLD_OUT("Car is already sold",
            "404", "This car is already sold out"),
    CAR_LIST_IS_EMPTY("Car list is empty",
            "404", "There is not car in our database"),
    ADDRESS_BY_ID_NOT_FOUND("Address by id: %s not found",
            "404", "The current address not found in our database"),
    ADDRESS_LIST_IS_EMPTY("Address list is empty",
            "404", "Address list is empty"),
    EMAIL_THE_SAME("Email is repeated",
            "404", "The current email found in database"),
    IMAGE_CAN_NOT_BE_UPLOADED("Image can not be uploaded to the system",
            "404", "Something went wrong, image can not be uploaded to the system"),
    IMAGE_BY_ID_NOT_FOUND("Image by id: %s not found",
            "404", "The current image not found in our databasse");

    private String msg;
    private String code;
    private String description;
}
