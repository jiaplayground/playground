package playcode.binaysearch;

public class MinimumSpeedArriveTime1870 {
    public int minSpeedOnTime(int[] dist, double hour) {
        if(hour<=dist.length-1) return -1;
        int left =1;;
        int right = 10_000_000;
        while(left <= right){
            int mid = left + (right-left)/2;

            if(getHour(mid, dist)>hour){
                left= mid+1;
            }
            else {

                right = mid-1;
            }
        }
        return left;
    }
    private double getHour(int speed, int[]dist){
        double time = 0.00d;
        for(int i=0;i<dist.length-1; i++){
            //  System.out.println(" " + (1.00*dist[i]/speed));
            time += Math.ceil(1.00*dist[i]/speed);
        }
        time += 1.00*dist[dist.length-1]/speed;

        return time;
    }
}
