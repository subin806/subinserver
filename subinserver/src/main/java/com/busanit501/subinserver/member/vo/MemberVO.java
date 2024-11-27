package com.busanit501.subinserver.member.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class MemberVO {
    private Long mno;
    private String id;
    private String password;
}