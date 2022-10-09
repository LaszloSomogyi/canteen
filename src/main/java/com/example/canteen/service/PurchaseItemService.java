package com.example.canteen.service;

import com.example.canteen.exceptions.PurchaseItemNotFoundException;
import com.example.canteen.model.PurchaseItem;
import com.example.canteen.repo.PurchaseItemRepo;
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

    public List<PurchaseItem> getAllPurchaseItems() {
        return purchaseItemRepo.findAll();
    }

    public PurchaseItem findById(Long purchaseItemId) {
        return purchaseItemRepo.findById(purchaseItemId).orElseThrow(() -> new PurchaseItemNotFoundException("Non-existent purchaseitem!"));
    }

    public PurchaseItem addPurchaseItem(PurchaseItem purchaseItem) {
        return purchaseItemRepo.save(purchaseItem);
    }

    public List<PurchaseItem> addPurchaseItems(List<PurchaseItem> purchaseItems) {
        return purchaseItemRepo.saveAll(purchaseItems);
    }
}
