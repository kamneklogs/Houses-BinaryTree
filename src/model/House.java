package model;

public class House {

    private String address;
    private double area;

    private House father;
    private House right;
    private House left;

    public House(String address, double area) {
        this.address = address;
        this.area = area;
    }

    public int compareTo(House h) {

        if (this.address.compareTo(h.getAddress()) < 0) {

            return -1;

        } else if (this.address.compareTo(h.getAddress()) > 0) {

            return 1;

        }

        return 0;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public House getFather() {
        return father;
    }

    public void setFather(House father) {
        this.father = father;
    }

    public House getRight() {
        return right;
    }

    public void setRight(House right) {
        this.right = right;
    }

    public House getLeft() {
        return left;
    }

    public void setLeft(House left) {
        this.left = left;
    }

}