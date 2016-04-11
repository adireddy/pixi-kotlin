(function (Kotlin) {
  'use strict';
  var _ = Kotlin.defineRootPackage(null, /** @lends _ */ {
    main_kand9s$animate: function (bunny, renderer, stage) {
      return function animate(v) {
        window.requestAnimationFrame(animate);
        bunny.rotation = bunny.rotation + 0.1;
        renderer.render(stage.v);
      };
    },
    main_kand9s$: function (args) {
      var tmp$0;
      window.scrollbars.visible = false;
      var options = new Object();
      options.backgroundColor = 13158;
      options.resolution = 1;
      var stage = {v: new PIXI.Container()};
      var renderer = PIXI.autoDetectRenderer(window.innerWidth, window.innerHeight, options);
      ((tmp$0 = document.body) != null ? tmp$0 : Kotlin.throwNPE()).appendChild(renderer.view);
      var texture = PIXI.Texture.fromImage('assets/basics/bunny.png');
      var bunny = new PIXI.Sprite(texture);
      bunny.anchor.x = 0.5;
      bunny.anchor.y = 0.5;
      bunny.position.x = 200.0;
      bunny.position.y = 150.0;
      stage.v.addChild(bunny);
      var animate = _.main_kand9s$animate(bunny, renderer, stage);
      window.requestAnimationFrame(animate);
    },
    pixi: Kotlin.definePackage(null, /** @lends _.pixi */ {
      geom: Kotlin.definePackage(null, /** @lends _.pixi.geom */ {
        Geometry: Kotlin.createTrait(null),
        Shape: Kotlin.createTrait(null)
      }),
      primitives: Kotlin.definePackage(null, /** @lends _.pixi.primitives */ {
        GraphicsData: Kotlin.createClass(null, null)
      }),
      core: Kotlin.definePackage(null, /** @lends _.pixi.core */ {
        interaction: Kotlin.definePackage(null, /** @lends _.pixi.core.interaction */ {
          EventEmitter: Kotlin.createClass(null, null)
        })
      })
    })
  });
  Kotlin.defineModule('pixi-kotlin', _);
  _.main_kand9s$([]);
}(Kotlin));
