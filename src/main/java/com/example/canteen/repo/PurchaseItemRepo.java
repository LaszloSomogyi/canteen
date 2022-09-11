package com.example.canteen.repo;

import com.example.canteen.model.PurchaseItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseItemRepo extends JpaRepository<PurchaseItem, Long> {
}
