package simple.api.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import simple.api.dto.BoardDTO;
import simple.api.repository.BoardRepository;
import simple.api.service.BoardService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    @Override
    public List<BoardDTO> list() {
        return boardRepository.findAll();
    }

    @Override
    public BoardDTO detail(Long id) {
        return boardRepository.findById(id);
    }

    @Override
    public void write(BoardDTO boardDTO) {
        boardRepository.save(boardDTO);
    }

    @Override
    public void update(BoardDTO boardDTO) {
        boardRepository.save(boardDTO);
    }

    @Override
    public void delete(Long id) {
        boardRepository.delete(id);
    }
}
