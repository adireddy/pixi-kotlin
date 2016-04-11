(function (Kotlin) {
  'use strict';
  var _ = Kotlin.defineRootPackage(null, /** @lends _ */ {
    main_kand9s$animate: function (bunny, renderer, stage) {
      return function animate() {
        requestAnimFrame(animate);
        bunny.rotation = bunny.rotation + 0.1;
        renderer.render(stage);
      };
    },
    main_kand9s$: function (args) {
      var tmp$0;
      var stage = new PIXI.Stage(6750105);
      var renderer = PIXI.autoDetectRenderer(400, 300);
      ((tmp$0 = document.body) != null ? tmp$0 : Kotlin.throwNPE()).appendChild(renderer.view);
      var texture = PIXI.Texture.fromImage('assets/basics/bunny.png');
      var bunny = new PIXI.Sprite(texture);
      bunny.anchor.x = 0.5;
      bunny.anchor.y = 0.5;
      bunny.position.x = 200.0;
      bunny.position.y = 150.0;
      stage.addChild(bunny);
      var animate = _.main_kand9s$animate(bunny, renderer, stage);
      requestAnimFrame(animate);
    },
    pixi: Kotlin.definePackage(null, /** @lends _.pixi */ {
      geom: Kotlin.definePackage(null, /** @lends _.pixi.geom */ {
        Geometry: Kotlin.createTrait(null),
        Shape: Kotlin.createTrait(null)
      }),
      primitives: Kotlin.definePackage(null, /** @lends _.pixi.primitives */ {
        GraphicsData: Kotlin.createClass(null, null)
      }),
      renderers: Kotlin.definePackage(null, /** @lends _.pixi.renderers */ {
        Renderer: Kotlin.createClass(null, function (width, height, options) {
          if (width === void 0)
            width = 0;
          if (height === void 0)
            height = 0;
          if (options === void 0)
            options = new Object();
          this.width = width;
          this.height = height;
          this.type = PIXI.WEBGL_RENDERER;
          this.resolution = options.resolution;
          this.transparent = options.transparent;
          this.preserveDrawingBuffer = options.preserveDrawingBuffer;
          this.clearBeforeRender = options.clearBeforeRender;
          this.view = options.view;
        }, /** @lends _.pixi.renderers.Renderer.prototype */ {
          render: function (stage) {
            noImpl;
          },
          resize: function (width, height) {
            noImpl;
          }
        })
      })
    })
  });
  Kotlin.defineModule('pixi-kotlin', _);
  _.main_kand9s$([]);
}(Kotlin));
