package simple.api.service.impl;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.javassist.tools.web.BadHttpRequest;
import org.springframework.stereotype.Service;
import simple.api.dto.MemberDTO;
import simple.api.repository.MemberRepository;
import simple.api.service.MemberService;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public MemberDTO emailCheck(MemberDTO memberDTO) {
        return memberRepository.findByEmail(memberDTO.getEmail());
    }

    @Override
    public void signUp(MemberDTO memberDTO) {
        memberRepository.save(memberDTO);
    }

    @Override
    public Long signIn(MemberDTO memberDTO) {
        MemberDTO result = memberRepository.findByEmailAndPassword(memberDTO);

        if (result != null) {
            return result.getId();
        }

        return null;
    }
}
