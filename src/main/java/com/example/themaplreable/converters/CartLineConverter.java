package com.example.themaplreable.converters;

import com.example.themaplreable.dto.CartLineDto;
import com.example.themaplreable.model.CartLine;


/**
 * Cart Line Converter.
 */
public class CartLineConverter {

    public static CartLineDto entityToDto(CartLine carteLine) {
        CartLineDto carteLineDto = new CartLineDto();
        if (carteLine != null) {
            carteLineDto.setId(carteLine.getId());
            carteLineDto.setName(carteLine.getName());
            carteLineDto.setImage(carteLine.getImage());
            carteLineDto.setPrice(carteLine.getPrice());
            carteLineDto.setQty(carteLine.getQty());
            carteLineDto.setProductId(carteLine.getProductId().toString());
        }

        return carteLineDto;
    }

    public static CartLine dtoToEntity(CartLineDto carteLineDto) {
        CartLine carteLine = new CartLine();
        if (carteLineDto != null) {
            carteLine.setId(carteLineDto.getId());
            carteLine.setName(carteLineDto.getName());
            carteLine.setImage(carteLineDto.getImage());
            carteLine.setPrice(carteLineDto.getPrice());
            carteLine.setQty(carteLineDto.getQty());
            //carteLine.setProductId(Long.valueOf(carteLineDto.getProductId()));
        }

        return carteLine;
    }
}
