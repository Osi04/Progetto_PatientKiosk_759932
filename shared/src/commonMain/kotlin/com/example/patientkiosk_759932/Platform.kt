package com.example.patientkiosk_759932

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform