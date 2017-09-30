package com.lxjr.sudadai.enums;

import java.util.HashMap;
import java.util.Map;

public enum WeightEnum {

    ONE(1,100),
    TWO(2,60),
    THREE(3,35),
    FOUR(4,22),
    FIVE(5,12),
    SIX(6,6);

    /** 顺序 **/
    private int order;

    /** 权重 **/
    private int weight;

    private static Map<Integer, Integer> valueMap = new HashMap<>();

    private WeightEnum(int order, int weight) {
        this.order = order;
        this.weight = weight;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public static Map<Integer, Integer> getValueMap() {
        if (valueMap.isEmpty()) {
            WeightEnum[] enums = WeightEnum.values();
            for (WeightEnum e : enums) {
                valueMap.put(e.getOrder(), e.getWeight());
            }
        }
        return valueMap;
    }
}
