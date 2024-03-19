package org.beduin.hl.socialnetwork.dto;


import lombok.*;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String city;
    private Date birthdate;
    private String gender;
    private String email;
}

