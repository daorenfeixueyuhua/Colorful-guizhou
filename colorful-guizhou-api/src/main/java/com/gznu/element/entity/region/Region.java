package com.gznu.element.entity.region;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Region {
    private String regionId;
    private String regionName;
    private String superRegionId;
}
