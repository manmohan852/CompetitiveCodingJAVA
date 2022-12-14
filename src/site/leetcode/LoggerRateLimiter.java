package site.leetcode;

import java.util.HashMap;
import java.util.Map;
//Leetcode 359

//Design a logger system that receive stream of messages along with its timestamps, each message should be printed if and only if it is not printed in the last 10 seconds.
//        Given a message and a timestamp (in seconds granularity), return true if the message should be printed in the given timestamp, otherwise returns false.
//        It is possible that several messages arrive roughly at the same time.
//        Example:
//        Logger logger = new Logger();
//       logging string "foo" at timestamp 1
//        logger.shouldPrintMessage(1, "foo"); returns true;
// logging string "bar" at timestamp 2
//        logger.shouldPrintMessage(2,"bar"); returns true;
// logging string "foo" at timestamp 3
//        logger.shouldPrintMessage(3,"foo"); returns false;
//
//// logging string "bar" at timestamp 8
//        logger.shouldPrintMessage(8,"bar"); returns false;
//
//// logging string "foo" at timestamp 10
//        logger.shouldPrintMessage(10,"foo"); returns false;
//
//// logging string "foo" at timestamp 11
//        logger.shouldPrintMessage(11,"foo"); returns true;
public class LoggerRateLimiter {

    //    Use a map to store the message and timestamp.
//    When the "shouldPrintMsg" is called, we check whether the map don't have the string or the previous timestamp is 10 seconds before.
//    If yes, we update the map with the new record and return true.
//    Otherwise, do nothing and return false
    Map<String, Integer> msg;

    public LoggerRateLimiter() {
        msg = new HashMap<>();
    }

    /**
     * Returns true if the message should be printed in the given timestamp, otherwise returns false.
     * If this method returns false, the message will not be printed.
     * The timestamp is in seconds granularity.
     */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!msg.containsKey(message) || timestamp - msg.get(message) >= 10) {
            msg.put(message, timestamp);
            return true;
        } else {
            return false;
        }
    }
}
