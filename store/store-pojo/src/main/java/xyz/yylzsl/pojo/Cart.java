package xyz.yylzsl.pojo;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class Cart implements Serializable {

    private Map<String,CartItem> map = new LinkedHashMap<>();
    private double total;

    // 获取购物项集合
    // 获取购物项信息
    // 获取总计
    // 添加商品到购物车
    // 商品移除购物车
    // 购物车清空


    public Map<String, CartItem> getMap() {
        return map;
    }

    public Collection<CartItem> getCartItems(){
        return map.values();
    }

    public double getTotal() {
        total = 0;
        for (Map.Entry<String, CartItem> entry : map.entrySet()) {
            CartItem cartItem = entry.getValue();
            total += cartItem.getTotal();
        }
        return total;
    }

    public void addCart(Product product, int quantity){
        if(product == null){
            return;
        }
        CartItem cartItem = map.get(product.getPid());
        if(cartItem==null){
            cartItem = new CartItem();
            cartItem.setQuantity(quantity);
            cartItem.setProduct(product);
            map.put(product.getPid(),cartItem);
        }else{
            cartItem.setQuantity(cartItem.getQuantity()+quantity);
        }
    }

    public void removeCart(String id){
        CartItem cartItem = map.remove(id);
    }

    public void clearCart(){
        map.clear();
    }
}
