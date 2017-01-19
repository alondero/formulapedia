import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class DriverOverviewController {

    @RequestMapping("/drivers")
    fun drivers(): String = "Hello World!"
}