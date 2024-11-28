//package com.busanit501.subinserver.jdbcex.service;
//
//import com.busanit501.subinserver.jdbcex.dao.MemberDAO;
//import com.busanit501.subinserver.jdbcex.dao.TodoDAO;
//import com.busanit501.subinserver.jdbcex.dto.MemberDTO;
//import com.busanit501.subinserver.jdbcex.dto.TodoDTO;
//import com.busanit501.subinserver.jdbcex.util.MapperUtil;
//import com.busanit501.subinserver.jdbcex.vo.MemberVO;
//import com.busanit501.subinserver.jdbcex.vo.TodoVO;
//import lombok.extern.log4j.Log4j2;
//import org.modelmapper.ModelMapper;
//
//import java.sql.SQLException;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Log4j2
//public enum MemberService {
//    INSTANCE;
//
//    private MemberDAO memberDAO;
//    private ModelMapper modelMapper;
//
//    // 생성자 이용해서, 초기화하기.
//    MemberService() {
//        memberDAO = new MemberDAO();
//        modelMapper = MapperUtil.INSTANCE.get();
//    }
//
//    //로그인 확인용
//    public MemberDTO login(String mid, String mpw) throws SQLException {
//        MemberVO memberVO = memberDAO.getMemberWithMpw(mid,mpw);
//        MemberDTO memberDTO = modelMapper.map(memberVO, MemberDTO.class);
//        return memberDTO;
//    }
//}
//
