package com.fys.events;

import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.input.UserAction;
import com.almasb.fxgl.time.LocalTimer;
import com.fys.constant.BaseConstant;
import javafx.util.Duration;

/**
 * @author fys
 * 向下移动
 */
public class DownEvent extends UserAction {
    private final Entity entity;
    private final LocalTimer moveTimer;

    public DownEvent(Entity entity, LocalTimer moveTimer) {
        super("向下移动");
        this.entity = entity;
        this.moveTimer = moveTimer;
    }

    @Override
    protected void onAction() {
        //越界
        if (entity.getY() >= BaseConstant.GAME_HEIGHT - BaseConstant.GRAPHICAL_LEN) {
            return;
        }
        //按着不放时的触发间隔
        if(!moveTimer.elapsed(Duration.seconds(BaseConstant.MOVE_INTERVAL))){
            return;
        }
        moveTimer.capture();
        entity.translateY(BaseConstant.MOVE_SPEED);
    }
}
