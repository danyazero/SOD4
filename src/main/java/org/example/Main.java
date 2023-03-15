package org.example;

import tree.Tree;

import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        Tree<Integer> tree = new Tree((Comparator<Integer>) (o1, o2) -> {
            if(o1 < 0 && o2 > 0) return 1;
            if (o1 > 0 && o2 < 0) return -1;
            if (o1 < 0) {
                return -Integer.compare(o1, o2);
            }else return Integer.compare(o1, o2);
        });

        loop:
        while (true){
            System.out.println("[1] 10^5 elements in tree");
            System.out.println("[2] 10^6 elements in tree");
            System.out.println("[3] Add Balanced tree");
            System.out.println("[4] Exit");
            Scanner scanner = new Scanner(System.in);
            int m = scanner.nextInt();
            switch (m) {
                case 1 -> randomIntsBinaryTree(tree, 100_000, scanner);
                case 2 -> randomIntsBinaryTree(tree, 1_000_000, scanner);
                case 3 -> addBalancedTree(tree, scanner);
                case 4 -> {break loop;}
            }
        }
    }

    private void randomIntsBinaryTree(Tree tree, int num, Scanner scanner) {
        addRandomElems(tree, num);

        System.out.println(tree.getHeight());
        System.out.println("Balanced:" + tree.getTreeBalanced());

        System.out.println("[1] Show tree");
        switch (scanner.nextInt()){
            case 1 -> tree.traverse();
        }
        System.out.println();
    }

    private void addBalancedTree(Tree tree, Scanner scanner){
        addElems(tree);

        System.out.println(tree.getHeight());
        System.out.println("Balanced:" + tree.getTreeBalanced());

        System.out.println("[1] Show tree");
        switch (scanner.nextInt()){
            case 1 -> tree.traverse();
        }
        System.out.println();
    }

    private void addRandomElems(Tree tree, int num){
        Random random = new Random();
        long start = System.currentTimeMillis();
        for (int i = 0; i < num; i++) {
            tree.add(random.nextInt(-10_00_000, 10_000_000));
        }
        long finish = System.currentTimeMillis();
        System.out.println("Time = " + (finish-start));
    }
    private void addElems(Tree tree){
        tree.add(14);
        tree.add(9);
        tree.add(14);
        tree.add(13);
        tree.add(1);
        tree.add(20);
    }
}
