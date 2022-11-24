package site.byteToByte;

public class BigIntModulus {

    // Compute the mod. We use a char array as it is equivalent to an array of
    // unsigned bytes
    public static int mod(char[] a, int b) {
        // If input is null, let's just return 0
        if (a == null) return 0;
        int m = 0;
        // Start with modding the most significant byte, then repeatedly shift
        // left. This way our value never gets larger than an int
        for (int i = 0; i < a.length; i++) {
            m <<= 8;
            m += (a[i] & 0xFF);
            m %= b;
        }
        return m;
    }
    //https://www.youtube.com/watch?time_continue=3&v=5LCuroQltsc&feature=emb_logo
    //normal division like algorithm
    // 5 in hex will be
    //m = 0x0000 0005  === 0x5  ==  5 in int ,,,,,   stored in integer [32 bits]; or 4 bytes;
    // m << 8 means shifting left by 8 bits or 2 bytes;

    // if m = 0x12  === 0x0000 0012, then after m<<8 ; m = 0x1200 === 0x0000 1200

}
