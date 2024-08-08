package com.fys.components;

import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.physics.BoundingShape;
import com.almasb.fxgl.physics.HitBox;
import com.fys.constant.BaseConstant;
import javafx.geometry.Point2D;
import javafx.scene.shape.Rectangle;

/**
 * 方块，每秒更新，向下移动
 */
public class RectComponent extends Component {

    @Override
    public void onAdded() {
        Rectangle one = new Rectangle(BaseConstant.GRAPHICAL_LEN, BaseConstant.GRAPHICAL_LEN, BaseConstant.RECT_COLOR);
        Rectangle two = new Rectangle(BaseConstant.GRAPHICAL_LEN, BaseConstant.GRAPHICAL_LEN, BaseConstant.RECT_COLOR);
        two.setTranslateX(20);
        two.setTranslateY(0);
        Rectangle three = new Rectangle(BaseConstant.GRAPHICAL_LEN, BaseConstant.GRAPHICAL_LEN, BaseConstant.RECT_COLOR);
        three.setTranslateX(0);
        three.setTranslateY(20);
        Rectangle four = new Rectangle(BaseConstant.GRAPHICAL_LEN, BaseConstant.GRAPHICAL_LEN, BaseConstant.RECT_COLOR);
        four.setTranslateX(20);
        four.setTranslateY(20);
        entity.getViewComponent().addChild(one);
        entity.getViewComponent().addChild(two);
        entity.getViewComponent().addChild(three);
        entity.getViewComponent().addChild(four);
        entity.getBoundingBoxComponent().addHitBox(new HitBox(new Point2D(0, 0), BoundingShape.box(20, 20)));
        entity.getBoundingBoxComponent().addHitBox(new HitBox(new Point2D(20, 0), BoundingShape.box(20, 20)));
        entity.getBoundingBoxComponent().addHitBox(new HitBox(new Point2D(0, 20), BoundingShape.box(20, 20)));
        entity.getBoundingBoxComponent().addHitBox(new HitBox(new Point2D(20, 20), BoundingShape.box(20, 20)));
        entity.setRotationOrigin(entity.getCenter());
        //在指定位置生成
        entity.translateX(BaseConstant.GENERATE_X);
    }
}
