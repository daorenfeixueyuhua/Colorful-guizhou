package com.gznu.element.entity.delicacy;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Delicacy {
    private String delicacyId;
    private String delicacyType;
    private String delicacyName;
    private String regionId;
    private Float price;
    private String introduction;
    private Integer count;
}
