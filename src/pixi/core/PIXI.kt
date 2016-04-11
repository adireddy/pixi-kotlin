package pixi.core

import pixi.core.renderers.Renderer
import pixi.core.renderers.RenderingOptions

@native object PIXI {
    /**
     * String of the current PIXI version
     *
     * @static
     * @constant
     * @property {String} VERSION
     */
    public val VERSION:String

    /**
     * @property {Float} PI_2 - Two Pi
     * @constant
     * @static
     */
    public val PI_2:Float

    /**
     * @property {Float} RAD_TO_DEG - Constant conversion factor for converting radians to degrees
     * @constant
     * @static
     */
    public val RAD_TO_DEG:Float

    /**
     * @property {Float} DEG_TO_RAD - Constant conversion factor for converting degrees to radians
     * @constant
     * @static
     */
    public val DEG_TO_RAD:Float

    /**
     * Target frames per millisecond.
     *
     * @static
     * @constant
     * @property {Float} TARGET_FPMS=0.06
     */
    public val TARGET_FPMS:Float

    /**
     * Constant to identify the Renderer Type.
     *
     * @static
     * @constant
     * @property {RendererType} RENDERER_TYPE
     * @property {Int} RENDERER_TYPE.UNKNOWN
     * @property {Int} RENDERER_TYPE.WEBGL
     * @property {Int} RENDERER_TYPE.CANVAS
     */
    public object RENDERER_TYPE  {
        public val UNKNOWN:Int = 0
        public val WEBGL:Int = 1
        public val CANVAS:Int = 1
    }

    /**
     * various blend modes supported by PIXI. IMPORTANT - The WebGL renderer only supports
     * the NORMAL, ADD, MULTIPLY and SCREEN blend modes. Anything else will silently act like
     * NORMAL.
     *
     * @static
     * @constant
     * @property {BlendModes} BLEND_MODES
     * @property {Int} BLEND_MODES.NORMAL
     * @property {Int} BLEND_MODES.ADD
     * @property {Int} BLEND_MODES.MULTIPLY
     * @property {Int} BLEND_MODES.SCREEN
     * @property {Int} BLEND_MODES.OVERLAY
     * @property {Int} BLEND_MODES.DARKEN
     * @property {Int} BLEND_MODES.LIGHTEN
     * @property {Int} BLEND_MODES.COLOR_DODGE
     * @property {Int} BLEND_MODES.COLOR_BURN
     * @property {Int} BLEND_MODES.HARD_LIGHT
     * @property {Int} BLEND_MODES.SOFT_LIGHT
     * @property {Int} BLEND_MODES.DIFFERENCE
     * @property {Int} BLEND_MODES.EXCLUSION
     * @property {Int} BLEND_MODES.HUE
     * @property {Int} BLEND_MODES.SATURATION
     * @property {Int} BLEND_MODES.COLOR
     * @property {Int} BLEND_MODES.LUMINOSITY
     */
    public object BLEND_MODES {
        public val NORMAL:Int = noImpl
        public val ADD:Int = noImpl
        public val MULTIPLY:Int = noImpl
        public val SCREEN:Int = noImpl
        public val OVERLAY:Int = noImpl
        public val DARKEN:Int = noImpl
        public val LIGHTEN:Int = noImpl
        public val COLOR_DODGE:Int = noImpl
        public val COLOR_BURN:Int = noImpl
        public val HARD_LIGHT:Int = noImpl
        public val SOFT_LIGHT:Int = noImpl
        public val DIFFERENCE:Int = noImpl
        public val EXCLUSION:Int = noImpl
        public val HUE:Int = noImpl
        public val SATURATION:Int = noImpl
        public val COLOR:Int = noImpl
        public val LUMINOSITY:Int = noImpl
    }

    /**
     * Various webgl draw modes. These can be used to specify which GL drawMode to use
     * under certain situations and renderers.
     *
     * @static
     * @constant
     * @property {DrawModes} DRAW_MODES
     * @property {Int} DRAW_MODES.POINTS
     * @property {Int} DRAW_MODES.LINES
     * @property {Int} DRAW_MODES.LINE_LOOP
     * @property {Int} DRAW_MODES.LINE_STRIP
     * @property {Int} DRAW_MODES.TRIANGLES
     * @property {Int} DRAW_MODES.TRIANGLE_STRIP
     * @property {Int} DRAW_MODES.TRIANGLE_FAN
     */
    public object DRAW_MODES {
        public val POINTS:Int = noImpl
        public val LINES:Int = noImpl
        public val LINE_LOOP:Int = noImpl
        public val LINE_STRIP:Int = noImpl
        public val TRIANGLES:Int = noImpl
        public val TRIANGLE_STRIP:Int = noImpl
        public val TRIANGLE_FAN:Int = noImpl
    }

    /**
     * The scale modes that are supported by pixi.
     *
     * The DEFAULT scale mode affects the default scaling mode of future operations.
     * It can be re-assigned to either LINEAR or NEAREST, depending upon suitability.
     *
     * @static
     * @constant
     * @property {ScaleModes} SCALE_MODES
     * @property {Int} SCALE_MODES.DEFAULT=LINEAR
     * @property {Int} SCALE_MODES.LINEAR Smooth scaling
     * @property {Int} SCALE_MODES.NEAREST Pixelating scaling
     */
    public object SCALE_MODES {
        public val DEFAULT:Int = noImpl
        public val LINEAR:Int = noImpl
        public val NEAREST:Int = noImpl
    }

