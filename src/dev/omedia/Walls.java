package dev.omedia;

public class Walls {
    private double width;
    private double height;

    public Walls(){

    }

    public Walls(double width, double height){
        if(width < 0){
            this.width = 0;
        }else {
            this.width = width;
        }
        if(height < 0){
            this.height = 0;
        }else {
            this.height = height;
        }
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if(width < 0) {
            this.width = 0;
        }else {
            this.width = width;
        }
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        if(height < 0) {
            this.height = 0;
        }else {
            this.height = height;
        }
    }

    public double getArea(){
        return width * height;
    }
}
