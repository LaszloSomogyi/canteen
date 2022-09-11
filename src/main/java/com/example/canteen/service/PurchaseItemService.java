package com.example.canteen.service;

import com.example.canteen.model.PurchaseItem;
import com.example.canteen.repo.PurchaseItemRepo;
import com.example.canteen.repo.PurchaseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseItemService {

    private final PurchaseItemRepo purchaseItemRepo;

    @Autowired
    public PurchaseItemService(PurchaseItemRepo purchaseItemRepo) {
        this.purchaseItemRepo = purchaseItemRepo;
    }

    public List<PurchaseItem> getAllPurchases() {
        return purchaseItemRepo.findAll();
    }
}
