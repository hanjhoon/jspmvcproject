package com.playdata.dao;

import com.playdata.dto.UserDto;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

public class UserDao {

    /**
     * users 테이블에서 username과 ,password가 일치하는 레코드를 조회한다.
     * @param username
     * @param password
     * @param req
     */

    public void selectUsernameByPassword(String username, String password, HttpServletRequest req) throws SQLException {
        Connection conn = (Connection) req.getServletContext().getAttribute("conn");
        String sql = "select * from users where username = ? and password = ?";
        try(PreparedStatement pstmt= conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                // 로그인 성공
                // Session에 username 속성을 추가
                req.getSession().setAttribute(username, "username");
                req.getSession().setAttribute(password, "password");
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

    }


}