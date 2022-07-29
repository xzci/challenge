package org.example.order;

import lombok.Data;
import org.example.Code;

import java.util.LinkedList;

@Data
public class OrderAudio implements Order {
    private final String code = String.valueOf(Code.Audio);
    private Integer post;

    public OrderAudio(int post) {
        this.post = post;
    }
}
