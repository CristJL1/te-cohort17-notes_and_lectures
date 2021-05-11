package com.techelevator;

public class Exercises {

	public static void main(String[] args) {

        /*
        1. 4 birds are sitting on a branch. 1 flies away. How many birds are left on
        the branch?
        */

		// ### EXAMPLE:
		int initialNumberOfBirds = 4;
		int birdsThatFlewAway = 1;
		int remainingNumberOfBirds = initialNumberOfBirds - birdsThatFlewAway;

		System.out.println("Birds Left: " + remainingNumberOfBirds);

        /*
        2. There are 6 birds and 3 nests. How many more birds are there than
        nests?
        */

		// ### EXAMPLE:
		int numberOfBirds = 6;
		int numberOfNests = 3;
		int numberOfExtraBirds = numberOfBirds - numberOfNests;

		System.out.println("Extra Birds: " + numberOfExtraBirds);

        /*
        3. 3 raccoons are playing in the woods. 2 go home to eat dinner. How
        many raccoons are left in the woods?
        */

		int numberOfRaccoons = 3;
		int wentHome = 2;
		int raccoonsLeft = numberOfRaccoons - wentHome;

		System.out.println("Raccoons Left: " + raccoonsLeft);

        /*
        4. There are 5 flowers and 3 bees. How many less bees than flowers?
        */

		int numberOfFlowers = 5;
		int numberOfBees = 3;
		int differenceBetweenFlowersAndBees = numberOfFlowers - numberOfBees;

		System.out.println("Difference Between Flowers and Bees: " + differenceBetweenFlowersAndBees);

        /*
        5. 1 lonely pigeon was eating breadcrumbs. Another pigeon came to eat
        breadcrumbs, too. How many pigeons are eating breadcrumbs now?
        */

		int loneyPigeons = 1;
		int friendlyPiegeons = 1;
		int pigeonsEatingBreadcrumbs = loneyPigeons + friendlyPiegeons;

		System.out.println("Pigeons Eating Breadcrumbs: " + pigeonsEatingBreadcrumbs);

        /*
        6. 3 owls were sitting on the fence. 2 more owls joined them. How many
        owls are on the fence now?
        */

		int initialOwls = 3;
		int joiningOwls = 2;
		int totalOwlsOnFence = initialOwls + joiningOwls;

		System.out.println("Owls Sitting On Fence: " + totalOwlsOnFence);

        /*
        7. 2 beavers were working on their home. 1 went for a swim. How many
        beavers are still working on their home?
        */

		int busyBeavers = 2;
		int swimmingBeavers = 1;
		int beaversStillWorking = busyBeavers - swimmingBeavers;

		System.out.println("Beavers Still Working on Home: " + beaversStillWorking);

        /*
        8. 2 toucans are sitting on a tree limb. 1 more toucan joins them. How
        many toucans in all?
        */

		int initialToucans = 2;
		int joiningToucans = 1;
		int toucansOnTree = initialToucans + joiningToucans;

		System.out.println("Toucans On Tree: " + toucansOnTree);

        /*
        9. There are 4 squirrels in a tree with 2 nuts. How many more squirrels
        are there than nuts?
        */

		int numberOfSquirrels = 4;
		int numberOfNuts = 2;
		int differenceBetweenSquirrelsAndNuts = numberOfSquirrels - numberOfNuts;

		System.out.println("Difference Between Squirrels and Nuts: " + differenceBetweenSquirrelsAndNuts);

        /*
        10. Mrs. Hilt found a quarter, 1 dime, and 2 nickels. How much money did
        she find?
        */

		double quarter = .25;
		double dime = .10;
		double nickel = .05;

		double totalAmountOfChange = (1*quarter) + (1*dime) + (2*nickel);

		System.out.println("Mrs. Hilt's Total Money: " + totalAmountOfChange);

        /*
        11. Mrs. Hilt's favorite first grade classes are baking muffins. Mrs. Brier's
        class bakes 18 muffins, Mrs. MacAdams's class bakes 20 muffins, and
        Mrs. Flannery's class bakes 17 muffins. How many muffins does first
        grade bake in all?
        */

		int mrsBriersClass = 18;
		int mrsMacAdamsClass = 20;
		int mrsFlannerysClass = 17;
		int totalNumberOfMuffins = mrsBriersClass + mrsFlannerysClass + mrsMacAdamsClass;

		System.out.println("Total Number Of Muffins: " + totalNumberOfMuffins);

        /*
        12. Mrs. Hilt bought a yoyo for 24 cents and a whistle for 14 cents. How
        much did she spend in all for the two toys?
        */

		double yoyoPrice = .24;
		double whistlePrice = .14;
		double totalPriceOfToys = yoyoPrice + whistlePrice;

		System.out.println("Total Price of Toys: " + totalPriceOfToys);

        /*
        13. Mrs. Hilt made 5 Rice Krispie Treats. She used 8 large marshmallows
        and 10 mini marshmallows.How many marshmallows did she use
        altogether?
        */

		int largeMarshmallows = 8;
		int miniMarshmallows = 10;
		int totalNumberOfMarshmallows = largeMarshmallows + miniMarshmallows;

		System.out.println("Total Number of Marshmallows Used: " + totalNumberOfMarshmallows);

        /*
        14. At Mrs. Hilt's house, there was 29 inches of snow, and Brecknock
        Elementary School received 17 inches of snow. How much more snow
        did Mrs. Hilt's house have?
        */

		int mrsHiltsHouseSnow = 29;
		int brecknockElementarySchoolSnow = 17;
		int differenceInSnowfall = mrsHiltsHouseSnow - brecknockElementarySchoolSnow;

		System.out.println("Difference in Snowfall: " + differenceInSnowfall);

        /*
        15. Mrs. Hilt has $10. She spends $3 on a toy truck and $2 on a pencil
        case. How much money does she have left?
        */

		int mrsHiltTotalCash = 10;
		int toyTruckPrice = 3;
		int pencilCasePrice = 2;
		int mrsHiltCashRemaining = mrsHiltTotalCash - (toyTruckPrice+pencilCasePrice);

		System.out.println("Mrs. Hilt's Remaining Cash: $" + mrsHiltCashRemaining);

        /*
        16. Josh had 16 marbles in his collection. He lost 7 marbles. How many
        marbles does he have now?
        */

		int joshTotalMarbles = 16;
		int lostMarbles = 7;
		int joshRemainingMarbles = joshTotalMarbles - lostMarbles;

		System.out.println("Josh's Remaining Marbles: " + joshRemainingMarbles);

        /*
        17. Megan has 19 seashells. How many more seashells does she need to
        find to have 25 seashells in her collection?
        */

		int numberOfSeashellsMeganHas = 19;
		int numberOfSeashellsMeganWants = 25;
		int numberofSeashellsMeganNeeds = numberOfSeashellsMeganWants - numberOfSeashellsMeganHas;

		System.out.println("Number of Seashells Megan Needs to Find: " + numberofSeashellsMeganNeeds);

        /*
        18. Brad has 17 balloons. 8 balloons are red and the rest are green. How
        many green balloons does Brad have?
        */

		int totalNumberOfBalloons = 17;
		int numberOfRedBalloons = 8;
		int numberOfGreenBalloons = totalNumberOfBalloons - numberOfRedBalloons;

		System.out.println("Number of Green Balloons: " + numberOfGreenBalloons);

        /*
        19. There are 38 books on the shelf. Marta put 10 more books on the shelf.
        How many books are on the shelf now?
        */

		int initialBooksOnShelf = 38;
		int booksAddedByMarta = 10;
		int totalNumberOfBooks = initialBooksOnShelf + booksAddedByMarta;

		System.out.println("Total Number of Books on Shelf: " + totalNumberOfBooks);

        /*
        20. A bee has 6 legs. How many legs do 8 bees have?
        */

		int numberOfLegsOnABee = 6;
		int numberOfBeesWithLegs = 8;
		int numberOfLegsBetweenAllBees = numberOfLegsOnABee * numberOfBeesWithLegs;

		System.out.println("8 Bees Have " + numberOfLegsBetweenAllBees + " legs together.");

        /*
        21. Mrs. Hilt bought an ice cream cone for 99 cents. How much would 2 ice
        cream cones cost?
        */

		double costOfIceCreamCone = .99;
		double numberOfIceCreamConesPurchased = 2;
		double totalCostOfIceCreamCones = costOfIceCreamCone * numberOfIceCreamConesPurchased;

		System.out.println("Cost of 2 Ice Cream Cones: $" + totalCostOfIceCreamCones);


        /*
        22. Mrs. Hilt wants to make a border around her garden. She needs 125
        rocks to complete the border. She has 64 rocks. How many more rocks
        does she need to complete the border?
        */

		int rocksNeededForBorder = 125;
		int rocksMrsHiltHas = 64;
		int rocksNeededByMrsHilt = rocksNeededForBorder - rocksMrsHiltHas;

		System.out.println("Mrs. Hilt still needs " + rocksNeededByMrsHilt + " rocks to finish her border.");

        /*
        23. Mrs. Hilt had 38 marbles. She lost 15 of them. How many marbles does
        she have left?
        */

		int mrsHiltStartingMarbles = 38;
		int mrsHiltLostMarbles = 15;
		int mrsHiltMarblesLeft = mrsHiltStartingMarbles - mrsHiltLostMarbles;

		System.out.println("Marbles Mrs. Hilt Has Left: " + mrsHiltMarblesLeft);

        /*
        24. Mrs. Hilt and her sister drove to a concert 78 miles away. They drove 32
        miles and then stopped for gas. How many miles did they have left to drive?
        */

		int milesToConcert = 78;
		int milesToGasStation = 32;
		int milesLeftToDrive = milesToConcert - milesToGasStation;

		System.out.println("Mrs. Hilt and her sister still have to drive " + milesLeftToDrive + " miles to the concert.");

        /*
        25. Mrs. Hilt spent 1 hour and 30 minutes shoveling snow on Saturday
        morning and 45 minutes shoveling snow on Saturday afternoon. How
        much total time did she spend shoveling snow?
        */

		int shovelTimeMorning = 90;
		int shovelTimeAfternoon = 45;
		int timeSpentShoveling = shovelTimeAfternoon + shovelTimeMorning;

		System.out.println("Mrs Hilt spent " + timeSpentShoveling + " minutes shoveling snow.");

        /*
        26. Mrs. Hilt bought 6 hot dogs. Each hot dog cost 50 cents. How much
        money did she pay for all of the hot dogs?
        */

		double mrsHiltsHotDogs = 6;
		double costOfHotDog = .50;
		double costOfAllHotDogs = mrsHiltsHotDogs * costOfHotDog;

		System.out.println("Price Mrs. Hilt paid for Hot Dogs: $" + costOfAllHotDogs);

        /*
        27. Mrs. Hilt has 50 cents. A pencil costs 7 cents. How many pencils can
        she buy with the money she has?
        */

		double mrsHiltPencilMoney = .50;
		double pencilCost = .07;
		double pencilsMrsHiltCanBuy = mrsHiltPencilMoney / pencilCost;

		System.out.println("Mrs. Hilt can purchase " + (int)pencilsMrsHiltCanBuy + " pencils.");

        /*
        28. Mrs. Hilt saw 33 butterflies. Some of the butterflies were red and others
        were orange. If 20 of the butterflies were orange, how many of them
        were red?
        */

		int mrsHiltButterflies = 33;
		int orangeButterflies = 20;
		int redButterflies = mrsHiltButterflies - orangeButterflies;

		System.out.println("Red Butterflies Seen by Mrs. Hilt: " + redButterflies);

        /*
        29. Kate gave the clerk $1.00. Her candy cost 54 cents. How much change
        should Kate get back?
        */

		double katePaidAmount = 1.00;
		double candyCostAmount = .54;
		double kateChange = katePaidAmount - candyCostAmount;

		System.out.println("Kate's change should be " + kateChange);

        /*
        30. Mark has 13 trees in his backyard. If he plants 12 more, how many trees
        will he have?
        */

		int currentTreesInMarksYard = 13;
		int treesMarkPlants = 12;
		int treesInMarksYardAfterPlanting = currentTreesInMarksYard + treesMarkPlants;

		System.out.println("Mark now has " + treesInMarksYardAfterPlanting + " trees in his yard.");

        /*
        31. Joy will see her grandma in two days. How many hours until she sees
        her?
        */

		int hoursInADay = 24;
		int daysUntilJoySeesHerGrandma = 2;
		int hoursUntilJoySeesHerGrandma = hoursInADay * daysUntilJoySeesHerGrandma;

		System.out.println("Joy will see her Grandma in " + hoursUntilJoySeesHerGrandma + " hours.");

        /*
        32. Kim has 4 cousins. She wants to give each one 5 pieces of gum. How
        much gum will she need?
        */

		int kimNumberOfCousins = 4;
		int kimPiecesOfGum = 5;
		int kimGumNeeded = kimPiecesOfGum * kimNumberOfCousins;

		System.out.println("Pieces of gum Kim needs: " + kimGumNeeded);

        /*
        33. Dan has $3.00. He bought a candy bar for $1.00. How much money is
        left?
        */

		double cashDan = 3.00;
		double costCandyBar = 1.00;
		double cashDanAfterPurchase = cashDan - costCandyBar;

		System.out.println("Dan has $" + cashDanAfterPurchase + " left.");

        /*
        34. 5 boats are in the lake. Each boat has 3 people. How many people are
        on boats in the lake?
        */

		int boatsOnLake = 5;
		int peoplePerBoat = 3;
		int peopleOnLake = boatsOnLake * peoplePerBoat;

		System.out.println("People on Lake: " + peopleOnLake);

        /*
        35. Ellen had 380 legos, but she lost 57 of them. How many legos does she
        have now?
        */

		int ellenLegos = 380;
		int lostLegos = 57;
		int ellenLegosLeft = ellenLegos - lostLegos;

		System.out.println("Ellen has " + ellenLegosLeft + " Legos left.");

        /*
        36. Arthur baked 35 muffins. How many more muffins does Arthur have to
        bake to have 83 muffins?
        */

		int muffinsArthurWants = 83;
		int muffinsAlreadyBaked = 35;
		int muffinsNeeded = muffinsArthurWants - muffinsAlreadyBaked;

		System.out.println("Number of Muffins Arthur Still Needs to Bake: " + muffinsNeeded);

        /*
        37. Willy has 1400 crayons. Lucy has 290 crayons. How many more
        crayons does Willy have then Lucy?
        */

		int willyCrayons = 1400;
		int lucyCrayons = 290;
		int differenceInCrayons = willyCrayons - lucyCrayons;

		System.out.println("Willy has " + differenceInCrayons + " more crayons than Lucy.");

        /*
        38. There are 10 stickers on a page. If you have 22 pages of stickers, how
        many stickers do you have?
        */

		int stickersPerPage = 10;
		int pagesOfStickers = 22;
		int stickersInBook = stickersPerPage * pagesOfStickers;

		System.out.println("Number of stickers in book: " + stickersInBook);

        /*
        39. There are 96 cupcakes for 8 children to share. How much will each
        person get if they share the cupcakes equally?
        */

		int cupcakesToShare = 96;
		int childrenThatWantCupcakes = 8;
		int cupcakesPerChild = cupcakesToShare / childrenThatWantCupcakes;

		System.out.println("Each child will get " + cupcakesPerChild + " cupcakes.");

        /*
        40. She made 47 gingerbread cookies which she will distribute equally in
        tiny glass jars. If each jar is to contain six cookies each, how many
        cookies will not be placed in a jar?
        */

		int gingerbreadCookiesTotal = 47;
		int cookiesPerJar = 6;
		int cookiesNotInJar = gingerbreadCookiesTotal % cookiesPerJar;

		System.out.println("Cookies that didn't make it into a jar: " + cookiesNotInJar);

        /*
        41. She also prepared 59 croissants which she plans to give to her 8
        neighbors. If each neighbor received and equal number of croissants,
        how many will be left with Marian?
        */

		int croissantsBaked = 59;
		int numberOfNeighbors = 8;
		int leftoverCroissants = croissantsBaked % numberOfNeighbors;

		System.out.println("Number of Croissants Left with Marian: " + leftoverCroissants);

        /*
        42. Marian also baked oatmeal cookies for her classmates. If she can
        place 12 cookies on a tray at a time, how many trays will she need to
        prepare 276 oatmeal cookies at a time?
        */

		int cookiesPerTray = 12;
		int cookiesBakedAtOnce = 276;
		int traysNeededForCookies = cookiesBakedAtOnce / cookiesPerTray;

		System.out.println("Trays needed for cookies: " + traysNeededForCookies);

        /*
        43. Marian’s friends were coming over that afternoon so she made 480
        bite-sized pretzels. If one serving is equal to 12 pretzels, how many
        servings of bite-sized pretzels was Marian able to prepare?
        */

		int pretzelsBaked = 480;
		int pretzelsPerServing = 12;
		int servingsPrepared = pretzelsBaked / pretzelsPerServing;

		System.out.println("Pretzel Servings Prepared: " + servingsPrepared);

        /*
        44. Lastly, she baked 53 lemon cupcakes for the children living in the city
        orphanage. If two lemon cupcakes were left at home, how many
        boxes with 3 lemon cupcakes each were given away?
        */

		int lemonCupcakesBaked = 53;
		int cupcakesPerBox = 3;
		int cupcakesAtHome = 2;
		int boxesGivenToOrphanage = (lemonCupcakesBaked - cupcakesAtHome) / cupcakesPerBox;

		System.out.println("Boxes of Cupcakes Given Away: " + boxesGivenToOrphanage);

        /*
        45. Susie's mom prepared 74 carrot sticks for breakfast. If the carrots
        were served equally to 12 people, how many carrot sticks were left
        uneaten?
        */

		int carrotSticksPrepared = 74;
		int peopleEatingCarrotSticks = 12;
		int leftoverCarrotSticks = carrotSticksPrepared % peopleEatingCarrotSticks;

		System.out.println("Number of Carrot Sticks Leftover: " + leftoverCarrotSticks);

        /*
        46. Susie and her sister gathered all 98 of their teddy bears and placed
        them on the shelves in their bedroom. If every shelf can carry a
        maximum of 7 teddy bears, how many shelves will be filled?
        */

		int teddyBearsOwned = 98;
		int teddyBeardsPerShelf = 7;
		int filledShelves = teddyBearsOwned / teddyBeardsPerShelf;

		System.out.println("Shelves filled with teddy bears: " + filledShelves);

        /*
        47. Susie’s mother collected all family pictures and wanted to place all of
        them in an album. If an album can contain 20 pictures, how many
        albums will she need if there are 480 pictures?
        */

		int picturesPerAlbum = 20;
		int picturesTotal = 480;
		int albumsNeeded = picturesTotal / picturesPerAlbum;

		System.out.println("Picture Albums Required: " + albumsNeeded);

        /*
        48. Joe, Susie’s brother, collected all 94 trading cards scattered in his
        room and placed them in boxes. If a full box can hold a maximum of 8
        cards, how many boxes were filled and how many cards are there in
        the unfilled box?
        */

		int tradingCards = 94;
		int cardsPerBox = 8;
		int filledBoxes = tradingCards / cardsPerBox;
		int cardsInUnfilledBox = tradingCards % cardsPerBox;

		System.out.println("Completely filled boxes: " + filledBoxes);

		System.out.println("Cards in partially filled box: " + cardsInUnfilledBox);

        /*
        49. Susie’s father repaired the bookshelves in the reading room. If he has
        210 books to be distributed equally on the 10 shelves he repaired,
        how many books will each shelf contain?
        */

		int booksOwned = 210;
		int shelvesRepaired = 10;
		int booksPerShelf = booksOwned / shelvesRepaired;

		System.out.println("Books per shelf: " + booksPerShelf);

        /*
        50. Cristina baked 17 croissants. If she planned to serve this equally to
        her seven guests, how many will each have?
        */

		int cristinaCroissants = 17;
		int cristinaGuests = 7;
		int croissantPerGuest = cristinaCroissants / cristinaGuests;

		System.out.println("Each of Cristina's guests will get " + croissantPerGuest + " croissants.");

        /*
            CHALLENGE PROBLEMS
        */

        /*
        Bill and Jill are house painters. Bill can paint a 12 x 14 room in 2.15 hours, while Jill averages
        1.90 hours. How long will it take the two painter working together to paint 5 12 x 14 rooms?
        Hint: Calculate the hourly rate for each painter, combine them, and then divide the total walls in feet by the combined hourly rate of the painters.
        Challenge: How many days will it take the pair to paint 623 rooms assuming they work 8 hours a day?.
        */

		/*
		double minutesPerHour = 60;
		double billPaint = (2.15 * minutesPerHour);
		double jillPaint = (1.90 * minutesPerHour);
		double averagePaint = (billPaint + jillPaint) /2;
		double surfaceAreaPainted = 12 * 14 * 5;
		double timeToPaint = surfaceAreaPainted / averagePaint;

		 */

		// System.out.println(timeToPaint);

        /*
        Create and assign variables to hold your first name, last name, and middle initial. Using concatenation,
        build an additional variable to hold your full name in the order of last name, first name, middle initial. The
        last and first names should be separated by a comma followed by a space, and the middle initial must end
        with a period.
        Example: "Hopper, Grace B."
        */

        /*
        The distance between New York and Chicago is 800 miles, and the train has already travelled 537 miles.
        What percentage of the trip has been completed?
        Hint: The percent completed is the miles already travelled divided by the total miles.
        Challenge: Display as an integer value between 0 and 100 using casts.
        */


	}

}
