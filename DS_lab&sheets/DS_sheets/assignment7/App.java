package app;


public class App {
    public static void main(String[] args) {
        BST tree = new BST();
        tree.add(100);
        tree.add(90);
        tree.add(110);
        tree.add(80);
        tree.add(95);
        tree.add(105);
        tree.add(120);
        tree.add(70);
        tree.add(92);
        System.out.println(tree.countNodes()+" nodes "+tree.countLeaves()+" leaves "+tree.countRightChildren()+" right children");
        if(tree.find(65))
            System.out.println("found 65");
        else
            System.out.println("not found 65");
        System.out.println("height: "+tree.getHeight());
        tree.display("in");
        tree.deleteLeaves();
        tree.display("in");
        BST tree2 = new BST();
        int arr[] = {50,30,60,55,80,65,62,75,85,100,90};
        tree2.preorderBuild(arr);
        BST subTree = new BST();
        for (int i = 0; i < 7; i++) {
            subTree.add(arr[i+4]);
        }
        System.out.println("subTree: ");
        subTree.display("in");
        if(tree2.findSubTree(subTree.getRoot()))
            System.out.print("found ");
        else
            System.out.print("not found ");
        System.out.println("in tree: ");
        tree2.display("in");
    }

}