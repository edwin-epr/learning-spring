package org.edwinepr.model;

import lombok.Getter;
import lombok.Setter;

public class Comment {
    @Getter @Setter
    private String author;

    @Getter @Setter
    private String text;
}
