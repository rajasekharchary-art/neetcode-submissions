class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int len = position.length;
        int[][] cars = new int[len][2];
        for(int i = 0; i < len; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a,b) -> a[0] - b[0]);
        Stack<Double> stack = new Stack<>();
        for(int[] car: cars) {
            double time = (target - car[0]) / (double)car[1];

            while(!stack.isEmpty() && stack.peek() <= time ) {
                stack.pop();
            }
            stack.push(time);

        }

        return stack.size();
    }
}
