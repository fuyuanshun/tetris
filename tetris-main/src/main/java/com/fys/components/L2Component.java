package com.fys.components;

import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.entity.components.BoundingBoxComponent;
import com.almasb.fxgl.physics.BoundingShape;
import com.almasb.fxgl.physics.HitBox;
import com.fys.constant.BaseConstant;
import javafx.geometry.Point2D;
import javafx.scene.shape.Rectangle;

/**
 * L型，每秒更新，向下移动
 */
public class L2Component extends Component {

    @Override
    public void onAdded() {
        Rectangle one = new Rectangle(BaseConstant.GRAPHICAL_LEN, BaseConstant.GRAPHICAL_LEN, BaseConstant.L2_COLOR);
        one.setTranslateX(20);
        one.setTranslateY(0);
        Rectangle two = new Rectangle(BaseConstant.GRAPHICAL_LEN, BaseConstant.GRAPHICAL_LEN, BaseConstant.L2_COLOR);
        two.setTranslateX(20);
        two.setTranslateY(20);
        Rectangle three = new Rectangle(BaseConstant.GRAPHICAL_LEN, BaseConstant.GRAPHICAL_LEN, BaseConstant.L2_COLOR);
        three.setTranslateX(20);
        three.setTranslateY(40);
        Rectangle four = new Rectangle(BaseConstant.GRAPHICAL_LEN, BaseConstant.GRAPHICAL_LEN, BaseConstant.L2_COLOR);
        four.setTranslateX(0);
        four.setTranslateY(40);
        entity.getViewComponent().addChild(one);
        entity.getViewComponent().addChild(two);
        entity.getViewComponent().addChild(three);
        entity.getViewComponent().addChild(four);
        entity.getBoundingBoxComponent().addHitBox(new HitBox(new Point2D(20, 0), BoundingShape.box(20, 20)));
        entity.getBoundingBoxComponent().addHitBox(new HitBox(new Point2D(20, 20), BoundingShape.box(20, 20)));
        entity.getBoundingBoxComponent().addHitBox(new HitBox(new Point2D(20, 40), BoundingShape.box(20, 20)));
        entity.getBoundingBoxComponent().addHitBox(new HitBox(new Point2D(0, 40), BoundingShape.box(20, 20)));
        entity.setRotationOrigin(entity.getCenter());
        entity.translateX(BaseConstant.GENERATE_X);
    }
}
