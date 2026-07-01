package app.morphe.patches.reddit

import app.morphe.patcher.annotation.Patch
import app.morphe.patcher.patch.BytecodePatch
import app.morphe.patcher.patch.BytecodePatchContext

@Patch(
    name = "Force System Font",
    description = "Forces Reddit to use your phone's default system font.",
    compatiblePackages = ["com.reddit.frontpage"]
)
class SystemFontPatch : BytecodePatch() {
    override fun execute(context: BytecodePatchContext) {
        val targetClass = context.classer.findClass("com.reddit.frontpage.MainActivity")
            ?: throw IllegalStateException("Can't find Reddit's main screen!")
        
        targetClass.methods.first { it.name == "onCreate" }.addInstructions(0, """
            invoke-static {p0}, Lapp/morphe/patches/reddit/FontIntegrationEngine;->initializeFontOverrides(Landroid/content/Context;)V
        """.trimIndent())
    }
}
