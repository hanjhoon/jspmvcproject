package com.playdata.dao;

import com.playdata.dto.BoardDto;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BoardDao {
    /**
     * board 테이블에서 모든 데이터를 조회
     * @param req
     * @return List<BoardDto>
     */

    public List<BoardDto> selectAll(HttpServletRequest req) {
        Connection conn = (Connection) req.getServletContext().getAttribute("conn");
        List<BoardDto> boardList = new ArrayList<>();
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM board ORDER BY id DESC");
            while(rs.next()){
                BoardDto boardDto = new BoardDto(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("content"),
                        rs.getString("author"),
                        rs.getString("created_at")
                );
                boardList.add(boardDto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return boardList;
    }

    public BoardDto selectById(String id, HttpServletRequest req) {
        Connection conn = (Connection) req.getServletContext().getAttribute("conn");
        BoardDto boardDto= null;
        String sql = "select * from board where id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, Integer.parseInt(id));
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                boardDto = BoardDto.builder()
                        .author(rs.getString("author"))
                        .title(rs.getString("title"))
                        .content(rs.getString("content"))
                        .created_at(rs.getString("created_at"))
                        .build();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return boardDto;
    }
}
