class Solution {
    class Pair {
        String first;
        int second;
        public Pair(String _f, int _s) {
            first = _f;
            second = _s;
        }
    }
    public int openLock(String[] deadends, String target) {
        int n = deadends.length;
        Set<String> s = new HashSet<>();
        Set<String> buildSet = new HashSet<>();
        buildSet.add("0000");
        for(String d : deadends) {
            s.add(d);
        }
        String start = "0000";
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start, 0));

        while(!q.isEmpty()) {
            Pair curr = q.poll();
            String word = curr.first;
            int dist = curr.second;

            if(s.contains(word)) continue;
            if(target.equals(word)) return dist;

            char[] charArr = word.toCharArray();
            for(int i = 0 ; i < 4 ; i++) {
                char currChar = charArr[i];
                int numValue = Character.getNumericValue(currChar);

                int nextNum1 = generateNextG(numValue);
                int nextNum2 = generateNextS(numValue);

                char[] arr1 = word.toCharArray();
                arr1[i] = (char)(nextNum1 + '0');
                String newWord1 = new String(arr1);

                char[] arr2 = word.toCharArray();
                arr2[i] = (char)(nextNum2 + '0');
                String newWord2 = new String(arr2);

                if(!buildSet.contains(newWord1)) {
                    q.add(new Pair(newWord1, dist+1));
                    buildSet.add(newWord1);
                }
                if(!buildSet.contains(newWord2)) {
                    q.add(new Pair(newWord2, dist+1));
                    buildSet.add(newWord2);
                }
            }
        }
        return -1;
    }

    public int generateNextG(int x) {
        if(x == 9) {
            return 0;
        } else {
            return x+1;
        }
    }

    public int generateNextS(int x) {
        if(x == 0) {
            return 9;
        } else {
            return x-1;
        }
    }

}