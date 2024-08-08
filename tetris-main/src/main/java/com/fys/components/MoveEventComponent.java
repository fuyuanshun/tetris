package com.fys.components;

import com.almasb.fxgl.core.util.LazyValue;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityGroup;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.time.LocalTimer;
import com.fys.constant.BaseConstant;
import com.fys.type.GraphicalType;
import javafx.util.Duration;

import java.util.List;

import static com.almasb.fxgl.dsl.FXGLForKtKt.getGameWorld;

public class MoveEventComponent extends Component {
    private LocalTimer moveTimer = FXGL.newLocalTimer();

    private LazyValue<EntityGroup> entityGroupLazyValue = new LazyValue<>(()->getGameWorld().getGroup(GraphicalType.BASE));

    public void moveLeft(){
        if(!moveTimer.elapsed(Duration.seconds(BaseConstant.MOVE_INTERVAL))){
            return;
        }
        moveTimer.capture();
        entity.translateX(-BaseConstant.MOVE_SPEED);
        List<Entity> collList = entityGroupLazyValue.get().getEntitiesCopy();
        for (Entity coll : collList) {
            if (entity != coll && entity.isColliding(coll)) {
                entity.translateX(BaseConstant.MOVE_SPEED);
                break;
            }
        }
    }

    public void moveRight(){
        if(!moveTimer.elapsed(Duration.seconds(BaseConstant.MOVE_INTERVAL))){
            return;
        }
        moveTimer.capture();
        entity.translateX(BaseConstant.MOVE_SPEED);
        List<Entity> collList = entityGroupLazyValue.get().getEntitiesCopy();
        for (Entity coll : collList) {
            if (entity != coll && entity.isColliding(coll)) {
                entity.translateX(-BaseConstant.MOVE_SPEED);
                break;
            }
        }
    }

    public void moveDown(){
        if(!moveTimer.elapsed(Duration.seconds(BaseConstant.MOVE_INTERVAL))){
            return;
        }
        moveTimer.capture();
        entity.translateY(BaseConstant.MOVE_SPEED);
        List<Entity> collList = entityGroupLazyValue.get().getEntitiesCopy();
        for (Entity coll : collList) {
            if (entity != coll && entity.isColliding(coll)) {
                entity.translateY(-BaseConstant.MOVE_SPEED);
                break;
            }
        }
    }

    public void deformation(){
        if (getGameWorld().getCollidingEntities(entity).size() > 0) {
            return;
        }
        if(!moveTimer.elapsed(Duration.seconds(BaseConstant.DEFORMATION_INTERVAL))){
            return;
        }
        moveTimer.capture();
        entity.setRotation(entity.getRotation() - 90);
    }

    public void stop(){
        entity.setUpdateEnabled(false);
    }
}
