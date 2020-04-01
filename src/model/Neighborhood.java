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

    public void remove(String address) {

        House toRemove = search(address);

        if (toRemove != null) {

            if (toRemove.getRight() == null && toRemove.getLeft() == null) {
                if (toRemove.getFather().getLeft() == toRemove) {
                    toRemove.getFather().setLeft(null);
                } else {
                    toRemove.getFather().setRight(null);
                }
            } else if (toRemove.getRight() == null ^ toRemove.getLeft() == null) {

                if (toRemove.getRight() != null) { // derecho es unico hijo del difunto
                    if (toRemove.getFather().getRight() == toRemove) {
                        toRemove.getRight().setFather(toRemove.getFather());
                        toRemove.getFather().setRight(toRemove.getRight());
                    } else {
                        toRemove.getRight().setFather(toRemove.getFather());
                        toRemove.getFather().setLeft(toRemove.getRight());
                    }

                } else { // izquierdo es unico hijo del difunto

                    if (toRemove.getFather().getRight() == toRemove) {
                        toRemove.getLeft().setFather(toRemove.getFather());
                        toRemove.getFather().setRight(toRemove.getLeft());
                    } else {
                        toRemove.getLeft().setFather(toRemove.getFather());
                        toRemove.getFather().setLeft(toRemove.getLeft());
                    }

                }

            } else if (toRemove.getLeft() != null && toRemove.getRight() != null) {

                House current = toRemove.getLeft();

                while (current.getRight() != null) {

                    current = current.getRight();

                }

                current.setFather(toRemove.getFather());
                current.setLeft(toRemove.getLeft());
                current.setRight(toRemove.getRight());
                current.getRight().setFather(current);
                current.getLeft().setFather(current);

                if (current.getFather().getRight() == current) {
                    current.getFather().setRight(null);
                } else {
                    current.getFather().setLeft(null);
                }

                current = null;

            }

        }

    }

}