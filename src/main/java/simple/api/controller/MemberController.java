package simple.api.controller;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.javassist.tools.web.BadHttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import simple.api.dto.MemberDTO;
import simple.api.exception.CustomException;
import simple.api.service.MemberService;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/email/check")
    public ResponseEntity<?> check(@RequestBody MemberDTO memberDTO) throws CustomException {
        memberService.emailCheck(memberDTO);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/sign/up")
    public ResponseEntity<?> up(@RequestBody MemberDTO memberDTO) {
        memberService.signUp(memberDTO);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/sign/in")
    public ResponseEntity<?> in(@RequestBody MemberDTO memberDTO) throws CustomException {
        Long id = memberService.signIn(memberDTO);

        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
