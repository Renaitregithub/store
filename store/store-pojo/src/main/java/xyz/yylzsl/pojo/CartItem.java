package xyz.yylzsl.pojo;

import java.io.Serializable;

public class CartItem implements Serializable {

    private Product product;
    private Integer quantity;
    private Double total;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotal() {
        this.total = quantity * product.getShop_price();
        return total;
    }
}
