package com.fys.components;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.entity.components.BoundingBoxComponent;
import com.almasb.fxgl.physics.BoundingShape;
import com.almasb.fxgl.physics.HitBox;
import com.almasb.fxgl.time.LocalTimer;
import com.fys.constant.BaseConstant;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import static com.almasb.fxgl.dsl.FXGLForKtKt.texture;

/**
 * 棍子，每秒更新，向下移动
 */
public class StickComponent extends Component {

    @Override
    public void onAdded() {
        Rectangle one = new Rectangle(BaseConstant.GRAPHICAL_LEN, BaseConstant.GRAPHICAL_LEN, BaseConstant.STICK_COLOR);
        Rectangle two = new Rectangle(BaseConstant.GRAPHICAL_LEN, BaseConstant.GRAPHICAL_LEN, BaseConstant.STICK_COLOR);
        two.setTranslateX(0);
        two.setTranslateY(20);
        Rectangle three = new Rectangle(BaseConstant.GRAPHICAL_LEN, BaseConstant.GRAPHICAL_LEN, BaseConstant.STICK_COLOR);
        three.setTranslateX(0);
        three.setTranslateY(40);
        Rectangle four = new Rectangle(BaseConstant.GRAPHICAL_LEN, BaseConstant.GRAPHICAL_LEN, BaseConstant.STICK_COLOR);
        four.setTranslateX(0);
        four.setTranslateY(60);
        entity.getViewComponent().addChild(one);
        entity.getViewComponent().addChild(two);
        entity.getViewComponent().addChild(three);
        entity.getViewComponent().addChild(four);
        entity.getBoundingBoxComponent().addHitBox(new HitBox(new Point2D(0, 0), BoundingShape.box(20, 20)));
        entity.getBoundingBoxComponent().addHitBox(new HitBox(new Point2D(0, 20), BoundingShape.box(20, 20)));
        entity.getBoundingBoxComponent().addHitBox(new HitBox(new Point2D(0, 40), BoundingShape.box(20, 20)));
        entity.getBoundingBoxComponent().addHitBox(new HitBox(new Point2D(0, 60), BoundingShape.box(20, 20)));
        entity.setRotationOrigin(entity.getCenter());
        entity.translateX(BaseConstant.GENERATE_X);
    }

    /**
     * 旋转
     */
    public void deformation(){
        entity.setRotation(entity.getRotation() - 90);
        BoundingBoxComponent boundingBoxComponent = entity.getBoundingBoxComponent();
        boundingBoxComponent.clearHitBoxes();
        boundingBoxComponent.addHitBox(new HitBox(new Point2D(0, 0), BoundingShape.box(20, 20)));
        boundingBoxComponent.addHitBox(new HitBox(new Point2D(20, 0), BoundingShape.box(20, 20)));
        boundingBoxComponent.addHitBox(new HitBox(new Point2D(40, 0), BoundingShape.box(20, 20)));
        boundingBoxComponent.addHitBox(new HitBox(new Point2D(40, 20), BoundingShape.box(20, 20)));
    }
}
