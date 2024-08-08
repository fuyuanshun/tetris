package com.fys.constant;

import javafx.scene.paint.Color;

/**
 * @author fys
 * @date 2022/05/03 01点15分
 * 基本常量类
 */
public class BaseConstant {
    /**
     * 禁止实例化
     */
    private BaseConstant(){}

    /**
     * 游戏标题
     */
    public static final String GAME_TITLE = "俄罗斯方块";

    /**
     * 游戏版本号
     */
    public static final String GAME_VERSION = "1.0";;

    /**
     * 游戏窗口高度
     */
    public static final Integer GAME_HEIGHT = 20 * 20;

    /**
     * 游戏窗口宽度
     */
    public static final Integer GAME_WIDTH = 20 * 10 + 20 * 5;

    /**
     * 每一个小方块的边长
     */
    public static final Integer GRAPHICAL_LEN = 20;

    /**
     * 方块生成位置-X轴
     */
    public static final Integer GENERATE_X = (GAME_WIDTH - GRAPHICAL_LEN) / 2;

    /**
     * 方块生成位置-Y轴
     */
    public static final Integer GENERATE_Y = 0;

    /**
     * 方块移动速度
     */
    public static final Integer MOVE_SPEED = 20;

    /**
     * 方块移动最小间隔时间（秒）
     */
    public static final Double MOVE_INTERVAL = 0.1;

    /**
     * 方块变形最小间隔时间（秒）
     */
    public static final Double DEFORMATION_INTERVAL = 0.2;

    /**
     * 游戏背景颜色
     */
    public static final Color BACKGROUND_COLOR = Color.rgb(102,204,204);

    /**
     * 正方形方块颜色
     */
    public static final Color RECT_COLOR = Color.rgb(153,204,51);

    /**
     * 棍型方块颜色
     */
    public static final Color STICK_COLOR = Color.rgb(255,153,204);

    /**
     * L型方块颜色
     */
    public static final Color L_COLOR = Color.rgb(255,102,102);

    /**
     * 倒L型方块颜色
     */
    public static final Color L2_COLOR = Color.rgb(153,102,204);

    /**
     * T型方块颜色
     */
    public static final Color T_COLOR = Color.rgb(255,51,204);

    /**
     * 方块类型数组
     */
    public static final String[] COMPONENT_TYPE_ARR = {"l", "l2", "rect", "stick", "t"};
}
