package simple.api.service;

import simple.api.dto.MemberDTO;

public interface MemberService {

    MemberDTO emailCheck(MemberDTO memberDTO);

    void signUp(MemberDTO memberDTO);

    Long signIn(MemberDTO memberDTO);
}
