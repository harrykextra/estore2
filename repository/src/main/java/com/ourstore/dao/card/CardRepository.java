package com.ourstore.dao.card;

import com.ourstore.dao.exceptions.CardException;
import com.ourstore.model.card.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Integer> {

    public default Card saveCard (Card card) throws CardException {

        if (!cardHasCustomer(card)) {
            throw new CardException("Can not save card without customer");
        } else if (!cardHasCardName(card)) {
            throw new CardException("Card must have a card name");
        } else if (!cardHasCvv(card)) {
            throw new CardException("Can must have cvv");
        } else if (!cardHasType(card)) {
            throw new CardException("Card type not specified");
        } else if (!cardHasExpDate(card)) {
            throw new CardException("Card expiry date not set");
        }

        return save(card);
    }

    private boolean cardHasCustomer (Card card) {
        return card.getCustomer() != null;
    }

    private boolean cardHasExpDate (Card card) {
        return card.getExpDate() != null;
    }

    private boolean cardHasCvv (Card card) {
        return card.getCvv() != null;
    }

    private boolean cardHasCardName (Card card) {
        return card.getCardName() != null;
    }

    private boolean cardHasType (Card card) {
        return card.getCardType() != null;
    }
}
