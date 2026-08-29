class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }

        // TreeMap keeps the keys (cards) in sorted order
        TreeMap<Integer, Integer> cardCounts = new TreeMap<>();
        for (int card : hand) {
            cardCounts.put(card, cardCounts.getOrDefault(card, 0) + 1);
        }

        for (int card : cardCounts.keySet()) {
            int count = cardCounts.get(card);
            
            if (count > 0) {
                for (int i = 0; i < groupSize; i++) {
                    int nextCard = card + i;
                    
                    if (cardCounts.getOrDefault(nextCard, 0) < count) {
                        return false;
                    }
                    
                    cardCounts.put(nextCard, cardCounts.get(nextCard) - count);
                }
            }
        }

        return true;
    }
}