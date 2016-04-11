package pixi.core.math

/**
 * The Point object represents a location in a two-dimensional coordinate system, where x represents
 * the horizontal axis and y represents the vertical axis.
 *
 * @class
 * @namespace PIXI
 * @param [x=0] {number} position of the point on the x axis
 * @param [y=0] {number} position of the point on the y axis
 */
@native("PIXI.Point")
public class Point(public var x: Double = 0.0, public var y: Double = 0.0) {

    /**
     * Creates a clone of this point
     *
     * @return {Point} a copy of the point
     */
    public fun clone(): Point = noImpl

    /**
     * Copies x and y from the given point
     *
     * @method copy
     * @param {Point} the point to copy
     */
    public fun copy(p: Point) = noImpl

    /**
     * Returns true if the given point is equal to this point
     *
     * @method copy
     * @param {Point} the point to compare
     * @returns {Boolean} the result of the comparison
     */
    public fun equals(p: Point): Boolean = noImpl

    /**
     * Sets the Point to a new x and y position.
     * If y is omitted, both x and y will be set to x.
     *
     * @method set
     * @param [x=0] position of the Point on the x axis
     * @param [y=x] position of the Point on the y axis
     */
    public fun set(x: Double = 0.0, y: Double = x) = noImpl
}