package pixi.core.display

import pixi.core.interaction.InteractionManager
import pixi.core.math.Matrix
import pixi.core.math.Point
import pixi.geom.Rectangle

/**
 * The base class for all objects that are rendered on the screen.
 * This is an abstract class and should not be used on its own rather it should be extended.
 */
@native("PIXI.DisplayObject")
public open class DisplayObject : InteractionManager() {

    /**
     * Retrieves the bounds of the displayObject as a rectangle object
     *
     * @param matrix {Matrix}
     * @return {Rectangle} the rectangular bounding area
     */
    public open fun getBounds(matrix: Matrix? = noImpl): Rectangle = noImpl

    /**
     * Retrieves the local bounds of the displayObject as a rectangle object
     *
     * @return {Rectangle} the rectangular bounding area
     */
    public open fun getLocalBounds(): Rectangle = noImpl

    /**
     * Calculates the global position of the display object
     *
     * @param position {Point} The world origin to calculate from
     * @return {Point} A point object representing the position of this object
     */
    public open fun toGlobal(position: Point): Point = noImpl

    /**
     * Calculates the local position of the display object relative to another point
     *
     * @param position {Point} The world origin to calculate from
     * @param [from] {DisplayObject} The DisplayObject to calculate the global position from
     * @param [point] {Point} A Point object in which to store the value, optional (otherwise will create a new Point)
     * @return {Point} A point object representing the position of this object
     */
    public fun toLocal(position: Point, frm: DisplayObject? = noImpl, point: Point? = noImpl): Point = noImpl

    /*
     * Updates the object transform for rendering
     *
     * TODO - Optimization pass!
     */
    public open fun updateTransform()

    public open fun displayObjectUpdateTransform()

    /**
     * Set the parent Container of this DisplayObject
     *
     * @param container {Container} The Container to add this DisplayObject to
     * @return {Container} The Container that this DisplayObject was added to
     */
    public open fun setParent(container: Container): Container = noImpl

    /**
     * Convenience public fun to set the postion, scale, skew and pivot at once.
     *
     * @param [x=0] {Double} The X position
     * @param [y=0] {Double} The Y position
     * @param [scaleX=1] {Double} The X scale value
     * @param [scaleY=1] {Double} The Y scale value
     * @param [skewX=0] {Double} The X skew value
     * @param [skewY=0] {Double} The Y skew value
     * @param [pivotX=0] {Double} The X pivot value
     * @param [pivotY=0] {Double} The Y pivot value
     * @return {DisplayObject}
     */
    public fun setTransform(x: Double? = noImpl, y: Double? = noImpl, scaleX: Double? = noImpl, scaleY: Double? = noImpl, rotation: Double? = noImpl, skewX: Double? = noImpl, skewY: Double? = noImpl, pivotX: Double? = noImpl, pivotY: Double? = noImpl): DisplayObject = noImpl

    /**
     * Base destroy method for generic display objects
     * @param [destroyChildren] {Boolean} if set to true, all the children will have their destroy method called as well (Container)
     * @param [destroyTexture] {Boolean} Should it destroy the current texture of the sprite as well (Sprite)
     * @param [destroyBaseTexture] {Boolean} whether to destroy the base texture as well (Text, Sprite)
     */
    public open fun destroy() = noImpl

    /**
     * The instance name of the object.
     *
     * @member {String}
     */
    public var name: String = noImpl

    /**
     * Set this to true if you want this display object to be cached as a bitmap.
     * This basically takes a snap shot of the display object as it is at that moment. It can provide a performance benefit for complex static displayObjects.
     * To remove simply set this property to 'null'
     *
     * @member {Boolean}
     * @memberof DisplayObject#
     */
    public var cacheAsBitmap: Boolean = noImpl

    /**
     * The opacity of the object.
     *
     * @member {Double}
     */
    public var alpha: Double = noImpl

    /**
     * The visibility of the object. If false the object will not be drawn, and
     * the updateTransform public fun will not be called.
     *
     * @member {Boolean}
     */
    public var visible: Boolean = noImpl

