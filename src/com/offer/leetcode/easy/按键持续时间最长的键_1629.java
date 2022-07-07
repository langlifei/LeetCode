package com.offer.leetcode.easy;

class Leetcode1629 {

    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char ans = keysPressed.charAt(0);
        int maxTime = releaseTimes[0];
        if(releaseTimes.length != keysPressed.length()){
            return ans;
        }
        int currentTime = 0;
        for(int i = 1 ; i < releaseTimes.length ; i++){
            currentTime = releaseTimes[i]-releaseTimes[i-1];
            if( currentTime > maxTime){
                maxTime = currentTime;
                ans = keysPressed.charAt(i);
            }else if (currentTime == maxTime && keysPressed.charAt(i) > ans){
                ans = keysPressed.charAt(i);
            }
        }
        return ans;
    }
}
