package hackerrank;

import java.util.HashMap;
import java.util.Map;

public class FurnitureOrder implements FurnitureOrderInterface {
    /**
     * TODO: Create a map of Furniture items to order quantities
     */
    private Map<Furniture, Integer> order;

    /**
     * Initialize a new mapping of Furniture types to order quantities.
     */
    FurnitureOrder() {
        // TODO: Complete the constructor
        order = new HashMap<Furniture, Integer>();
    }

    public void addToOrder(final Furniture type, final int furnitureCount) {
        order.computeIfPresent(type, (k, val) -> val + furnitureCount);
        order.putIfAbsent(type, furnitureCount);
    }


    public HashMap<Furniture, Integer> getOrderedFurniture() {
        // TODO: Complete the method
        return null;
    }

    public float getTotalOrderCost() {
        // TODO: Complete the method
        float totalCost;
        order.forEach((k, val) -> {
            totalCost =  k.cost() * val;
        });
        return totalCost;
    }

    public int getTypeCount(Furniture type) {
        return order.containsKey(type) ? order.get(type) : 0;
    }

    public float getTypeCost(Furniture type) {
        float cost = 0.0f;
        if(order.containsKey(type)){
            cost = order.get(type) * type.cost();
        }
        return cost;
    }

    public int getTotalOrderQuantity() {
        // TODO: Complete the method
        return -1;
    }
}