import HousingMarket.Apartment
import HousingMarket.Customer
import HousingMarket.Garage
import HousingMarket.House
import HousingMarket.HousingMarket
import HousingMarket.HousingMarket.Companion.showAdvertisements
import HousingMarket.HousingType

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val testHousingSystem = HousingMarket();

    val garage1 = Garage(true, "", 20, 2);
    val garage2 = Garage(true, "", 20, 2);

    val henk = Customer("Henk", "Henk@breda.nl")
    val anne = Customer("Anne", "Anne@avans.nl")

    val house1 = House("Gastakker 12", 130, 380000, HousingType.TERRACED, 210)
    val house2 = House("Singel 123", 120, 650000, HousingType.TERRACED, 180)
    val house3 = House("Hogeschoollaan 1", 40000, null, HousingType.DETACHED, 25000)
    val house4 = House("Bosrijk 10", 110, 510000, HousingType.BUNGALOW, 380)

    val apartment1 = Apartment("Teteringsdijks 110", 65, 260000, 99, 3)
    val apartment2 = Apartment("Tuinzigtlaan 117", 90, 290000, 130, 5)

    val garage3 = Garage(hasElectricity = true, "Hofjes 11", 19, 21000)
    val garage4 = Garage(hasElectricity = false, "Hofjes 13", 19, 19000)
    val garage5 = Garage(hasElectricity = true, "Hofjes 13", 19, priceAsked = null)

    val allProperties =
        listOf(house1, house2, house3, house4, apartment1, apartment2, garage1, garage2, garage3, garage5, garage4)

    testHousingSystem.advertise(allProperties)

    house4.doOffer(henk, 500000)
    house4.doOffer(henk, 505000)
    house4.doOffer(anne, 510000)


    val search = testHousingSystem.search({ p -> p.livingArea > 10 });
    showAdvertisements(selection = search, includeBids = true);
}