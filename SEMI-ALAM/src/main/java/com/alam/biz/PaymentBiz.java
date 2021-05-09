package com.alam.biz;

import java.util.List;

import com.alam.dao.PaymentDao;
import com.alam.dto.PaymentDto;

public class PaymentBiz {
	private PaymentDao dao = new PaymentDao();
	
	public int paySuccess(PaymentDto dto) {
		return dao.paySuccess(dto);
	}
	
	public List<PaymentDto> paidList(String id) {
		return dao.paidList(id);
	}
	
	public List<PaymentDto> soldList(String id) {
		return dao.soldList(id);
	}
	
	public List<PaymentDto> listAll() {
		return dao.listAll();
	}
	
	public PaymentDto checkPaid(PaymentDto dto) {
		return dao.checkPaid(dto);
	}
	
	public List<PaymentDto> sellerRank() {
		return dao.sellerRank();
	}
}
