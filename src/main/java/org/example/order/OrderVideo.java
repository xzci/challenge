package org.example.order;

import lombok.Data;
import org.example.Code;

import java.util.LinkedList;

@Data
public class OrderVideo implements Order{
    private final String code = String.valueOf(Code.Video);
    private Integer post;

    public OrderVideo(int post) {
        this.post = post;
    }
}
