package com.example.servingwebcontent;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Controller
@Slf4j
public class BeezePayController {

	@GetMapping("/breezePay")
	public ModelAndView breezePay(@RequestParam(name="orderNo", required=false, defaultValue="a001") String name, Model model) {
		RestTemplate restTemplate = new RestTemplate();
		String payUrl = "http://localhost:8888/breezePay";

		SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmss");

		OrderInfo orderInfo = new OrderInfo();
		orderInfo.setAmount((int)(Math.random() * 1000));
		orderInfo.setChannelName("BZOnline");
		orderInfo.setOrderNo(sdf.format(new Date()));

		HttpEntity<OrderInfo> request = new HttpEntity<>(orderInfo);
		PayInfo payInfo = restTemplate.postForObject(payUrl, request, PayInfo.class);

		log.info("## payInfo - {}", payInfo);

		model.addAttribute("attribute", "redirectWithRedirectPrefix");
		return new ModelAndView("redirect:"+payInfo.getPaymentUrl());
	}

}
