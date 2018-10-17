package com.example.smlr.services

import org.junit.Assert.*
import org.junit.Test
import java.util.*

class DefaultKeyConverterServiceTest {

    var service: KeyConverterService = DefaultKeyConverterService()

    @Test
    fun givenIdMustBeConvertibleBothWays() {
        val rand = Random()
        for(i in 0..1000L) {
            val initialId = Math.abs(rand.nextLong())
            val key = service.idToKey(initialId)
            val id = service.keyToId(key)
            assertEquals(initialId, id)
        }
    }
}