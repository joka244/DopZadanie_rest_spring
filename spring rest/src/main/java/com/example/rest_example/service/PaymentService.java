package com.example.rest_example.service;

import com.example.rest_example.model.Clothes;
import com.example.rest_example.model.PaymentResult;
import com.example.rest_example.model.StoreAssortment;
import com.example.rest_example.model.UserOrder;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    //store Clothes assortment
    private static Clothes[] clothesData = {
            new Clothes("1", "Addidas", "Winter clothes", "Jacket", "L", 8000),
            new Clothes("2", "Puma", "Summer clothes", "T-shirt", "L", 1500),
            new Clothes("3", "Nike", "Winter clothes", "Cap", "M", 1200),
            new Clothes("4", "Nike", "Summer clothes", "Shorts", "XL", 1500),
            new Clothes("5", "Puma ", "Winter clothes", "Jacket", "XXL", 7000)
    };
    // the number of products in the store
    private static int[] quantityData = {0, 2, 3, 5, 1};
    private static StoreAssortment storeAssortment = new StoreAssortment(clothesData, quantityData);

    public PaymentResult buyClothes(UserOrder userOrder) {
        int size = storeAssortment.getClothess().length;
        for (int i = 0; i < size; i++) {
            Clothes currentClothes = storeAssortment.getClothess()[i];
            if (currentClothes.getId().equals(userOrder.getProductId())) {
                double orderPrice = currentClothes.getPrice() * userOrder.getQuantity();
                return new PaymentResult(
                        currentClothes.toString(),
                        userOrder.getQuantity(),
                        orderPrice,
                        "Buy successful!");
            }
        }
        return new PaymentResult(
                userOrder.getProductId(),
                userOrder.getQuantity(),
                0,
                "Buy failure! Model with id = " + userOrder.getProductId() + " not found");

    }
}
