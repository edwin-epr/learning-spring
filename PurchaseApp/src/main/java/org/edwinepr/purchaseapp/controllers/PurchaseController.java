package org.edwinepr.purchaseapp.controllers;

import lombok.Data;
import org.edwinepr.purchaseapp.model.Purchase;
import org.edwinepr.purchaseapp.repositories.PurchaseRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/purchase")
@Data
public class PurchaseController {

    private final PurchaseRepository purchaseRepository;

    @PostMapping
    public void storePurchase(@RequestBody Purchase purchase) {
        purchaseRepository.storePurchase(purchase);
    }

    @GetMapping
    public List<Purchase> getPurchases() {
        return purchaseRepository.getAllPurchases();
    }
}
