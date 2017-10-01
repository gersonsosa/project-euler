package com.gersonsosa.projecteuler.contacts;

import java.util.Scanner;

public class Contacts {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        TernarySearchTree contactsTree = new TernarySearchTree();
        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();
            switch (op) {
                case "add":
                    contactsTree.insert(contact);
                    break;
                case "find":
                    System.out.println(contactsTree.countByPrefix(contact));
                    break;
                default:
                    throw new IllegalArgumentException(String.format("Unknown operation: %s", op));
            }
        }
    }

    public static class Node {
        private char data;

        private boolean endOfString;

        private Node left;
        private Node equal;
        private Node right;

        public Node(char data) {
            this.data = data;
        }

        public char getData() {
            return data;
        }

        public void setData(char data) {
            this.data = data;
        }

        public boolean isEndOfString() {
            return endOfString;
        }

        public void setEndOfString(boolean endOfString) {
            this.endOfString = endOfString;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getEqual() {
            return equal;
        }

        public void setEqual(Node equal) {
            this.equal = equal;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    public static class TernarySearchTree {

        public static final int FIRST_CHAR_INDEX = 0;
        private Node root;

        public void insert(String contactName) {
            if (contactName == null || contactName.isEmpty()) {
                return;
            }
            if (root == null) {
                root = new Node(contactName.charAt(FIRST_CHAR_INDEX));
            }
            root = insert(root, contactName, FIRST_CHAR_INDEX);
        }

        private Node insert(Node node, String contactName, int i) {

            char current = contactName.charAt(i);

            if (node == null) {
                node = new Node(current);
            }

            if (current < node.getData()) {
                node.setLeft(insert(node.getLeft(), contactName, i));
            } else if (current > node.getData()) {
                node.setRight(insert(node.getRight(), contactName, i));
            } else {
                if (i < contactName.length() - 1) {
                    node.setEqual(insert(node.getEqual(), contactName, i + 1));
                } else {
                    node.setEndOfString(true);
                }
            }
            return node;
        }

        public int countByPrefix(String prefix) {

            if (prefix == null || prefix.isEmpty()) {
                return 0;
            }

            Node foundNode = get(root, prefix, FIRST_CHAR_INDEX);
            if (foundNode == null) {
                return 0;
            }
            int contacts = countContacts(foundNode.getEqual());
            return foundNode.isEndOfString() ? 1 + contacts : contacts;
        }

        private int countContacts(Node node) {
            if (node == null) {
                return 0;
            }

            int i = node.isEndOfString() ? 1 : 0;

            return i + countContacts(node.getLeft()) + countContacts(node.getEqual()) + countContacts(node.getRight());
        }

        private Node get(Node node, String prefix, int i) {

            if (node == null) {
                return null;
            }

            char current = prefix.charAt(i);

            if (current < node.getData()) {
                return get(node.getLeft(), prefix, i);
            } else if (current > node.getData()) {
                return get(node.getRight(), prefix, i);
            } else {
                if (i < prefix.length() - 1) {
                    return get(node.getEqual(), prefix, i + 1);
                } else {
                    return node;
                }
            }
        }
    }
}
