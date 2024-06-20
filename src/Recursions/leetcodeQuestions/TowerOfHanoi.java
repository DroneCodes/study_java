package Recursions.leetcodeQuestions;

public class TowerOfHanoi {

    /*
    Tower of Hanoi is a mathematical puzzle where we have three rods and n disks. The objective of the puzzle is to move the entire stack to another rod, obeying the following simple rules:
    1. Only one disk can be moved at a time.
    2. Each move consists of taking the upper disk from one of the stacks and placing it on top of another stack i.e. a disk can only be moved if it is the uppermost disk on a stack.
    3. No disk may be placed on top of a smaller disk.

    Approach:
    1. Move n-1 disks from source to auxiliary using destination as auxiliary.
    2. Move nth disk from source to destination.
    3. Move n-1 disks from auxiliary to destination using source as auxiliary.

    Time Complexity: O(2^n)

    Note: This is a recursive solution.
    source is the rod from which we have to move the disks.
    aux means auxiliary.
    des means destination.
     */
    public void towerOfHanoi(int n, char from_source, char to_aux, char to_des) {
        // If only 1 disk, make the move and return, as there is no disk to move from source to auxiliary.
        if(n == 1) {
            System.out.println("Move disk 1 from rod " + from_source + " to rod " + to_des);
            return;
        }

        // Move n-1 disks from source to auxiliary using destination as auxiliary.
        towerOfHanoi(n-1, from_source, to_des, to_aux);

        // Move nth disk from source to destination.
        System.out.println("Move disk " + n + " from rod " + from_source + " to rod " + to_des);

        // Move n-1 disks from auxiliary to destination using source as auxiliary.
        towerOfHanoi(n-1, to_aux, from_source, to_des);
    }

    public static void main(String[] args) {
        TowerOfHanoi obj = new TowerOfHanoi();
        obj.towerOfHanoi(5, 'A', 'B', 'C');
    }

}
