class Solution {
    public String convert(String s, int numRows) {
        if(numRows <= 1) {
            return s;
        }
        ArrayList<ArrayList<Character>> ch = new ArrayList<>();
        for(int i = 0; i < numRows; i++) {
            ch.add(new ArrayList<>());
        }

        int dir=1, currRow=0;
        for(char c: s.toCharArray()) {
            ch.get(currRow).add(c);
            if(currRow == numRows - 1){
                dir=-1;
            }
            else if(currRow == 0){
                dir=1;
            }
            currRow += dir;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<ch.size(); i++) {
            for(char c: ch.get(i)){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}