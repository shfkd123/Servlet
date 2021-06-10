package kr.or.ddit.handler.order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.dto.OrderVO;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.service.OrderService;

public class OrderPayHandler implements Handler {

	private OrderService orderService;
	
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "order/pay_success";
		
		String[] orderNos = request.getParameter("orderNo").split(",");
		String orderStatus = request.getParameter("orderStatus");
		
		if(orderStatus.equals("결제완료")) {
			request.setAttribute("msg", "주문이 완료되었습니다.");
		}
		if(orderStatus.equals("주문대기")) {
			request.setAttribute("msg", "결제가 취소되었습니다.");
		}
		for(String orderNo : orderNos) {
			OrderVO order = new OrderVO();
			order.setOrderNo(orderNo);
			order.setOrderStatus(orderStatus);
			orderService.changeOrderStatus(order);
		}
		return url;
	}

}
