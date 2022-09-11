package com.example.canteen.repo;

import com.example.canteen.model.PurchaseItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PurchaseItemRepo extends JpaRepository<PurchaseItem, Long> {

    Optional<PurchaseItem> findPurchaseItemById(Long id);
}
