package com.gznu.element.entity.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class User {
    private String userName;
    private String passWord;
    private String name;
    private Integer gender;
    private String birthday;
    private String regionId;

}
