package simple.api.repository;

import simple.api.dto.MemberDTO;

public interface MemberRepository {

    void save(MemberDTO memberDTO);

    MemberDTO findByEmail(String email);

    MemberDTO findByEmailAndPassword(MemberDTO memberDTO);
}
