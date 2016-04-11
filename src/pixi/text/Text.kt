package pixi.text

import pixi.TextStyle
import pixi.core.sprites.Sprite

@native("PIXI.Text")
public class Text(text: String, style: TextStyle = noImpl) : Sprite(noImpl) {
    // TODO
    public fun setText(text: String): Unit = noImpl
}