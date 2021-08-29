package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.Shop;

public interface ShopRepository extends JpaRepository <Shop, Long> {
}
