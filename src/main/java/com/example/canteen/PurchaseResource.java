package com.example.canteen;

import com.example.canteen.model.Purchase;
import com.example.canteen.service.PurchaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        Purchase purchase = purchaseService.findPurchaseById(purchaseId);
        return new ResponseEntity<>(purchase, HttpStatus.OK);
    }
}
