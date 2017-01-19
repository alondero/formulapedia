import org.springframework.boot.SpringApplication.run
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan("com.github.alondero.formulapedia")
open class Application {
    @Bean open fun driverOverviewController() = DriverOverviewController()
}

fun main(args: Array<String>) {
    run(Application::class.java, *args)
}