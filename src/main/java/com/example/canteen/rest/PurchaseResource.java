package com.example.canteen.rest;

import com.example.canteen.model.Purchase;
import com.example.canteen.service.PurchaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchase")
public class PurchaseResource {
    private final PurchaseService purchaseService;

    public PurchaseResource(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @GetMapping
    public ResponseEntity<List<Purchase>> getAllPurchases() {
        List<Purchase> purchases = purchaseService.getAllPurchases();
        return new ResponseEntity<>(purchases, HttpStatus.OK);
    }

    @GetMapping("/find/{purchase_id}")
    public ResponseEntity<Purchase> getPurchaseById (@PathVariable("purchase_id") Long purchaseId) {
        Purchase purchase = purchaseService.findById(purchaseId);
        return new ResponseEntity<>(purchase, HttpStatus.OK);
    }

    @PostMapping("/addpurchase")
    public ResponseEntity<Purchase> addPurchase(@RequestBody Purchase purchase) {
        Purchase newPurchase = purchaseService.addPurchase(purchase);
        return new ResponseEntity<>(newPurchase, HttpStatus.CREATED);
    }
}
