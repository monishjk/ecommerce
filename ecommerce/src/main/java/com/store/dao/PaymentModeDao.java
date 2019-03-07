package com.store.dao;

import com.store.model.PaymentMode;

public interface PaymentModeDao {
	PaymentMode getPayment(String digi16);
	boolean updatePayment(PaymentMode paymentMode);
}
