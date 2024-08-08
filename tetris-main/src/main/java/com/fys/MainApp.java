package com.fys;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.localization.Language;
import com.almasb.fxgl.physics.CollisionHandler;
import com.almasb.fxgl.physics.HitBox;
import com.almasb.fxgl.time.LocalTimer;
import com.fys.components.ComponentFactory;
import com.fys.components.MoveEventComponent;
import com.fys.components.StickComponent;
import com.fys.constant.BaseConstant;
import com.fys.type.GraphicalType;
import javafx.scene.input.KeyCode;

import java.util.Random;

import static com.almasb.fxgl.dsl.FXGLForKtKt.*;

/**
 * @author fys
 */
public class MainApp extends GameApplication {

    private Entity currentEntity;
    private StickComponent stickComponent;
    private MoveEventComponent moveEventComponent;

    private LocalTimer moveTimer;

    @Override
    protected void initSettings(GameSettings gameSettings) {
        //游戏启动页面
        gameSettings.setMainMenuEnabled(true);
        //标题
        gameSettings.setTitle(BaseConstant.GAME_TITLE);
        //版本号
        gameSettings.setVersion(BaseConstant.GAME_VERSION);
        //窗口宽高
        gameSettings.setHeight(BaseConstant.GAME_HEIGHT);
        gameSettings.setWidth(BaseConstant.GAME_WIDTH);
        //添加中文支持
        gameSettings.getSupportedLanguages().add(Language.CHINESE);
        gameSettings.setDefaultLanguage(Language.CHINESE);
    }

    @Override
    protected void initGame() {
        getGameWorld().addEntityFactory(new ComponentFactory());
        //设置背景图
        getGameScene().setBackgroundRepeat("background_image.png");
        currentEntity = randomGraphical();
        moveEventComponent = currentEntity.getComponent(MoveEventComponent.class);
        //控制移动频率
        moveTimer = FXGL.newLocalTimer();
    }

    @Override
    protected void initInput() {
        FXGL.onKey(KeyCode.LEFT, () -> moveEventComponent.moveLeft());
        FXGL.onKey(KeyCode.RIGHT, () -> moveEventComponent.moveRight());
        FXGL.onKey(KeyCode.DOWN, () -> moveEventComponent.moveDown());
        FXGL.onKey(KeyCode.UP, () -> moveEventComponent.deformation());
    }

    @Override
    protected void initPhysics() {
        getPhysicsWorld().addCollisionHandler(new CollisionHandler(GraphicalType.BASE, GraphicalType.BASE) {
            @Override
            protected void onHitBoxTrigger(Entity a, Entity b, HitBox boxA, HitBox boxB) {
                if (a.getX() == b.getX() && a.distanceBBox(b) == 0) {
                    moveEventComponent.stop();
                    currentEntity = randomGraphical();
                    moveEventComponent = currentEntity.getComponent(MoveEventComponent.class);
                }
            }
        });
    }

    @Override
    protected void onUpdate(double tpf) {
        if (currentEntity.getY() >= BaseConstant.GAME_HEIGHT - currentEntity.getHeight()) {
            moveEventComponent.stop();
            currentEntity = randomGraphical();
            moveEventComponent = currentEntity.getComponent(MoveEventComponent.class);
        }
    }

    /**
     * 随机生成一个方块
     * @return
     */
    public Entity randomGraphical(){
        Random random = new Random();
        return spawn(BaseConstant.COMPONENT_TYPE_ARR[random.nextInt(5)]);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
