package com.example.canteen.service;

import com.example.canteen.model.Purchase;
import com.example.canteen.repo.PurchaseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseService {

    private final PurchaseRepo purchaseRepo;

    @Autowired
    public PurchaseService(PurchaseRepo purchaseRepo) {
        this.purchaseRepo = purchaseRepo;
    }

    public List<Purchase> getAllPurchases() {
        return purchaseRepo.findAll();
    }

}