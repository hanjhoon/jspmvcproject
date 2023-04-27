package com.playdata.service;

import com.playdata.dao.BoardDao;
import com.playdata.dto.BoardDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class BoardService {
    /**
     * board 테이블에서 모든 데이터를 조회
     * @param req
     * @return
     */
    public List<BoardDto> getBoard(HttpServletRequest req) {
        BoardDao boardDao = new BoardDao();
        boardDao.selectAll(req);
        return boardDao.selectAll(req);
    }

    public BoardDto getBoard(String id, HttpServletRequest req) {
        BoardDao boardDao = new BoardDao();
        return boardDao.selectById(id, req);
    }
}
