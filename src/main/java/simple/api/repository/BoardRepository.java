package simple.api.repository;

import simple.api.dto.BoardDTO;
import simple.api.dto.MemberDTO;

import java.util.List;

public interface BoardRepository {

    void save(BoardDTO boardDTO);

    BoardDTO findById(Long id);

    List<BoardDTO> findAll();

    void delete(Long id);
}