    /**
     * Can this object be rendered, if false the object will not be drawn but the updateTransform
     * methods will still be called.
     *
     * @member {Boolean}
     */
    public open var renderable: Boolean = noImpl

    /**
     * The display object container that contains this display object.
     *
     * @member {Container}
     * @readOnly
     */
    public var parent: Container = noImpl

    /**
     * The multiplied alpha of the displayObject
     *
     * @member {Double}
     * @readOnly
     */
    public var worldAlpha: Double = noImpl

    /**
     * The area the filter is applied to. This is used as more of an optimisation
     * rather than figuring out the dimensions of the displayObject each frame you can set this rectangle
     *
     * Also works as an interaction mask
     *
     * @member {Rectangle}
     */
    public var filterArea: Rectangle = noImpl

    /**
     * Interaction shape. Children will be hit first, then this shape will be checked.
     *
     * @memberof DisplayObject#
     */
    public var hitArea: dynamic = noImpl

    /**
     * The position of the displayObject on the x axis relative to the local coordinates of the parent.
     *
     * @member {Double}
     * @memberof DisplayObject#
     */
    public var x: Double = noImpl

    /**
     * The position of the displayObject on the y axis relative to the local coordinates of the parent.
     *
     * @member {Double}
     * @memberof DisplayObject#
     */
    public var y: Double = noImpl

    /**
     * Current transform of the object based on world (parent) factors
     *
     * @member {Matrix}
     * @readOnly
     */
    public var worldTransform: Matrix = noImpl

    /**
     * Current transform of the object based on local factors:position, scale, other stuff
     *
     * @member {PIXI.Matrix}
     * @readOnly
     */
    public var localTransform: Matrix = noImpl

    /**
     * The coordinate of the object relative to the local coordinates of the parent.
     *
     * @member {Point}
     */
    public var position: Point = noImpl

    /**
     * The scale factor of the object.
     *
     * @member {Point}
     */
    public var scale: Point = noImpl

    /**
     * The pivot point of the displayObject that it rotates around
     *
     * @member {Point}
     */
    public var pivot: Point = noImpl

    /**
     * The skew factor for the object in radians.
     *
     * @member {Point}
     */
    public var skew: Point = noImpl

    /**
     * The rotation of the object in radians.
     *
     * @member {Double}
     */
    public var rotation: Double = noImpl

    /**
     * Indicates if the displayObject is globally visible.
     *
     * @member {Boolean}
     * @memberof DisplayObject#
     * @readonly
     */
    public var worldVisible: Boolean = noImpl

    /**
     * Sets a mask for the displayObject. A mask is an object that limits the visibility of an object to the shape of the mask applied to it.
     * In PIXI a regular mask must be a PIXI.Graphics or a PIXI.Sprite object. This allows for much faster masking in canvas as it utilises shape clipping.
     * To remove a mask, set this property to null.
     *
     * @todo For the moment, PIXI.CanvasRenderer doesn't support PIXI.Sprite as mask.
     *
     * @member {Graphics|Sprite}
     * @memberof DisplayObject#
     */
    public var mask: dynamic = noImpl

    /**
     * Sets the filters for the displayObject.
     * * IMPORTANT:This is a webGL only feature and will be ignored by the canvas renderer.
     * To remove filters simply set this property to 'null'
     *
     * @member {Array<AbstractFilter>}
     * @memberof DisplayObject#
     */
    public var filters: Array<dynamic> = noImpl

    /**
     * Indicates if the displayObject is interactive or not.
     *
     * @member {Boolean}
     * @default false
     * @memberof DisplayObject#
     */
    public var interactive: Boolean = noImpl

    /**
     * Indicates if the displayObject uses button mode or normal mode.
     *
     * @member {Boolean}
     * @default false
     * @memberof DisplayObject#
     */
    public var buttonMode: Boolean = noImpl

    /**
     * Indicates if the children of displayObject are interactive or not.
     *
     * @member {Boolean}
     * @default true
     * @memberof DisplayObject#
     */
    public var interactiveChildren: Boolean = noImpl

    /**
     * Default cursor.
     *
     * @member {String}
     * @default pointer
     * @memberof DisplayObject#
     */
    public var defaultCursor: String = noImpl
}