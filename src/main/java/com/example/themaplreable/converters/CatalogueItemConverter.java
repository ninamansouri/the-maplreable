package com.example.themaplreable.converters;

import com.example.themaplreable.dto.CartLineDto;
import com.example.themaplreable.dto.CatalogueItemDto;
import com.example.themaplreable.model.CartLine;
import com.example.themaplreable.model.CatalogueItem;
import com.example.themaplreable.model.enums.Type;

import javax.persistence.*;

/**
 * Catalogue Item Converter.
 */
public class CatalogueItemConverter {

    public static CatalogueItemDto entityToDto(CatalogueItem catalogueItem) {
        CatalogueItemDto catalogueItemDto = new CatalogueItemDto();
        catalogueItemDto.setId(catalogueItem.getId());
        catalogueItemDto.setName(catalogueItem.getName());
        catalogueItemDto.setImage(catalogueItem.getImage());
        catalogueItemDto.setPrice(catalogueItem.getPrice());
        catalogueItemDto.setMaxQty(catalogueItem.getMaxQty());
        catalogueItemDto.setType(catalogueItem.getType());

        return catalogueItemDto;
    }

    public static CatalogueItem dtoToEntity(CatalogueItemDto catalogueItemDto) {
        CatalogueItem catalogueItem = new CatalogueItem();
        catalogueItem.setId(catalogueItem.getId());
        catalogueItem.setName(catalogueItemDto.getName());
        catalogueItem.setImage(catalogueItemDto.getImage());
        catalogueItem.setPrice(catalogueItemDto.getPrice());
        catalogueItem.setMaxQty(catalogueItemDto.getMaxQty());
        catalogueItem.setType(catalogueItemDto.getType());

        return catalogueItem;
    }
}
