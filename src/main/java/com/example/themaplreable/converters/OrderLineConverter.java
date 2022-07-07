package com.example.themaplreable.converters;

import com.example.themaplreable.dto.MapleSyrupDto;
import com.example.themaplreable.dto.OrderLineDto;
import com.example.themaplreable.model.MapleSyrup;
import com.example.themaplreable.model.OrderLine;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Order Line Converter.
 */
public class OrderLineConverter {

    public static OrderLineDto entityToDto(OrderLine orderLine) {
        OrderLineDto orderLineDto = new OrderLineDto();
        orderLineDto.setId(orderLine.getId());
        orderLineDto.setProductId(orderLine.getProductId());
        orderLineDto.setQty(orderLine.getQty());

        return orderLineDto;
    }

    public static OrderLine dtoToEntity(OrderLineDto orderLineDto) {
        OrderLine orderLine = new OrderLine();
        orderLine.setId(orderLineDto.getId());
        orderLine.setProductId(orderLineDto.getProductId());
        orderLine.setQty(orderLineDto.getQty());

        return orderLine;
    }
}
