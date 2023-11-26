package simple.api.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import simple.api.dto.MemberDTO;
import simple.api.exception.CustomErrorCode;
import simple.api.exception.CustomException;
import simple.api.repository.MemberRepository;
import simple.api.service.MemberService;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public void emailCheck(MemberDTO memberDTO) throws CustomException {
        MemberDTO member = memberRepository.findByEmail(memberDTO.getEmail());

        if (member != null) {
            throw new CustomException(CustomErrorCode.EMAIL_ALREADY_EXISTS);
        }

    }

    @Override
    public void signUp(MemberDTO memberDTO) {
        memberRepository.save(memberDTO);
    }

    @Override
    public Long signIn(MemberDTO memberDTO) throws CustomException {
        MemberDTO member = memberRepository.findByEmailAndPassword(memberDTO);

        if (member == null) {
            throw new CustomException(CustomErrorCode.LOGIN_FAILED);
        }

        return member.getId();

    }
}
