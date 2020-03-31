package model;

public class Neighborhood {

    private House root;

    public Neighborhood() {

    }

    public void addHouse(String address, double area) {

        House newHouse = new House(address, area);

        if (root == null) {
            root = newHouse;
        } else {

            addHouse(root, newHouse);

        }

    }

    private void addHouse(House current, House newHouse) {

        if (newHouse.compareTo(current) <= 0) {
            if (current.getLeft() == null) {
                current.setLeft(newHouse);
                current.getLeft().setFather(current);
            } else {
                addHouse(current.getLeft(), newHouse);
            }

        } else {

            if (current.getRight() == null) {
                current.setRight(newHouse);
                current.getRight().setFather(current);
            } else {
                addHouse(current.getRight(), newHouse);
            }
        }

    }

    public House search(String address) {

        if (root.getAddress().equals(address)) {
            return root;
        }

        return search(root, address);

    }

    private House search(House current, String address) {

        if (current == null) {

            return null;

        } else if (current.getAddress().equals(address)) {

            return current;

        } else if (current.getAddress().compareTo(address) > 0) {

            if (current.getLeft() == null) {

                return null;

            } else {

                return search(current.getLeft(), address);

            }

        } else {

            if (current.getAddress().equals(address)) {

                return current;

            } else {

                return search(current.getRight(), address);

            }
        }

    }

    public void remove(String address){

        if(root.getAddress().equals(address)){
            root = root;
        }

    }

}