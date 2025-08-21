class solution{
    public boolean validperfectsquare(int num){
        int sqrt = (int)Math.sqrt(num);
        return sqrt*sqrt == num;
    }
}