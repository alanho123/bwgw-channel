package com.example.servingwebcontent;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PayInfo {
    private String paymentUrl;
    private String txId;
}
