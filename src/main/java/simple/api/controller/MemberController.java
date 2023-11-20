package simple.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import simple.api.dto.MemberDTO;
import simple.api.service.MemberService;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/email/check")
    public ResponseEntity<?> check(@RequestBody MemberDTO memberDTO) {
        MemberDTO tmp = memberService.emailCheck(memberDTO);

        if (tmp != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/sign/up")
    public ResponseEntity<?> up(@RequestBody MemberDTO memberDTO) {
        memberService.signUp(memberDTO);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/sign/in")
    public ResponseEntity<?> in(@RequestBody MemberDTO memberDTO) {
        Long id = memberService.signIn(memberDTO);

        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
