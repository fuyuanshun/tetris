package com.fys.components;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.dsl.components.*;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.almasb.fxgl.physics.PhysicsComponent;
import com.fys.type.GraphicalType;

/**
 * @author fys
 */
public class ComponentFactory implements EntityFactory {

    /**
     * 正四方形方块
     * @param spawnData
     * @return
     */
    @Spawns("rect")
    public Entity createRect(SpawnData spawnData){
        return FXGL
                .entityBuilder(spawnData)
                .type(GraphicalType.BASE)
                .collidable()
                .with(new KeepOnScreenComponent())
                .with(new AutoMoveDownComponent())
                .with(new MoveEventComponent())
                .with(new RectComponent())
                .build();
    }

    /**
     * 棍型方块
     * @param spawnData
     * @return
     */
    @Spawns("stick")
    public Entity createStick(SpawnData spawnData){
        return FXGL
                .entityBuilder(spawnData)
                .type(GraphicalType.BASE)
                .collidable()
                .with(new KeepOnScreenComponent())
                .with(new AutoMoveDownComponent())
                .with(new MoveEventComponent())
                .with(new StickComponent())
                .build();
    }

    /**
     * T型方块
     * @param spawnData
     * @return
     */
    @Spawns("t")
    public Entity createT(SpawnData spawnData){
        return FXGL
                .entityBuilder(spawnData)
                .type(GraphicalType.BASE)
                .collidable()
                .with(new KeepOnScreenComponent())
                .with(new AutoMoveDownComponent())
                .with(new MoveEventComponent())
                .with(new TComponent())
                .build();
    }

    /**
     * L型方块
     * @param spawnData
     * @return
     */
    @Spawns("l")
    public Entity createL(SpawnData spawnData){
        return FXGL
                .entityBuilder(spawnData)
                .type(GraphicalType.BASE)
                .collidable()
                .with(new KeepOnScreenComponent())
                .with(new AutoMoveDownComponent())
                .with(new MoveEventComponent())
                .with(new LComponent())
                .build();
    }

    /**
     * 反L型方块
     * @param spawnData
     * @return
     */
    @Spawns("l2")
    public Entity createL2(SpawnData spawnData){
        return FXGL
                .entityBuilder(spawnData)
                .type(GraphicalType.BASE)
                .collidable()
                .with(new KeepOnScreenComponent())
                .with(new AutoMoveDownComponent())
                .with(new MoveEventComponent())
                .with(new L2Component())
                .build();
    }
}
