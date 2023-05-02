import org.apache.log4j.PropertyConfigurator
import ui.UI
import java.util.*


fun main() {
    val scan = Scanner(System.`in`)
    val log4jConfPath = "log4j.properties"
    PropertyConfigurator.configure(log4jConfPath)
    UI(scan).start()
}