package com.github.alondero.formulapedia

import com.github.alondero.formulapedia.drivers.DriverResource
import com.github.salomonbrys.kodein.instance
import io.dropwizard.Application
import io.dropwizard.setup.Environment
import org.eclipse.jetty.servlets.CrossOriginFilter
import java.util.*
import javax.servlet.DispatcherType



class FormulapediaApplication: Application<FormulapediaConfiguration>() {
    override fun run(configuration: FormulapediaConfiguration?, environment: Environment?) {
        environment?.servlets()?.addFilter("CORS", CrossOriginFilter::class.java)?.apply {
            setInitParameter("allowedOrigins", "*")
            setInitParameter("allowedHeaders", "X-Requested-With,Content-Type,Accept,Origin")
            setInitParameter("allowedMethods", "OPTIONS,GET,PUT,POST,DELETE,HEAD")

            // Add URL mapping
            addMappingForUrlPatterns(EnumSet.allOf(DispatcherType::class.java), true, "/*")
        }

        configuration?.let {
            val kodein = ApplicationModule()

            environment?.let {
                it.jersey().register(kodein.objectGraph.instance<DriverResource>())
            }
        }
    }
}

fun main(args: Array<String>) {
    FormulapediaApplication().run(*args)
}