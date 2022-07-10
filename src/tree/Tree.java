package tree;

public class Tree<T> {

    private Tree<T> left;

    private Tree<T> right;

    private T value;



    public Tree() {
        value = null;
        left = null;
        right = null;
    }

    public Tree(T value) {
        this.value = value;
    }

    public Tree(T value, Tree<T> left) {
        this.value = value;
        this.left = left;
    }

    public Tree(T value, Tree<T> left, Tree<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }


    public Tree<T> getLeft() {
        return left;
    }

    public void setLeft(Tree<T> left) {
        this.left = left;
    }

    public Tree<T> getRight() {
        return right;
    }

    public void setRight(Tree<T> right) {
        this.right = right;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }



    @Override
    public String toString() {
        return (left == null && right == null) ?
                (value == null) ? "Tree{}" : "Tree{" + value + "}"
                :
                "Tree{" +
                "\nvalue=" + value +
                "\nleft=" + left +
                "\nright=" + right +
                '}';
    }

}
