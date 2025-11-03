package com.gildedrose.Strategies;

import com.gildedrose.Interfaces.ItemUpdater;
import com.gildedrose.Item;

public class AgedBrieStrategy implements ItemUpdater {
    public void itemUpdate(Item item)
    {
        increase_quality(item);
        item.sellIn--;
        if (item.sellIn<0)
        {
            increase_quality(item);
        }
    }
    private void increase_quality(Item item)
    {
        if (item.quality<50)
        {
            item.quality++;
        }
    }
}
