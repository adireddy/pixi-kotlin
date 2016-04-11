package pixi.core.math

@native("PIXI.Matrix")

/**
 * The Matrix class is now an object, which makes it a lot faster,
 * here is a representation of it :
 * | a | b | tx|
 * | c | d | ty|
 * | 0 | 0 | 1 |
 *
 * @class
 * @namespace PIXI
 */
public class Matrix {
    /**
     * @member {Double}
     * @default 1
     */
    public var a: Double = noImpl

    /**
     * @member {Double}
     * @default 0
     */
    public var b: Double = noImpl

    /**
     * @member {Double}
     * @default 0
     */
    public var c: Double = noImpl

    /**
     * @member {Double}
     * @default 1
     */
    public var d: Double = noImpl

    /**
     * @member {Double}
     * @default 0
     */
    public var tx: Double = noImpl

    /**
     * @member {Double}
     * @default 0
     */
    public var ty: Double = noImpl

    /**
     * Creates a Matrix object based on the given array. The Element to Matrix mapping order is as follows:
     *
     * a = array[0]
     * b = array[1]
     * c = array[3]
     * d = array[4]
     * tx = array[2]
     * ty = array[5]
     *
     * @param array {Double[]} The array that the matrix will be populated from.
     */
    public fun fromArray(array: Array<Double>) = noImpl

    /**
     * Creates an array from the current Matrix object.
     *
     * @param transpose {Boolean} Whether we need to transpose the matrix or not
     * @return {Double[]} the newly created array which contains the matrix
     */
    public fun toArray(transpose: Boolean): Array<Double> = noImpl

    /**
     * Get a new position with the current transformation applied.
     * Can be used to go from a child's coordinate space to the world coordinate space. (e.g. rendering)
     *
     * @param pos {Point} The origin
     * @param [newPos] {Point} The point that the new position is assigned to (allowed to be same as input)
     * @return {Point} The new point, transformed through this matrix
     */
    public fun apply(pos: Point, newPos: Point? = noImpl): Point = noImpl

    /**
     * Get a new position with the inverse of the current transformation applied.
     * Can be used to go from the world coordinate space to a child's coordinate space. (e.g. input)
     *
     * @param pos {Point} The origin
     * @param [newPos] {Point} The point that the new position is assigned to (allowed to be same as input)
     * @return {Point} The new point, inverse-transformed through this matrix
     */
    public fun applyInverse(pos: Point, newPos: Point? = noImpl): Point = noImpl

    /**
     * Translates the matrix on the x and y.
     *
     * @param {Double} x
     * @param {Double} y
     * @return {Matrix} This matrix. Good for chaining method calls.
     */
    public fun translate(x: Double, y: Double): Matrix = noImpl

    /**
     * Applies a scale transformation to the matrix.
     *
     * @param {Double} x The amount to scale horizontally
     * @param {Double} y The amount to scale vertically
     * @return {Matrix} This matrix. Good for chaining method calls.
     */
    public fun scale(x: Double, y: Double): Matrix = noImpl

    /**
     * Applies a rotation transformation to the matrix.
     *
     * @param {Double} angle - The angle in radians.
     * @return {Matrix} This matrix. Good for chaining method calls.
     */
    public fun rotate(angle: Double): Matrix = noImpl

    /**
     * Appends the given Matrix to this Matrix.
     *
     * @param {Matrix} matrix
     * @return {Matrix} This matrix. Good for chaining method calls.
     */
    public fun append(matrix: Matrix): Matrix = noImpl

    /**
     * Prepends the given Matrix to this Matrix.
     *
     * @param {Matrix} matrix
     * @return {Matrix} This matrix. Good for chaining method calls.
     */
    public fun prepend(matrix: Matrix): Matrix = noImpl

    /**
     * Resets this Matix to an identity (default) matrix.
     *
     * @return {Matrix} This matrix. Good for chaining method calls.
     */
    public fun identity(): Matrix = noImpl

    public fun invert(): Matrix = noImpl

    public fun clone(): Matrix = noImpl

    public fun copy(matrix: Matrix): Matrix = noImpl
}