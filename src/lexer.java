import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static java.lang.System.exit;

public class lexer {
    public static String tokenstr = "";
    public static char ch;

    public static void main(String[] args) {
        try {
            BufferedReader in = new BufferedReader(new FileReader(args[0]));

            String para;
            while ((para = in.readLine()) != null) {
                int i = 0;
                while (i < para.length()) {
                    ch = para.charAt(i);
                    if (ch == 9 || ch == 10 || ch == 13 || ch == 32) i++;
                    else if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                        tokenstr += ch;
                        while (++i < para.length()) {
                            ch = para.charAt(i);
                            if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9')) {
                                tokenstr += ch;
                            } else break;
                        }
                        if (tokenstr.equals("BEGIN")) System.out.println("Begin");
                        else if (tokenstr.equals("END")) System.out.println("End");
                        else if (tokenstr.equals("FOR")) System.out.println("For");
                        else if (tokenstr.equals("IF")) System.out.println("If");
                        else if (tokenstr.equals("THEN")) System.out.println("Then");
                        else if (tokenstr.equals("ELSE")) System.out.println("Else");
                        else System.out.println("Ident(" + tokenstr + ")");
                        tokenstr = "";
                    } else if (ch >= '0' && ch <= '9') {
                        tokenstr += ch;
                        while (++i < para.length()) {
                            ch = para.charAt(i);
                            if (ch >= '0' && ch <= '9') {
                                tokenstr += ch;
                            } else break;
                        }
                        System.out.println("Int(" + Integer.valueOf(tokenstr) + ")");
                        tokenstr = "";
                    } else if (ch == ':') {
                        if (++i < para.length() && para.charAt(i) == '=') {
                            System.out.println("Assign");
                            i++;
                        } else System.out.println("Colon");
                    } else if (ch == '+') {
                        System.out.println("Plus");
                        i++;
                    } else if (ch == '*') {
                        System.out.println("Star");
                        i++;
                    } else if (ch == ',') {
                        System.out.println("Comma");
                        i++;
                    } else if (ch == '(') {
                        System.out.println("LParenthesis");
                        i++;
                    } else if (ch == ')') {
                        System.out.println("RParenthesis");
                        i++;
                    } else {
                        System.out.println("Unknown");
                        exit(0);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
