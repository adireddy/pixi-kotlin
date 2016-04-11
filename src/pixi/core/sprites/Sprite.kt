package pixi.core.sprites

import pixi.core.display.Container
import pixi.core.math.Point
import pixi.core.textures.Texture

/**
 * The Sprite object is the base for all textured objects that are rendered to the screen
 *
 * A sprite can be created directly from an image like this:
 * var sprite = PIXI.Sprite.fromImage("assets/image.png")
 * yourStage.addChild(sprite)
 */
@native("PIXI.Sprite")
open public class Sprite(public var texture: Texture) : Container() {

    companion object {
        /**
         * Helper function that creates a sprite that will contain a texture from the TextureCache based on the frameId
         * The frame ids are created when a Texture packer file has been loaded
         *
         * @static
         * @param frameId {String} The frame Id of the texture in the cache
         * @return {Sprite} A new Sprite using a texture from the texture cache matching the frameId
         */
        public fun fromFrame(frameId: String): Sprite = noImpl

        /**
         * Helper function that creates a sprite that will contain a texture based on an image url
         * If the image is not in the texture cache it will be loaded
         *
         * @static
         * @param imageId {String} The image url of the texture
         * @return {Sprite} A new Sprite using a texture from the texture cache matching the image id
         */
        public fun fromImage(imageId: String, crossorigin: Boolean = noImpl, scaleMode: Int = noImpl): Sprite = noImpl
    }

    /**
     * The anchor sets the origin point of the texture.
     * The default is 0,0 this means the texture's origin is the top left
     * Setting than anchor to 0.5,0.5 means the textures origin is centered
     * Setting the anchor to 1,1 would mean the textures origin points will be the bottom right corner
     *
     * @member {Point}
     */
    public var anchor: Point = noImpl

    /**
     * The tint applied to the sprite. This is a hex value. A value of 0xFFFFFF will remove any tint effect.
     *
     * @member {Int}
     * @default 0xFFFFFF
     */
    public open var tint: Int = noImpl

    /**
     * The blend mode to be applied to the sprite. Set to CONST.blendModes.NORMAL to remove any blend mode.
     *
     * @member {Int}
     * @default CONST.blendModes.NORMAL;
     */
    public open var blendMode: Int = noImpl

    /**
     * The shader that will be used to render the sprite. Set to null to remove a current shader.
     *
     * @member {AbstractFilter}
     */
    public var shader: dynamic = noImpl

    /**
     * Renders the object using the Canvas renderer
     *
     * @param renderer {CanvasRenderer} The renderer
     */
    public fun renderCanvas(renderer: dynamic) = noImpl

    /**
     * Helper function that creates a new sprite based on the source you provide.
     * The soucre can be - frame id, image url, video url, canvae element, video element, base texture
     *
     * @static
     * @param source {}
     * @return {Sprite} A Texture
     */
    public fun from(source: dynamic): Sprite = noImpl
}