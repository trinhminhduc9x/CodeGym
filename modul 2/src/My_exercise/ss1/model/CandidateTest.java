package My_exercise.ss1.model;

import static org.junit.jupiter.api.Assertions.*;

class  CandidateTest {
    public static void main(String[] args) {
        Candidate[] candidates = new  Candidate[3];
        candidates[0] = new Candidate(1,"duc","12-12-12",8,7,8);
        candidates[1] = new Candidate(2,"duc","12-12-12",8,7,8);
        candidates[2] = new Candidate(3,"duc","12-12-12",8,7,8);
        for (Candidate candidate: candidates) {
            System.out.println(candidate);
        }
    }
}