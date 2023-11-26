package simple.api.service;

import simple.api.dto.MemberDTO;
import simple.api.exception.CustomException;

public interface MemberService {

    void emailCheck(MemberDTO memberDTO) throws CustomException;

    void signUp(MemberDTO memberDTO);

    Long signIn(MemberDTO memberDTO) throws CustomException;
}
