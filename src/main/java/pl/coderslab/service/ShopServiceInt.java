package pl.coderslab.service;

import pl.coderslab.dto.ShopDto;

import java.util.List;

public interface ShopServiceInt {
    List<ShopDto> findAll();
}
