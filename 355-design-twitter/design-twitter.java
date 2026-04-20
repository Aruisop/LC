class Twitter {
     static int time  = 0;
     class Tweets{
     int id;
     int time;
     public Tweets(int id, int time){
        this.id = id;
        this.time = time;
       }
     }
     Map<Integer, Set<Integer>>followsmp;
     Map<Integer, List<Tweets>>tweetsmp;
     public Twitter() {
         this.followsmp= new HashMap<>();
         this.tweetsmp=new HashMap<>();
     }
    
     public void postTweet(int userId, int tweetId) {
           tweetsmp.putIfAbsent(userId, new ArrayList<>());
           tweetsmp.get(userId).add(new Tweets(tweetId, time++));
     }
    
     public List<Integer> getNewsFeed(int userId) {
         List<Integer>ans = new ArrayList<>();
         PriorityQueue<Tweets>pq=new PriorityQueue<>((a,b)->(b.time-a.time));
         if(tweetsmp.containsKey(userId)){
            pq.addAll(tweetsmp.get(userId));
         }
         if(followsmp.containsKey(userId)){
             for(int followees:followsmp.get(userId)){
                if(tweetsmp.containsKey(followees))
                pq.addAll(tweetsmp.get(followees));
             }
         }
         while(!pq.isEmpty() && ans.size()<10){
            ans.add(pq.poll().id);
         }
         return ans;
     }
    
     public void follow(int followerId, int followeeId) {
         if(followerId==followeeId) return;
         followsmp.putIfAbsent(followerId, new HashSet<>());
         followsmp.get(followerId).add(followeeId);
     }
    
     public void unfollow(int followerId, int followeeId) {
         if(followsmp.containsKey(followerId)){
            followsmp.get(followerId).remove(followeeId);
         }
     }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */