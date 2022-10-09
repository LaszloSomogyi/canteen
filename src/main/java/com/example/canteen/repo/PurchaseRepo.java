package com.example.canteen.repo;

import com.example.canteen.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PurchaseRepo extends JpaRepository<Purchase, Long> { }
