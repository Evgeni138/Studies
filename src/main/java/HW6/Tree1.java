package HW6;

public class Tree1 {
    static String str = "";
/** Метод, собирает дерево с помощью прямого обхода в строку скобочной записью, используя рекурсию*/

    static void treeToString(Node root) {
        if (root == null) {
            return;
        }
        str += root.value;

        if (root.left == null && root.right == null) {
            return;
        }

        str += "(";
        treeToString(root.left);
        str += ";";
        if (root.right != null) {
            treeToString(root.right);
            str+= ")";
        } else str += ")";

    }

    public static void main(String[] args) {
        /** Задаем структуру дерева */
        Node root = new Node("5");

        Node l1 = new Node("3");
        Node l11 = new Node("1");
        Node r12 = new Node("2");

        Node r2 = new Node("7");
        Node l21 = new Node("6");
        Node r21 = new Node("11");
        Node l221 = new Node("10");

        r2.left = l21;
        r2.right = r21;

        l1.left = l11;
        l1.right = r12;

        root.right = r2;
        root.left = l1;
        r21.left = l221;
        System.out.println("Прямой обход дерева");
        Iterr.View(root, "");
        System.out.println();
        System.out.println("Обратный обход дерева");
        Iterr.ViewBack(root, "");

        System.out.println();
        System.out.println("Центрированный обход дерева");
        Iterr.ViewIn(root, "");
        System.out.println();

        treeToString(root);
        System.out.println(str); // Вывод строки скобочной записи дерева
    }
}

class Node { /** Создаем класс Node(двухсвязный список) для построения дерева */
    public Node(String v) {
        value = v;
    }

    String value;
    Node left;
    Node right;

}

class Iterr {
    static void View(Node n, String space) { /** Метод прямого обхода дерева */
        if (n != null) {
            System.out.printf("%s%s\n", space, n.value);

            if (n.left != null) {
                View(n.left, space + "  ");
            }
            if (n.right != null) {
                View(n.right, space + "  ");
            }
        }
    }

    static void ViewBack(Node n, String space) { /** Метод обратного обхода дерева */
        if (n != null) {

            if (n.left != null) {
                ViewBack(n.left, space + "  ");
            }

            if (n.right != null) {
                ViewBack(n.right, space + "  ");
            }
            System.out.printf("%s%s\n", space, n.value);

        }
    }

    static void ViewIn(Node n, String space) { /** Метод центрированного обхода дерева */
        if (n != null) {

            if (n.left != null) {
                ViewIn(n.left, space + "  ");
            }
            System.out.printf("%s%s\n", space, n.value);

            if (n.right != null) {
                ViewIn(n.right, space + "  ");
            }

        }
    }
}


