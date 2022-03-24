package site.metacoding.dbtest.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import site.metacoding.dbtest.domain.boardTbl.BoardTbl;
import site.metacoding.dbtest.domain.boardTbl.BoardTblRepository;
import site.metacoding.dbtest.web.dto.ResponseDto;

@RestController
public class BoardTblApiController {

    private BoardTblRepository boardTblRepository;

    public BoardTblApiController(BoardTblRepository boardTblRepository) {
        this.boardTblRepository = boardTblRepository;
    }

    @GetMapping("/api/search")
    public ResponseDto<?> search(@RequestParam(defaultValue = "") String keyword) {
        // 보내줄 데이터 타입이 List<BoardTbl>이다. 검색 결과를 줘야하기 때문.
        // 와일드 카드

        List<BoardTbl> boards = boardTblRepository.mSearch(keyword);

        return new ResponseDto<>(1, "성공", boards); // 리턴 타입이 정해져있기 때문에 <>안에 생략 가능
        // MessageConverter발동, 자바 오브젝트를 JSON으로 변환

    }
}
