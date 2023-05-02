package ui

import com.mongodb.client.model.Filters.eq
import realm.CategoriesDao
import realm.PosicionsDao
import ui.UI.Companion.mongoManager
import java.util.*

class CatUI(private val scan: Scanner) {
    private val categoriesDao = CategoriesDao(mongoManager.database)

    fun showMenu(){
        while (true) {
            println("Categories:")
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
        categoriesDao.list().find().forEach {
            println("Title: ${it["title"]}, despription: ${it["description"]}")
        }
        return
    }
    private fun remove(){
        val list = categoriesDao.list().find().toList()
        list.forEachIndexed { i, it ->
            println("${i+1}: [Title: ${it["title"]}, despription: ${it["description"]}]")
        }

        print("Position to remove: ")
        val id = list.getOrNull(scan.nextInt()-1)?.get("_id")
        categoriesDao.deleteItem(eq(id))
        return
    }
}