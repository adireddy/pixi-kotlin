package pixi.core.interaction

import org.w3c.dom.events.Event
import pixi.core.display.DisplayObject
import pixi.core.math.Point
import pixi.core.sprites.Sprite

/**
 * Holds all information related to an interaction event
 */
@native("PIXI.interaction.InteractionData")
public class InteractionData {
    /**
     * This point stores the global coords of where the touch/mouse event happened
     *
     * @member {Point}
     */
    public var global: Point = noImpl

    /**
     * The target Sprite that was interacted with
     *
     * @member {Sprite}
     */
    public var target: Sprite = noImpl

    /**
     * When passed to an event handler, this will be the original DOM Event that was captured
     *
     * @member {Event}
     */
    public var originalEvent: Event = noImpl

    /**
     * This will return the local coordinates of the specified displayObject for this InteractionData
     *
     * @param displayObject {DisplayObject} The DisplayObject that you would like the local coords off
     * @param [point] {Point} A Point object in which to store the value, optional (otherwise will create a new point)
     * @param [globalPos] {Point} A Point object containing your custom global coords, optional (otherwise will use the current global coords)
     * @return {Point} A point containing the coordinates of the InteractionData position relative to the DisplayObject
     */
    public fun getLocalPosition(displayObject: DisplayObject, Point: Point? = noImpl, globalPos: Point? = noImpl): Point = noImpl
}