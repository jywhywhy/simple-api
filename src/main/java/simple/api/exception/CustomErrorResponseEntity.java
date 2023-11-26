package simple.api.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;

@Getter
@Setter
@Builder
public class CustomErrorResponseEntity {
    private int status;
    private String message;
    private String code;

    public static ResponseEntity<CustomErrorResponseEntity> toResponse(CustomErrorCode e) {
        return ResponseEntity
                .status(e.getHttpStatus())
                .body(CustomErrorResponseEntity
                        .builder()
                        .status(e.getHttpStatus().value())
                        .message(e.getMessage())
                        .code(e.name())
                        .build()
                );
    }
}
