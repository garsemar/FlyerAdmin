package realm

import com.mongodb.BasicDBObject
import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase
import model.Posicions
import org.bson.Document
import org.bson.conversions.Bson
import org.bson.types.ObjectId
import javax.print.attribute.standard.MediaSize.Other

class PosicionsDao(val database: MongoDatabase){

    fun list() : MongoCollection<Document> = database.getCollection("Posicions")

    fun deleteItem(id: Bson){
        list().deleteOne(id)
    }
}