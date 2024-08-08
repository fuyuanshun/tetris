package com.fys.events;

import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.input.UserAction;
import com.almasb.fxgl.time.LocalTimer;
import com.fys.constant.BaseConstant;
import javafx.util.Duration;

/**
 * @author fys
 * 向左移动
 */
public class LeftEvent extends UserAction {
    private final Entity entity;
    private final LocalTimer moveTimer;

    public LeftEvent(Entity entity, LocalTimer moveTimer) {
        super("向左移动");
        this.entity = entity;
        this.moveTimer = moveTimer;
    }

    @Override
    protected void onAction() {
        //到底了，不能移动
        if (entity.getY() == BaseConstant.GAME_HEIGHT - BaseConstant.GRAPHICAL_LEN) {
            return;
        }
        //越界
        if (entity.getX() <= 0) {
            return;
        }
        if(!moveTimer.elapsed(Duration.seconds(BaseConstant.MOVE_INTERVAL))){
            return;
        }
        moveTimer.capture();
        entity.translateX(-BaseConstant.MOVE_SPEED);
    }
}
