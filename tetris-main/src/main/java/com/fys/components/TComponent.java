package com.fys.components;

import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.physics.BoundingShape;
import com.almasb.fxgl.physics.HitBox;
import com.fys.constant.BaseConstant;
import javafx.geometry.Point2D;
import javafx.scene.shape.Rectangle;

/**
 * T型方块，每秒更新，向下移动
 */
public class TComponent extends Component {

    @Override
    public void onAdded() {
        Rectangle one = new Rectangle(BaseConstant.GRAPHICAL_LEN, BaseConstant.GRAPHICAL_LEN, BaseConstant.T_COLOR);
        one.setTranslateX(20);
        one.setTranslateY(0);
        Rectangle two = new Rectangle(BaseConstant.GRAPHICAL_LEN, BaseConstant.GRAPHICAL_LEN, BaseConstant.T_COLOR);
        two.setTranslateX(0);
        two.setTranslateY(20);
        Rectangle three = new Rectangle(BaseConstant.GRAPHICAL_LEN, BaseConstant.GRAPHICAL_LEN, BaseConstant.T_COLOR);
        three.setTranslateX(20);
        three.setTranslateY(20);
        Rectangle four = new Rectangle(BaseConstant.GRAPHICAL_LEN, BaseConstant.GRAPHICAL_LEN, BaseConstant.T_COLOR);
        four.setTranslateX(40);
        four.setTranslateY(20);
        entity.getViewComponent().addChild(one);
        entity.getViewComponent().addChild(two);
        entity.getViewComponent().addChild(three);
        entity.getViewComponent().addChild(four);
        entity.getBoundingBoxComponent().addHitBox(new HitBox(new Point2D(20, 0), BoundingShape.box(20, 20)));
        entity.getBoundingBoxComponent().addHitBox(new HitBox(new Point2D(0, 20), BoundingShape.box(20, 20)));
        entity.getBoundingBoxComponent().addHitBox(new HitBox(new Point2D(20, 20), BoundingShape.box(20, 20)));
        entity.getBoundingBoxComponent().addHitBox(new HitBox(new Point2D(40, 20), BoundingShape.box(20, 20)));
        entity.setRotationOrigin(entity.getCenter());
        entity.translateX(BaseConstant.GENERATE_X);
    }
}
