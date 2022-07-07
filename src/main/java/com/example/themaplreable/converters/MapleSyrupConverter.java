package com.example.themaplreable.converters;

import com.example.themaplreable.dto.CatalogueItemDto;
import com.example.themaplreable.dto.MapleSyrupDto;
import com.example.themaplreable.model.CatalogueItem;
import com.example.themaplreable.model.MapleSyrup;
import com.example.themaplreable.model.enums.Type;

import javax.persistence.*;

/**
 * Maple Syrup Converter.
 */
public class MapleSyrupConverter {

    public static MapleSyrupDto entityToDto(MapleSyrup mapleSyrup) {
        MapleSyrupDto mapleSyrupDto = new MapleSyrupDto();
        mapleSyrupDto.setId(mapleSyrup.getId());
        mapleSyrupDto.setName(mapleSyrup.getName());
        mapleSyrupDto.setDescription(mapleSyrup.getDescription());
        mapleSyrupDto.setImage(mapleSyrup.getImage());
        mapleSyrupDto.setPrice(mapleSyrup.getPrice());
        mapleSyrupDto.setStock(mapleSyrup.getStock());
        mapleSyrupDto.setType(mapleSyrup.getType());

        return mapleSyrupDto;
    }

    public static MapleSyrup dtoToEntity(MapleSyrupDto mapleSyrupDto) {
        MapleSyrup mapleSyrup = new MapleSyrup();
        mapleSyrup.setId(mapleSyrupDto.getId());
        mapleSyrup.setName(mapleSyrupDto.getName());
        mapleSyrup.setDescription(mapleSyrupDto.getDescription());
        mapleSyrup.setImage(mapleSyrupDto.getImage());
        mapleSyrup.setPrice(mapleSyrupDto.getPrice());
        mapleSyrup.setStock(mapleSyrupDto.getStock());
        mapleSyrup.setType(mapleSyrupDto.getType());

        return mapleSyrup;
    }
}
