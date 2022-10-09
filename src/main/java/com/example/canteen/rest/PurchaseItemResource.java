package com.example.canteen.rest;

import com.example.canteen.model.PurchaseItem;
import com.example.canteen.service.PurchaseItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchaseitem")
public class PurchaseItemResource {
    private final PurchaseItemService purchaseItemService;

    public PurchaseItemResource(PurchaseItemService purchaseItemService) {
        this.purchaseItemService = purchaseItemService;
    }

    @GetMapping
    public ResponseEntity<List<PurchaseItem>> getAllPurchaseItems() {
        List<PurchaseItem> purchaseItems = purchaseItemService.getAllPurchaseItems();
        return new ResponseEntity<>(purchaseItems, HttpStatus.OK);
    }

    @GetMapping("/find/{purchaseitem_id}")
    public ResponseEntity<PurchaseItem> getPurchaseItemById (@PathVariable("purchaseitem_id") Long purchaseItemId) {
        PurchaseItem purchaseItem = purchaseItemService.findById(purchaseItemId);
        return new ResponseEntity<>(purchaseItem, HttpStatus.OK);
    }

    @PostMapping("/addpurchaseitem")
    public ResponseEntity<PurchaseItem> addPurchaseItem(@RequestBody PurchaseItem purchaseItem) {
        PurchaseItem newPurchaseItem = purchaseItemService.addPurchaseItem(purchaseItem);
        return new ResponseEntity<>(newPurchaseItem, HttpStatus.CREATED);
    }

    @PostMapping("/addpurchaseitems")
    public ResponseEntity<List<PurchaseItem>> addPurchaseItems(@RequestBody List<PurchaseItem> purchaseItems) {
        List<PurchaseItem> newPurchaseItems = purchaseItemService.addPurchaseItems(purchaseItems);
        return new ResponseEntity<>(newPurchaseItems, HttpStatus.CREATED);
    }
}
