public class Practice {
        public int ValueMissing (int[] nums) {
            int length = nums.length;
            int gaussSum= length * (length + 1) / 2;

            // this value would be updated as we add to the array
            int arraySum = 0;
            for (int num : nums){
                arraySum = arraySum + num;
            }
            int numberMissing = gaussSum - arraySum;
            return numberMissing;
        }

        public static void main(String[] args) {
            Practice practice = new Practice();
            int[] nums = {0, 1, 3};
            System.out.println(practice.ValueMissing(nums));
        }
}
