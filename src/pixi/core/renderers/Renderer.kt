package pixi.core.renderers

import org.w3c.dom.HTMLCanvasElement
import pixi.core.display.DisplayObject

@native("PIXI.SystemRenderer")

/**
 * @class
 * @memberof PIXI
 * @param system {String} The name of the system this renderer is for.
 * @param [width=800] {Float} the width of the canvas view
 * @param [height=600] {Float} the height of the canvas view
 * @param [options] {RenderingOptions} The optional renderer parameters
 * @param [options.view] {HTMLCanvasElement} the canvas to use as a view, optional
 * @param [options.transparent=false] {Boolean} If the render view is transparent, default false
 * @param [options.autoResize=false] {Boolean} If the render view is automatically resized, default false
 * @param [options.antialias=false] {Boolean} sets antialias (only applicable in chrome at the moment)
 * @param [options.resolution=1] {Float} the resolution of the renderer retina would be 2
 * @param [options.clearBeforeRender=true] {Boolean} This sets if the CanvasRenderer will clear the canvas or
 *      not before the new render pass.
 * @param [options.backgroundColor=0x000000] {Int} The background color of the rendered area (shown if not transparent).
 * @param [options.roundPixels=false] {Boolean} If true Pixi will Math.floor() x/y values when rendering, stopping pixel interpolation.
 */
public class Renderer(public val type: String, public val width: Int? = noImpl, public val height: Int? = noImpl, options: RenderingOptions? = noImpl) {

    /**
     * The canvas element that everything is drawn to
     *
     * @member {CanvasElement}
     */
    public var view: HTMLCanvasElement = noImpl

    /**
     * The resolution of the renderer
     *
     * @member {Float}
     * @default 1
     */
    public var resolution: Float = noImpl

    /**
     * Whether the render view is transparent
     *
     * @member {Boolean}
     */
    public var transparent: Boolean = noImpl

    /**
     * Whether the render view should be resized automatically
     *
     * @member {Boolean}
     */
    public var autoResize: Boolean = noImpl

    /**
     * Tracks the blend modes useful for this renderer.
     *
     * @member {object<string, mixed>}
     */
    public var blendModes: dynamic = noImpl

    /**
     * The value of the preserveDrawingBuffer flag affects whether or not the contents of the stencil buffer is retained after rendering.
     *
     * @member {Boolean}
     */
    public var preserveDrawingBuffer: Boolean = noImpl

    /**
     * This sets if the CanvasRenderer will clear the canvas or not before the new render pass.
     * If the scene is NOT transparent Pixi will use a canvas sized fillRect operation every frame to set the canvas background color.
     * If the scene is transparent Pixi will use clearRect to clear the canvas every frame.
     * Disable this by setting this to false. For example if your game has a canvas filling background image you often don't need this set.
     *
     * @member {Boolean}
     * @default
     */
    public var clearBeforeRender: Boolean = noImpl

    /**
     * The background color to fill if not transparent
     *
     * @member {Int}
     * @default 0x000000
     */
    public var backgroundColor: Int = noImpl

    /**
     * If true Pixi will Math.floor() x/y values when rendering, stopping pixel interpolation.
     * Handy for crisp pixel art and speed on legacy devices.
     *
     * @member {Boolean}
     */
    public var roundPixels: Boolean = noImpl

    /**
     * Plugins object
     */
    public var plugins: dynamic = noImpl

    /**
     * Resizes the canvas view to the specified width and height
     *
     * @param width {Float} the new width of the canvas view
     * @param height {Float} the new height of the canvas view
     */
    public fun resize(width: Float, height: Float) = noImpl

    /**
     * Removes everything from the renderer and optionally removes the Canvas DOM element.
     *
     * @param [removeView=false] {Boolean} Removes the Canvas element from the DOM.
     */
    public fun destroy(removeView: Boolean? = false) = noImpl

    /**
     * Renders the object to canvas/webGL view
     *
     * @param object {DisplayObject} the object to be rendered
     */
    public fun render(obj: DisplayObject) = noImpl
}
