package com.busanit501.subinserver.member.dao;

import com.busanit501.subinserver.jdbcex.dao.ConnectionUtil;
import com.busanit501.subinserver.jdbcex.vo.TodoVO;
import com.busanit501.subinserver.member.vo.MemberVO;
import lombok.Cleanup;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
    public void insert(MemberVO memberVO) throws SQLException {

        String sql = "insert into tbl_member1 (id, password) " +
                "values (?, ?)";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, memberVO.getId());
        preparedStatement.setString(2,memberVO.getPassword());
        preparedStatement.executeUpdate();
    } //insert

    //2
    // select , DB에서 전체 조회.
    public List<MemberVO> selectAll() throws SQLException {
        String sql = "select * from tbl_member1";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();
        List<MemberVO> list = new ArrayList<>();
        while (resultSet.next()) {
            MemberVO memberVO = MemberVO.builder()
                    .mno(resultSet.getLong("mno"))
                    .id(resultSet.getString("id"))
                    .password(resultSet.getString("password"))
                    .build();
            list.add(memberVO);
        }
        return  list;
    }

    //3, 하나 조회.
    public MemberVO selectOne(Long mno) throws SQLException {
        String sql = "select * from tbl_member1 where mno = ?";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, mno);
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        MemberVO memberVO = MemberVO.builder()
                .mno(resultSet.getLong("mno"))
                .id(resultSet.getString("id"))
                .password(resultSet.getString("password"))
                .build();
        return memberVO;
    }

    //수정
public void updateOne(MemberVO memberVO) throws SQLException {
        String sql = "update tbl_member1 set id =?, password =?" +
                " where mno = ?";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
    preparedStatement.setString(1, memberVO.getId());
    preparedStatement.setString(2,memberVO.getPassword());
    preparedStatement.setLong(3,memberVO.getMno());
        preparedStatement.executeUpdate();
}

    //삭제
public void deleteTodo(Long mno) throws SQLException {
       String sql = "delete from tbl_member1 where mno =?";
       @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
       @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
       preparedStatement.setLong(1, mno);
       preparedStatement.executeUpdate();
}

}
