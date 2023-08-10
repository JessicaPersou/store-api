package br.com.shop.dto;

import br.com.shop.enums.PaymentType;
import br.com.shop.enums.SaleStatus;
import br.com.shop.model.Product;
import br.com.shop.model.Sale;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleDTO {

    private Long id;
    private LocalDate dateCreateSale;
    private int quantity;
    private double totalPrice;
    private PaymentType paymentType;
    private SaleStatus saleStatus;
    private List<ProductDTO> productsList = new ArrayList<>();
    private Long buyerId;



    public SaleDTO(Sale sale, List<Product> productsList) {
        this.id = sale.getId();
        this.dateCreateSale = sale.getDateCreateSale();
        this.quantity = sale.getQuantity();
        this.totalPrice = sale.getTotalPrice();
        this.paymentType = sale.getPaymentType();
        this.saleStatus = sale.getSaleStatus();
        this.buyerId = sale.getClient().getId();
        this.productsList = new ArrayList<>();

        productsList.forEach(item -> {
            ProductDTO product = new ProductDTO();
            product.setName(item.getName());
            product.setDescription(item.getDescription());
            product.setPrice(item.getPrice());
            product.setImage(item.getImage());
            product.setCategory(item.getCategory().getId());
            product.setId(item.getId());

            this.productsList.add(product);
        });
    }

    public SaleDTO(Sale sale){
        this.id = sale.getId();
        this.dateCreateSale = sale.getDateCreateSale();
        this.quantity = sale.getQuantity();
        this.totalPrice = sale.getTotalPrice();
        this.paymentType = sale.getPaymentType();
        this.saleStatus = sale.getSaleStatus();
        this.buyerId = sale.getClient().getId();


        productsList.forEach(item -> {
            ProductDTO product = new ProductDTO();
            product.setName(item.getName());
            product.setDescription(item.getDescription());
            product.setPrice(item.getPrice());
            product.setImage(item.getImage());
            product.setCategory(item.getCategory());
            product.setId(item.getId());

            this.productsList.add(product);
        });

    }
}