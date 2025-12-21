class Solution {
    public String categorizeBox(int length, int width, int height, int mass) {
        String box = "";
        String box1 = "";

        long volume = 1L * length * width * height; // FIXED overflow

        if (length >= 10000 || width >= 10000 || height >= 10000 || volume >= 1000000000L) {
            box = "Bulky";
        }
        if (mass >= 100) {
            box1 = "Heavy";
        }

        if (box.equals("Bulky") && box1.equals("Heavy")) {
            return "Both";
        }
        if (!box.equals("Bulky") && !box1.equals("Heavy")) {
            return "Neither";
        }
        if (box.equals("Bulky")) {
            return "Bulky";
        }
        return "Heavy";
    }
}