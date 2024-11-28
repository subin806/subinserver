package com.busanit501.subinserver.food.dao;

import com.busanit501.subinserver.food.vo.MemberVO;
import com.busanit501.subinserver.jdbcex.dao.ConnectionUtil;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {
    // 화면으로부터 전달받은 ,
    // String mid, String mpw
    // 예시 ) mid: lsy, mpw: 1234
    public MemberVO getMemberWithMpw(String mid, String mpw) throws SQLException {
        String query = "select * from tbl_member where mid=? and mpw=?";
        // 결과 데이터를 담아둘 임시 박스 MemberVO
        MemberVO memberVO = null;

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, mid);
        preparedStatement.setString(2, mpw);
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        memberVO = MemberVO.builder()
                .mid(resultSet.getString("mid"))
                .mpw(resultSet.getString("mpw"))
                .mname(resultSet.getString("mname"))
                .build();

        return memberVO;
    }
}
