package com.gznu.element.entity.landscape;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Landscape {
    private String landscapeId;
    private String landscapeType;
    private String landscapeName;
    private String regionId;
    private Float price;
    private String introduction;
    private Integer count;
}
