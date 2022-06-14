package com.guakun22.robot.wali.model.persistence;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDO {

    private Long id;

    private String name;

    private String password;

    private LocalDate createAt;

    private LocalDate modifiedAt;

}
