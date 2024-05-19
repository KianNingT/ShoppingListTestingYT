package com.plcoding.testingcourse.shopping.domain

import assertk.assertFailure
import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource


class ShoppingCartTest {

    private lateinit var cart: ShoppingCart

    @BeforeEach
    fun setup() {
        //cart is equals to new shopping card instance
        cart = ShoppingCart()
    }

    @ParameterizedTest
    @CsvSource(
        "3, 13.00, 4, 4.00, 2, 10.50",
        "1, 11.00, 3, 3.00, 1, 9.50",
    )
    fun `Add multiple product, total price sum is correct`(
        chickenQuantity: Int,
        chickenPrice: Double,
        chipsQuantity: Int,
        chipsPrice: Double,
        packOfBeerQuantity: Int,
        packOfBeerPrice: Double
    ) {

        //Given
        val chicken = Product(1, "Chicken", chickenPrice)
        val chips = Product(2, "Chips", chipsPrice)
        val packOfBeer = Product(3, "Pack of Beer", packOfBeerPrice)
        cart.addProduct(chicken, chickenQuantity)
        cart.addProduct(chips, chipsQuantity)
        cart.addProduct(packOfBeer, packOfBeerQuantity)

        //Action
        val priceSum = cart.getTotalCost()

        //Assertion
        val chickenTotal = chickenQuantity * chickenPrice
        val chipsTotal = chipsQuantity * chipsPrice
        val packOfBeerTotal = packOfBeerQuantity * packOfBeerPrice
        val allTotal = chickenTotal + chipsTotal + packOfBeerTotal
        assertThat(priceSum).isEqualTo(allTotal)
    }

    @RepeatedTest(50)
    fun `Insert a product with quantity 0, throw function exception`() {

        // GIVEN
        val productWithZeroQuantity = Product(1, "Product0", 30.00)

        // ACTION
        val priceSum = cart.getTotalCost()

        // ASSERTION
        assertFailure {
            cart.addProduct(productWithZeroQuantity, 0)

        }
    }

    @Test
    fun `check for valid product`() {

        //GIVEN
        val product = Product(30, "Test Product", 30.00)
        cart.addProduct(product, 5)

        //ACTION
        val priceSum = cart.getTotalCost()

        assertThat(priceSum).isEqualTo(0.00)
    }

}