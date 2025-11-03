package com.gildedrose.Strategies;

import com.gildedrose.Interfaces.ItemUpdater;
import com.gildedrose.Item;

public class NormalStrategy implements ItemUpdater {
    public void itemUpdate(Item item)
    {
        decrease_quality(item);
        item.sellIn--;
        if (item.sellIn<0) decrease_quality(item);

    }
    private void decrease_quality(Item item)
    {
        if (item.quality>0)
        {
            item.quality--;
        }
    }
}
