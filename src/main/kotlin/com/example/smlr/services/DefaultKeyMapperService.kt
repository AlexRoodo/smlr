package com.example.smlr.services

import org.springframework.stereotype.Component
import java.util.concurrent.ConcurrentHashMap

@Component
class DefaultKeyMapperService: KeyMapperService {

    private val map: MutableMap<String, String> = ConcurrentHashMap()

    override fun add(key: String, link: String): KeyMapperService.Add {
        return if (map.contains(key)) {
            KeyMapperService.Add.AlreadyExist(key)
        } else {
            map[key] = link
            KeyMapperService.Add.Success(key, link)
        }
    }

    override fun getLink(key: String): KeyMapperService.Get {
        return if (map.contains(key)) {
            KeyMapperService.Get.Link(map[key]!!)
        } else {
            KeyMapperService.Get.NotFound(key)
        }
    }
}