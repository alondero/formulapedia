import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class DriverOverviewController {

    @RequestMapping("/drivers")
    fun drivers() = listOf(
            Driver("Lewis Hamilton", "British"),
            Driver("Valtteri Bottas", "Finnish")
    )
}

data class Driver (val name: String, val nationality: String)