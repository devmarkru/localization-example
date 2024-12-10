package ru.devmark.localization.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.support.ResourceBundleMessageSource
import org.springframework.web.servlet.LocaleResolver
import org.springframework.web.servlet.i18n.SessionLocaleResolver
import java.util.Locale

@Configuration
class MessageConfig {

    @Bean
    fun localeResolver(): LocaleResolver =
        with(SessionLocaleResolver()) {
            setDefaultLocale(Locale.US)
            this
        }

    @Bean
    fun messageSource(): ResourceBundleMessageSource =
        with(ResourceBundleMessageSource()) {
            setUseCodeAsDefaultMessage(true)
            setBasenames("messages")
            setDefaultEncoding("UTF-8")
            this
        }
}
