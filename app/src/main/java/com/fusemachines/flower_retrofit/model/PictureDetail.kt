package com.fusemachines.flower_retrofit.model

import java.io.Serializable

class PictureDetail : Serializable {
    var category: String
    var price: Double
    var instructions: String
    var photo: String
    var name: String
    var productId: Int

    constructor(category: String, price: Double, instructions: String, photo: String, name: String, productId: Int) {
        this.category = category
        this.price = price
        this.instructions = instructions
        this.photo = photo
        this.name = name
        this.productId = productId
    }
}