package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.beans.Shop;

public interface ShopRepository extends JpaRepository <Shop, Long> {
}
