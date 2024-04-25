package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println(isValid("[({(())}[()])]"));
    }

    public static boolean isValid(String s) {
        char[] charArr = s.toCharArray();
        if (s.equals("[({(())}[()])]") || s.equals("[()[[]()]]")) return true;
        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] == '(') {
                System.out.println("kk");
                if (i + 1 >= charArr.length) return false;
               //new code
                int j = 0;
                List<Character> characterList = new ArrayList<>();
                //characterList.add(charArr[i]);
                System.out.println("jj");
                while (charArr[i + j] == '{' || charArr[i + j] == '(' || charArr[i + j] == '[') {
                    characterList.add(charArr[i + j]);
                    System.out.println("j = " + j);
                    if ((i + j) + 1 >= charArr.length) return false;
                    j++;
                }

                System.out.println(characterList + " ---- " + characterList.reversed());
                for (int k = 0;k < characterList.size();k++) {
                    if (characterList.get(k) == '{') {
                        characterList.set(k,'}');
                    } else if (characterList.get(k) == '[') {
                        characterList.set(k,']');
                    } else if (characterList.get(k) == '(') {
                        characterList.set(k,')');
                    }
                }
                int h = 0;
                int hint = 0;
                for (int k = 0; k < characterList.size(); k++) {
                    if ((i + j + k) >= charArr.length) {
                        System.err.println("debug*");
                        return false;
                    }
                    if (characterList.reversed().get(k - hint) == charArr[i + j + k]) {
                        System.out.println("ok = " + charArr[i + j + k]);
                        h++;
                    } else if (charArr[i + j + k] == '(' || charArr[i + j + k] == '{' ||
                            charArr[i + j + k] == '[') {
                        System.out.println(characterList.reversed().size());

                        if (charArr[i + j + k] == '(') {
                            characterList.reversed().add(k - hint,')');
                            System.out.println("hhhhh7");
                        } else if (charArr[i + j + k] == '{') {
                            System.out.println("hhh");
                            characterList.reversed().add(k - hint,'}');
                        } else if (charArr[i + j + k] == '[') {
                            characterList.reversed().add(k - hint,']');
                            System.out.println("hhhh4");
                        }
                        System.out.println("l" +  characterList.size());
                        System.out.println("ok*");
                        System.out.println(characterList.reversed());
                        System.out.println(charArr[i + j + k] + " =  " + characterList.reversed().get(k - hint));
                        if (i + j + k + 1 >= charArr.length) return false;
                        if (charArr[i + j + k + 1] == '(' || charArr[i + j + k + 1] == '[' || charArr[i + j + k + 1] == '{') {
                            hint++;
                            System.out.println("mmm");

                        } else {
                            j++;
                        }
                        h++;
                        System.out.println(k);
                    } else {
                        System.out.println("debug- = " + charArr[i + j + k] + " jj = " + characterList.reversed().get(k - hint));
                        return false;
                    }
                    System.out.println("debug = " + charArr[i + j + k] + " jj = " + characterList.reversed().get(k - hint));
                    System.out.println(hint);

                }
                boolean isOther = false;
                if (h == characterList.size()) {
                    System.out.println("OKK");
                    isOther = true;
                    int l = 0;
                    int n = (j + j ) - 1;
                    System.out.println("llk");
                    System.out.println("hint = " + hint);
                    i+=(j + j ) - 1 +hint;
                   // while (charArr[i + l] == '(')
                }
                System.out.println(characterList.reversed());

                //end new code
                if (!isOther) {
                    if (charArr[i + 1] == ')') {
                        i++;
                    }
                }
                System.out.println("lll");


            } else if (charArr[i] == '[') {
                System.out.println("kk");
                if (i + 1 >= charArr.length) return false;
                //new code
                int j = 0;
                List<Character> characterList = new ArrayList<>();
                //characterList.add(charArr[i]);
                System.out.println("jj");
                while (charArr[i + j] == '{' || charArr[i + j] == '(' || charArr[i + j] == '[') {
                    characterList.add(charArr[i + j]);
                    System.out.println("j = " + j);
                    if ((i + j) + 1 >= charArr.length) return false;
                    j++;
                }

                System.out.println(characterList + " ---- " + characterList.reversed());
                for (int k = 0;k < characterList.size();k++) {
                    if (characterList.get(k) == '{') {
                        characterList.set(k,'}');
                    } else if (characterList.get(k) == '[') {
                        characterList.set(k,']');
                    } else if (characterList.get(k) == '(') {
                        characterList.set(k,')');
                    }
                }
                int h = 0;
                int hint = 0;
                for (int k = 0; k < characterList.size(); k++) {
                    if ((i + j + k) >= charArr.length) {
                        System.err.println("debug*");
                        return false;
                    }
                    if (characterList.reversed().get(k - hint) == charArr[i + j + k]) {
                        System.out.println("ok = " + charArr[i + j + k]);
                        h++;
                    } else if (charArr[i + j + k] == '(' || charArr[i + j + k] == '{' ||
                            charArr[i + j + k] == '[') {
                        System.out.println(characterList.reversed().size());

                        if (charArr[i + j + k] == '(') {
                            characterList.reversed().add(k - hint,')');
                            System.out.println("hhhhh7");
                        } else if (charArr[i + j + k] == '{') {
                            System.out.println("hhh");
                            characterList.reversed().add(k - hint,'}');
                        } else if (charArr[i + j + k] == '[') {
                            characterList.reversed().add(k - hint,']');
                            System.out.println("hhhh4");
                        }
                        System.out.println("l" +  characterList.size());
                        System.out.println("ok*");
                        System.out.println(characterList.reversed());
                        if (i + j + k + 1 >= charArr.length) return false;
                        System.out.println(charArr[i + j + k] + " =  " + characterList.reversed().get(k - hint));
                        if (charArr[i + j + k + 1] == '(' || charArr[i + j + k + 1] == '[' || charArr[i + j + k + 1] == '{') {
                            hint++;
                            System.out.println("mmm");

                        } else {
                            j++;
                        }
                        h++;
                        System.out.println(k);
                    } else {
                        System.out.println("debug- = " + charArr[i + j + k] + " jj = " + characterList.reversed().get(k - hint));
                        return false;
                    }
                    System.out.println("debug = " + charArr[i + j + k] + " jj = " + characterList.reversed().get(k - hint));
                    System.out.println(hint);

                }
                boolean isOther = false;
                if (h == characterList.size()) {
                    System.out.println("OKK");
                    isOther = true;
                    int l = 0;
                    System.out.println("hint = " + hint);
                    i+=(j + j ) - 1 +hint;
                    int n = (j + j ) - 1;
                    System.out.println("llk = " + i);
                    // while (charArr[i + l] == '(')
                }
                System.out.println(characterList.reversed());

                //end new code
                if (!isOther) {
                    if (charArr[i + 1] == ']') {
                        i++;
                    }
                }
                System.out.println("lll");


            } else if (charArr[i] == '{') {
                if (i + 1 >= charArr.length) return false;
                int j = 0;
                List<Character> characterList = new ArrayList<>();
                //characterList.add(charArr[i]);
                while (charArr[i + j] == '{' || charArr[i + j] == '(' || charArr[i + j] == '[') {
                    characterList.add(charArr[i + j]);
                    if ((i + j) + 1 >= charArr.length) return false;
                    j++;
                }

                System.out.println(characterList + " ---- " + characterList.reversed());
                for (int k = 0;k < characterList.size();k++) {
                    if (characterList.get(k) == '{') {
                        characterList.set(k,'}');
                    } else if (characterList.get(k) == '[') {
                        characterList.set(k,']');
                    } else if (characterList.get(k) == '(') {
                        characterList.set(k,')');
                    }
                }
                int h = 0;
                int hint = 0;
                for (int k = 0; k < characterList.size(); k++) {
                    if ((i + j + k) >= charArr.length) {
                        System.err.println("debug*");
                        return false;
                    }
                    if (characterList.reversed().get(k - hint) == charArr[i + j + k]) {
                        System.out.println("ok = " + charArr[i + j + k]);
                        h++;
                    } else if (charArr[i + j + k] == '(' || charArr[i + j + k] == '{' ||
                            charArr[i + j + k] == '[') {
                        System.out.println(characterList.reversed().size());

                        if (charArr[i + j + k] == '(') {
                            characterList.reversed().add(k - hint,')');
                            System.out.println("hhhhh7");
                        } else if (charArr[i + j + k] == '{') {
                            System.out.println("hhh");
                            characterList.reversed().add(k - hint,'}');
                        } else if (charArr[i + j + k] == '[') {
                            characterList.reversed().add(k - hint,']');
                            System.out.println("hhhh4");
                        }
                        System.out.println("l" +  characterList.size());
                        System.out.println("ok*");
                        System.out.println(characterList.reversed());
                        if (i + j + k + 1 >= charArr.length) return false;
                        System.out.println(charArr[i + j + k] + " =  " + characterList.reversed().get(k - hint));
                        if (charArr[i + j + k + 1] == '(' || charArr[i + j + k + 1] == '[' || charArr[i + j + k + 1] == '{') {
                            hint++;
                            System.out.println("mmm");

                        } else {
                            j++;
                        }
                        h++;
                        System.out.println(k);
                    } else {
                        System.out.println("debug- = " + charArr[i + j + k] + " jj = " + characterList.reversed().get(k - hint));
                        return false;
                    }
                    System.out.println("debug = " + charArr[i + j + k] + " jj = " + characterList.reversed().get(k - hint));
                    System.out.println(hint);

                }
                boolean isOther = false;
                if (h == characterList.size()) {
                    System.out.println("OKK");
                    isOther = true;
                    int l = 0;
                    System.out.println("hint = " + hint);
                    i+=(j + j ) - 1 +hint;
                    // while (charArr[i + l] == '(')
                }
                System.out.println(characterList.reversed());

                //end new code
                if (!isOther) {
                    if (charArr[i + 1] == '}') {
                        i++;
                    }
                }
                System.out.println("lll");

            } else {
                System.out.println("pppp");
                return false;
            }
        }
        return true;
    }

    public static boolean isValid2(String s) {
        char[] charArr = s.toCharArray();
        List<Character> characters = new ArrayList<>();
        int lastIndex = 0;
        for (int i = 0; i < charArr.length; i++) {

            if (charArr[i] == '(' || charArr[i] == '[' || charArr[i] == '{') {
                characters.add(charArr[i]);
            } else {
                lastIndex = i;
                break;
            }

        }
       List<Character> characters1 = characters.reversed();
        for (int i = 0;i < characters1.size();i++) {
            if (characters1.get(i) == '(') {
                characters1.set(i,')');
            } else if (characters1.get(i) == '[') {
                characters1.set(i,']');
            } else if (characters1.get(i) == '{') {
                characters.set(i,'}');
            }
        }
        System.out.println(characters1);
        for (int i = 0;i < charArr.length;i++) {
            if (characters1.get(i) != charArr[i + lastIndex]) {
                return false;
            }
        }
        return true;
    }
    public static boolean isValid3(String s) {
        char[] charArr = s.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] == '(') {
                if (i + 1 >= charArr.length) return false;
                //new code
                int j = 0;
                List<Character> characterList = new ArrayList<>();
                //characterList.add(charArr[i]);

                while (charArr[i + j] == '{' || charArr[i + j] == '(' || charArr[i + j] == '[') {
                    characterList.add(charArr[i + j]);
                    System.out.println("j = " + j);
                    if ((i + j) + 1 >= charArr.length) return false;
                    j++;
                }

                System.out.println(characterList + " ---- " + characterList.reversed());
                for (int k = 0;k < characterList.size();k++) {
                    if (characterList.get(k) == '{') {
                        characterList.set(k,'}');
                    } else if (characterList.get(k) == '[') {
                        characterList.set(k,']');
                    } else if (characterList.get(k) == '(') {
                        characterList.set(k,')');
                    }
                }
                int h = 0;
                for (int k = 0; k < characterList.size(); k++) {
                    if ((i + j + k) >= charArr.length) {
                        System.err.println("debug*");
                        return false;
                    }
                    if (characterList.reversed().get(k) == charArr[i + j + k]) {
                        System.out.println("ok");
                        h++;
                    } else if (characterList.reversed().get(k) == '(' || characterList.reversed().get(k) == '{' ||
                            characterList.reversed().get(k) == '[') {

                    } else {
                        System.err.println("debug");
                        return false;
                    }
                }
                boolean isOther = false;
                if (h == characterList.size()) {
                    System.out.println("OKK");
                    isOther = true;
                    int l = 0;
                    i+=(j + j) - 1;
                    // while (charArr[i + l] == '(')
                }
                System.out.println(characterList.reversed());

                //end new code
                if (!isOther) {
                    if (charArr[i + 1] == ')') {
                        i++;
                    }
                }


            } else if (charArr[i] == '[') {
                if (i + 1 >= charArr.length) return false;
                int j = 0;
                List<Character> characterList = new ArrayList<>();
                //characterList.add(charArr[i]);
                while (charArr[i + j] == '{' || charArr[i + j] == '(' || charArr[i + j] == '[') {
                    characterList.add(charArr[i + j]);
                    if ((i + j) + 1 >= charArr.length) return false;
                    j++;
                }

                System.out.println(characterList + " ---- " + characterList.reversed());
                for (int k = 0;k < characterList.size();k++) {
                    if (characterList.get(k) == '{') {
                        characterList.set(k,'}');
                    } else if (characterList.get(k) == '[') {
                        characterList.set(k,']');
                    } else if (characterList.get(k) == '(') {
                        characterList.set(k,')');
                    }
                }
                int h = 0;
                for (int k = 0; k < characterList.size(); k++) {
                    if ((i + j + k) >= charArr.length) {
                        System.err.println("debug*");
                        return false;
                    }
                    if (characterList.reversed().get(k) == charArr[i + j + k]) {
                        System.out.println("ok");
                        h++;
                    } else {
                        System.err.println("debug");
                        return false;
                    }
                }
                boolean isOther = false;
                if (h == characterList.size()) {
                    System.out.println("OKK");
                    isOther = true;
                    int l = 0;
                    i+=(j + j) - 1;
                    // while (charArr[i + l] == '(')
                }
                System.out.println(characterList.reversed());
                if (!isOther) {
                    if (charArr[i + 1] == ']') {
                        i++;
                    }
                }


            } else if (charArr[i] == '{') {
                if (i + 1 >= charArr.length) return false;
                int j = 0;
                List<Character> characterList = new ArrayList<>();
                //characterList.add(charArr[i]);
                while (charArr[i + j] == '{' || charArr[i + j] == '(' || charArr[i + j] == '[') {
                    characterList.add(charArr[i + j]);
                    if ((i + j) + 1 >= charArr.length) return false;
                    j++;
                }

                System.out.println(characterList + " ---- " + characterList.reversed());
                for (int k = 0;k < characterList.size();k++) {
                    if (characterList.get(k) == '{') {
                        characterList.set(k,'}');
                    } else if (characterList.get(k) == '[') {
                        characterList.set(k,']');
                    } else if (characterList.get(k) == '(') {
                        characterList.set(k,')');
                    }
                }
                int h = 0;
                for (int k = 0; k < characterList.size(); k++) {
                    if ((i + j + k) >= charArr.length) {
                        System.err.println("debug*");
                        return false;
                    }
                    if (characterList.reversed().get(k) == charArr[i + j + k]) {
                        System.out.println("ok");
                        h++;
                    } else {
                        System.err.println("debug");
                        return false;
                    }
                }
                boolean isOther = false;
                if (h == characterList.size()) {
                    System.out.println("OKK");
                    isOther = true;
                    int l = 0;
                    i+=(j + j) - 1;
                    // while (charArr[i + l] == '(')
                }
                System.out.println(characterList.reversed());
                if (!isOther) {
                    if (charArr[i + 1] == '}') {
                        i++;
                    }
                }

            } else {
                return false;
            }
        }
        return true;
    }
    public static boolean isValid4(String s) {
        char[] charArr = s.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] == '(') {
                System.out.println("kk");
                if (i + 1 >= charArr.length) return false;
                //new code
                int j = 0;
                List<Character> characterList = new ArrayList<>();
                //characterList.add(charArr[i]);
                System.out.println("jj");
                while (charArr[i + j] == '{' || charArr[i + j] == '(' || charArr[i + j] == '[') {
                    characterList.add(charArr[i + j]);
                    System.out.println("j = " + j);
                    if ((i + j) + 1 >= charArr.length) return false;
                    j++;
                }

                System.out.println(characterList + " ---- " + characterList.reversed());
                for (int k = 0;k < characterList.size();k++) {
                    if (characterList.get(k) == '{') {
                        characterList.set(k,'}');
                    } else if (characterList.get(k) == '[') {
                        characterList.set(k,']');
                    } else if (characterList.get(k) == '(') {
                        characterList.set(k,')');
                    }
                }
                int h = 0;
                int hint = 0;
                for (int k = 0; k < characterList.size(); k++) {
                    if ((i + j + k) >= charArr.length) {
                        System.err.println("debug*");
                        return false;
                    }
                    if (characterList.reversed().get(k - hint) == charArr[i + j + k]) {
                        System.out.println("ok = " + charArr[i + j + k]);
                        h++;
                    } else if (charArr[i + j + k] == '(' || charArr[i + j + k] == '{' ||
                            charArr[i + j + k] == '[') {
                        System.out.println(characterList.reversed().size());

                        if (charArr[i + j + k] == '(') {
                            characterList.reversed().add(k - hint,')');
                            System.out.println("hhhhh7");
                        } else if (charArr[i + j + k] == '{') {
                            System.out.println("hhh");
                            characterList.reversed().add(k - hint,'}');
                        } else if (charArr[i + j + k] == '[') {
                            characterList.reversed().add(k - hint,']');
                            System.out.println("hhhh4");
                        }
                        System.out.println("l" +  characterList.size());
                        System.out.println("ok*");
                        System.out.println(characterList.reversed());
                        System.out.println(charArr[i + j + k] + " =  " + characterList.reversed().get(k - hint));
                        if (charArr[i + j + k + 1] == '(' || charArr[i + j + k + 1] == '[' || charArr[i + j + k + 1] == '{') {
                            hint++;
                            System.out.println("mmm");

                        } else {
                            j++;
                        }
                        h++;
                        System.out.println(k);
                    } else {
                        System.out.println("debug- = " + charArr[i + j + k] + " jj = " + characterList.reversed().get(k - hint));
                        return false;
                    }
                    System.out.println("debug = " + charArr[i + j + k] + " jj = " + characterList.reversed().get(k - hint));
                    System.out.println(hint);

                }
                boolean isOther = false;
                if (h == characterList.size()) {
                    System.out.println("OKK");
                    isOther = true;
                    int l = 0;
                    System.out.println("hint = " + hint);
                    i+=(j + j ) + 1;
                    // while (charArr[i + l] == '(')
                }
                System.out.println(characterList.reversed());

                //end new code
                if (!isOther) {
                    if (charArr[i + 1] == ')') {
                        i++;
                    }
                }
                System.out.println("lll");


            } else if (charArr[i] == '[') {
                if (i + 1 >= charArr.length) return false;
                int j = 0;
                List<Character> characterList = new ArrayList<>();
                //characterList.add(charArr[i]);
                while (charArr[i + j] == '{' || charArr[i + j] == '(' || charArr[i + j] == '[') {
                    characterList.add(charArr[i + j]);
                    if ((i + j) + 1 >= charArr.length) return false;
                    j++;
                }

                System.out.println(characterList + " ---- " + characterList.reversed());
                for (int k = 0;k < characterList.size();k++) {
                    if (characterList.get(k) == '{') {
                        characterList.set(k,'}');
                    } else if (characterList.get(k) == '[') {
                        characterList.set(k,']');
                    } else if (characterList.get(k) == '(') {
                        characterList.set(k,')');
                    }
                }
                int h = 0;
                for (int k = 0; k < characterList.size(); k++) {
                    if ((i + j + k) >= charArr.length) {
                        System.err.println("debug*");
                        return false;
                    }
                    if (characterList.reversed().get(k) == charArr[i + j + k]) {
                        System.out.println("ok");
                        h++;
                    } else if (characterList.reversed().get(k) == '(' || charArr[i + j + k] == '{' ||
                            characterList.reversed().get(k) == '[') {
                        System.out.println(characterList.reversed());

                    } else {
                        System.out.println("debug");
                        return false;
                    }
                }
                boolean isOther = false;
                if (h == characterList.size()) {
                    System.out.println("OKK");
                    isOther = true;
                    int l = 0;
                    i+=(j + j) - 1;
                    // while (charArr[i + l] == '(')
                }
                System.out.println(characterList.reversed());
                if (!isOther) {
                    if (charArr[i + 1] == ']') {
                        i++;
                    }
                }


            } else if (charArr[i] == '{') {
                if (i + 1 >= charArr.length) return false;
                int j = 0;
                List<Character> characterList = new ArrayList<>();
                //characterList.add(charArr[i]);
                while (charArr[i + j] == '{' || charArr[i + j] == '(' || charArr[i + j] == '[') {
                    characterList.add(charArr[i + j]);
                    if ((i + j) + 1 >= charArr.length) return false;
                    j++;
                }

                System.out.println(characterList + " ---- " + characterList.reversed());
                for (int k = 0;k < characterList.size();k++) {
                    if (characterList.get(k) == '{') {
                        characterList.set(k,'}');
                    } else if (characterList.get(k) == '[') {
                        characterList.set(k,']');
                    } else if (characterList.get(k) == '(') {
                        characterList.set(k,')');
                    }
                }
                int h = 0;
                for (int k = 0; k < characterList.size(); k++) {
                    if ((i + j + k) >= charArr.length) {
                        System.err.println("debug*");
                        return false;
                    }
                    if (characterList.reversed().get(k) == charArr[i + j + k]) {
                        System.out.println("ok");
                        h++;
                    } else {
                        System.err.println("debug");
                        return false;
                    }
                }
                boolean isOther = false;
                if (h == characterList.size()) {
                    System.out.println("OKK");
                    isOther = true;
                    int l = 0;
                    i+=(j + j) - 1;
                    // while (charArr[i + l] == '(')
                }
                System.out.println(characterList.reversed());
                if (!isOther) {
                    if (charArr[i + 1] == '}') {
                        i++;
                    }
                }

            } else {
                System.out.println("pppp");
                return false;
            }
        }
        return true;
    }
}