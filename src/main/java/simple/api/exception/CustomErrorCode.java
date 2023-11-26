package simple.api.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum CustomErrorCode {

    EMAIL_ALREADY_EXISTS(HttpStatus.BAD_REQUEST, "이미 등록된 이메일 입니다."),
    LOGIN_FAILED(HttpStatus.BAD_REQUEST, "아이디나 비밀번호를 확인해 주세요.")
    ;

    private final HttpStatus httpStatus;
    private final String message;

}