    /**
     * The wrap modes that are supported by pixi.
     *
     * The DEFAULT wrap mode affects the default wraping mode of future operations.
     * It can be re-assigned to either CLAMP or REPEAT, depending upon suitability.
     * If the texture is non power of two then clamp will be used regardless as webGL can only use REPEAT if the texture is po2
     * This property only affects WebGL
     * @static
     * @constant
     * @property {WrapModes} WRAP_MODES
     * @property {Int} WRAP_MODES.DEFAULT=CLAMP
     * @property {Int} WRAP_MODES.CLAMP The textures uvs are clamped
     * @property {Int} WRAP_MODES.REPEAT The texture uvs tile and repeat
     * @property {Int} WRAP_MODES.MIRRORED_REPEAT The texture uvs tile and repeat with mirroring
     */
    public object WRAP_MODES {
        public val DEFAULT:Int = noImpl
        public val CLAMP:Int = noImpl
        public val REPEAT:Int = noImpl
        public val MIRRORED_REPEAT:Int = noImpl
    }

    /**
     * The gc modes that are supported by pixi.
     *
     * The DEFAULT Garbage Collection mode for pixi textures is MANUAL
     * If set to DEFAULT, the renderer will occasianally check textures usage. If they are not used for a specified period of time they will be removed from the GPU.
     * They will of corse be uploaded again when they are required. This is a silent behind the scenes process that should ensure that the GPU does not  get filled up.
     * Handy for mobile devices!
     * This property only affects WebGL
     * @static
     * @constant
     * @property {GCModes} GC_MODES
     * @property {Int} GC_MODES.DEFAULT=DEFAULT
     * @property {Int} GC_MODES.AUTO Garbage collection will happen periodically automatically
     * @property {Int} GC_MODES.MANUAL Garbage collection will need to be called manually
     */
    public object GC_MODES {
        public val DEFAULT:Int = noImpl
        public val AUTO:Int = noImpl
        public val MANUAL:Int = noImpl
    }

    /**
     * If set to true WebGL will attempt make textures mimpaped by default
     * Mipmapping will only succeed if the base texture uploaded has power of two dimensions
     * @static
     * @constant
     * @property {Boolean} MIPMAP_TEXTURES
     */
    public val MIPMAP_TEXTURES:Boolean

    /**
     * The prefix that denotes a URL is for a retina asset
     *
     * @static
     * @constant
     * @property {String} RETINA_PREFIX
     */
    //example: '@2x', /@(.+)x/
    public val RETINA_PREFIX:String

    public val RESOLUTION:Double

    public val FILTER_RESOLUTION:Double

    /**
     * The default render options if none are supplied to {@link PIXI.WebGLRenderer}
     * or {@link PIXI.CanvasRenderer}.
     *
     * @static
     * @constant
     * @property {DefaultRenderOptions} DEFAULT_RENDER_OPTIONS
     * @property {HTMLCanvasElement} DEFAULT_RENDER_OPTIONS.view=null
     * @property {Boolean} DEFAULT_RENDER_OPTIONS.transparent=false
     * @property {Boolean} DEFAULT_RENDER_OPTIONS.antialias=false
     * @property {Boolean} DEFAULT_RENDER_OPTIONS.forceFXAA=false
     * @property {Boolean} DEFAULT_RENDER_OPTIONS.preserveDrawingBuffer=false
     * @property {Float} DEFAULT_RENDER_OPTIONS.resolution=1
     * @property {Int} DEFAULT_RENDER_OPTIONS.backgroundColor=0x000000
     * @property {Boolean} DEFAULT_RENDER_OPTIONS.clearBeforeRender=true
     * @property {Boolean} DEFAULT_RENDER_OPTIONS.autoResize=false
     */
    public object DEFAULT_RENDER_OPTIONS {
        public val transparent:Boolean = false
        public val antialias:Boolean = false
        public val forceFXAA:Boolean = false
        public val preserveDrawingBuffer:Boolean = false
        public val resolution:Double = 1.0
        public val backgroundColor:Int = 0x000000
        public val clearBeforeRender:Boolean = true
        public val autoResize:Boolean = false
    }

    /**
     * Constants that identify shapes, mainly to prevent `instanceof` calls.
     *
     * @static
     * @constant
     * @property {Shapes} SHAPES
     * @property {Int} SHAPES.POLY=0
     * @property {Int} SHAPES.RECT=1
     * @property {Int} SHAPES.CIRC=2
     * @property {Int} SHAPES.ELIP=3
     * @property {Int} SHAPES.RREC=4
     */
    public object SHAPES {
        public val POLY:Int = 0
        public val RECT:Int = 1
        public val CIRC:Int = 2
        public val ELIP:Int = 3
        public val RREC:Int = 4
    }

    //4096 - nice balance between mobile and desktop machines
    public val SPRITE_BATCH_SIZE:Int

    public val SPRITE_MAX_TEXTURES:Int

    public fun autoDetectRenderer(width:Double, height:Double, options: RenderingOptions? = noImpl, noWebGL:Boolean? = noImpl): Renderer;
}

