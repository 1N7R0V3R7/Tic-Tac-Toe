import java.util.*;
public class Board {
    String userState;
    String jvmState;
    boolean winnerFlag;
    int size = 0;
    //  Index VS Character
    // X -> 1 && O -> 0
    // false -> Player 
    HashMap<Integer, String> map = new HashMap<>();
    public Board(String state) {
        this.userState = state;
        this.jvmState = (userState.equals("X")) ? "O" : "X";
    }
    public String getValue(int key) {
        if(map.containsKey(key))
            return " " + map.get(key) + " ";
        return "   ";
    }
    public void display() {
        System.out.println(getValue(1) + "|" + getValue(2) + "|" + getValue(3));
        System.out.println("---+---+---");
        System.out.println(getValue(4) + "|" + getValue(5) + "|" + getValue(6));
        System.out.println("---+---+---");
        System.out.println(getValue(7) + "|" + getValue(8) + "|" + getValue(9));
    }
    public int getJVMMove() {
        int temp = (int)Math.round(Math.random()*9);
        return temp;
    }
    public void add(int index) {
        if(map.containsKey(index) || index<1 || index>9) {
            System.out.println("Invalid Choice!");
            return;
        }
        else {
            map.put(index, userState);
            size++;
            System.out.println(size);
            if(size==9) 
                return;
            int randomIndex = getJVMMove();
            while(map.containsKey(randomIndex) || randomIndex==0)
                randomIndex = getJVMMove();
            map.put(randomIndex, jvmState);
            size++;
        }
    }
    public boolean firstRow() {
        if(map.containsKey(1) && map.containsKey(2) && map.containsKey(3)) {
            if(map.get(1).equals(userState)) {
                if(map.get(2).equals(userState) && map.get(3).equals(userState)) {
                    winnerFlag = false;
                    return true;
                }
            }
            else {
                if(map.get(2).equals(jvmState) && map.get(3).equals(jvmState)) {
                    winnerFlag = true;
                    return true;
                }
            }
        }
        return false;
    }
    public boolean secondRow() {
        if(map.containsKey(4) && map.containsKey(5) && map.containsKey(6)) {
            if(map.get(4).equals(userState)) {
                if(map.get(5).equals(userState) && map.get(6).equals(userState)) {
                    winnerFlag = false;
                    return true;
                }
            }
            else {
                if(map.get(6).equals(jvmState) && map.get(6).equals(jvmState)) {
                    winnerFlag = true;
                    return true;
                }
            }
        }
        return false;
    }
    public boolean thirdRow() {
        if(map.containsKey(7) && map.containsKey(8) && map.containsKey(9)) {
            if(map.get(7).equals(userState)) {
                if(map.get(8).equals(userState) && map.get(9).equals(userState)) {
                    winnerFlag = false;
                    return true;
                }
            }
            else {
                if(map.get(8).equals(jvmState) && map.get(9).equals(jvmState)) {
                    winnerFlag = true;
                    return true;
                }
            }
        }
        return false;
    }
    public boolean firstCol() {
        if(map.containsKey(1) && map.containsKey(4) && map.containsKey(7)) {
            if(map.get(1).equals(userState)) {
                if(map.get(4).equals(userState) && map.get(7).equals(userState)) {
                    winnerFlag = false;
                    return true;
                }
            }
            else {
                if(map.get(4).equals(jvmState) && map.get(7).equals(jvmState)) {
                    winnerFlag = true;
                    return true;
                }
            }
            
        }
        return false;
    }
    public boolean secondCol() {
        if(map.containsKey(2) && map.containsKey(5) && map.containsKey(8)) {
            if(map.get(2).equals(userState)) {
                if(map.get(5).equals(userState) && map.get(8).equals(userState)) {
                    winnerFlag = false;
                    return true;
                }
            }
            else {
                if(map.get(5).equals(jvmState) && map.get(8).equals(jvmState)) {
                    winnerFlag = true;
                    return true;
                }
            }
        }
        return false;
    }
    public boolean thirdCol() {
        if(map.containsKey(3) && map.containsKey(6) && map.containsKey(9)) {
            if(map.get(3).equals(userState)) {
                if(map.get(6).equals(userState) && map.get(9).equals(userState)) {
                    winnerFlag = false;
                    return true;
                }
            }
            else {
                if(map.get(6).equals(jvmState) && map.get(9).equals(jvmState)) {
                    winnerFlag = true;
                    return true;
                }
            }
        }
        return false;
    }
    public boolean firstDiagnol() {
        if(map.containsKey(1) && map.containsKey(5) && map.containsKey(9)) {
            if(map.get(1).equals(userState)) {
                if(map.get(5).equals(userState) && map.get(9).equals(userState)) {
                    winnerFlag = false;
                    return true;
                }
            }
            else {
                if(map.get(5).equals(jvmState) && map.get(9).equals(jvmState)) {
                    winnerFlag = true;
                    return true;
                }
            }
        }
        return false;
    }
    public boolean secondDiagnol() {
        if(map.containsKey(3) && map.containsKey(5) && map.containsKey(7)) {
            if(map.get(3).equals(userState)) {
                if(map.get(5).equals(userState) && map.get(7).equals(userState)) {
                    winnerFlag = false;
                    return true;
                }
            }
            else {
                if(map.get(5).equals(jvmState) && map.get(7).equals(jvmState)) {
                    winnerFlag = true;
                    return true;
                }
            }
        }
        return false;
    }
    public boolean getWinner() {
        if(map.containsKey(1) && map.containsKey(2) && map.containsKey(3) && map.containsKey(4) && map.containsKey(5) && map.containsKey(6) && map.containsKey(7) && map.containsKey(8) && map.containsKey(9)) {
            System.out.println("Draw!!!");
            System.exit(1);
        }
        return firstRow() || secondRow() || thirdRow() || firstCol() || secondCol() || thirdCol() || firstDiagnol() || secondDiagnol();
    }
}