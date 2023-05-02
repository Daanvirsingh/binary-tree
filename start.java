
public class start {


    public static void main(String[] args)
    {
        //created empty binary tree
        BinaryTree tree = new BinaryTree();

        TextParser tp = new TextParser();

        if (tp.openFile("pg345.txt") == false) {
            System.out.println("Error opening file");
            System.exit(0);
        }
        String word = tp.getNextWord();
        while(word != null) {
            word = tp.getNextWord();
            if(word!=null){
                tree.insert(word);
            }
        }
        System.out.println("ROOT word:-" + tree.root.word );
        System.out.println("\nIN ORDER:- ");
        tree.printInorder(20);
        System.out.println("\nPOST ORDER:- ");
        tree.printPostorder(20);
        System.out.println("\nPRE ORDER:- ");
        tree.printPreorder(20);
        tree.printAlphabetically();
    }
}
