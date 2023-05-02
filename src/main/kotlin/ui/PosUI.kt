package ui

import com.mongodb.client.model.Filters.eq
import realm.PosicionsDao
import ui.UI.Companion.mongoManager
import java.util.*

class PosUI(private val scan: Scanner) {
    private val posicionsDao = PosicionsDao(mongoManager.database)

    fun showMenu(){
        while (true) {
            println("Positions:")
            println("1: List")
            println("2: Remove")
            println("0: Back")
            when (scan.nextInt()) {
                1 -> list()
                2 -> remove()
                0 -> return
            }
        }
    }
    private fun list(){
        posicionsDao.list().find().forEach {
            println("Title: ${it["title"]}, coords: (${it["lat"]} ${it["lon"]})")
        }
        return
    }
    private fun remove(){
        val list = posicionsDao.list().find().toList()
        list.forEachIndexed { i, it ->
            println("${i+1}: [Title: ${it["title"]}, coords: (${it["lat"]} ${it["lon"]})]")
        }

        print("Position to remove: ")
        val id = list.getOrNull(scan.nextInt()-1)?.get("_id")
        posicionsDao.deleteItem(eq(id))
        return
    }
}