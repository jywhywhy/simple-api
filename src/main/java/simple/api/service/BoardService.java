package simple.api.service;

import simple.api.dto.BoardDTO;

import java.util.List;

public interface BoardService {

    List<BoardDTO> list();

    BoardDTO detail(Long id);

    void write(BoardDTO boardDTO);

    void update(BoardDTO boardDTO);

    void delete(Long id);
}
