package pl.coderslab.service;

import pl.coderslab.dto.ShopDto;

import java.util.List;

public interface ShopService {
    List<ShopDto> findAll();
    List<ShopDto> findAllNext();
}
