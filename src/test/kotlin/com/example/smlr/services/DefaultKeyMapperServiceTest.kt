package com.example.smlr.services

import org.junit.Assert.*

import org.junit.Test

class DefaultKeyMapperServiceTest {

    val service: KeyMapperService = DefaultKeyMapperService();

    private val KEY: String = "aAbBcCdD"
    private val LINK: String = "http://www.eveonline.com"
    private val LINK_NEW: String = "http://www.wow.com"

    @Test
    fun clientCanAddNewKeyWithLink() {
        assertEquals(KeyMapperService.Add.Success(KEY, LINK), service.add(KEY, LINK))
        assertEquals(KeyMapperService.Get.Link(LINK), service.getLink(KEY))
    }

    @Test
    fun clientCannotAddExistingKey() {
        service.add(KEY, LINK)
        assertEquals(KeyMapperService.Add.AlreadyExist(KEY), service.add(KEY, LINK_NEW))
        assertEquals(KeyMapperService.Get.Link(LINK), service.getLink(KEY))
    }

    @Test
    fun clientCannotTakeLinkIfKeyIsNotFound() {
        assertEquals(KeyMapperService.Get.NotFound(KEY), service.getLink(KEY))
    }

}