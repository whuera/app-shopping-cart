package com.app.mobilpymes.shoppingcart.services.impl;

import com.app.mobilpymes.shoppingcart.entity.PaymentItem;
import com.app.mobilpymes.shoppingcart.repository.PaymentItemsRepository;
import com.app.mobilpymes.shoppingcart.services.PaymentService;
import com.app.mobilpymes.shoppingcart.utils.ShoppingCartEnum;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public
class PaymentServiceImpl implements PaymentService {

    private
    final PaymentItemsRepository paymentItemsRepository;

    @Override
    public
    List < PaymentItem > listAllCards ( ) {
        return paymentItemsRepository.findAll ( );
    }

    @Override
    public
    PaymentItem getCardById (Long id) {
        return paymentItemsRepository.getById ( id );
    }

    @Override
    public
    PaymentItem createPaymentCard (PaymentItem paymentItem) {
        if ( null == paymentItem ) {
            return null;
        }
        return paymentItemsRepository.save ( paymentItem );
    }

    @Override
    public
    PaymentItem updatePaymentCard (PaymentItem paymentItem) {
        PaymentItem paymentItemDB = getCardById ( paymentItem.getId ( ) );
        if ( null == paymentItemDB ) {
            return null;
        }
        paymentItemDB.setNumberCard ( paymentItem.getNumberCard ( ) );
        paymentItemDB.setCvv ( paymentItem.getCvv ( ) );
        paymentItemDB.setDateExpired ( paymentItem.getDateExpired ( ) );
        paymentItemDB.setTypeCard ( paymentItem.getTypeCard ( ) );
        paymentItemDB.setCustomer ( paymentItem.getCustomer ( ) );
        return paymentItemsRepository.save ( paymentItemDB );
    }

    @Override
    public
    PaymentItem deletePaymentCard (Long idCard) {
        if ( !idCard.equals ( null ) ) {
            PaymentItem cardCustomer = getCardById ( idCard );
            cardCustomer.setStatusCard ( ShoppingCartEnum.CARD_INACTIVE.type );
            return paymentItemsRepository.save ( cardCustomer );
        } else {
            return null;
        }
    }
}
