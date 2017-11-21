package ii_collections

fun Shop.getCustomersWhoOrderedProduct(product: Product): Set<Customer> =
        this.customers.filter { it.orderedProducts.contains(product) }.toSet()


fun Customer.getMostExpensiveDeliveredProduct(): Product? =
        // Return the most expensive product among all delivered products
    // (use the Order.isDelivered flag)
    this.orders.filter { it.isDelivered }
            .flatMap { it.products }
            .sortedByDescending { it.price }
            .get(0)

fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int =
    // Return the number of times the given product was ordered.
    // Note: a customer may order the same product for several times.
    this.customers.flatMap { it.orders.flatMap { it.products } }
            .filter { it.equals(product) }
            .count()
