package pixi.core.textures

import org.w3c.dom.HTMLCanvasElement
import pixi.core.interaction.EventEmitter
import pixi.geom.Rectangle

@native("PIXI.Texture")
/**
 * A texture stores the information that represents an image or part of an image. It cannot be added
 * to the display list directly. Instead use it as the texture for a Sprite. If no frame is provided then the whole image is used.
 *
 * You can directly create a texture from an image and then reuse it multiple times like this :
 *
 * ```js
 * 	var texture = PIXI.Texture.fromImage('assets/image.png');
 * 	var sprite1 = new PIXI.Sprite(texture);
 * 	var sprite2 = new PIXI.Sprite(texture);
 * ```
 *
 * @class
 * @mixes eventTarget
 * @memberof PIXI
 * @param baseTexture {BaseTexture} The base texture source to create the texture from
 * @param [frame] {Rectangle} The rectangle frame of the texture to show
 * @param [crop] {Rectangle} The area of original texture
 * @param [trim] {Rectangle} Trimmed texture rectangle
 * @param [rotate] {boolean} indicates whether the texture should be rotated by 90 degrees ( used by texture packer )
 */
open public class Texture(open public var baseTexture: BaseTexture, open public var frame: Rectangle, open public var crop: Rectangle = noImpl
                          , public var trim: Rectangle = noImpl, public var rotate: Rectangle = noImpl) : EventEmitter() {

    /** Does this Texture have any frame data assigned to it? */
    public var noFrame: Boolean = noImpl

    /** This will let the renderer know if the texture is valid. If it's not then it cannot be rendered. */
    public var valid: Boolean = noImpl

    /** This will let a renderer know that a texture has been updated (used mainly for webGL uv updates) */
    public var requiresUpdate: Boolean = noImpl

    /** The width of the Texture in pixels. */
    open public var width: Int = noImpl

    /** The height of the Texture in pixels. */
    open public var height: Int = noImpl

    /**
     * Destroys this texture
     *
     * @param destroyBase Whether to destroy the base texture as well
     */
    public fun destroy(destroyBase: Boolean): Unit = noImpl

    /**
     * Specifies the region of the baseTexture that this texture will use.
     *
     * @param frame The frame of the texture to set it to
     */
    public fun setFrame(frame: Rectangle): Unit = noImpl

    companion object StaticMethods {
        /**
         * Helper function that creates a Texture object from the given image url.
         * If the image is not in the texture cache it will be  created and loaded.
         *
         * @param imageUrl The image url of the texture
         * @param crossorigin  Whether requests should be treated as crossorigin
         * @param scaleMode See {{#crossLink "PIXI/scaleModes:property"}}PIXI.scaleModes{{/crossLink}} for possible values
         */
        public fun fromImage(imageUrl: String, crossorigin: Boolean = noImpl, scaleMode: Int = noImpl): Texture = noImpl

        /**
         * Helper function that returns a Texture objected based on the given frame id.
         * If the frame id is not in the texture cache an error will be thrown.
         *
         * @param frameId The frame id of the texture
         */
        public fun fromFrame(frameId: String): Texture = noImpl

        /**
         * Helper function that creates a new a Texture based on the given canvas element.
         *
         * @param canvas The canvas element source of the texture
         * @param scaleMode See {{#crossLink "PIXI/scaleModes:property"}}PIXI.scaleModes{{/crossLink}} for possible values
         */
        public fun fromCanvas(canvas: HTMLCanvasElement, scaleMode: Int): Texture = noImpl

        /**
         * Adds a texture to the global PIXI.TextureCache. This cache is shared across the whole PIXI object.
         *
         * @param texture The Texture to add to the cache.
         * @param id The id that the texture will be stored against.
         */
        public fun addTextureToCache(texture: Texture, id: String): Unit = noImpl

        /**
         * Remove a texture from the global PIXI.TextureCache.
         *
         * @param id The id of the texture to be removed
         * @return The texture that was removed
         */
        public fun removeTextureFromCache(id: String): Texture = noImpl

        public val emptyTexture: Texture = noImpl
    }
}