package ml.vladmikh.projects.cosmetics_store_app.data.network.model

data class Price(
    val discount: Int,
    val price: String,
    val priceWithDiscount: String,
    val unit: String
)