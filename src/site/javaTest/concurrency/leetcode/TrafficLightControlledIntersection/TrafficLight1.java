package site.javaTest.concurrency.leetcode.TrafficLightControlledIntersection;

//https://leetcode.com/problems/traffic-light-controlled-intersection/
public class TrafficLight1 {
//    We just need to maintain which road is green right now and if a new car comes,
//    simply check which direction it wants to go and acquire the signal to turn green.
    volatile int greenRoad;

    public TrafficLight1() {
        this.greenRoad = 1;
    }

    public void carArrived(
            int carId,           // ID of the car
            int roadId,          // ID of the road the car travels on. Can be 1 (road A) or 2 (road B)
            int direction,       // Direction of the car
            Runnable turnGreen,  // Use turnGreen.run() to turn light to green on current road
            Runnable crossCar    // Use crossCar.run() to make car cross the intersection
    ) {
        synchronized (this) {
            if (roadId != this.greenRoad) {
                turnGreen.run();
            }
            this.greenRoad = roadId;
            crossCar.run();
        }
    }
}
