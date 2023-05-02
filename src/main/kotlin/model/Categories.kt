package model

import org.bson.types.ObjectId

data class Categories(
    var _id: ObjectId = ObjectId.get(),
    var title: String = "",
    var description: String = "",
    var owner_id: String = ""
)