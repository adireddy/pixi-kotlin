import pixi.display.Sprite
import pixi.display.Stage
import pixi.requestAnimFrame
import pixi.textures.Texture
import kotlin.browser.*

import pixi.utils.autoDetectRenderer


fun main(args: Array<String>) {

    // create an new instance of a pixi stage
    val stage = Stage(0x66FF99)

    // create a renderer instance
    val renderer = autoDetectRenderer(400, 300)

    // add the renderer view element to the DOM
    document.body!!.appendChild(renderer.view)

    // create a texture from an image path
    val texture = Texture.fromImage("assets/basics/bunny.png")

    // create a new Sprite using the texture
    val bunny = Sprite(texture)

    // center the sprites anchor point
    bunny.anchor.x = 0.5
    bunny.anchor.y = 0.5

    // move the sprite to the center of the screen
    bunny.position.x = 200.0
    bunny.position.y = 150.0

    stage.addChild(bunny)

    fun animate() {
        requestAnimFrame(::animate)

        // just for fun, let's rotate mr rabbit a little
        bunny.rotation += 0.1

        // render the stage
        renderer.render(stage)
    }

    requestAnimFrame(::animate)
}