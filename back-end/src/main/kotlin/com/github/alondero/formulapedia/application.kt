package com.github.alondero.formulapedia

import com.github.alondero.formulapedia.drivers.DriverResource
import com.github.salomonbrys.kodein.instance
import io.dropwizard.Application
import io.dropwizard.setup.Environment

class FormulapediaApplication: Application<FormulapediaConfiguration>() {
    override fun run(configuration: FormulapediaConfiguration?, environment: Environment?) {
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