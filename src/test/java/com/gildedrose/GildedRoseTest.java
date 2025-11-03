package com.gildedrose;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test @DisplayName("case the date has passed so the quality degrades twice as fast (-=2)")
    void case_date_passed_twice_degradation() {
        Item[] items = new Item[] { new Item("foo", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, app.items[0].quality);
    }

    @Test @DisplayName("case the date has not passed so the quality degraade by one")
    void case_date_not_passed_degradation_by_one() {
        Item[] items = new Item[] { new Item("foo", 1, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].quality);
    }

    // min 3 commits (test cases all but the conjured , clean the code (without the new the feature) using design patterns, add the conjured with test cases


    // Aged Brie Unit Tests
    @Test @DisplayName("Case 1 : Aged Brie Item with unexpired date and quality <50")
    void aged_case_one()
    {
        Item[] items = new Item[] { new Item("Aged Brie", 5, 49) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality,"decrease in quality by one as it is not expired yet");
        assertEquals(4, app.items[0].sellIn,"expiry date decrease by one");
    }
    @Test @DisplayName("Case 2 : Aged Brie Item with expired date (<0) and quality 49")
    void aged_case_two()
    {
        Item[] items = new Item[] { new Item("Aged Brie", -1, 49) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality,"aged brie increase in qulaity once if qulaity is less than 50 by one");
        assertEquals(-2, app.items[0].sellIn,"expiry date decrease by one");
    }

    @Test @DisplayName("Case 3 : Aged Brie Item with expired date (<0) and quality 48 to not enter the last nested if condition")
    void aged_case_three()
    {
        Item[] items = new Item[] { new Item("Aged Brie", -1, 48) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality,"aged brie increase in quality twice after expiry");
        assertEquals(-2, app.items[0].sellIn,"expiry date decrease by one");
    }


    //Sulfuras Test Cases
    @Test @DisplayName("Case 1 : Sulfuras item has no effect on the quality and the sellin and has an unaltered quality of 80")
    void sulfuras_case_one()
    {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 5, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality,"lengendary item dosent chnage quality");
        assertEquals(5, app.items[0].sellIn, "legenedary item doesnt have expiry date deduction");
    }


    //backstage Test cases
    @Test @DisplayName("Case 1 : Backstage item has quality less than 50 but expiry date more than 11 days")
    void backstage_case_one()
    {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 12, 48) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(49, app.items[0].quality,"quality decrease once if more than 11 days away from concert");
        assertEquals(11, app.items[0].sellIn,"expiry date decrease by one");
    }

    @Test @DisplayName("Case 2 : Backstage item has quality less than 50 but expiry date more than 6 days but less than 11 days (upgrade quality twice)")
    void backstage_case_two()
    {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 9, 48) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality,"quality decrease twice if less than 11 days only");
        assertEquals(8, app.items[0].sellIn,"expiry date decrease by one");
    }

    @Test @DisplayName("Case 3 : Backstage item has quality less than 50 but expiry date less than 6 days (quality update 3 times)")
    void backstage_case_three()
    {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 47) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality,"quality of ticket increase twice if remaining day less than 11 and 6 and quality is less than 50 by 3");
        assertEquals(4, app.items[0].sellIn,"expiry date decrease by one");
    }

    @Test @DisplayName("Case 4 : Backstage item has quality is 48 but expiry date less than 6 days (quality update 2 times)")
    void backstage_case_four()
    {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 48) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality,"quality of ticket increase twice if remaining day less than 11 and 6 and quality is less than 50 by 2");
        assertEquals(4, app.items[0].sellIn,"expiry date decrease by one");
    }

    @Test @DisplayName("Case 5 : Backstage item has quality is 49 but expiry date more than 6 days but less than 11 days (upgrade quality once)")
    void backstage_case_five()
    {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 9, 49) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality, "quality of ticket increase as we approach concert");
        assertEquals(8, app.items[0].sellIn,"expiry date decrease by one");
    }

    @Test @DisplayName("Case 6 : Backstage item has quality less than 50 but expiry date has passed(quality is 0)")
    void backstage_case_six()
    {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 49) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality,"quality of tickets fall to 0 after concert");
        assertEquals(-1, app.items[0].sellIn, "expiry date decrease by one");
    }


    //Normal Item tests
    @Test @DisplayName("case 1 : Normal item with quality greater than 0 but is expired")
    void normal_case_one(){
        Item[] items = new Item[] { new Item("Normal", 0, 45) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(43, app.items[0].quality,"expired item decreases quality twice");
        assertEquals(-1, app.items[0].sellIn,"expiry date decrease by one");
    }

    @Test @DisplayName("case 2 : Normal item with quality greater than 0 but has not expired")
    void normal_case_two(){
        Item[] items = new Item[] { new Item("Normal", 5, 45) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(44, app.items[0].quality,"quality greater than 0 decrease by one ");
        assertEquals(4, app.items[0].sellIn,"expiry date decrease by one");
    }

    @Test @DisplayName("case 3 : Normal item with quality of 0 but has not expired")
    void normal_case_three(){
        Item[] items = new Item[] { new Item("Normal", 5, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality,"quality does not change");
        assertEquals(4, app.items[0].sellIn,"expiry date decrease by one");
    }

    @Test @DisplayName("case 4 : Normal item with quality of 0 but has  expired")
    void normal_case_four(){
        Item[] items = new Item[] { new Item("Normal", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality , "quality does not change");
        assertEquals(-1, app.items[0].sellIn, "expiry date decrease by one");
    }

}
