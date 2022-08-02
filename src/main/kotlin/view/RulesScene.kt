package view

import tools.aqua.bgw.components.uicomponents.Button
import tools.aqua.bgw.components.uicomponents.Label
import tools.aqua.bgw.core.MenuScene
import tools.aqua.bgw.util.Font
import tools.aqua.bgw.visual.ColorVisual

class RulesScene : MenuScene(400,500){
    private val headlineLabel = Label(
        width = 200, height = 50, posX = 100, posY = 50,
        text = "Rules",
        font = Font(size = 40)
    )

    private val rulesText = Label(
        width = 300, height = 300, posX = 50, posY = 100,
        text = "lorem ipsum",
        font = Font(size = 22)
    )

    val backButton = Button(
        width = 140, height = 35,
        posX = 200, posY = 450,
        text = "Back"
    ).apply {
        visual = ColorVisual(66,164,255)
    }

}