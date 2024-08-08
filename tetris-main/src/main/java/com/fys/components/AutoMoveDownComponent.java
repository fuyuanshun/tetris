package com.fys.components;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.time.LocalTimer;
import com.fys.constant.BaseConstant;
import javafx.util.Duration;

public class AutoMoveDownComponent extends Component {
    private LocalTimer localTimer = FXGL.newLocalTimer();
    @Override
    public void onAdded() {

    }

    @Override
    public void onUpdate(double tpf) {
        if (localTimer.elapsed(Duration.seconds(1)) && entity.getY() < BaseConstant.GAME_HEIGHT - entity.getHeight()) {
            entity.getComponent(MoveEventComponent.class).moveDown();
            localTimer.capture();
        }
    }
}
