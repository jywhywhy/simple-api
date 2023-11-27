package simple.api.repository.impl;

import org.springframework.stereotype.Repository;
import simple.api.dto.BoardDTO;
import simple.api.dto.MemberDTO;
import simple.api.repository.BoardRepository;
import simple.api.repository.MemberRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemoryBoardRepository implements BoardRepository {

    private final Map<Long, BoardDTO> store = new HashMap<>();

    private Long id = 1L;

    @Override
    public void save(BoardDTO boardDTO) {
        if (boardDTO.getId() != null) {
            store.put(boardDTO.getId(), boardDTO);
        } else {
            boardDTO.setId(id);
            store.put(id++, boardDTO);
        }
    }

    @Override
    public BoardDTO findById(Long id) {
        return store.get(id);
    }

    @Override
    public List<BoardDTO> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public void delete(Long id) {
        store.remove(id);
    }

}
