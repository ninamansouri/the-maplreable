package com.example.themaplreable.converters;

import com.example.themaplreable.dto.CartLineDto;
import com.example.themaplreable.dto.OrderLineDto;
import com.example.themaplreable.model.CartLine;
import com.example.themaplreable.model.OrderLine;

import java.util.ArrayList;
import java.util.List;

/**
 * Order Line Converter.
 */
public class OrderLineConverter {

    public static OrderLineDto entityToDto(OrderLine orderLine) {
        OrderLineDto orderLineDto = new OrderLineDto();
        if (orderLine != null) {
            orderLineDto.setProductId(orderLine.getProductId());
            orderLineDto.setQty(orderLine.getQty());
        }

        return orderLineDto;
    }

    public static OrderLine dtoToEntity(OrderLineDto orderLineDto) {
        OrderLine orderLine = new OrderLine();
        if (orderLineDto != null) {
            orderLine.setProductId(orderLineDto.getProductId());
            orderLine.setQty(orderLineDto.getQty());
        }

        return orderLine;
    }

    public static List<OrderLineDto> entitiesToDtos(List<OrderLine> orderLines) {
        List<OrderLineDto> orderLinesDto = new ArrayList<>();

        for (OrderLine orderLine : orderLines) {
            orderLinesDto.add(entityToDto(orderLine));
        }

        return orderLinesDto;
    }
}
