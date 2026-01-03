package com.davidmerchan.navigation3demo.hiltNavigation

import javax.inject.Inject
import javax.inject.Singleton

interface DemoRepository {
    fun items(): List<String>
    fun detailText(id: String): String
}

@Singleton
class InMemoryDemoRepository @Inject constructor() : DemoRepository {
    override fun items(): List<String> = List(10) { index -> "Item $index" }

    override fun detailText(id: String): String = "Detail for item $id"
}
