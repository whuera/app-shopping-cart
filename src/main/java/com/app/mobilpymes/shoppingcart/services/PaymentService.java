package com.app.mobilpymes.shoppingcart.services;

import com.app.mobilpymes.shoppingcart.entity.PaymentItem;

import java.util.List;

public
interface PaymentService {
    public
    List < PaymentItem > listAllCards ( );

    public
    PaymentItem getCardById (Long id);

    public
    PaymentItem createPaymentCard (PaymentItem paymentItem);

    public
    PaymentItem updatePaymentCard (PaymentItem paymentItem);

    public
    PaymentItem deletePaymentCard (Long idCard);

}
