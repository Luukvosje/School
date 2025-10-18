package HousingMarket

import java.time.Instant
import kotlin.random.Random

enum class HousingType {
    DETACHED, SEMI_DETACHED, TERRACED, BUNGALOW
}

interface Locatable {
    fun getLocation(): LatLong
}

data class LatLong(val latitude: Double, val longitude: Double)


data class Customer(val name: String, val email: String)

data class Bid(
    val customer: Customer,
    val priceOffered: Int,
    val timeOfBid: Instant = Instant.now()
)

abstract class Property(
    private val address: String,
    val livingArea: Int,
    var priceAsked: Int?,
) : Locatable {

    private val _bids: MutableList<Bid> = mutableListOf()
    val bids: List<Bid> get() = _bids.toList()

    fun doOffer(customer: Customer, priceOffered: Int) {
        require(priceOffered > 0) {
            "Price must be above 0"
        }

        if (isAccepted(priceOffered)) {
            _bids.add(Bid(customer, priceOffered, Instant.now()))
        }
        Thread.sleep(10)
    }

    fun isAccepted(priceOffered: Int): Boolean {
        return priceOffered > (_bids.maxOfOrNull { bid -> bid.priceOffered } ?: 0)
    }

    override fun getLocation(): LatLong {
        return LatLong(
            51.58494229691791 + Random.nextDouble(-0.1, 0.1),
            4.797559120743779 + Random.nextDouble(-0.1, 0.1)
        )
    }

    abstract fun getMonthlyPayments(): Int?
}

fun Property.eneryCalculator(): Double =
    when (this) {
        is Garage -> 0.0
        is Apartment -> 9.0
        is House -> when (type) {
            HousingType.BUNGALOW,
            HousingType.DETACHED -> livingArea * 15.0

            HousingType.SEMI_DETACHED -> livingArea * 13.0
            HousingType.TERRACED -> livingArea * 11.0
        }

        else -> 0.0
    }

class Garage(
    val hasElectricity: Boolean,
    address: String,
    livingArea: Int,
    priceAsked: Int? = null,
) : Property(address, livingArea, priceAsked) {

    override fun getMonthlyPayments(): Int? = priceAsked?.let {
        val mortgageYear = it * HousingMarket.interest
        return (mortgageYear / 12).toInt()
    }

    override fun toString(): String {
        return super.toString()
    }
}

class Apartment(
    address: String,
    livingArea: Int,
    priceOffered: Int? = null,
    val floor: Int,
    val paymentHao: Int,
) : Property(address, livingArea, priceOffered) {
    override fun getMonthlyPayments(): Int? = priceAsked?.let {
        val livingPrice = livingArea * 0.15;
        val enery = eneryCalculator();
        val mortgageYear = it * HousingMarket.interest
        val vve = paymentHao;
        return (vve + livingPrice + enery + mortgageYear).toInt() / 12;
    }

    override fun toString(): String = super.toString() + "\n\tlocated at ${floor} floor"

}

class House(
    address: String,
    livingArea: Int,
    priceAsked: Int? = null,
    val type: HousingType,
    val plotArea: Int,
) : Property(address, livingArea, priceAsked) {
    override fun getMonthlyPayments(): Int? =
        priceAsked?.let {
            val mortgageYear = it * HousingMarket.interest
            val yearPrice = it * 0.01 + plotArea * 5;
            val enery = eneryCalculator();
            return (yearPrice + enery + mortgageYear).toInt() / 12;
        }

    override fun toString(): String = super.toString() +
            "\n\tthis ${type.toString().lowercase()} house is situated at $plotArea m2 plot area"
}

class HousingMarket {
    private val allHouses = mutableListOf<Property>()

    fun advertise(home: Property) {
        allHouses.add(home)
    }

    fun advertise(homes: List<Property>) {
        allHouses.addAll(homes)
    }


    fun search(query: (Property) -> Boolean): List<Property> = allHouses.filter(query)

    fun search(minPrice: Int = 0, maxPrice: Int = Int.MAX_VALUE) =
        allHouses.filter { house -> house.priceAsked in minPrice..maxPrice }


    companion object {
        val interest: Double = 0.4;

        fun showAdvertisements(selection: List<Property>, includeBids: Boolean) {
            println("=".repeat(40))
            selection.forEachIndexed { index, property ->
                println("Selected property: $property")
                if (includeBids) println(property.bids.joinToString(prefix = "\t\t", separator = "\n\t\t"))
                println("-".repeat(40))
            }
            println("=".repeat(40))
            println()
        }
    }
}