package pixi.textures

import org.w3c.dom.HTMLCanvasElement
import org.w3c.dom.ImageData
import pixi.display.Stage
import pixi.renderers.Renderer
import pixi.PIXI
import pixi.geom.Rectangle

@native("PIXI.RenderTexture")
/**
 * A RenderTexture is a special texture that allows any Pixi display object to be rendered to it.
 *
 * __Hint__: All DisplayObjects (i.e. Sprites) that render to a RenderTexture should be preloaded otherwise black rectangles will be drawn instead.
 *
 * A RenderTexture takes a snapshot of any Display Object given to its render method. The position and rotation of the given Display Objects is ignored. For example:
 *
 *    var renderTexture = PIXI.RenderTexture(800, 600);
 *    var sprite = PIXI.Sprite.fromImage("spinObj_01.png");
 *    sprite.position.x = 800/2;
 *    sprite.position.y = 600/2;
 *    sprite.anchor.x = 0.5;
 *    sprite.anchor.y = 0.5;
 *    renderTexture.render(sprite);
 *
 * The Sprite in this case will be rendered to a position of 0,0. To render this sprite at its actual position a DisplayObjectContainer should be used:
 *
 *    var doc = PIXI.DisplayObjectContainer();
 *    doc.addChild(sprite);
 *    renderTexture.render(doc);  // Renders to center of renderTexture
 *
 *
 */
public class RenderTexture(
    /** The width of the render texture */
    public override var width: Int = 100,

    /** The height of the render texture */
    public override var height: Int = 100,

    /** The renderer used for this RenderTexture. A RenderTexture can only belong to one renderer at the moment if its webGL. */
    public var renderer: Renderer = noImpl,

    /** See {{#crossLink "PIXI/scaleModes:property"}}PIXI.scaleModes{{/crossLink}} for possible values */
    scaleMode: Int = PIXI.scaleModes.DEFAULT,

    /** The resolution of the texture being generated */
    public var resolution: Float = 1f
) : Texture(noImpl, noImpl) {
    /** The framing rectangle of the render texture */
    public override var frame: Rectangle = noImpl

    /**
     * This is the area of the BaseTexture image to actually copy to the Canvas / WebGL when rendering,
     * irrespective of the actual frame size or placement (which can be influenced by trimmed texture atlases)
     */
    public override var crop: Rectangle = noImpl

    /** The base texture object that this texture uses */
    public override var baseTexture: BaseTexture = noImpl

    /**
     * Resizes the RenderTexture.
     *
     * @param width The width to resize to.
     * @param height The height to resize to.
     * @param updateBase Should the baseTexture.width and height values be resized as well?
     */
    public fun resize(width: Int, height: Int, updateBase: Boolean): Unit = noImpl

    /**
     * Clears the RenderTexture.
     */
    public fun clear(): Unit = noImpl

    /**
     * Will return a HTML Image of the texture
     */
    public fun getImage(): ImageData = noImpl

    /**
     * Will return a a base64 encoded string of this texture. It works by calling RenderTexture.getCanvas and then running toDataURL on that.
     */
    public fun getBase64(): String = noImpl

    /**
     * Creates a Canvas element, renders this RenderTexture to it and then returns it.
     *
     * @return A Canvas element with the texture rendered on.
     */
    public fun getCanvas(): HTMLCanvasElement = noImpl

    public fun render(stage: Stage, clear: Boolean): Unit = noImpl
}