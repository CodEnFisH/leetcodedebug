package round3;

import java.util.Arrays;

/**
 * Created by codefish on 2/13/15.
 */
public class ValidNumber {
    private enum Transition {
        DIGIT, SIGN, DOT, EXP, SPACE, ELSE;
    };
    class DFA {
        int currentState; // start
        int INVALID_STATE;
        int[][] transTab;
        public DFA(){
            buildTable();
        }
        public Transition getTransition(char nextChar){
            if('0' <= nextChar && nextChar <= '9') return Transition.DIGIT; //        # digit
            else if(nextChar == '+' || nextChar == '-') return Transition.SIGN; //    # sign
            else if(nextChar == '.') return Transition.DOT;                    //     # dot
            else if(nextChar == 'e') return Transition.EXP;                    //     # exp
            else if(nextChar == ' ') return Transition.SPACE;                      // # space
            else return Transition.ELSE;                                          //  # else
        }
        // transit to the next state, if not valid, return false, else return true
        public boolean nextState(char c){
            int transId = getTransition(c).ordinal();
            currentState = transTab[currentState][transId];
            return currentState != INVALID_STATE;
        }
        private void buildTable(){
            transTab = new int[11][6];
            currentState = 0;
            INVALID_STATE = 10;
            Arrays.fill(transTab[0], INVALID_STATE);
            transTab[0][Transition.SPACE.ordinal()] = 0;
            transTab[0][Transition.DIGIT.ordinal()] = 1;
            transTab[0][Transition.DOT.ordinal()] = 2;
            transTab[0][Transition.SIGN.ordinal()] = 3;
            Arrays.fill(transTab[1], INVALID_STATE);
            transTab[1][Transition.DIGIT.ordinal()] = 1;
            transTab[1][Transition.DOT.ordinal()] = 9;
            transTab[1][Transition.EXP.ordinal()] = 4;
            transTab[1][Transition.SPACE.ordinal()] = 8;
            Arrays.fill(transTab[2], INVALID_STATE);
            transTab[2][Transition.DIGIT.ordinal()] = 5;
            Arrays.fill(transTab[3], INVALID_STATE);
            transTab[3][Transition.DOT.ordinal()] = 2;
            transTab[3][Transition.DIGIT.ordinal()] = 1;
            Arrays.fill(transTab[4], INVALID_STATE);
            transTab[4][Transition.SIGN.ordinal()] = 6;
            transTab[4][Transition.DIGIT.ordinal()] = 7;
            Arrays.fill(transTab[5], INVALID_STATE);
            transTab[5][Transition.DIGIT.ordinal()] = 5;
            transTab[5][Transition.EXP.ordinal()] = 4;
            transTab[5][Transition.SPACE.ordinal()] = 8;
            Arrays.fill(transTab[6], INVALID_STATE);
            transTab[6][Transition.DIGIT.ordinal()] = 7;
            Arrays.fill(transTab[7], INVALID_STATE);
            transTab[7][Transition.DIGIT.ordinal()] = 7;
            transTab[7][Transition.SPACE.ordinal()] = 8;
            Arrays.fill(transTab[8], INVALID_STATE);
            transTab[8][Transition.SPACE.ordinal()] = 8;
            Arrays.fill(transTab[9], INVALID_STATE);
            transTab[9][Transition.DIGIT.ordinal()] = 9;
            transTab[9][Transition.EXP.ordinal()] = 4;
            transTab[9][Transition.SPACE.ordinal()] = 8;
        }
        public boolean getFinalState(){
            return currentState == 1 || currentState == 5 || currentState == 7 || currentState ==
                    8 || currentState == 9;
        }
    }
    public boolean isNumber(String s) {
        DFA dfa = new DFA();
        for(int i = 0; i < s.length(); i++){
            if(!dfa.nextState(s.charAt(i))) return false;
        }
        return dfa.getFinalState();
    }
}
