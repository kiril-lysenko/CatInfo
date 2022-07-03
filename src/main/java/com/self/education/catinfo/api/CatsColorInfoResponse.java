package com.self.education.catinfo.api;

import com.self.education.catinfo.domain.Colors;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CatsColorInfoResponse {

    private Colors catColor;
    private Integer count;
}
