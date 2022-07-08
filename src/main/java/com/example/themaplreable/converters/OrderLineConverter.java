package com.example.themaplreable.converters;

import com.example.themaplreable.dto.OrderLineDto;
import com.example.themaplreable.model.OrderLine;

/**
 * Order Line Converter.
 */
public class OrderLineConverter {

    public static OrderLineDto entityToDto(OrderLine orderLine) {
        OrderLineDto orderLineDto = new OrderLineDto();
        if (orderLine != null) {
            orderLineDto.setId(orderLine.getId());
            orderLineDto.setQty(orderLine.getQty());
            orderLineDto.setProductId(orderLine.getProductId().toString());
        }

        return orderLineDto;
    }

    public static OrderLine dtoToEntity(OrderLineDto orderLineDto) {
        OrderLine orderLine = new OrderLine();
        if (orderLineDto != null) {
            orderLine.setId(orderLineDto.getId());
            orderLine.setQty(orderLineDto.getQty());
            //orderLine.setProductId(orderLineDto.getProductId());
        }

        return orderLine;
    }
}
