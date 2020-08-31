package com.example.servingwebcontent;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderInfo {
    private String orderNo;
    private Integer amount;
    private String channelName;
}
