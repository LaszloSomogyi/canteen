package com.example.canteen;

import com.example.canteen.model.PurchaseItem;
import com.example.canteen.service.PurchaseItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        PurchaseItem purchaseItem = purchaseItemService.findPurchaseItemById(purchaseItemId);
        return new ResponseEntity<>(purchaseItem, HttpStatus.OK);
    }
}
