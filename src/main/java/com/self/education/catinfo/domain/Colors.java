package com.self.education.catinfo.domain;

import lombok.Getter;

@Getter
public enum Colors {

    WHITE("White"),
    BLACK("Black"),
    BLACK_WHITE("Black & White"),
    RED("Red"),
    BLACK_RED("Black & Red"),
    RED_WHITE("Red & White"),
    RED_WHITE_BLACK("Red & White & Black"),
    BLUE("Blue"),
    FAWN("Fawn"),
    CREAM("Cream");

    private String title;

    Colors(final String title) {
        this.title = title;
    }
}
