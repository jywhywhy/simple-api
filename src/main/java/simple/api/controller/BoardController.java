package simple.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import simple.api.dto.BoardDTO;
import simple.api.service.BoardService;

import java.util.List;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/list")
    public ResponseEntity<?> list() {
        List<BoardDTO> list = boardService.list();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<?> detail(@PathVariable("id") Long id) {
        BoardDTO boardDTO = boardService.detail(id);

        return new ResponseEntity<>(boardDTO, HttpStatus.OK);
    }

    @PostMapping("/write")
    public ResponseEntity<?> write(@RequestBody BoardDTO boardDTO) {
        boardService.write(boardDTO);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody BoardDTO boardDTO) {
        boardService.update(boardDTO);

        return new ResponseEntity<>(HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        boardService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
