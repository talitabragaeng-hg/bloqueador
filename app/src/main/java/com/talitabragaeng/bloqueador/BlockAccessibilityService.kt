package com.talitabragaeng.bloqueador

import android.accessibilityservice.AccessibilityService
import android.content.Intent
import android.view.accessibility.AccessibilityEvent

class BlockAccessibilityService : AccessibilityService() {

    private val appsBloqueados = setOf(
        "com.instagram.android",
        "com.twitter.android",
        "com.facebook.katana"
    )

    private var ultimoAppMostrado: String? = null

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        val pacote = event?.packageName?.toString() ?: return

        if (pacote in appsBloqueados && pacote != ultimoAppMostrado) {
            ultimoAppMostrado = pacote
            val intent = Intent(this, OverlayActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }

        if (pacote !in appsBloqueados) {
            ultimoAppMostrado = null
        }
    }

    override fun onInterrupt() {}
}
