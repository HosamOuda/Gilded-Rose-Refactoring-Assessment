<h1> Gilded Rose Coding Assignment</h1>

<h3> Problem description</h3>
<p>The guilded Rose is a team in a small inn with a prime location in a prominent city. They are mainly focusing on buying and selling goods but the goods are constantly degrading quality
as they approach the expiry date. They mainly sell four items (Aged Brie, Backstage Concert Tickets, Sulfuras legendary item, and finally Normal Item).


</p>

<h3> Problem Requirements</h3>
The items within that system have some main features and requirements:
<ol>
<li>All items have a SellIn value which denotes the number of days we have to sell the item</li>
<li>All items have a Quality value which denotes how valuable the item is</li>
<li>At the end of each day, our system lowers both values for every item</li>	
<li>Once the sell-by date has passed, Quality degrades twice as fast</li>
<li>The Quality of an item is never negative</li>
<li>"Aged Brie" actually increases in Quality the older it gets</li>
<li>The Quality of an item is never more than 50</li> 
<li>"Sulfuras", being a legendary item, never has to be sold or decreases in Quality</li> 
<li>"Backstage passes", like aged brie, increase in Quality as its SellIn value approaches;
	   quality increases by 2 when there are 10 days or fewer, and by 3 when there are 5 days or fewer, but
	 The   quality drops to 0 after the concert
</li> 
</ol>

Furthermore, it's required to also implement an extra item, which is a  conjured item. This particular item degrades twice as fast as the normal item, so that needs to be considered.

	
<h3> Used Design patterns </h3>
In this particular Problem, we use 2 main design patterns:
<ol>
	<li>Strategy Design pattern: Every item in the code has a certain logic that it strictly follows therefore instead of creating a bunch of if condition to match every possible scenario we can create a strategy class for every item type and make all these strategies implement a certain interface to ensure its consisitency and they are almost identical in structure but have different behaviour </li>
	<li>Factory Design Pattern: As we currently have different strategies for every item type with the same structure but different implementations, it would be greatly beneficial if we can create a factory method which can automatically create objects based on our needs and return them for the main GildedRose method to use.  </li>
</ol>

<h3> Implementation Approach</h3>
<ol>
	<li>Create Unit tests to simulate different cases of the GildedRose code, thus creating a ground of truth for our implementation</li>
	<li>Create different items' strategies and separate the logic into different independent classes</li>
	<li> Create the factory method with which the objects of different strategy classes will be created</li>
	<li> Run our ground of truth test cases in order to ensure that the code behaviour is as desired</li>
	<li>Add the new conjured item with modification to its logic as it degrades in quality twice as fast as the normal items</li>
	<li> Simulate different scenarios using the unit tests to ensure that our logic matches the requirements</li>
	<li> Finally Run all tests</li>
</ol>
