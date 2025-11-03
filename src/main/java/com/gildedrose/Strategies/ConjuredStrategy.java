package com.gildedrose.Strategies;

import com.gildedrose.Interfaces.ItemUpdater;
import com.gildedrose.Item;

public class ConjuredStrategy implements ItemUpdater {

    /*
    as the conjured item decrease twice as fast as the normal item then at every call for decrease quality we
    will decrease by two
     */
    public void itemUpdate(Item item)
    {
        decrease_quality(item);
        item.sellIn--;
        if (item.sellIn<0) decrease_quality(item);

    }
    private void decrease_quality(Item item)
    {
        if (item.quality>0) item.quality= item.quality-2;
    }
}
