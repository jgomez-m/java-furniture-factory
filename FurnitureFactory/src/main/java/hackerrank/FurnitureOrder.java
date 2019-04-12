package hackerrank;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class FurnitureOrder implements FurnitureOrderInterface {
    /**
     * TODO: Create a map of Furniture items to order quantities
     */
    private HashMap<Furniture, Integer> order;

    /**
     * Initialize a new mapping of Furniture types to order quantities.
     */
    FurnitureOrder() {
        order = new HashMap<Furniture, Integer>();
    }

    public void addToOrder(final Furniture type, final int furnitureCount) {
        order.computeIfPresent(type, (k, val) -> val + furnitureCount);
        order.putIfAbsent(type, furnitureCount);
    }


    public HashMap<Furniture, Integer> getOrderedFurniture() {
        return order;
    }

    public float getTotalOrderCost() {
        float totalCost = 0.0f;
        for(Map.Entry<Furniture, Integer> entry : order.entrySet()){
            totalCost+= entry.getKey().cost() * entry.getValue();
        }
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
        final AtomicInteger totalQuantity = new AtomicInteger();
        if(!order.isEmpty()){
            order.forEach((k,v) -> totalQuantity.addAndGet(v));
        }
        return totalQuantity.get();
    }
}
