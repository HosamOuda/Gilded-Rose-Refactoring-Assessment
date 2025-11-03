package com.gildedrose.Strategies;

import com.gildedrose.Item;
import com.gildedrose.Interfaces.ItemUpdater;
public class BackstageStrategy implements ItemUpdater{
    public void itemUpdate(Item item)
    {
        if (item.quality<50)
        {
            item.quality++;
            if (item.sellIn<11)increase_quality(item);
            if (item.sellIn<6) increase_quality(item);
        }
        item.sellIn--;
        if (item.sellIn<0) item.quality=0;
    }
    private void increase_quality(Item item)
    {
        if (item.quality<50)
        {
            item.quality++;
        }
    }
}
