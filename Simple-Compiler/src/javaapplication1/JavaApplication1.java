/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Batoo
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static boolean isOperator(char x) {
        if (x == '=' || x == '/' || x == '*' || x == '-' || x == '+') {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isR(String x) {
        if (x.charAt(0) == 'R') {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isDigit1(String x) {
        if (x.equals("0") || x.equals("1") || x.equals("2") || x.equals("3") || x.equals("4") || x.equals("5") || x.equals("6") || x.equals("7") || x.equals("8") || x.equals("9")) {
            return true;
        } else {
            return false;
        }
    }

//    public static boolean exist1(LinkedList y, String x) {
//        for (int i = 0; i < y.size(); i++) {
//            if (y.get(i).equals(x)) {
//                return true;
//            }
//
//        }
//        return false;
//    }
    public static ArrayList exist(LinkedList y) {
        ArrayList<String> arr = new ArrayList<>();

        for (int i = 0; i < y.size(); i++) {
            for (int j = 0; j < y.size(); j++) {
                if (y.get(i).equals("+") || y.get(i).equals("-") || y.get(i).equals("*") || y.get(i).equals("/")) {
                    break;
                } //[id1, =, id3, +, id2, id4, *, id3]
                else if (j != i) {
                    if (y.get(i).equals(y.get(j)) && arr.contains(y.get(i)) == false) {
                        arr.add((String) y.get(i));
                    } else {
                        continue;
                    }
//                }
//                else {
//                    continue;
                }
            }

        }

        return arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("please enter Expression");
        String exp = sc.nextLine();
        ArrayList<String> exp1 = new ArrayList();
        int counter = 1;
        String la = "";
        for (int i = 0; i < exp.length(); i++) {
            if (exp.charAt(i) == 'p' && exp.charAt(i + 1) == 'o' && exp.charAt(i + 2) == 'w') {
                char test = exp.charAt(i + 6);
                String num1 = String.valueOf(test);
                int omar = Integer.parseInt(num1);
                String test1 = "";
                for (int k = 0; k < omar; k++) {
                    test1 += exp.charAt(i + 4);
                    if (k != omar - 1) {
                        test1 += '*';
                    }
                }

                String test2 = "";
                for (int x = 0; x < test1.length(); x++) {
                    if (test1.charAt(x) >= 'a' && test1.charAt(x) <= 'z' || test1.charAt(x) >= 'A' && test1.charAt(x) <= 'Z') {
                        test2 += "id" + counter;

                        counter++;
                    } else if (test1.charAt(x) == ' ') {
                        continue;
                    } else {
                        test2 += test1.charAt(x);
                    }
                }
                exp1.add(test2);
                i = i + 7;
            } else if (exp.charAt(i) == 'p' && exp.charAt(i + 1) == 'i' || exp.charAt(i) == 'P' && exp.charAt(i + 1) <= 'I') {
                exp1.add("3.14");
                i += 1;
            } //        else if(exp.charAt(i) == 'p' && exp.charAt(i+1) == 'i' ){
            //            exp1.add("3.14");
            //            i+=2;
            //            
            //        }
            else if (exp.charAt(i) == 's' && exp.charAt(i + 1) == 'q' && exp.charAt(i + 2) == 'r' && exp.charAt(i + 3) == 't') {

                exp1.add(Integer.toString((int) Math.sqrt(Integer.parseInt(String.valueOf(exp.charAt((i + 5)))))));

                i = i + 6;
            } else if (exp.charAt(i) >= 'a' && exp.charAt(i) <= 'z' || exp.charAt(i) >= 'A' && exp.charAt(i) <= 'Z') {
                exp1.add("id" + counter);
//                exp1.add(counter+"");
                counter++;
            } else if (exp.charAt(i) == ' ') {
                continue;
            } else {
                exp1.add(exp.charAt(i) + "");
            }
        }

        for (int i = 0; i < exp1.size(); i++) {
            la += exp1.get(i);
        }
        System.out.println("");
        System.out.println("Lexical Analyzer:");
        System.out.println(la);

        LinkedList<String> op = new LinkedList<String>();
        LinkedList<String> id = new LinkedList<String>();
        char op1 = ' ';
        for (int i = 0; i < la.length(); i++) {
            if (la.charAt(i) == '*' || la.charAt(i) == '/') {
                op1 = la.charAt(i);
                int x = i - 1;
                int s = i + 1;
                String y = "";
                String z = "";

                while (!isOperator(la.charAt(x))) {
                    y += String.valueOf(la.charAt(x));
                    x--;

                }
                x = i - 1;
                while (!isOperator(la.charAt(s))) {
                    z += String.valueOf(la.charAt(s));
                    s++;
                    if (s >= la.length()) {
                        break;
                    }
                }
                StringBuilder sb = new StringBuilder(y);
                y = sb.reverse() + "";

                id.add(z);

                id.add(op1 + "");

                id.add(y);

            } else if (la.charAt(i) == '+' || la.charAt(i) == '-') {
                op1 = la.charAt(i);
                int x = i - 1;
                String y = "";
                String z = "";
                int s = i + 1;
                while (!isOperator(la.charAt(x))) {

                    y += String.valueOf(la.charAt(x));
                    x--;

                }

                while (!isOperator(la.charAt(s))) {
                    z += String.valueOf(la.charAt(s));
                    s++;
                    if (s >= la.length()) {
                        break;
                    }
                }
                StringBuilder sb = new StringBuilder(y);
                y = sb.reverse() + "";

                id.addFirst(y);

                id.addFirst(op1 + "");

                id.addFirst(z);

            }

        }

        for (int i = 0; i < la.length(); i++) {
            if (la.charAt(i) == '=') {
                op1 = '=';
                String x = String.valueOf(la.charAt(0)) + la.charAt(1) + la.charAt(2);
                id.addFirst(op1 + "");
                id.addFirst(x);

            }
        }

        ArrayList<String> arr = new ArrayList<>();
        arr = exist(id);
        int arrindex = 0;

        for (int i = 0; i < id.size(); i++) {
            if (isOperator(id.get(i).charAt(0))) {
                op.add(id.get(i));
//                       id.remove(i);

            }
        }
        boolean opcond = false;
        String opsymbol = "";
        String acc = op.get(1);

        for (int i = 1; i < op.size(); i++) {
            if (op.get(i).equals(acc)) {
                opcond = true;
                opsymbol = op.get(i);
            } else {
                opcond = false;
                opsymbol = null;
                break;

            }

        }

        if (opcond == true) {
            for (int i = 0; i < arr.size(); i++) {
                for (int j = 0; j < id.size(); j++) {
                    if (id.get(j) == arr.get(i)) {
                        if (j == 0) {
                            continue;

                        } else if (j == id.size() - 1) {
                            if (id.get(j - 1).equals(opsymbol)) {
                                id.remove(j);
                            } else {
                                continue;
                            }
                        } else {
                            if (id.get(j + 1).equals(opsymbol) || id.get(j - 1).equals(opsymbol)) {
                                id.remove(j);
                            } else {
                                continue;
                            }

                        }
                    }
                }
            }

            for (int i = 0; i < id.size(); i++) {
                if (i != 0 && id.get(i).equals("=") && isOperator(id.get(i + 1).charAt(0))) {

                    String temp = id.get(i + 1);
                    id.set(i + 1, id.get(i + 2));
                    id.set(i + 2, temp);

                }
                if (i == 0) {
                    continue;
                } else if (i == id.size() - 1) {

                } else if (id.get(i - 1).equals(opsymbol) && !isOperator(id.get(i + 1).charAt(0))) {
                    String temp = id.get(i - 1);
                    id.set(i - 1, id.get(i));
                    id.set(i, temp);
                } else if (id.get(i + 1).equals(opsymbol) && !isOperator(id.get(i - 1).charAt(0))) {
                    String temp = id.get(i + 1);
                    id.set(i + 1, id.get(i));
                    id.set(i, temp);
                }
            }

        } else {

            for (int i = 0; i < arr.size(); i++) {
                for (int j = 0; j < id.size(); j++) {
                    if (id.get(j) == arr.get(i)) {
                        if (j == 0) {
                            continue;

                        } else if (j == id.size() - 1) {
                            if (id.get(j - 1).equals("+") || id.get(j - 1).equals("-")) {
                                id.remove(j);
                            } else {
                                continue;
                            }
                        } else {
                            if (id.get(j + 1).equals("+") || id.get(j - 1).equals("+") || id.get(j + 1).equals("-") || id.get(j - 1).equals("-")) {
                                id.remove(j);
                            } else {
                                continue;
                            }

                        }
                    }
                }
            }

            for (int i = 0; i < id.size(); i++) {
                if (i != 0 && id.get(i).equals("=") && isOperator(id.get(i + 1).charAt(0))) {
                    String temp = id.get(i + 1);
                    id.set(i, id.get(i + 2));
                    id.set(i + 2, temp);

                }
                if (i == 0) {
                    continue;
                } else if (i == id.size() - 1) {

                } else if (id.get(i - 1).equals("+") && !isOperator(id.get(i + 1).charAt(0)) || id.get(i - 1).equals("-") && !isOperator(id.get(i + 1).charAt(0))) {
                    String temp = id.get(i - 1);
                    id.set(i - 1, id.get(i));
                    id.set(i, temp);
                } else if (id.get(i + 1).equals("+") && !isOperator(id.get(i - 1).charAt(0)) || id.get(i + 1).equals("-") && !isOperator(id.get(i - 1).charAt(0))) {
                    String temp = id.get(i + 1);
                    id.set(i + 1, id.get(i));
                    id.set(i, temp);
                }
            }

        }

        for (int i = 0; i < id.size(); i++) {
            if (isOperator(id.get(i).charAt(0))) {
                id.remove(i);

            }
        }

        int omar = id.size() + op.size();
        LinkedList<String> id2 = new LinkedList();
        LinkedList<String> op2 = new LinkedList();

        for (int i = 0; i < id.size(); i++) {
            id2.add(id.get(i));
        }

        for (int i = 0; i < op.size(); i++) {
            op2.add(op.get(i));
        }
        System.out.println("");
        System.out.println("Syntax Tree:");
        for (int i = 0; i < omar; i++) {

            if (i == 0) {
                System.out.println("            " + op.get(0));
                System.out.println("           /" + "  \\  ");
                System.out.println("          /" + "    \\  ");
                op.remove(0);
            } else if (op.size() == 0 && id.size() == 2) {
                System.out.println("          " + id.get(0) + "         " + id.get(1));

                id.remove(0);
                id.remove(0);
                break;

            } else {
                if ((id.size() + op.size()) % 2 == 0) {
                    System.out.println("        " + id.get(0) + "       " + op.get(0));
                    System.out.println("               /" + "    \\  ");
                    System.out.println("              /" + "      \\  ");
                    op.remove(0);
                    id.remove(0);
                } else {
                    System.out.println("        " + id.get(0) + "         " + id.get(1));
                    System.out.println("               /" + "    \\  ");
                    System.out.println("              /" + "      \\  ");
                    id.remove(0);
                    id.remove(1);

                }

            }

        }
        System.out.println(id2);

        for (int i = 0; i < id2.size(); i++) {
            if (isDigit1(id2.get(i))) {
                id2.set(i, "int2float(" + id2.get(i) + ".0)");
//                    (i, "int2float("+id2.get(i)+")");
            }

        }

        LinkedList<String> icg = new LinkedList();
        LinkedList<String> icgop = new LinkedList();
        LinkedList<String> cg = new LinkedList();
        LinkedList<String> cgo = new LinkedList();
        for (int i = 0; i < id2.size(); i++) {
            cg.add(id2.get(i));
        }
        for (int i = 0; i < op2.size(); i++) {
            cgo.add(op2.get(i));
        }

        for (int i = id2.size() - 1; i >= 0; i--) {
            icg.add(id2.get(i));
        }
        for (int i = op2.size() - 1; i >= 0; i--) {
            icgop.add(op2.get(i));
        }

        LinkedList<String> co = new LinkedList<>();
        LinkedList<String> coop = new LinkedList<>();
        for (int i = 0; i < id2.size(); i++) {
            co.add(icg.get(i));
        }
        for (int i = 0; i < icgop.size(); i++) {
            coop.add(icgop.get(i));
        }

        int omar1 = id2.size() + op2.size();
        System.out.println("");
        System.out.println("Semantic Tree:");
        for (int i = 0; i < omar1; i++) {

            if (i == 0) {
                System.out.println("            " + op2.get(0));
                System.out.println("           /" + "  \\  ");
                System.out.println("          /" + "    \\  ");
                op2.remove(0);
            } else if (op2.size() == 0 && id2.size() == 2) {
                System.out.println("          " + id2.get(0) + "         " + id2.get(1));

                id2.remove(0);
                id2.remove(0);
                break;

            } else {
                if ((id2.size() + op2.size()) % 2 == 0) {
                    System.out.println("        " + id2.get(0) + "       " + op2.get(0));
                    System.out.println("               /" + "    \\  ");
                    System.out.println("              /" + "      \\  ");
                    op2.remove(0);
                    id2.remove(0);
                } else {
                    System.out.println("        " + id2.get(0) + "         " + id2.get(1));
                    System.out.println("               /" + "    \\  ");
                    System.out.println("              /" + "      \\  ");
                    id2.remove(0);
                    id2.remove(1);

                }

            }

        }
        System.out.println("");
        System.out.println("ICG");

        LinkedList<String> icgf = new LinkedList();
        LinkedList<String> cof = new LinkedList();

        int counter1 = 1;

        for (int i = 0; i < icg.size(); i++) {
            if (icg.get(i).charAt(0) == 'i' && icg.get(i).charAt(1) == 'n' && icg.get(i).charAt(2) == 't' && icg.get(i).charAt(3) == '2') {
                icgf.addFirst("t" + Integer.toString(counter1) + " = " + icg.get(i));
                icg.set(i, "t" + Integer.toString(counter1));
                counter1++;
            }

        }

        while (icg.size() > 1) {

            String p = "";
            p = "t" + Integer.toString(counter1) + " = " + icg.get(0) + " " + icgop.get(0) + " " + icg.get(1);
            icg.remove(0);
            icg.remove(0);
            icgop.remove(0);
            icg.addFirst("t" + Integer.toString(counter1));
            icgf.add(p);
            counter1++;
            if (icg.size() == 2) {
                icgf.add(icg.get(icg.size() - 1) + " = " + icg.get(0));
                break;

            }

        }

        for (int i = 0; i < icgf.size(); i++) {
            System.out.println(icgf.get(i));

        }

        for (int i = 0; i < co.size(); i++) {
            if (co.get(i).charAt(0) == 'i' && co.get(i).charAt(1) == 'n' && co.get(i).charAt(2) == 't' && co.get(i).charAt(3) == '2') {
//            icgf.addFirst("t"+Integer.toString(counter1)+" = "+icg.get(i));
                String n = "";
                n = String.valueOf(co.get(i).charAt(10)) + String.valueOf(co.get(i).charAt(11)) + String.valueOf(co.get(i).charAt(12));
                co.set(i, n);

            }

        }
        int counter2 = 1;
        while (co.size() > 1) {

            String p = "";
            p = "t" + Integer.toString(counter2) + " = " + co.get(0) + " " + coop.get(0) + " " + co.get(1);
            co.remove(0);
            co.remove(0);
            coop.remove(0);
            co.addFirst("t" + Integer.toString(counter2));
            cof.add(p);
            counter2++;
            if (co.size() == 3) {
                cof.add(co.get(co.size() - 1) + " = " + co.get(0) + " " + coop.get(0) + " " + co.get(1));
                break;

            }

        }
        System.out.println("");
        System.out.println("Code Optemizer");
        for (int i = 0; i < cof.size(); i++) {
            System.out.println(cof.get(i));

        }

    

        LinkedList<String> cgacc = new LinkedList();
        for (int i = 0; i < cgo.size(); i++) {
            if (cgo.get(i).equals("=")) {
                cgo.set(i, "STR");

            } else if (cgo.get(i).equals("*")) {
                cgo.set(i, "MUL");

            } else if (cgo.get(i).equals("/")) {
                cgo.set(i, "DIV");

            } else if (cgo.get(i).equals("-")) {
                cgo.set(i, "SUB");

            } else if (cgo.get(i).equals("+")) {
                cgo.set(i, "ADD");

            }
        }
        while (cg.size() > 0) {
            cgacc.add(cg.get(0));
            cg.remove(0);
            if (cgo.size() > 0) {
                cgacc.add(cgo.get(0));
                cgo.remove(0);
            }

        }

        Collections.reverse(cgacc);
        LinkedList<String> cont = new LinkedList();
        LinkedList<String> mansour = new LinkedList();
        LinkedList<String> accum = new LinkedList();
        accum.add("R2");
        int r = 0;  // odd==r1 even = r2
        String mans = "R2";
        int man = 0;
        String mok = "";
//[id1, STR, id5, ADD, id2, ADD, id4, MUL, id3]
        while (cgacc.size() > 1) {
            if (!cont.contains(cgacc.get(0)) && !Character.isDigit(cgacc.get(0).charAt(0)) && !isR(cgacc.get(0))) {
                if (cgacc.size() == 3) {
                } else {
                    if (accum.get(0).equals(mok)) {
                        accum.remove(0);
                        r++;
                        if (r % 2 == 0) {
                            accum.add("R2");
                        } else {
                            accum.add("R1");
                        }
                    }
                    mansour.add("LDA " + accum.get(0) + " , " + cgacc.get(0));
                    cgacc.set(0, accum.get(0));
                    cont.add(cgacc.get(0));

                    accum.remove(0);
                    r++;
                    if (r % 2 == 0) {
                        accum.add("R2");
                    } else {
                        accum.add("R1");
                    }

                    if (!cont.contains(cgacc.get(0 + 2)) && !isR(cgacc.get(0 + 2))) {
                        if (accum.get(0).equals(mok)) {
                            accum.remove(0);
                            r++;
                            if (r % 2 == 0) {
                                accum.add("R2");
                            } else {
                                accum.add("R1");
                            }
                        }
                        mansour.add("LDA " + accum.get(0) + " , " + cgacc.get(0 + 2));
                        cgacc.set(0 + 2, accum.get(0));
                        cont.add(cgacc.get(0 + 2));
                        accum.remove(0);
                        r++;
                        if (r % 2 == 0) {
                            accum.add("R2");
                        } else {
                            accum.add("R1");
                        }
                    }

                }
            }

            if (!cont.contains(cgacc.get(0 + 2)) && !Character.isDigit(cgacc.get(0 + 2).charAt(0)) && !isR(cgacc.get(0 + 2))) {
                if (cgacc.size() == 3) {
                } else {
                    if (accum.get(0).equals(mok)) {
                        accum.remove(0);
                        r++;
                        if (r % 2 == 0) {
                            accum.add("R2");
                        } else {
                            accum.add("R1");
                        }
                    }
                    mansour.add("LDA " + accum.get(0) + " , " + cgacc.get(0 + 2));
                    cgacc.set(0 + 2, accum.get(0));
                    cont.add(cgacc.get(0 + 2));
                    accum.remove(0);
                    r++;
                    if (r % 2 == 0) {
                        accum.add("R2");
                    } else {
                        accum.add("R1");
                    }

                }
            }
            if (cgacc.size() == 3) {
                mansour.add(cgacc.get(0 + 1) + " " + cgacc.get(0 + 2) + " , " + cgacc.get(0));
                cgacc.remove(0);
                cgacc.remove(0);
                cgacc.remove(0);
            } else {
                mansour.add(cgacc.get(0 + 1) + " " + mans + " , " + cgacc.get(0) + " , " + cgacc.get(0 + 2));

                cgacc.remove(0);
                cgacc.remove(0);
                cgacc.remove(0);
                cgacc.addFirst(mans);
                mok = mans;
                man++;
                if (man % 2 == 0) {
                    mans = "R2";
                } else {
                    mans = "R1";
                }

            }
        }
        System.out.println("");
        System.out.println("Code Generation");
        for (int i = 0; i < mansour.size(); i++) {
            System.out.println(mansour.get(i));

        }

    }
}
