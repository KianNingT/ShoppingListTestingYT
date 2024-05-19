package com.plcoding.testingcourse.shopping.domain

import com.plcoding.testingcourseexamples.part1.domain.ShoppingCartCache


class ShoppingCart {

    private val validProductIds = listOf(1, 2, 3, 4, 5)
    private val items = mutableListOf<Product>()

    class shoppingCartCacheDummy: ShoppingCartCache {
        override fun saveCart(items: List<Product>) {
            TODO("Not yet implemented")
        }

        override fun loadCart(): List<Product> {
            TODO("Not yet implemented")
        }

        override fun clearCart() {
            TODO("Not yet implemented")
        }
    }

    fun addProduct(product: Product, quantity: Int) {
        if(quantity < 0) {
            throw IllegalArgumentException("Quantity can't be negative")
        }
        if(isValidProduct(product)) {
            repeat(quantity) {
                items.add(product)
            }
        }
    }

    private fun isValidProduct(product: Product): Boolean {
        return product.price >= 0.0 && product.id in validProductIds
    }

    fun getTotalCost(): Double {
        return items.sumOf { it.price }
    }
}