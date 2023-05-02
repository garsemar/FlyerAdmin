package realm

import com.mongodb.ConnectionString
import com.mongodb.MongoClientSettings
import com.mongodb.MongoClientSettings.getDefaultCodecRegistry
import com.mongodb.ServerApi
import com.mongodb.ServerApiVersion
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoClients
import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase
import model.Posicions
import org.bson.codecs.configuration.CodecRegistries.fromProviders
import org.bson.codecs.configuration.CodecRegistries.fromRegistries
import org.bson.codecs.pojo.PojoCodecProvider

class MongoManager {
    lateinit var mongoClient: MongoClient
    lateinit var database: MongoDatabase

    fun configureRealm(){
        val pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build()
        val pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider))
        val connectionString =
            ConnectionString("mongodb+srv://itb:superultrasegurapassword@flyer.ank1ohj.mongodb.net/?retryWrites=true&w=majority")
        val settings: MongoClientSettings = MongoClientSettings.builder()
            .applyConnectionString(connectionString)
            .serverApi(
                ServerApi.builder()
                    .version(ServerApiVersion.V1)
                    .build()
            )
            .build()
        mongoClient = MongoClients.create(settings)
        database = mongoClient.getDatabase("Flyer").withCodecRegistry(pojoCodecRegistry)
        // var collection = database.getCollection("Posicions", Posicions::class.java)
    }
}