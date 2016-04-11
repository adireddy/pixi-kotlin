package pixi.core.display

/**
 * A Container represents a collection of display objects.
 * It is the base class of all display objects that act as a container for other objects.
 *
 * @class
 * @extends DisplayObject
 * @namespace PIXI
 */
@native("PIXI.Container")
public open class Container : DisplayObject() {
    /**
     * The array of children of this container.
     *
     * @member {DisplayObject[]}
     * @readonly
     */
    public var children: Array<DisplayObject> = noImpl

    /**
     * The width of the Container, setting this will actually modify the scale to achieve the value set
     *
     * @member {Double}
     * @memberof Container#
     */
   public open var width: Double = noImpl

    /**
     * The height of the Container, setting this will actually modify the scale to achieve the value set
     *
     * @member {Double}
     * @memberof Container#
     */
    public open var height: Double = noImpl

    /**
     * Adds a child to the container.
     *
     * You can also add multple items like so:myContainer.addChild(thinkOne, thingTwo, thingThree)
     *
     * @param child {DisplayObject} The DisplayObject to add to the container
     * @return {DisplayObject} The child that was added.
     */
    public fun addChild(child: dynamic): DisplayObject = noImpl

    /**
     * Adds a child to the container at a specified index.
     * If the index is out of bounds an error will be thrown.
     *
     * @param child {DisplayObject} The child to add
     * @param index {Int} The index to place the child in
     * @return {DisplayObject} The child that was added.
     */
    public fun addChildAt(child: DisplayObject, index: Int): DisplayObject = noImpl

    /**
     * Swaps the position of 2 Display Objects within this container.
     *
     * @param child1 {DisplayObject}
     * @param child2 {DisplayObject}
     */
    public fun swapChildren(child1: DisplayObject, child2: DisplayObject) = noImpl

    /**
     * Returns the index position of a child DisplayObject instance
     *
     * @param child {DisplayObject} The DisplayObject instance to identify
     * @return {Int} The index position of the child display object to identify
     */
    public fun getChildIndex(child: DisplayObject): Int = noImpl

    /**
     * Changes the position of an existing child in the display object container
     *
     * @param child {DisplayObject} The child DisplayObject instance for which you want to change the index number
     * @param index {Int} The resulting index number for the child display object
     */
    public fun setChildIndex(child: DisplayObject, index: Int) = noImpl

    /**
     * Returns the child at the specified index
     *
     * @param index {Int} The index to get the child from
     * @return {DisplayObject} The child at the given index, if any.
     */
    public fun getChildAt(index: Int): DisplayObject = noImpl

    /**
     * Removes a child from the container.
     *
     * @param child {DisplayObject} The DisplayObject to remove
     * @return {DisplayObject} The child that was removed.
     */
    public fun removeChild(child: DisplayObject): DisplayObject = noImpl

    /**
     * Removes a child from the specified index position.
     *
     * @param index {Int} The index to get the child from
     * @return {DisplayObject} The child that was removed.
     */
    public fun removeChildAt(index: Int): DisplayObject = noImpl

    /**
     * Removes all children from this container that are within the begin and end indexes.
     *
     * @param beginIndex {Int} The beginning position. Default value is 0.
     * @param endIndex {Int} The ending position. Default value is size of the container.
     */
    public fun removeChildren(beginIndex: Int? = noImpl, endIndex: Int? = noImpl) = noImpl

    /**
     * Returns the display object in the container
     *
     * @param name {string} instance name
     * @return {DisplayObject}
     */
    public fun getChildByName(name: String): DisplayObject = noImpl
}