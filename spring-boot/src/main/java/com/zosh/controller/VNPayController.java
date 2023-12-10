package com.zosh.controller;

import com.zosh.config.VNPayService;
import com.zosh.exception.OrderException;
import com.zosh.modal.Order;
import com.zosh.repository.OrderRepository;
import com.zosh.response.ApiResponse;
import com.zosh.response.PaymentLinkResponse;
import com.zosh.service.OrderService;
import com.zosh.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class VNPayController {
    @Autowired
    private VNPayService vnPayService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;
    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/payments/{orderId}")
    public String createPaymentLink(@PathVariable Long orderId,
                                                         @RequestHeader("Authorization")String jwt) throws OrderException {
        Order order=orderService.findOrderById(orderId);
        String baseUrl = "http://localhost:3000";
        String vnpayUrl = vnPayService.createOrder(10000, String.valueOf(orderId), baseUrl);
        //return new ResponseEntity<ApiResponse>(new ApiResponse("Payment OK", true), HttpStatus.OK);
        return "redirect:" + vnpayUrl;
    }

    @GetMapping("/payments")
    public String GetMapping(HttpServletRequest request, Model model){
        int paymentStatus =vnPayService.orderReturn(request);

        String orderInfo = request.getParameter("vnp_OrderInfo");
        String paymentTime = request.getParameter("vnp_PayDate");
        String transactionId = request.getParameter("vnp_TransactionNo");
        String totalPrice = request.getParameter("vnp_Amount");

        model.addAttribute("orderId", orderInfo);
        model.addAttribute("totalPrice", totalPrice);
        model.addAttribute("paymentTime", paymentTime);
        model.addAttribute("transactionId", transactionId);

        return paymentStatus == 1 ? "ordersuccess" : "orderfail";
    }
}
