package com.busanit501.subinserver.member.service;

import com.busanit501.subinserver.jdbcex.util.MapperUtil;
import com.busanit501.subinserver.member.dao.MemberDAO;
import com.busanit501.subinserver.member.dto.MemberDTO;
import com.busanit501.subinserver.member.vo.MemberVO;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public enum MemberService {
    INSTANCE;

    private MemberDAO memberDAO;
    private ModelMapper modelMapper;

    // 생성자 이용해서, 초기화하기.
    MemberService() {
        memberDAO = new MemberDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }

    //1.register
    public void register(MemberDTO memberDTO) throws SQLException {
        MemberVO memberVO = modelMapper.map(memberDTO, MemberVO.class); // 변수 타입 수정
        log.info("memberVO : " + memberVO);

        memberDAO.insert(memberVO);
    }


    //2.select
    public List<MemberDTO> listAll() throws SQLException {
        List<MemberVO> voList = memberDAO.selectAll();
        log.info("voList : " + voList);
        List<MemberDTO> dtoList = voList.stream().map(vo -> modelMapper.map(vo, MemberDTO.class))
                .collect(Collectors.toList());
        return dtoList;
    }


    //3,하나조회
    public MemberDTO get(Long mno) throws SQLException {
        log.info("mno : " + mno);
        MemberVO memberVO = memberDAO.selectOne(mno);
        MemberDTO memberDTO = modelMapper.map(memberVO,MemberDTO.class);
        return memberDTO;
    }

    //4 수정 기능
    public void update(MemberDTO memberDTO) throws SQLException {
        log.info("수정할 회원 정보 : " + memberDTO);
        MemberVO memberVO = modelMapper.map(memberDTO, MemberVO.class);
        memberDAO.updateOne(memberVO);

    }

    //5. 삭제
    public void delete(Long mno) throws SQLException {
        memberDAO.deleteTodo(mno);
    }

    public void insert(MemberDTO memberDTO) {
    }

}
