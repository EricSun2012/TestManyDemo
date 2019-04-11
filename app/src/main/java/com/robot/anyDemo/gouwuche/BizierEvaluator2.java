package com.robot.anyDemo.gouwuche;

import android.animation.TypeEvaluator;

public class BizierEvaluator2 implements TypeEvaluator<Point> {

    private Point controllPoint;

    public BizierEvaluator2(Point point) {
        controllPoint = point;
    }

    @Override
    public Point evaluate(float t, Point startValue, Point endValue) {

        int x = (int) ((1 - t) * (1 - t) * startValue.getX() + 2f * t * (1 - t) * controllPoint.getX() + t * t * endValue.getX());
        int y = (int) ((1 - t) * (1 - t) * startValue.getY() + 2f * t * (1 - t) * controllPoint.getY() + t * t * endValue.getY());
        return new Point(x, y);
    }
}
