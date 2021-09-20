package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.dto.ShopDto;
import pl.coderslab.model.Shop;

import java.util.List;

public interface ShopRepository extends JpaRepository <Shop, Long> {
    List<ShopDto> findAllByIdAfter(Long id);
}
