package realm

import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase
import org.bson.Document
import org.bson.conversions.Bson

class CategoriesDao(val database: MongoDatabase){

    fun list() : MongoCollection<Document> = database.getCollection("Categories")

    fun deleteItem(id: Bson){
        list().deleteOne(id)
    }
}