package com.javarush.task.task37.task3710.decorators;

import com.javarush.task.task37.task3710.shapes.Shape;

public class RedShapeDecorator extends ShapeDecorator {
    private Shape shape;
    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
        shape = decoratedShape;
    }
    private void setBorderColor(Shape shapeDecorator){
        String s = shape.getClass().getSimpleName();
        System.out.printf("Setting border color for %s to red.", s);
    }

    @Override
    public void draw() {
        setBorderColor(shape);
        super.draw();
    }
}
