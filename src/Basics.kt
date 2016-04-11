import pixi.core.PIXI
import pixi.core.display.Container
import pixi.core.renderers.RenderingOptions
import pixi.core.sprites.Sprite
import pixi.core.textures.Texture
import kotlin.browser.document
import kotlin.browser.window


fun main(args: Array<String>) {
    var options: RenderingOptions = RenderingOptions();
    options.backgroundColor = 0x003366;
    options.resolution = 1;

    var stage = Container();

    // create a renderer instance
    val renderer = PIXI.autoDetectRenderer(window.innerWidth, window.innerHeight, options)

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

    fun animate(v: Double) {
        window.requestAnimationFrame(::animate)

        // just for fun, let's rotate mr rabbit a little
        bunny.rotation += 0.1

        // render the stage
        renderer.render(stage)
    }

    window.requestAnimationFrame(::animate)
}