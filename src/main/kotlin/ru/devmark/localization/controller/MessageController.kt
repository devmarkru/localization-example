package ru.devmark.localization.controller

import org.springframework.context.MessageSource
import org.springframework.http.HttpHeaders
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/messages")
class MessageController(
    val messageSource: MessageSource,
) {

    @GetMapping
    fun getMessage(
        @RequestHeader(value = HttpHeaders.ACCEPT_LANGUAGE, required = false)
        locale: Locale? = null,
    ) = messageSource.getMessage(
        "text.welcome",
        null,
        locale ?: Locale.US
    )
}
