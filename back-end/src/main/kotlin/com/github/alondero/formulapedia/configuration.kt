package com.github.alondero.formulapedia

import com.github.alondero.formulapedia.drivers.DriverResource
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.singleton
import io.dropwizard.Configuration

class FormulapediaConfiguration: Configuration()

class ApplicationModule {
    val objectGraph = Kodein {
        bind() from singleton{DriverResource()}
    }
}
