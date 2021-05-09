package com.alam.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.alam.dto.PaymentDto;

public class PaymentDao extends SqlMapConfig {
	private String namespace="payment.mapper.";
	
	public int paySuccess(PaymentDto dto) {
		int res = 0;
		
		try(SqlSession session = getSqlSessionFactory().openSession(true)) {
			res = session.insert(namespace+"paySuccess", dto);
		}
		
		return res;
	}
	
	public List<PaymentDto> paidList(String id) {
		List<PaymentDto> list = new ArrayList<PaymentDto>();
		
		try(SqlSession session = getSqlSessionFactory().openSession(false)) {
			list = session.selectList(namespace+"paidList", id);
		}
		
		return list;
	}
	
	public List<PaymentDto> soldList(String id) {
		List<PaymentDto> list = new ArrayList<PaymentDto>();
		
		try(SqlSession session = getSqlSessionFactory().openSession(false)) {
			list = session.selectList(namespace+"soldList", id);
		}
		
		return list;
	}
	
	public List<PaymentDto> listAll() {
		List<PaymentDto> list = new ArrayList<PaymentDto>();
		
		try(SqlSession session = getSqlSessionFactory().openSession(false)) {
			list = session.selectList(namespace+"listAll");
		}
		
		return list;
	}
	
	public PaymentDto checkPaid(PaymentDto dto) {
		PaymentDto paid = null;
		
		try(SqlSession session = getSqlSessionFactory().openSession(false)) {
			paid = session.selectOne(namespace+"checkPaid", dto);
		}
		
		return paid;
	}
	
	public List<PaymentDto> sellerRank() {
		List<PaymentDto> list = new ArrayList<PaymentDto>();
		
		try(SqlSession session = getSqlSessionFactory().openSession(false)) {
			list = session.selectList(namespace+"sellerRank");
		}
		
		return list;
	}
}
