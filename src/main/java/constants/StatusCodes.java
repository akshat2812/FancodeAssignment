package constants;

public enum StatusCodes {
    OK(200),
    CREATED(201),
    NO_CONTENT(204),
    BAD_REQUEST(400),
    UNAUTHORIZED(401),
    FORBIDDEN(403),
    NOT_FOUND(404),
    METHOD_NOT_ALLOWED(405),
    INTERNAL_SERVER_ERROR(500),
    NOT_IMPLEMENTED(501);
    ;

    private Integer code;
    private StatusCodes(Integer code) {
        this.code = code;
    }
}
