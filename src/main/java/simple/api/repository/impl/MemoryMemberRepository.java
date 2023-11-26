package simple.api.repository.impl;

import org.springframework.stereotype.Repository;
import simple.api.dto.MemberDTO;
import simple.api.repository.MemberRepository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class MemoryMemberRepository implements MemberRepository {

    private final Map<Long, MemberDTO> store = new HashMap<>();

    private Long id = 1L;

    @Override
    public void save(MemberDTO memberDTO) {
        memberDTO.setId(id);
        store.put(id++, memberDTO);
    }

    @Override
    public MemberDTO findByEmail(String email) {
        MemberDTO memberDTO = null;
        for (Long key : store.keySet()) {
            MemberDTO tmp = store.get(key);
            if (tmp.getEmail().equals(email)) {
                memberDTO = tmp;
            }
        }

        return memberDTO;
    }

    @Override
    public MemberDTO findByEmailAndPassword(MemberDTO memberDTO) {
        MemberDTO result = findByEmail(memberDTO.getEmail());
        if (result != null && result.getPassword().equals(memberDTO.getPassword())) {
            return result;
        }

        return null;
    }
}
