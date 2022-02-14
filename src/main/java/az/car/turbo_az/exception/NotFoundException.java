package az.car.turbo_az.exception;

public class NotFoundException extends BaseException {

    public NotFoundException(BusinessExceptionEnum ex) {
        super(ex.getMsg(), ex.getCode(), ex.getDescription());
    }

    public NotFoundException(BusinessExceptionEnum ex, Object o) {
        super(String.format(ex.getMsg(), o), ex.getCode(), ex.getDescription());
    }
}
