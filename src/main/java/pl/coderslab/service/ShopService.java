package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.beans.Shop;
import pl.coderslab.dto.ShopDto;
import pl.coderslab.dto.UserDto;
import pl.coderslab.repository.ShopRepository;
import pl.coderslab.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class ShopService implements ShopServiceInt{
    private final ShopRepository shopRepository;

    public ShopService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public List<ShopDto> findAll() {
        return shopRepository.findAll()
                .stream()
                .map(shop -> new ShopDto(shop.getId(), shop.getShopName()))
                .collect(Collectors.toList());
    }
}
