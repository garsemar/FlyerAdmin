package ui

import realm.MongoManager
import java.util.Scanner

class UI(private val scan: Scanner) {
    private lateinit var catUI: CatUI
    private lateinit var posUI: PosUI

    companion object{
        val mongoManager = MongoManager()
    }

    init {
        mongoManager.configureRealm()
    }

    fun start(){
        posUI = PosUI(scan)
        catUI = CatUI(scan)
        showMenu()
    }

    private fun showMenu(){
        while (true) {
            println("FlyerAdmin")
            println("1: Posicions")
            println("2: Categories")
            println("0: Exit")
            when (scan.nextInt()) {
                1 -> posUI.showMenu()
                2 -> catUI.showMenu()
                0 -> return
            }
        }
    }
}