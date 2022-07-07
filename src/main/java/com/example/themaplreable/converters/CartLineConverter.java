package com.example.themaplreable.converters;


import com.example.themaplreable.dto.CartLineDto;
import com.example.themaplreable.model.CartLine;


/**
 * Cart Line Converter.
 */
public class CartLineConverter {

    public static CartLineDto entityToDto(CartLine carteLine) {
        CartLineDto carteLineDto = new CartLineDto();
        carteLineDto.setId(carteLine.getId());
        carteLineDto.setProductId(carteLine.getProductId());
        carteLineDto.setName(carteLine.getName());
        carteLineDto.setImage(carteLine.getImage());
        carteLineDto.setPrice(carteLine.getPrice());
        carteLineDto.setQty(carteLine.getQty());

        return carteLineDto;
    }

    public static CartLine dtoToEntity(CartLineDto carteLineDto) {
        CartLine carteLine = new CartLine();
        carteLine.setId(carteLineDto.getId());
        carteLine.setProductId(carteLineDto.getProductId());
        carteLine.setName(carteLineDto.getName());
        carteLine.setImage(carteLineDto.getImage());
        carteLine.setPrice(carteLineDto.getPrice());
        carteLine.setQty(carteLineDto.getQty());

        return carteLine;
    }
}
