package org.example.order;

import lombok.Data;
import org.example.Code;

import java.util.LinkedList;

@Data
public class OrderImage implements Order {
    private final String code = String.valueOf(Code.Image);
    private Integer post;

    public OrderImage(int post) {
        this.post = post;
    }
}
