package model

import org.bson.types.ObjectId

data class Posicions(
    var _id: ObjectId = ObjectId.get(),
    var title: String = "",
    var lat: Double = 0.0,
    var lon: Double = 0.0,
    var image: ByteArray? = null,
    var owner_id: String = ""
)