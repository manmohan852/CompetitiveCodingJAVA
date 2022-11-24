package site.designPattern.behavioural.strategy.enumStrategy.ex4;

enum PlayStrategy { /* Make sure to score quickly on T20 games */
    T20 {
        @Override
        public void play() {
            System.out.printf("In %s, If it's in the V, make sure it goes to tree %n", name());
        }
    }, /* Make a balance between attach and defence in One day */ ONE_DAY {
        @Override
        public void play() {
            System.out.printf("In %s, Push it for Single %n", name());
        }
    }, /* Test match is all about occupying the crease and grinding opposition */ TEST {
        @Override
        public void play() {
            System.out.printf("In %s, Grind them hard %n", name());
        }
    };

    public void play() {
        System.out.printf("In Cricket, Play as per Merit of Ball %n");
    }
}
