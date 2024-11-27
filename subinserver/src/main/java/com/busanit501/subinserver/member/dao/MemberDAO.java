package com.busanit501.subinserver.member.dao;

import com.busanit501.subinserver.jdbcex.dao.ConnectionUtil;
import com.busanit501.subinserver.member.vo.MemberVO;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MemberDAO {
}

//1.insert
public void insert(MemberVO memberVO) throws SQLException {

    String sql = "insert into tbl_member (id, password)" +
            values(?,?)";
    @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
    @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
    preparedStatement.setString(1, memberVO.getId());
    preparedStatement.setString(2, memberVO.getPassword());
    preparedStatement.executeUpdate();

    //2.select(전체조회)
}