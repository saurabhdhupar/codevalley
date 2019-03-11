import java.lang.*;

class JewelStone {
    
    static class JewelStoneState {
        int jewelCount;
        int stoneCount;
        
        public JewelStoneState(int stoneCount, int jewelCount) {
            this.stoneCount = stoneCount;
            this.jewelCount = jewelCount;
        }
        
        int getStoneCount() {
            return this.stoneCount;
        }
        
        int getJewelCount() {
            return this.jewelCount;
        }
        
        void setStoneCount(int stoneCount) {
            this.stoneCount = stoneCount;
        }
        
        void setJewelCount(int jewelCount) {
            this.jewelCount = jewelCount;
        }
        
        void incStoneCount() {
            this.stoneCount += 1;
        }
        
        void incJewelCount() {
            this.jewelCount += 1;
        }
        
        public String toString() {
            return this.stoneCount + "|" + this.jewelCount;
        }
        
    }
    
    void getPutJewel(Map<Character, JewelStoneState> m, char jewel) {
        if(m.containsKey(jewel)) {
                m.get(jewel).incJewelCount();
        } 
        else {
                m.put(jewel, new JewelStoneState(0, 1));
        }
    }
    
    void getPutStone(Map<Character, JewelStoneState> m, char stone) {
        if(m.containsKey(stone)) {
                m.get(stone).incStoneCount();
        } 
        else {
                m.put(stone, new JewelStoneState(1, 0));
        }
    }
    
    public int numJewelsInStones(String J, String S) {
        int loopEnd = Math.min(J.length(), S.length());
        Map<Character, JewelStoneState> m = new HashMap<>();
        int i = 0;
        int j = 0;
        for(i = 0; i < loopEnd; i++) {
            char jewel = J.charAt(i);
            char stone = S.charAt(i);
            getPutJewel(m, jewel);
            getPutStone(m, stone);
        }
        
        if(J.length() > i) {
            for(j = i; j < J.length(); j++) {
                char jewel = J.charAt(j);
                getPutJewel(m, jewel);
            }
        }
        
        else if(S.length() > i) {
            for(j = i; j < S.length(); j++) {
                char stone = S.charAt(j);
                getPutStone(m, stone);
            }
        }
        int totalCommon = 0;
        Iterator<JewelStoneState> itr = m.values().iterator();
        while(itr.hasNext()) {
            JewelStoneState o = itr.next();
            if(o.getStoneCount() > 0 && o.getJewelCount() > 0) {
               totalCommon += Math.max(o.getStoneCount() , o.getJewelCount()); 
            }
            else {
               totalCommon += Math.min(o.getStoneCount() , o.getJewelCount()); 
            }
            
            
        }
        return totalCommon;
        
    }
}
