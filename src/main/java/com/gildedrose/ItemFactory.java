package com.gildedrose;

import com.gildedrose.Interfaces.ItemUpdater;
import com.gildedrose.Strategies.*;


/*
by applying the strategy design pattern on different items
to separate their logic into separate independent strategy,

we can use the factory design pattern along with strategy
design pattern in order to dynamically create objects
of the corresponding strategy efficiently
 */
public class ItemFactory {
    public static ItemUpdater createItem (Item item)
    {

        if (item.name.equals("Aged Brie")) return new AgedBrieStrategy();
        else if (item.name.equals("Sulfuras, Hand of Ragnaros"))return new SulfurasStrategy();
        else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) return new BackstageStrategy();
        else  return new NormalStrategy();

        }
    }

