package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.dto.ShopDto;
import pl.coderslab.repository.ShopRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShopServiceImp implements ShopService {
    private final ShopRepository shopRepository;

    public ShopServiceImp(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public List<ShopDto> findAll() {
        return shopRepository.findAll()
                .stream()
                .map(shop -> new ShopDto(shop.getId(), shop.getShopName()))
                .collect(Collectors.toList());
    }

    @Override
    public List<ShopDto> findAllNext() {
        return shopRepository.findAllByIdAfter(1L);

    }
}
