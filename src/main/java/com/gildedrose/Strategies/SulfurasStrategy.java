package com.gildedrose.Strategies;

import com.gildedrose.Interfaces.ItemUpdater;
import com.gildedrose.Item;

public class SulfurasStrategy implements ItemUpdater {

    public void itemUpdate(Item item) {
        System.out.println("The Sulfuras , hand of Ragnaros has no effect on the quality and the expiry date");
    }
}
