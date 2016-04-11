package pixi.core.textures

import org.w3c.dom.HTMLCanvasElement
import pixi.core.PIXI

/**
 * A texture stores the information that represents an image. All textures have a base texture.
 *
 * @class
 * @memberof PIXI
 * @param source {Image|Canvas} the source object of the texture.
 * @param [scaleMode=scaleModes.DEFAULT] {Int} See {@link SCALE_MODES} for possible values
 * @param resolution {Float} the resolution of the texture for devices with different pixel ratios
 */
@native("PIXI.BaseTexture")
public class BaseTexture(public var source: String, public var scaleMode: Int = PIXI.SCALE_MODES.DEFAULT, public var resolution: Double = PIXI.RESOLUTION) {
    companion object {
        /**
         * Helper public fun that creates a base texture from the given canvas element.
         *
         * @param canvas The canvas element source of the texture
         * @param scaleMode Should be one of the PIXI.scaleMode consts
         */
        public fun fromCanvas(canvas: HTMLCanvasElement, scaleMode: Int? = noImpl): BaseTexture = noImpl

        /**
         * Helper public fun that creates a base texture from the given image url.
         * If the image is not in the base texture cache it will be created and loaded.
         *
         * @param The image url of the texture
         * @param crossorigin
         * @param scaleMode Should be one of the PIXI.scaleMode consts
         */
        public fun fromImage(imageUrl: String, crossorigin: Boolean? = noImpl, scaleMode: Int? = noImpl): BaseTexture = noImpl
    }

    /**
     * The width of the base texture set when the image has loaded
     *
     * @member {Float}
     * @readOnly
     */
    public val width: Float

    /**
     * The height of the base texture set when the image has loaded
     *
     * @member {Float}
     * @readOnly
     */
    public val height: Float

    /**
     * Set to true once the base texture has successfully loaded.
     *
     * This is never true if the underlying source fails to load or has no texture data.
     *
     * @member {Boolean}
     * @readOnly
     */
    public val hasLoaded: Boolean

    /**
     * Set to true if the source is currently loading.
     *
     * If an Image source is loading the 'loaded' or 'error' event will be
     * dispatched when the operation ends. An underyling source that is
     * immediately-available bypasses loading entirely.
     *
     * @member {Boolean}
     * @readonly
     */
    public val isLoading: Boolean

    /**
     * Controls if RGB channels should be pre-multiplied by Alpha  (WebGL only)
     *
     * @member {Boolean}
     * @default true
     */
    public var premultipliedAlpha: Boolean = noImpl

    /**
     * @member {String}
     */
    public var imageUrl: String = noImpl

    /**
     *
     * Set this to true if a mipmap of this texture needs to be generated. This value needs to be set before the texture is used
     * Also the texture must be a power of two size to work
     *
     * @member {Boolean}
     */
    public var mipmap: Boolean = noImpl

    /**
     * Updates the texture on all the webgl renderers.
     *
     * @fires update
     */
    public fun update() = noImpl

    /**
     * Destroys this base texture
     *
     */
    public fun destroy() = noImpl

    /**
     * Frees the texture from WebGL memory without destroying this texture object.
     * This means you can still use the texture later which will upload it to GPU
     * memory again.
     *
     */
    public fun dispose() = noImpl

    /**
     * Load a source.
     *
     * If the source is not-immediately-available, such as an image that needs to be
     * downloaded, then the 'loaded' or 'error' event will be dispatched in the future
     * and `hasLoaded` will remain false after this call.
     *
     * The logic state after calling `loadSource` directly or indirectly (eg. `fromImage`, `new BaseTexture`) is:
     *
     *     if (texture.hasLoaded) {
     *        // texture ready for use
     *     } else if (texture.isLoading) {
     *        // listen to 'loaded' and/or 'error' events on texture
     *     } else {
     *        // not loading, not going to load UNLESS the source is reloaded
     *        // (it may still make sense to listen to the events)
     *     }
     *
     * @protected
     * @param source {Image|Canvas} the source object of the texture.
     */
    public fun loadSource(source: String) = noImpl

    /**
     * Changes the source image of the texture.
     * The original source must be an Image element.
     *
     * @param newSrc {String} the path of the image
     */
    public fun updateSourceImage(newSrc: String) = noImpl
}